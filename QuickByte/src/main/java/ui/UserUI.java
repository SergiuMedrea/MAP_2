package ui;

import controller.UserController;
import domain.User;
import repo.inMemory.UserRepo;

import java.util.Optional;
import java.util.Scanner;

public class UserUI {
    private static final UserController userController = UserController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public UserUI() {
        userController.setRepository(UserRepo.getInstance());
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public User createUser() {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter address ID: ");
        int addressID = scanner.nextInt();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        User newUser = new User(0, addressID, firstName, lastName, phoneNumber);
        User createdUser = userController.createEntity(newUser);

        System.out.println("User created with ID: " + createdUser.getUserID());

        return createdUser;
    }

    private void viewUsers() {
        System.out.println("Users:");
        for (User user : userController.getAllEntities()) {
            System.out.println("ID: " + user.getUserID() +
                    ", Name: " + user.getFirstName() + " " + user.getLastName() +
                    ", Address ID: " + user.getAddressID() +
                    ", Phone Number: " + user.getPhoneNumber());
        }
    }

    public User updateUser() {
        System.out.print("Enter user ID to update: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        User updatedUser = null;

        Optional<User> existingUser = userController.getEntityById(userID);
        if (existingUser.isPresent()) {
            System.out.print("Enter new first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new address\n");
            int addressID = scanner.nextInt();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            updatedUser = new User(userID, addressID, firstName, lastName, phoneNumber);
            userController.updateEntity(updatedUser);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
        return updatedUser;
    }

    private void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        int userID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = userController.deleteEntity(userID);
        if (deleted) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}

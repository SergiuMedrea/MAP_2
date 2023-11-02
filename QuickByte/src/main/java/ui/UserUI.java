package ui;

import domain.Address;
import repo.inMemory.UserRepo;
import domain.User;

import java.util.Scanner;

public class UserUI {
    private static final UserRepo userRepo = new UserRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
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

    public static User createUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        Address address = AddressUI.createAddress();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        User newUser = userRepo.createUser(name, address, phoneNumber);
        System.out.println("User created with ID: " + newUser.userID());
        return newUser;
    }

    private static void viewUsers() {
        System.out.println("Users:");
        for (User user : userRepo.getAllUsers()) {
            System.out.println("ID: " + user.userID() + ", Name: " + user.name() +
                    ", Address: " + user.address()+ ", Phone Number: " + user.phoneNumber());
        }
    }

    public static User updateUser() {
        System.out.print("Enter user ID to update: ");
        Long userID = scanner.nextLong();
        scanner.nextLine();
        User updatedUser = null;

        User existingUser = userRepo.getUserByID(userID);
        if (existingUser != null) {
            System.out.print("Enter new user name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new address\n");
            Address address = AddressUI.updateAddress();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();

            updatedUser = new User(userID, name, address, phoneNumber);
            userRepo.updateUser(updatedUser);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
        return updatedUser;
    }

    private static void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        Long userID = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = userRepo.deleteUser(userID);
        if (deleted) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}

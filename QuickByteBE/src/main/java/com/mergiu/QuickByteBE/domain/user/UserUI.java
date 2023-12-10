package com.mergiu.QuickByteBE.domain.user;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserUI implements EntityUI {

    private final UserService userService;

    @Autowired
    public UserUI(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all users");
            System.out.println("2. Add a new user");
            System.out.println("3. Delete a user");
            System.out.println("4. Update a user");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllUsers();
                    break;
                case 2:
                    addNewUser(scanner);
                    break;
                case 3:
                    deleteUser(scanner);
                    break;
                case 4:
                    updateUser(scanner);
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllUsers() {
        List<User> users = userService.getUsers();
        users.forEach(System.out::println);
    }

    private void addNewUser(Scanner scanner) {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();

        User newUser = new User(firstName, lastName, phoneNumber, null); // You might want to add address input
        userService.addNewUser(newUser);
        System.out.println("User added successfully.");
    }

    private void deleteUser(Scanner scanner) {
        System.out.println("Enter user ID to delete:");
        Long userId = scanner.nextLong();
        userService.deleteUser(userId);
        System.out.println("User deleted successfully.");
    }

    private void updateUser(Scanner scanner) {
        System.out.println("Enter user ID to update:");
        Long userId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new first name (press Enter to skip):");
        String firstName = scanner.nextLine();

        System.out.println("Enter new last name (press Enter to skip):");
        String lastName = scanner.nextLine();

        System.out.println("Enter new phone number (press Enter to skip):");
        String phoneNumber = scanner.nextLine();

        userService.updateUser(userId, firstName, lastName, phoneNumber);
        System.out.println("User updated successfully.");
    }
}
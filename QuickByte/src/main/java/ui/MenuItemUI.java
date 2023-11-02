package ui;

import domain.MenuItem;
import repo.inMemory.MenuItemRepo;

import java.util.List;
import java.util.Scanner;

public class MenuItemUI {
    private static final MenuItemRepo menuItemRepo = new MenuItemRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Menu Item");
            System.out.println("2. View Menu Items");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createMenuItem();
                    break;
                case 2:
                    viewMenuItems();
                    break;
                case 3:
                    updateMenuItem();
                    break;
                case 4:
                    deleteMenuItem();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createMenuItem() {
        System.out.print("Enter menu item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter menu item price: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter menu item description: ");
        String description = scanner.nextLine();
        System.out.print("Enter menu item category: ");
        String category = scanner.nextLine();
        System.out.print("Enter restaurant ID: ");
        Long restaurantID = scanner.nextLong();
        scanner.nextLine();

        MenuItem newMenuItem = menuItemRepo.createMenuItem(name, price, description, category, restaurantID);
        System.out.println("Menu item created with ID: " + newMenuItem.menuItemID());
    }

    private static void viewMenuItems() {
        System.out.println("Menu Items:");
        List<MenuItem> menuItems = menuItemRepo.getAllMenuItems();
        for (MenuItem menuItem : menuItems) {
            System.out.println("ID: " + menuItem.menuItemID() +
                    ", Name: " + menuItem.name() +
                    ", Price: $" + menuItem.price() +
                    ", Description: " + menuItem.description() +
                    ", Category: " + menuItem.category() +
                    ", Restaurant ID: " + menuItem.restaurantID());
        }
    }

    private static void updateMenuItem() {
        System.out.print("Enter menu item ID to update: ");
        Long menuItemID = scanner.nextLong();
        scanner.nextLine();

        MenuItem existingMenuItem = menuItemRepo.getMenuItemByID(menuItemID);
        if (existingMenuItem != null) {
            System.out.print("Enter new menu item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new menu item price: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new menu item description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new menu item category: ");
            String category = scanner.nextLine();
            System.out.print("Enter new restaurant ID: ");
            Long restaurantID = scanner.nextLong();
            scanner.nextLine();

            MenuItem updatedMenuItem = new MenuItem(menuItemID, name, price, description, category, restaurantID);
            menuItemRepo.updateMenuItem(updatedMenuItem);
            System.out.println("Menu item updated successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }

    private static void deleteMenuItem() {
        System.out.print("Enter menu item ID to delete: ");
        Long menuItemID = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = menuItemRepo.deleteMenuItem(menuItemID);
        if (deleted) {
            System.out.println("Menu item deleted successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }
}

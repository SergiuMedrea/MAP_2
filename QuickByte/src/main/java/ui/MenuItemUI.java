package ui;

import controller.EntityController;
import controller.MenuItemController;
import domain.MenuItem;
import repo.inMemory.InMemoryRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuItemUI {
    private static final MenuItemController menuItemController = new MenuItemController(new InMemoryRepo<>());
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
        System.out.print("Enter menu item category ID: ");
        int categoryID = scanner.nextInt();
        System.out.print("Enter restaurant ID: ");
        int restaurantID = scanner.nextInt();
        scanner.nextLine();

        MenuItem newMenuItem = new MenuItem(0, categoryID, restaurantID, name, price, description);
        MenuItem createdMenuItem = menuItemController.createEntity(newMenuItem);

        System.out.println("Menu item created with ID: " + createdMenuItem.getMenuItemID());
    }

    private static void viewMenuItems() {
        System.out.println("Menu Items:");
        List<MenuItem> menuItems = menuItemController.getAllEntities();
        for (MenuItem menuItem : menuItems) {
            System.out.println("ID: " + menuItem.getMenuItemID() +
                    ", Name: " + menuItem.getName() +
                    ", Price: $" + menuItem.getPrice() +
                    ", Description: " + menuItem.getDescription() +
                    ", Category ID: " + menuItem.getCategoryID() +
                    ", Restaurant ID: " + menuItem.getRestaurantID());
        }
    }

    private static void updateMenuItem() {
        System.out.print("Enter menu item ID to update: ");
        int menuItemID = scanner.nextInt();
        scanner.nextLine();

        Optional<MenuItem> existingMenuItem = menuItemController.getEntityById(menuItemID);
        if (existingMenuItem.isPresent()) {
            System.out.print("Enter new menu item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new menu item price: ");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new menu item description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new menu item category ID: ");
            int categoryID = scanner.nextInt();
            System.out.print("Enter new restaurant ID: ");
            int restaurantID = scanner.nextInt();
            scanner.nextLine();

            MenuItem updatedMenuItem = new MenuItem(menuItemID, categoryID, restaurantID, name, price, description);
            menuItemController.updateEntity(updatedMenuItem);
            System.out.println("Menu item updated successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }

    private static void deleteMenuItem() {
        System.out.print("Enter menu item ID to delete: ");
        int menuItemID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = menuItemController.deleteEntity(menuItemID);
        if (deleted) {
            System.out.println("Menu item deleted successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }
}

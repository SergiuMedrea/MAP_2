package com.mergiu.QuickByteBE.domain.menuItem;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Component
public class MenuItemUI implements EntityUI {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemUI(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all menu items");
            System.out.println("2. Add a new menu item");
            System.out.println("3. Delete a menu item");
            System.out.println("4. Update a menu item");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllMenuItems();
                    break;
                case 2:
                    addNewMenuItem(scanner);
                    break;
                case 3:
                    deleteMenuItem(scanner);
                    break;
                case 4:
                    updateMenuItem(scanner);
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllMenuItems() {
        List<MenuItem> menuItems = menuItemService.getMenuItems();
        menuItems.forEach(System.out::println);
    }

    private void addNewMenuItem(Scanner scanner) {
        System.out.println("Enter menu item name:");
        String name = scanner.nextLine();

        System.out.println("Enter menu item price:");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter menu item description:");
        String description = scanner.nextLine();

        MenuItem newMenuItem = new MenuItem(null, null, name, price, description);
        menuItemService.addNewMenuItem(newMenuItem);
        System.out.println("Menu item added successfully.");
    }

    private void deleteMenuItem(Scanner scanner) {
        System.out.println("Enter menu item ID to delete:");
        Long menuItemId = scanner.nextLong();
        menuItemService.deleteMenuItem(menuItemId);
        System.out.println("Menu item deleted successfully.");
    }

    private void updateMenuItem(Scanner scanner) {
        System.out.println("Enter menu item ID to update:");
        Long menuItemId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new menu item name (press Enter to skip):");
        String name = scanner.nextLine();

        System.out.println("Enter new menu item price (press Enter to skip):");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new menu item description (press Enter to skip):");
        String description = scanner.nextLine();

        menuItemService.updateMenuItem(menuItemId, name, price, description);
        System.out.println("Menu item updated successfully.");
    }
}

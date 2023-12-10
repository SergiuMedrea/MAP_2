package com.mergiu.QuickByteBE.domain.order;

import com.mergiu.QuickByteBE.domain.menuItem.MenuItem;
import com.mergiu.QuickByteBE.ui.EntityUI;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class OrderUI implements EntityUI {

    private final OrderService orderService;

    @Autowired
    public OrderUI(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all orders");
            System.out.println("2. Add a new order");
            System.out.println("3. Delete an order");
            System.out.println("4. Update an order");
            System.out.println("5. Add menu item to an order");
            System.out.println("6. Delete menu item from an order");
            System.out.println("7. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllOrders();
                    break;
                case 2:
                    addNewOrder(scanner);
                    break;
                case 3:
                    deleteOrder(scanner);
                    break;
                case 4:
                    updateOrder(scanner);
                    break;
                case 5:
                    addMenuItemToOrder(scanner);
                    break;
                case 6:
                    deleteMenuItemFromOrder(scanner);
                    break;
                case 7:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    @Transactional
    public void listAllOrders() {
        List<Order> orders = orderService.getOrders();
        orders.forEach(System.out::println);
    }

    private void addNewOrder(Scanner scanner) {
        Order newOrder = new Order();
        orderService.addNewOrder(newOrder);
        System.out.println("Order added successfully.");
    }

    private void deleteOrder(Scanner scanner) {
        System.out.println("Enter order ID to delete:");
        Long orderId = scanner.nextLong();
        orderService.deleteOrder(orderId);
        System.out.println("Order deleted successfully.");
    }

    private void updateOrder(Scanner scanner) {
        System.out.println("Enter order ID to update:");
        Long orderId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new order status (press Enter to skip):");
        String orderStatus = scanner.nextLine();

        orderService.updateOrder(orderId, orderStatus);
        System.out.println("Order updated successfully.");
    }

    private void addMenuItemToOrder(Scanner scanner) {
        System.out.println("Enter order ID to add menu item:");
        Long orderId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter menu item name:");
        String menuItemName = scanner.nextLine();

        System.out.println("Enter menu item price:");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter menu item description:");
        String description = scanner.nextLine();

        MenuItem menuItem = new MenuItem(null, null, menuItemName, price, description); // Create a temporary menu item
        orderService.addMenuItemToOrder(orderId, menuItem);
        System.out.println("Menu item added to the order successfully.");
    }

    private void deleteMenuItemFromOrder(Scanner scanner) {
        System.out.println("Enter order ID to delete menu item:");
        Long orderId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter menu item name to delete:");
        String menuItemName = scanner.nextLine();

        System.out.println("Enter menu item price:");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter menu item description:");
        String description = scanner.nextLine();

        MenuItem menuItem = new MenuItem(null, null, menuItemName, price, description); // Create a temporary menu item
        orderService.deleteMenuItemFromOrder(orderId, menuItem);
        System.out.println("Menu item deleted from the order successfully.");
    }
}

package ui;

import domain.Order;
import repo.inMemory.OrderRepo;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class OrderUI {
    private static final OrderRepo orderRepo = new OrderRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createOrder() {
        System.out.print("Enter order date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        Date date = Date.valueOf(dateString);
        System.out.print("Enter user ID: ");
        Long userID = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter courier ID: ");
        Long courierID = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter address ID: ");
        Long addressID = scanner.nextLong();
        scanner.nextLine();

        Order newOrder = orderRepo.createOrder(date, userID, courierID, addressID);
        System.out.println("Order created with ID: " + newOrder.orderID());
    }

    private static void viewOrders() {
        System.out.println("Orders:");
        List<Order> orders = orderRepo.getAllOrders();
        for (Order order : orders) {
            System.out.println("ID: " + order.orderID() +
                    ", Date: " + order.date() +
                    ", User ID: " + order.userID() +
                    ", Courier ID: " + order.courierID() +
                    ", Address ID: " + order.addressID());
        }
    }

    private static void updateOrder() {
        System.out.print("Enter order ID to update: ");
        Long orderID = scanner.nextLong();
        scanner.nextLine();

        Order existingOrder = orderRepo.getOrderByID(orderID);
        if (existingOrder != null) {
            System.out.print("Enter new order date (YYYY-MM-DD): ");
            String dateString = scanner.nextLine();
            Date date = Date.valueOf(dateString);
            System.out.print("Enter new user ID: ");
            Long userID = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter new courier ID: ");
            Long courierID = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter new address ID: ");
            Long addressID = scanner.nextLong();
            scanner.nextLine();

            Order updatedOrder = new Order(orderID, date, userID, courierID, addressID);
            orderRepo.updateOrder(updatedOrder);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private static void deleteOrder() {
        System.out.print("Enter order ID to delete: ");
        Long orderID = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = orderRepo.deleteOrder(orderID);
        if (deleted) {
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }
}

package ui;

import controller.OrderController;
import domain.EntityObserver;
import domain.Order;
import repo.inMemory.OrderRepo;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrderUI implements EntityObserver<Order> {
    private static final OrderController orderController = OrderController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public OrderUI() {
        orderController.setRepository(OrderRepo.getInstance());
    }

    public void run() {
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

    public void createOrder() {
        System.out.print("Enter order date (YYYY-MM-DD HH:mm:ss): ");
        String dateString = scanner.nextLine();
        Timestamp date = Timestamp.valueOf(dateString);
        System.out.print("Enter user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter courier ID: ");
        int courierID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter address ID: ");
        int addressID = scanner.nextInt();
        scanner.nextLine();

        Order newOrder = new Order(0, userID, courierID, addressID, date);
        Order createdOrder = orderController.createEntity(newOrder);

        System.out.println("Order created with ID: " + createdOrder.getOrderID());
    }

    private void viewOrders() {
        System.out.println("Orders:");
        List<Order> orders = orderController.getAllEntities();
        for (Order order : orders) {
            System.out.println("ID: " + order.getOrderID() +
                    ", Date: " + order.getDateTime() +
                    ", User ID: " + order.getUserID() +
                    ", Courier ID: " + order.getCourierID() +
                    ", Address ID: " + order.getAddressID());
        }
    }

    private void updateOrder() {
        System.out.print("Enter order ID to update: ");
        int orderID = scanner.nextInt();
        scanner.nextLine();

        Optional<Order> existingOrder = orderController.getEntityById(orderID);
        if (existingOrder.isPresent()) {
            System.out.print("Enter new order date (YYYY-MM-DD): ");
            String dateString = scanner.nextLine();
            Timestamp date = Timestamp.valueOf(dateString);
            System.out.print("Enter new user ID: ");
            int userID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new courier ID: ");
            int courierID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new address ID: ");
            int addressID = scanner.nextInt();
            scanner.nextLine();

            Order updatedOrder = new Order(orderID, userID, courierID, addressID, date);
            orderController.updateEntity(updatedOrder);
            System.out.println("Order updated successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private void deleteOrder() {
        System.out.print("Enter order ID to delete: ");
        int orderID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = orderController.deleteEntity(orderID);
        if (deleted) {
            System.out.println("Order deleted successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    @Override
    public void onEntityCreated(Order entity) {

    }

    @Override
    public void onEntityUpdated(Order entity) {

    }

    @Override
    public void onEntityDeleted(int entityId) {

    }
}

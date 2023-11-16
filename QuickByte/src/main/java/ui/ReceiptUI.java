package ui;

import controller.ReceiptController;
import domain.EntityObserver;
import domain.Receipt;
import repo.inMemory.ReceiptRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ReceiptUI implements EntityObserver<Receipt> {
    private static final ReceiptController receiptController = ReceiptController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public ReceiptUI() {
        receiptController.setRepository(ReceiptRepo.getInstance());
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Receipt");
            System.out.println("2. View Receipts");
            System.out.println("3. Update Receipt");
            System.out.println("4. Delete Receipt");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createReceipt();
                    break;
                case 2:
                    viewReceipts();
                    break;
                case 3:
                    updateReceipt();
                    break;
                case 4:
                    deletePaymentMethod();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createReceipt() {
        System.out.print("Enter user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter order ID: ");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter payment method: ");
        String paymentMethod = scanner.nextLine();
        System.out.print("Enter account information: ");
        String accountInformation = scanner.nextLine();

        Receipt newReceipt = new Receipt(orderID, userID, amount, paymentMethod, accountInformation);
        Receipt createdReceipt = receiptController.createEntity(newReceipt);
        System.out.println("Payment method created with ID: " + createdReceipt.getUserID() + createdReceipt.getOrderID());
    }

    private void viewReceipts() {
        System.out.println("Payment Methods:");
        List<Receipt> receipts = receiptController.getAllEntities();
        for (Receipt receipt : receipts) {
            System.out.println("ID: " + receipt.getOrderID() + receipt.getOrderID() +
                    ", Type: " + receipt.getPaymentType() +
                    ", Account Information: " + receipt.getAccountInformation() +
                    ", User ID: " + receipt.getUserID() +
                    ", Order ID: " + receipt.getOrderID());
        }
    }

    private void updateReceipt() {
        System.out.print("Enter payment method ID to update: ");
        int receiptID = scanner.nextInt();
        scanner.nextLine();

        Optional<Receipt> existingReceipt = receiptController.getEntityById(receiptID);
        if (existingReceipt.isPresent()) {
            System.out.print("Enter new user ID: ");
            int userID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new order ID: ");
            int orderID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new amount: ");
            int amount = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter  new payment method: ");
            String paymentMethod = scanner.nextLine();
            System.out.print("Enter new account information: ");
            String accountInformation = scanner.nextLine();

            Receipt updatedReceipt = new Receipt(orderID, userID, amount, paymentMethod, accountInformation);
            receiptController.updateEntity(updatedReceipt);
            System.out.println("Payment method updated successfully.");
        } else {
            System.out.println("Payment method not found.");
        }
    }

    private void deletePaymentMethod() {
        System.out.print("Enter payment method ID to delete: ");
        int paymentMethodID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = receiptController.deleteEntity(paymentMethodID);
        if (deleted) {
            System.out.println("Payment method deleted successfully.");
        } else {
            System.out.println("Payment method not found.");
        }
    }

    @Override
    public void onEntityCreated(Receipt entity) {

    }

    @Override
    public void onEntityUpdated(Receipt entity) {

    }

    @Override
    public void onEntityDeleted(int entityId) {

    }
}

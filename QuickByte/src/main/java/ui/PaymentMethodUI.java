package ui;

import domain.Receipt;
import repo.inMemory.ReceiptRepo;

import java.util.List;
import java.util.Scanner;

public class PaymentMethodUI {
    private static final ReceiptRepo RECEIPT_REPO = new ReceiptRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Payment Method");
            System.out.println("2. View Payment Methods");
            System.out.println("3. Update Payment Method");
            System.out.println("4. Delete Payment Method");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createPaymentMethod();
                    break;
                case 2:
                    viewPaymentMethods();
                    break;
                case 3:
                    updatePaymentMethod();
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

    private static void createPaymentMethod() {
        System.out.print("Enter payment method paymentType: ");
        String type = scanner.nextLine();
        System.out.print("Enter account information: ");
        String accountInformation = scanner.nextLine();
        System.out.print("Enter user ID: ");
        Long userID = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter order ID: ");
        Long orderID = scanner.nextLong();
        scanner.nextLine();

        Receipt newReceipt = RECEIPT_REPO.createPaymentMethod(type, accountInformation, userID, orderID);
        System.out.println("Payment method created with ID: " + newReceipt.receiptId());
    }

    private static void viewPaymentMethods() {
        System.out.println("Payment Methods:");
        List<Receipt> receipts = RECEIPT_REPO.getAllPaymentMethods();
        for (Receipt receipt : receipts) {
            System.out.println("ID: " + receipt.receiptId() +
                    ", Type: " + receipt.paymentType() +
                    ", Account Information: " + receipt.accountInformation() +
                    ", User ID: " + receipt.userID() +
                    ", Order ID: " + receipt.orderID());
        }
    }

    private static void updatePaymentMethod() {
        System.out.print("Enter payment method ID to update: ");
        Long paymentMethodID = scanner.nextLong();
        scanner.nextLine();

        Receipt existingReceipt = RECEIPT_REPO.getPaymentMethodByID(paymentMethodID);
        if (existingReceipt != null) {
            System.out.print("Enter new payment method paymentType: ");
            String type = scanner.nextLine();
            System.out.print("Enter new account information: ");
            String accountInformation = scanner.nextLine();
            System.out.print("Enter new user ID: ");
            Long userID = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Enter new order ID: ");
            Long orderID = scanner.nextLong();
            scanner.nextLine();

            Receipt updatedReceipt = new Receipt(paymentMethodID, type, accountInformation, userID, orderID);
            RECEIPT_REPO.updatePaymentMethod(updatedReceipt);
            System.out.println("Payment method updated successfully.");
        } else {
            System.out.println("Payment method not found.");
        }
    }

    private static void deletePaymentMethod() {
        System.out.print("Enter payment method ID to delete: ");
        Long paymentMethodID = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = RECEIPT_REPO.deletePaymentMethod(paymentMethodID);
        if (deleted) {
            System.out.println("Payment method deleted successfully.");
        } else {
            System.out.println("Payment method not found.");
        }
    }
}

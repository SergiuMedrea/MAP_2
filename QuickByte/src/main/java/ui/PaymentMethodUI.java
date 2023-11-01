package ui;

import domain.PaymentMethod;
import repo.inMemory.PaymentMethodRepo;

import java.util.List;
import java.util.Scanner;

public class PaymentMethodUI {
    private static final PaymentMethodRepo paymentMethodRepo = new PaymentMethodRepo();
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
            scanner.nextLine(); // Consume newline

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
        System.out.print("Enter payment method type: ");
        String type = scanner.nextLine();
        System.out.print("Enter account information: ");
        String accountInformation = scanner.nextLine();
        System.out.print("Enter user ID: ");
        Long userID = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter order ID: ");
        Long orderID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        PaymentMethod newPaymentMethod = paymentMethodRepo.createPaymentMethod(type, accountInformation, userID, orderID);
        System.out.println("Payment method created with ID: " + newPaymentMethod.paymentMethodID());
    }

    private static void viewPaymentMethods() {
        System.out.println("Payment Methods:");
        List<PaymentMethod> paymentMethods = paymentMethodRepo.getAllPaymentMethods();
        for (PaymentMethod paymentMethod : paymentMethods) {
            System.out.println("ID: " + paymentMethod.paymentMethodID() +
                    ", Type: " + paymentMethod.type() +
                    ", Account Information: " + paymentMethod.accountInformation() +
                    ", User ID: " + paymentMethod.userID() +
                    ", Order ID: " + paymentMethod.orderID());
        }
    }

    private static void updatePaymentMethod() {
        System.out.print("Enter payment method ID to update: ");
        Long paymentMethodID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        PaymentMethod existingPaymentMethod = paymentMethodRepo.getPaymentMethodByID(paymentMethodID);
        if (existingPaymentMethod != null) {
            System.out.print("Enter new payment method type: ");
            String type = scanner.nextLine();
            System.out.print("Enter new account information: ");
            String accountInformation = scanner.nextLine();
            System.out.print("Enter new user ID: ");
            Long userID = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new order ID: ");
            Long orderID = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            PaymentMethod updatedPaymentMethod = new PaymentMethod(paymentMethodID, type, accountInformation, userID, orderID);
            paymentMethodRepo.updatePaymentMethod(updatedPaymentMethod);
            System.out.println("Payment method updated successfully.");
        } else {
            System.out.println("Payment method not found.");
        }
    }

    private static void deletePaymentMethod() {
        System.out.print("Enter payment method ID to delete: ");
        Long paymentMethodID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        boolean deleted = paymentMethodRepo.deletePaymentMethod(paymentMethodID);
        if (deleted) {
            System.out.println("Payment method deleted successfully.");
        } else {
            System.out.println("Payment method not found.");
        }
    }
}

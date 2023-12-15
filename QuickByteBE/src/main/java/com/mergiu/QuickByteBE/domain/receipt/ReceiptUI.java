package com.mergiu.QuickByteBE.domain.receipt;

import com.mergiu.QuickByteBE.domain.receipt.paymentStrategy.CardPaymentStrategy;
import com.mergiu.QuickByteBE.domain.receipt.paymentStrategy.CashPaymentStrategy;
import com.mergiu.QuickByteBE.domain.receipt.paymentStrategy.PaymentStrategy;
import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class ReceiptUI implements EntityUI {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptUI(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Receipt Menu:");
            System.out.println("1. List all receipts");
            System.out.println("2. Get receipt by ID");
            System.out.println("3. Create a new receipt");
            System.out.println("4. Update a receipt");
            System.out.println("5. Delete a receipt");
            System.out.println("6. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllReceipts();
                    break;
                case 2:
                    getReceiptById();
                    break;
                case 3:
                    createReceipt();
                    break;
                case 4:
                    updateReceipt();
                    break;
                case 5:
                    deleteReceipt();
                    break;
                case 6:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void listAllReceipts() {
        receiptService.getAllReceipts().forEach(System.out::println);
    }

    public void getReceiptById() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter receipt ID:");
        Long receiptId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        Optional<Receipt> receiptOptional = receiptService.getReceiptById(receiptId);

        receiptOptional.ifPresentOrElse(
                receipt -> System.out.println("Receipt details:\n" + receipt),
                () -> System.out.println("Receipt not found")
        );
    }

    public void createReceipt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Choose payment method:");
        System.out.println("1. Card");
        System.out.println("2. Cash");
        int paymentMethodChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        PaymentStrategy paymentStrategy = createPaymentStrategy(paymentMethodChoice);
        paymentStrategy.processPayment();
        String paymentType;
        if(paymentMethodChoice == 1)
            paymentType = "Card";
        else
            paymentType = "Cash";

        System.out.println("Enter account information:");
        String accountInformation = scanner.nextLine();

        Receipt newReceipt = new Receipt(null, null, amount, paymentType, accountInformation);
        receiptService.createReceipt(newReceipt);

        System.out.println("Receipt created successfully!");
    }

    public void updateReceipt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter receipt ID to update:");
        Long receiptId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new amount:");
        int newAmount = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Choose new payment method:");
        System.out.println("1. Card");
        System.out.println("2. Cash");
        int paymentMethodChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        PaymentStrategy newPaymentStrategy = createPaymentStrategy(paymentMethodChoice);
        newPaymentStrategy.processPayment();
        String paymentType;
        if(paymentMethodChoice == 1)
            paymentType = "Card";
        else
            paymentType = "Cash";

        System.out.println("Enter new account information:");
        String newAccountInformation = scanner.nextLine();

        receiptService.updateReceipt(receiptId, newAmount, paymentType, newAccountInformation);

        System.out.println("Receipt updated successfully!");
    }

    private void deleteReceipt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter receipt ID to delete:");
        Long receiptId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        receiptService.deleteReceipt(receiptId);

        System.out.println("Receipt deleted successfully!");
    }

    private PaymentStrategy createPaymentStrategy(int choice) {
        switch (choice) {
            case 1:
                return new CardPaymentStrategy();
            case 2:
                return new CashPaymentStrategy();
            default:
                throw new IllegalArgumentException("Invalid payment method choice");
        }
    }
}

package repo.inMemory;

import domain.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReceiptRepo {
    private final List<Receipt> receipts = new ArrayList<>();
    private int nextReceiptID = 1;

    /**
     * Create a new receipt and add it to the repository
     */
    public Receipt createReceipt(int orderID, int userID, int amount, String paymentType, String accountInformation) {
        Receipt newReceipt = new Receipt(orderID, userID, amount, paymentType, accountInformation);
        receipts.add(newReceipt);
        nextReceiptID++;
        return newReceipt;
    }

    /**
     * Retrieve a receipt by ID | Optional.empty() if not found
     */
    public Optional<Receipt> getReceiptByID(int receiptID) {
        return receipts.stream()
                .filter(receipt -> Objects.equals(receiptID, receipt.orderID())) // Assuming receiptID is the same as orderID
                .findFirst();
    }

    /**
     * Retrieve all receipts
     */
    public List<Receipt> getAllReceipts() {
        return new ArrayList<>(receipts);
    }

    /**
     * Update an existing receipt
     */
    public boolean updateReceipt(Receipt updatedReceipt) {
        for (int i = 0; i < receipts.size(); i++) {
            Receipt existingReceipt = receipts.get(i);
            if (Objects.equals(existingReceipt.orderID(), updatedReceipt.orderID())) {
                receipts.set(i, updatedReceipt);
                return true; // Update successful
            }
        }
        return false; // Receipt not found
    }

    /**
     * Delete a receipt by ID
     */
    public boolean deleteReceipt(int receiptID) {
        return receipts.removeIf(receipt -> Objects.equals(receiptID, receipt.orderID())); // Assuming receiptID is the same as orderID
    }
}

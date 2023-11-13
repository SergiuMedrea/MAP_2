package repo.inMemory;

import domain.Receipt;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRepo {
    private final List<Receipt> receipts = new ArrayList<>();
    private long nextPaymentMethodID = 1;

    public Receipt createPaymentMethod(String type, String accountInformation, Long userID, Long orderID) {
        Receipt newReceipt = new Receipt(nextPaymentMethodID, type, accountInformation, userID, orderID);
        receipts.add(newReceipt);
        nextPaymentMethodID++;
        return newReceipt;
    }

    public Receipt getPaymentMethodByID(Long paymentMethodID) {
        return receipts.stream()
                .filter(receipt -> receipt.receiptId().equals(paymentMethodID))
                .findFirst()
                .orElse(null);
    }

    public List<Receipt> getAllPaymentMethods() {
        return new ArrayList<>(receipts);
    }

    public Receipt updatePaymentMethod(Receipt updatedReceipt) {
        for (int i = 0; i < receipts.size(); i++) {
            Receipt receipt = receipts.get(i);
            if (receipt.receiptId().equals(updatedReceipt.receiptId())) {
                receipts.set(i, updatedReceipt);
                return updatedReceipt;
            }
        }

        return null;
    }

    public boolean deletePaymentMethod(Long paymentMethodID) {
        return receipts.removeIf(receipt -> receipt.receiptId().equals(paymentMethodID));
    }
}

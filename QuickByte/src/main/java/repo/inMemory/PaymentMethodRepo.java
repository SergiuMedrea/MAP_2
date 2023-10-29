package repo.inMemory;

import entities.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRepo {
    private final List<PaymentMethod> paymentMethods = new ArrayList<>();
    private long nextPaymentMethodID = 1;

    public PaymentMethod createPaymentMethod(String type, String accountInformation, Long userID, Long orderID) {
        PaymentMethod newPaymentMethod = new PaymentMethod(nextPaymentMethodID, type, accountInformation, userID, orderID);
        paymentMethods.add(newPaymentMethod);
        nextPaymentMethodID++;
        return newPaymentMethod;
    }

    public PaymentMethod getPaymentMethodByID(Long paymentMethodID) {
        return paymentMethods.stream()
                .filter(paymentMethod -> paymentMethod.paymentMethodID().equals(paymentMethodID))
                .findFirst()
                .orElse(null);
    }

    public List<PaymentMethod> getAllPaymentMethods() {
        return new ArrayList<>(paymentMethods);
    }

    public PaymentMethod updatePaymentMethod(PaymentMethod updatedPaymentMethod) {
        for (int i = 0; i < paymentMethods.size(); i++) {
            PaymentMethod paymentMethod = paymentMethods.get(i);
            if (paymentMethod.paymentMethodID().equals(updatedPaymentMethod.paymentMethodID())) {
                paymentMethods.set(i, updatedPaymentMethod);
                return updatedPaymentMethod;
            }
        }

        return null;
    }

    public boolean deletePaymentMethod(Long paymentMethodID) {
        return paymentMethods.removeIf(paymentMethod -> paymentMethod.paymentMethodID().equals(paymentMethodID));
    }
}

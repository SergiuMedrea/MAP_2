package com.mergiu.QuickByteBE.domain.receipt.paymentStrategy;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing card payment...");
    }
}

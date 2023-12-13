package com.mergiu.QuickByteBE.domain.receipt.paymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment...");
    }
}

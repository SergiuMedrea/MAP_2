package com.mergiu.QuickByteBE.strategy_test;

import com.mergiu.QuickByteBE.domain.receipt.Receipt;
import com.mergiu.QuickByteBE.domain.receipt.ReceiptService;
import com.mergiu.QuickByteBE.domain.receipt.ReceiptUI;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReceiptTest {
    @Test
    void createReceipt_shouldInvokeServiceMethodWithCorrectParameters() {
        ReceiptService receiptService = mock(ReceiptService.class);
        ReceiptUI receiptUI = new ReceiptUI(receiptService);

        // Arrange
        provideInput("100\n1\nAccount123"); // Simulate user input

        // Act
        receiptUI.createReceipt();

        // Assert
        ArgumentCaptor<Receipt> receiptCaptor = ArgumentCaptor.forClass(Receipt.class);
        verify(receiptService).createReceipt(receiptCaptor.capture());

        Receipt createdReceipt = receiptCaptor.getValue();
        assertEquals(100, createdReceipt.getAmount());
        assertEquals("Card", createdReceipt.getPaymentType());
        assertEquals("Account123", createdReceipt.getAccountInformation());
    }
}

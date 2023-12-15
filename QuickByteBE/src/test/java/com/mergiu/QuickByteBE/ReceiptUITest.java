package com.mergiu.QuickByteBE;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Optional;

import com.mergiu.QuickByteBE.domain.receipt.Receipt;
import com.mergiu.QuickByteBE.domain.receipt.ReceiptService;
import com.mergiu.QuickByteBE.domain.receipt.ReceiptUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceiptUITest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(System.out);
    }

    @Test
    void testCreateReceiptWithCardPayment() {
        ReceiptService receiptService = mock(ReceiptService.class);

        // Simulate user input
        String simulatedInput = "100\n1\nJohn Doe\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ReceiptUI receiptUI = new ReceiptUI(receiptService);
        receiptUI.createReceipt();

        // Verify that the CardPaymentStrategy was used
        verify(receiptService).createReceipt(argThat(receipt -> "Card".equals(receipt.getPaymentType())));
        assertTrue(outputStreamCaptor.toString().contains("Receipt created successfully!"));
    }

    @Test
    void testUpdateReceiptWithCashPayment() {
        ReceiptService receiptService = mock(ReceiptService.class);
        when(receiptService.getReceiptById(anyLong())).thenReturn(Optional.of(new Receipt()));

        // Simulate user input
        String simulatedInput = "1\n200\n2\nJane Doe\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ReceiptUI receiptUI = new ReceiptUI(receiptService);
        receiptUI.updateReceipt();

        // Verify that the CashPaymentStrategy was used
        verify(receiptService).updateReceipt(anyLong(), anyInt(), argThat(paymentType -> "Cash".equals(paymentType)), anyString());
        assertTrue(outputStreamCaptor.toString().contains("Receipt updated successfully!"));
    }

    @Test
    void testGetReceiptByIdNotFound() {
        ReceiptService receiptService = mock(ReceiptService.class);
        when(receiptService.getReceiptById(anyLong())).thenReturn(Optional.empty());

        // Simulate user input
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ReceiptUI receiptUI = new ReceiptUI(receiptService);
        receiptUI.getReceiptById();

        assertTrue(outputStreamCaptor.toString().contains("Receipt not found"));
    }
}

package com.mergiu.QuickByteBE.domain.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiptService {

    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public List<Receipt> getAllReceipts() {
        return receiptRepository.findAll();
    }

    public Optional<Receipt> getReceiptById(Long receiptId) {
        return receiptRepository.findById(receiptId);
    }

    public void createReceipt(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    public void updateReceipt(Long receiptId, int amount, String paymentType, String accountInformation) {
        Receipt receipt = receiptRepository.findById(receiptId)
                .orElseThrow(() -> new RuntimeException("Receipt not found"));

        receipt.setAmount(amount);
        receipt.setPaymentType(paymentType);
        receipt.setAccountInformation(accountInformation);

        receiptRepository.save(receipt);
    }

    public void deleteReceipt(Long receiptId) {
        boolean exists = receiptRepository.existsById(receiptId);
        if(!exists)
            throw new IllegalStateException("Receipt with id " + receiptId + " does not exist");

        receiptRepository.deleteById(receiptId);
    }
}

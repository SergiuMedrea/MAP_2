package com.mergiu.QuickByteBE.domain.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/receipts")
public class ReceiptController {

    private final ReceiptService receiptService;

    @Autowired
    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @GetMapping
    public List<Receipt> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{receiptId}")
    public Optional<Receipt> getReceiptById(@PathVariable Long receiptId) {
        return receiptService.getReceiptById(receiptId);
    }

    @PostMapping
    public void createReceipt(@RequestBody Receipt receipt) {
        receiptService.createReceipt(receipt);
    }

    @PutMapping("/{receiptId}")
    public void updateReceipt(
            @PathVariable Long receiptId,
            @RequestParam int amount,
            @RequestParam String paymentType,
            @RequestParam String accountInformation) {
        receiptService.updateReceipt(receiptId, amount, paymentType, accountInformation);
    }

    @DeleteMapping("/{receiptId}")
    public void deleteReceipt(@PathVariable Long receiptId) {
        receiptService.deleteReceipt(receiptId);
    }
}

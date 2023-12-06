package com.mergiu.QuickByteBE.domain.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/discounts")
public class DiscountController {

    private final DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public List<Discount> getDiscounts() {
        return discountService.getDiscounts();
    }

    @PostMapping
    public void addNewDiscount(@RequestBody Discount discount) {
        discountService.addNewDiscount(discount);
    }

    @DeleteMapping("/{discountId}")
    public void deleteDiscount(@PathVariable Long discountId) {
        discountService.deleteDiscount(discountId);
    }

    @PutMapping("/{discountId}")
    public void updateDiscount(
            @PathVariable Long discountId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate,
            @RequestParam(required = false) int discountPercentage) {
        discountService.updateDiscount(discountId, name, description, startDate, endDate, discountPercentage);
    }
}
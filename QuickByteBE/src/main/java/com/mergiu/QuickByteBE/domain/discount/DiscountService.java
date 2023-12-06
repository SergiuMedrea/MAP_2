package com.mergiu.QuickByteBE.domain.discount;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class DiscountService {
    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> getDiscounts() {
        return discountRepository.findAll();
    }

    public void addNewDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void deleteDiscount(Long discountId) {
        boolean exists = discountRepository.existsById(discountId);

        if (!exists) {
            throw new IllegalStateException("Discount with id " + discountId + " does not exist");
        }

        discountRepository.deleteById(discountId);
    }

    @Transactional
    public void updateDiscount(Long discountId, String name, String description, Date startDate, Date endDate, int discountPercentage) {
        Discount discount = discountRepository.findById(discountId)
                .orElseThrow(() -> new IllegalStateException("Discount with id " + discountId + " does not exist"));

        if (name != null && !name.isEmpty() && !Objects.equals(discount.getName(), name)) {
            discount.setName(name);
        }

        if (description != null && !description.isEmpty() && !Objects.equals(discount.getDescription(), description)) {
            discount.setDescription(description);
        }

        if (startDate != null && !Objects.equals(discount.getStartDate(), startDate)) {
            discount.setStartDate(startDate);
        }

        if (endDate != null && !Objects.equals(discount.getEndDate(), endDate)) {
            discount.setEndDate(endDate);
        }

        if (discountPercentage != 0 && !Objects.equals(discount.getDiscountPercentage(), discountPercentage)) {
            discount.setDiscountPercentage(discountPercentage);
        }

        discountRepository.save(discount);
    }
}

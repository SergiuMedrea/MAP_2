package repo.inMemory;

import domain.Discount;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DiscountRepo {
    private final List<Discount> discounts = new ArrayList<>();
    private int nextPromotionID = 1;

    /**
     * Create a new discount and add it to the repository
     */
    public Discount createDiscount(
            int restaurantID,
            String name,
            String description,
            Date startDate,
            Date endDate,
            int discountPercentage
    ) {
        Discount newDiscount = new Discount(nextPromotionID, restaurantID, name, description, startDate, endDate, discountPercentage);
        discounts.add(newDiscount);
        nextPromotionID++;
        return newDiscount;
    }

    /**
     * Retrieve a discount by promotion ID | Optional.empty() if not found
     */
    public Optional<Discount> getDiscountByPromotionID(int promotionID) {
        return discounts.stream()
                .filter(discount -> Objects.equals(promotionID, discount.promotionID()))
                .findFirst();
    }

    /**
     * Retrieve all discounts
     */
    public List<Discount> getAllDiscounts() {
        return new ArrayList<>(discounts);
    }

    /**
     * Update an existing discount
     */
    public boolean updateDiscount(Discount updatedDiscount) {
        for (int i = 0; i < discounts.size(); i++) {
            Discount existingDiscount = discounts.get(i);
            if (Objects.equals(existingDiscount.promotionID(), updatedDiscount.promotionID())) {
                discounts.set(i, updatedDiscount);
                return true; // Update successful
            }
        }
        return false; // Discount not found
    }

    /**
     * Delete a discount by promotion ID
     */
    public boolean deleteDiscount(int promotionID) {
        return discounts.removeIf(discount -> Objects.equals(promotionID, discount.promotionID()));
    }
}

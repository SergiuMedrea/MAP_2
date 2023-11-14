package repo.inMemory;

import domain.Discount;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class DiscountRepo {
    private final List<Discount> discounts = new ArrayList<>();
    private long nextPromotionID = 1;

    public Discount createPromotion(String name, String description, Date startDate, Date endDate, int discountPercentage, String couponCode, Long restaurantID) {
        Discount newDiscount = new Discount(nextPromotionID, name, description, startDate, endDate, discountPercentage, couponCode, restaurantID);
        discounts.add(newDiscount);
        nextPromotionID++;
        return newDiscount;
    }

    public Discount getPromotionByID(Long promotionID) {
        return discounts.stream()
                .filter(discount -> discount.promotionID().equals(promotionID))
                .findFirst()
                .orElse(null);
    }

    public List<Discount> getAllPromotions() {
        return new ArrayList<>(discounts);
    }

    public Discount updatePromotion(Discount updatedDiscount) {
        for (int i = 0; i < discounts.size(); i++) {
            Discount discount = discounts.get(i);
            if (discount.promotionID().equals(updatedDiscount.promotionID())) {
                discounts.set(i, updatedDiscount);
                return updatedDiscount;
            }
        }

        return null;
    }

    public boolean deletePromotion(Long promotionID) {
        return discounts.removeIf(discount -> discount.promotionID().equals(promotionID));
    }
}

package repo.inMemory;

import entities.Promotion;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class PromotionRepo {
    private final List<Promotion> promotions = new ArrayList<>();
    private long nextPromotionID = 1;

    public Promotion createPromotion(String name, String description, Date startDate, Date endDate, int discountPercentage, String couponCode, Long restaurantID) {
        Promotion newPromotion = new Promotion(nextPromotionID, name, description, startDate, endDate, discountPercentage, couponCode, restaurantID);
        promotions.add(newPromotion);
        nextPromotionID++;
        return newPromotion;
    }

    public Promotion getPromotionByID(Long promotionID) {
        return promotions.stream()
                .filter(promotion -> promotion.promotionID().equals(promotionID))
                .findFirst()
                .orElse(null);
    }

    public List<Promotion> getAllPromotions() {
        return new ArrayList<>(promotions);
    }

    public Promotion updatePromotion(Promotion updatedPromotion) {
        for (int i = 0; i < promotions.size(); i++) {
            Promotion promotion = promotions.get(i);
            if (promotion.promotionID().equals(updatedPromotion.promotionID())) {
                promotions.set(i, updatedPromotion);
                return updatedPromotion;
            }
        }

        return null;
    }

    public boolean deletePromotion(Long promotionID) {
        return promotions.removeIf(promotion -> promotion.promotionID().equals(promotionID));
    }
}

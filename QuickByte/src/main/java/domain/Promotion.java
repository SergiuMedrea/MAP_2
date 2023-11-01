package domain;

import java.sql.Date;

public record Promotion(Long promotionID, String name, String description, Date startDate, Date endDate,
                        int discountPercentage, String couponCode, Long restaurantID) {
}

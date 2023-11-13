package domain;

import java.sql.Date;

public record Promotion(int promotionID,
                        int restaurantID,
                        String name,
                        String description,
                        Date startDate,
                        Date endDate,
                        int discountPercentage) {
}

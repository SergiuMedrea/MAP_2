package domain;

import java.sql.Date;

public record Discount(int promotionID,
                       int restaurantID,
                       String name,
                       String description,
                       Date startDate,
                       Date endDate,
                       int discountPercentage) {
}

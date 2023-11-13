package domain;

public record Review(int reviewID,
                     int userID,
                     int restaurantID,
                     int rating,
                     String comment) {
}

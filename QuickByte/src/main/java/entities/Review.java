package entities;

public record Review(Long reviewID, int rating, String comment, Long userID, Long restaurantID) {
}
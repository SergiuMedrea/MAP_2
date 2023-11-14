package domain;

public class Review implements Identifiable {
    private int reviewID;
    private int userID;
    private int restaurantID;
    private int rating;
    private String comment;

    public Review(int reviewID, int userID, int restaurantID, int rating, String comment) {
        this.reviewID = reviewID;
        this.userID = userID;
        this.restaurantID = restaurantID;
        this.rating = rating;
        this.comment = comment;
    }

    @Override
    public int getId() {
        return getReviewID();
    }

    @Override
    public void setId(int id) {
        setReviewID(id);
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

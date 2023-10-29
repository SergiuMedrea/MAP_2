package repo.inMemory;

import entities.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepo {
    private final List<Review> reviews = new ArrayList<>();
    private long nextReviewID = 1;

    public Review createReview(int rating, String comment, Long userID, Long restaurantID) {
        Review newReview = new Review(nextReviewID, rating, comment, userID, restaurantID);
        reviews.add(newReview);
        nextReviewID++;
        return newReview;
    }

    public Review getReviewByID(Long reviewID) {
        return reviews.stream()
                .filter(review -> review.reviewID().equals(reviewID))
                .findFirst()
                .orElse(null);
    }

    public List<Review> getAllReviews() {
        return new ArrayList<>(reviews);
    }

    public Review updateReview(Review updatedReview) {
        for (int i = 0; i < reviews.size(); i++) {
            Review review = reviews.get(i);
            if (review.reviewID().equals(updatedReview.reviewID())) {
                reviews.set(i, updatedReview);
                return updatedReview;
            }
        }

        return null;
    }

    public boolean deleteReview(Long reviewID) {
        return reviews.removeIf(review -> review.reviewID().equals(reviewID));
    }
}

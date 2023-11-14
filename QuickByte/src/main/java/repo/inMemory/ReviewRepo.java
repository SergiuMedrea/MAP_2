package repo.inMemory;

import domain.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ReviewRepo {
    private final List<Review> reviews = new ArrayList<>();
    private int nextReviewID = 1;

    /**
     * Create a new review and add it to the repository
     */
    public Review createReview(int userID, int restaurantID, int rating, String comment) {
        Review newReview = new Review(nextReviewID, userID, restaurantID, rating, comment);
        reviews.add(newReview);
        nextReviewID++;
        return newReview;
    }

    /**
     * Retrieve a review by ID | Optional.empty() if not found
     */
    public Optional<Review> getReviewByID(int reviewID) {
        return reviews.stream()
                .filter(review -> Objects.equals(reviewID, review.reviewID()))
                .findFirst();
    }

    /**
     * Retrieve all reviews
     */
    public List<Review> getAllReviews() {
        return new ArrayList<>(reviews);
    }

    /**
     * Update an existing review
     */
    public boolean updateReview(Review updatedReview) {
        for (int i = 0; i < reviews.size(); i++) {
            Review existingReview = reviews.get(i);
            if (Objects.equals(existingReview.reviewID(), updatedReview.reviewID())) {
                reviews.set(i, updatedReview);
                return true; // Update successful
            }
        }
        return false; // Review not found
    }

    /**
     * Delete a review by ID
     */
    public boolean deleteReview(int reviewID) {
        return reviews.removeIf(review -> Objects.equals(reviewID, review.reviewID()));
    }
}

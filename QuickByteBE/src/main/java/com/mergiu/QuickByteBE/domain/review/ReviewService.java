//package com.mergiu.QuickByteBE.domain.review;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ReviewService {
//
//    private final ReviewRepository reviewRepository;
//
//    @Autowired
//    public ReviewService(ReviewRepository reviewRepository) {
//        this.reviewRepository = reviewRepository;
//    }
//
//    public List<Review> getAllReviews() {
//        return reviewRepository.findAll();
//    }
//
//    public Optional<Review> getReviewById(Long reviewId) {
//        return reviewRepository.findById(reviewId);
//    }
//
//    public void createReview(Review review) {
//        reviewRepository.save(review);
//    }
//
//    public void updateReview(Long reviewId, int rating, String comment) {
//        Review review = reviewRepository.findById(reviewId)
//                .orElseThrow(() -> new RuntimeException("Review not found"));
//
//        review.setRating(rating);
//        review.setComment(comment);
//
//        reviewRepository.save(review);
//    }
//
//    public void deleteReview(Long reviewId) {
//        Review review = reviewRepository.findById(reviewId)
//                .orElseThrow(() -> new RuntimeException("Review not found"));
//
//        reviewRepository.deleteById(reviewId);
//    }
//}

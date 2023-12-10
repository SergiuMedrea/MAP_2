package com.mergiu.QuickByteBE.domain.review;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{reviewId}")
    public Optional<Review> getReviewById(@PathVariable Long reviewId) {
        return reviewService.getReviewById(reviewId);
    }

    @PostMapping
    public void createReview(@RequestBody Review review) {
        reviewService.createReview(review);
    }

    @PutMapping("/{reviewId}")
    public void updateReview(
            @PathVariable Long reviewId,
            @RequestParam int rating,
            @RequestParam String comment) {
        reviewService.updateReview(reviewId, rating, comment);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}

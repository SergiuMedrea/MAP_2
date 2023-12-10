package com.mergiu.QuickByteBE.domain.review;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ReviewUI implements EntityUI {

    private final ReviewService reviewService;

    @Autowired
    public ReviewUI(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Review Menu:");
            System.out.println("1. List all reviews");
            System.out.println("2. Create a new review");
            System.out.println("3. Update a review");
            System.out.println("4. Delete a review");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllReviews();
                    break;
                case 2:
                    createReview();
                    break;
                case 3:
                    updateReview();
                    break;
                case 4:
                    deleteReview();
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllReviews() {
        reviewService.getAllReviews().forEach(System.out::println);
    }

    private void createReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rating:");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter comment:");
        String comment = scanner.nextLine();

        Review newReview = new Review(null, null, null, rating, comment);
        reviewService.createReview(newReview);

        System.out.println("Review created successfully!");
    }

    private void updateReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter review ID to update:");
        Long reviewId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new rating:");
        int newRating = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new comment:");
        String newComment = scanner.nextLine();

        reviewService.updateReview(reviewId, newRating, newComment);

        System.out.println("Review updated successfully!");
    }

    private void deleteReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter review ID to delete:");
        Long reviewId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        reviewService.deleteReview(reviewId);

        System.out.println("Review deleted successfully!");
    }
}

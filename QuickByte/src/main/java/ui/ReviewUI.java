package ui;

import domain.Review;
import repo.inMemory.ReviewRepo;

import java.util.List;
import java.util.Scanner;

public class ReviewUI {
    private static final ReviewRepo reviewRepo = new ReviewRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Review");
            System.out.println("2. View Reviews");
            System.out.println("3. Update Review");
            System.out.println("4. Delete Review");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createReview();
                    break;
                case 2:
                    viewReviews();
                    break;
                case 3:
                    updateReview();
                    break;
                case 4:
                    deleteReview();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createReview() {
        System.out.print("Enter rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        System.out.print("Enter user ID: ");
        Long userID = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter restaurant ID: ");
        Long restaurantID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Review newReview = reviewRepo.createReview(rating, comment, userID, restaurantID);
        System.out.println("Review created with ID: " + newReview.reviewID());
    }

    private static void viewReviews() {
        System.out.println("Reviews:");
        List<Review> reviews = reviewRepo.getAllReviews();
        for (Review review : reviews) {
            System.out.println("ID: " + review.reviewID() +
                    ", Rating: " + review.rating() +
                    ", Comment: " + review.comment() +
                    ", User ID: " + review.userID() +
                    ", Restaurant ID: " + review.restaurantID());
        }
    }

    private static void updateReview() {
        System.out.print("Enter review ID to update: ");
        Long reviewID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Review existingReview = reviewRepo.getReviewByID(reviewID);
        if (existingReview != null) {
            System.out.print("Enter new rating (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new comment: ");
            String comment = scanner.nextLine();
            System.out.print("Enter new user ID: ");
            Long userID = scanner.nextLong();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new restaurant ID: ");
            Long restaurantID = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            Review updatedReview = new Review(reviewID, rating, comment, userID, restaurantID);
            reviewRepo.updateReview(updatedReview);
            System.out.println("Review updated successfully.");
        } else {
            System.out.println("Review not found.");
        }
    }

    private static void deleteReview() {
        System.out.print("Enter review ID to delete: ");
        Long reviewID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        boolean deleted = reviewRepo.deleteReview(reviewID);
        if (deleted) {
            System.out.println("Review deleted successfully.");
        } else {
            System.out.println("Review not found.");
        }
    }
}

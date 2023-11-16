package ui;

import controller.ReviewController;
import domain.EntityObserver;
import domain.Review;
import repo.inMemory.ReviewRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ReviewUI implements EntityObserver<Review> {
    private static final ReviewController reviewController = ReviewController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public ReviewUI() {
        reviewController.setRepository(ReviewRepo.getInstance());
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Review");
            System.out.println("2. View Reviews");
            System.out.println("3. Update Review");
            System.out.println("4. Delete Review");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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

    private void createReview() {
        System.out.print("Enter rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine();
        System.out.print("Enter user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter restaurant ID: ");
        int restaurantID = scanner.nextInt();
        scanner.nextLine();

        Review newReview = new Review(0, userID, restaurantID, rating, comment);
        Review createdReview = reviewController.createEntity(newReview);
        System.out.println("Review created with ID: " + createdReview.getReviewID());
    }

    private void viewReviews() {
        System.out.println("Reviews:");
        List<Review> reviews = reviewController.getAllEntities();
        for (Review review : reviews) {
            System.out.println("ID: " + review.getReviewID() +
                    ", Rating: " + review.getRating() +
                    ", Comment: " + review.getComment() +
                    ", User ID: " + review.getUserID() +
                    ", Restaurant ID: " + review.getRestaurantID());
        }
    }

    private void updateReview() {
        System.out.print("Enter review ID to update: ");
        int reviewID = scanner.nextInt();
        scanner.nextLine();

        Optional<Review> existingReview = reviewController.getEntityById(reviewID);
        if (existingReview.isPresent()) {
            System.out.print("Enter new rating (1-5): ");
            int rating = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new comment: ");
            String comment = scanner.nextLine();
            System.out.print("Enter new user ID: ");
            int userID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new restaurant ID: ");
            int restaurantID = scanner.nextInt();
            scanner.nextLine();

            Review updatedReview = new Review(reviewID, userID, restaurantID, rating, comment);
            reviewController.updateEntity(updatedReview);
            System.out.println("Review updated successfully.");
        } else {
            System.out.println("Review not found.");
        }
    }

    private void deleteReview() {
        System.out.print("Enter review ID to delete: ");
        int reviewID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = reviewController.deleteEntity(reviewID);
        if (deleted) {
            System.out.println("Review deleted successfully.");
        } else {
            System.out.println("Review not found.");
        }
    }

    @Override
    public void onEntityCreated(Review entity) {

    }

    @Override
    public void onEntityUpdated(Review entity) {

    }

    @Override
    public void onEntityDeleted(int entityId) {

    }
}

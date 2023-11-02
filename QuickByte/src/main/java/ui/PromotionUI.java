package ui;

import domain.Promotion;
import repo.inMemory.PromotionRepo;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class PromotionUI {
    private static final PromotionRepo promotionRepo = new PromotionRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Promotion");
            System.out.println("2. View Promotions");
            System.out.println("3. Update Promotion");
            System.out.println("4. Delete Promotion");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createPromotion();
                    break;
                case 2:
                    viewPromotions();
                    break;
                case 3:
                    updatePromotion();
                    break;
                case 4:
                    deletePromotion();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createPromotion() {
        System.out.print("Enter promotion name: ");
        String name = scanner.nextLine();
        System.out.print("Enter promotion description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDateString = scanner.nextLine();
        Date startDate = Date.valueOf(startDateString);
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDateString = scanner.nextLine();
        Date endDate = Date.valueOf(endDateString);
        System.out.print("Enter discount percentage: ");
        int discountPercentage = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter coupon code: ");
        String couponCode = scanner.nextLine();
        System.out.print("Enter restaurant ID: ");
        Long restaurantID = scanner.nextLong();
        scanner.nextLine();

        Promotion newPromotion = promotionRepo.createPromotion(name, description, startDate, endDate, discountPercentage, couponCode, restaurantID);
        System.out.println("Promotion created with ID: " + newPromotion.promotionID());
    }

    private static void viewPromotions() {
        System.out.println("Promotions:");
        List<Promotion> promotions = promotionRepo.getAllPromotions();
        for (Promotion promotion : promotions) {
            System.out.println("ID: " + promotion.promotionID() +
                    ", Name: " + promotion.name() +
                    ", Description: " + promotion.description() +
                    ", Start Date: " + promotion.startDate() +
                    ", End Date: " + promotion.endDate() +
                    ", Discount Percentage: " + promotion.discountPercentage() + "%" +
                    ", Coupon Code: " + promotion.couponCode() +
                    ", Restaurant ID: " + promotion.restaurantID());
        }
    }

    private static void updatePromotion() {
        System.out.print("Enter promotion ID to update: ");
        Long promotionID = scanner.nextLong();
        scanner.nextLine();

        Promotion existingPromotion = promotionRepo.getPromotionByID(promotionID);
        if (existingPromotion != null) {
            System.out.print("Enter new promotion name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new promotion description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new start date (YYYY-MM-DD): ");
            String startDateString = scanner.nextLine();
            Date startDate = Date.valueOf(startDateString);
            System.out.print("Enter new end date (YYYY-MM-DD): ");
            String endDateString = scanner.nextLine();
            Date endDate = Date.valueOf(endDateString);
            System.out.print("Enter new discount percentage: ");
            int discountPercentage = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new coupon code: ");
            String couponCode = scanner.nextLine();
            System.out.print("Enter new restaurant ID: ");
            Long restaurantID = scanner.nextLong();
            scanner.nextLine();

            Promotion updatedPromotion = new Promotion(promotionID, name, description, startDate, endDate, discountPercentage, couponCode, restaurantID);
            promotionRepo.updatePromotion(updatedPromotion);
            System.out.println("Promotion updated successfully.");
        } else {
            System.out.println("Promotion not found.");
        }
    }

    private static void deletePromotion() {
        System.out.print("Enter promotion ID to delete: ");
        Long promotionID = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = promotionRepo.deletePromotion(promotionID);
        if (deleted) {
            System.out.println("Promotion deleted successfully.");
        } else {
            System.out.println("Promotion not found.");
        }
    }
}

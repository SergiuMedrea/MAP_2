package ui;

import domain.Discount;
import repo.inMemory.DiscountRepo;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class DiscountUI {
    private static final DiscountRepo DISCOUNT_REPO = new DiscountRepo();
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

        Discount newDiscount = DISCOUNT_REPO.createPromotion(name, description, startDate, endDate, discountPercentage, couponCode, restaurantID);
        System.out.println("Promotion created with ID: " + newDiscount.promotionID());
    }

    private static void viewPromotions() {
        System.out.println("Promotions:");
        List<Discount> discounts = DISCOUNT_REPO.getAllPromotions();
        for (Discount discount : discounts) {
            System.out.println("ID: " + discount.promotionID() +
                    ", Name: " + discount.name() +
                    ", Description: " + discount.description() +
                    ", Start Date: " + discount.startDate() +
                    ", End Date: " + discount.endDate() +
                    ", Discount Percentage: " + discount.discountPercentage() + "%" +
                    ", Coupon Code: " + discount.couponCode() +
                    ", Restaurant ID: " + discount.restaurantID());
        }
    }

    private static void updatePromotion() {
        System.out.print("Enter promotion ID to update: ");
        Long promotionID = scanner.nextLong();
        scanner.nextLine();

        Discount existingDiscount = DISCOUNT_REPO.getPromotionByID(promotionID);
        if (existingDiscount != null) {
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

            Discount updatedDiscount = new Discount(promotionID, name, description, startDate, endDate, discountPercentage, couponCode, restaurantID);
            DISCOUNT_REPO.updatePromotion(updatedDiscount);
            System.out.println("Promotion updated successfully.");
        } else {
            System.out.println("Promotion not found.");
        }
    }

    private static void deletePromotion() {
        System.out.print("Enter promotion ID to delete: ");
        Long promotionID = scanner.nextLong();
        scanner.nextLine();

        boolean deleted = DISCOUNT_REPO.deletePromotion(promotionID);
        if (deleted) {
            System.out.println("Promotion deleted successfully.");
        } else {
            System.out.println("Promotion not found.");
        }
    }
}

package ui;

import controller.DiscountController;
import domain.Discount;
import domain.EntityObserver;
import repo.inMemory.DiscountRepo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DiscountUI implements EntityObserver<Discount> {
    private static final DiscountController discountController = DiscountController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public DiscountUI() {
        discountController.setRepository(DiscountRepo.getInstance());
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Discount");
            System.out.println("2. View Discounts");
            System.out.println("3. Update Discount");
            System.out.println("4. Delete Discount");
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

    private void createPromotion() {
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
        System.out.print("Enter restaurant ID: ");
        int restaurantID = scanner.nextInt();
        scanner.nextLine();

        Discount newDiscount = new Discount(0, restaurantID, name, description, startDate, endDate, discountPercentage);
        Discount createdDiscount = discountController.createEntity(newDiscount);

        System.out.println("Promotion created with ID: " + createdDiscount.getDiscountID());
    }

    private void viewPromotions() {
        System.out.println("Promotions:");
        List<Discount> discounts = discountController.getAllEntities();
        for (Discount discount : discounts) {
            System.out.println("ID: " + discount.getDiscountID() +
                    ", Name: " + discount.getName() +
                    ", Description: " + discount.getDescription() +
                    ", Start Date: " + discount.getStartDate() +
                    ", End Date: " + discount.getEndDate() +
                    ", Discount Percentage: " + discount.getDiscountPercentage() + "%" +
                    ", Restaurant ID: " + discount.getRestaurantID());
        }
    }

    private void updatePromotion() {
        System.out.print("Enter promotion ID to update: ");
        int promotionID = scanner.nextInt();
        scanner.nextLine();

        Optional<Discount> existingDiscount = discountController.getEntityById(promotionID);
        if (existingDiscount.isPresent()) {
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
            System.out.print("Enter new restaurant ID: ");
            int restaurantID = scanner.nextInt();
            scanner.nextLine();

            Discount updatedDiscount = new Discount(promotionID, restaurantID, name, description, startDate, endDate, discountPercentage);
            discountController.updateEntity(updatedDiscount);
            System.out.println("Promotion updated successfully.");
        } else {
            System.out.println("Promotion not found.");
        }
    }

    private void deletePromotion() {
        System.out.print("Enter promotion ID to delete: ");
        int promotionID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = discountController.deleteEntity(promotionID);
        if (deleted) {
            System.out.println("Promotion deleted successfully.");
        } else {
            System.out.println("Promotion not found.");
        }
    }

    @Override
    public void onEntityCreated(Discount entity) {

    }

    @Override
    public void onEntityUpdated(Discount entity) {

    }

    @Override
    public void onEntityDeleted(int entityId) {

    }
}

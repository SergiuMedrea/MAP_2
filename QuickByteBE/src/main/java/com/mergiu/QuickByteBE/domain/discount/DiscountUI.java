package com.mergiu.QuickByteBE.domain.discount;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Component
public class DiscountUI implements EntityUI {

    private final DiscountService discountService;

    @Autowired
    public DiscountUI(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. List all discounts");
            System.out.println("2. Add a new discount");
            System.out.println("3. Delete a discount");
            System.out.println("4. Update a discount");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllDiscounts();
                    break;
                case 2:
                    addNewDiscount(scanner);
                    break;
                case 3:
                    deleteDiscount(scanner);
                    break;
                case 4:
                    updateDiscount(scanner);
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllDiscounts() {
        List<Discount> discounts = discountService.getDiscounts();
        discounts.forEach(System.out::println);
    }

    private void addNewDiscount(Scanner scanner) {
        System.out.println("Enter discount name:");
        String name = scanner.nextLine();

        System.out.println("Enter discount description:");
        String description = scanner.nextLine();

        System.out.println("Enter discount start date (yyyy-MM-dd):");
        Date startDate = parseDate(scanner.nextLine());

        System.out.println("Enter discount end date (yyyy-MM-dd):");
        Date endDate = parseDate(scanner.nextLine());

        System.out.println("Enter discount percentage:");
        int discountPercentage = scanner.nextInt();

        Discount newDiscount = new Discount(null, name, description, startDate, endDate, discountPercentage);
        discountService.addNewDiscount(newDiscount);
        System.out.println("Discount added successfully.");
    }

    private void deleteDiscount(Scanner scanner) {
        System.out.println("Enter discount ID to delete:");
        Long discountId = scanner.nextLong();
        discountService.deleteDiscount(discountId);
        System.out.println("Discount deleted successfully.");
    }

    private void updateDiscount(Scanner scanner) {
        System.out.println("Enter discount ID to update:");
        Long discountId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new discount name (press Enter to skip):");
        String name = scanner.nextLine();

        System.out.println("Enter new discount description (press Enter to skip):");
        String description = scanner.nextLine();

        System.out.println("Enter new discount start date (yyyy-MM-dd, press Enter to skip):");
        Date startDate = parseDate(scanner.nextLine());

        System.out.println("Enter new discount end date (yyyy-MM-dd, press Enter to skip):");
        Date endDate = parseDate(scanner.nextLine());

        System.out.println("Enter new discount percentage (press Enter to skip):");
        int discountPercentage = scanner.nextInt();

        discountService.updateDiscount(discountId, name, description, startDate, endDate, discountPercentage);
        System.out.println("Discount updated successfully.");
    }

    private Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }
}

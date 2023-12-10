package com.mergiu.QuickByteBE.domain.courier;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CourierUI implements EntityUI {

    private final CourierService courierService;

    @Autowired
    public CourierUI(CourierService courierService) {
        this.courierService = courierService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Courier Menu:");
            System.out.println("1. List all couriers");
            System.out.println("2. Add a new courier");
            System.out.println("3. Delete a courier");
            System.out.println("4. Update a courier");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllCouriers();
                    break;
                case 2:
                    addCourier();
                    break;
                case 3:
                    deleteCourier();
                    break;
                case 4:
                    updateCourier();
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllCouriers() {
        courierService.getCouriers().forEach(System.out::println);
    }

    private void addCourier() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.nextLine();

        Courier newCourier = new Courier(null, firstName, lastName, phoneNumber, vehicleType);
        courierService.addNewCourier(newCourier);

        System.out.println("Courier added successfully!");
    }

    private void deleteCourier() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter courier id to delete:");
        Long courierId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        courierService.deleteCourier(courierId);

        System.out.println("Courier deleted successfully!");
    }

    private void updateCourier() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter courier id to update:");
        Long courierId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new first name (press Enter to keep current):");
        String newFirstName = scanner.nextLine();

        System.out.println("Enter new last name (press Enter to keep current):");
        String newLastName = scanner.nextLine();

        System.out.println("Enter new phone number (press Enter to keep current):");
        String newPhoneNumber = scanner.nextLine();

        System.out.println("Enter new vehicle type (press Enter to keep current):");
        String newVehicleType = scanner.nextLine();

        courierService.updateCourier(courierId, newFirstName, newLastName, newPhoneNumber, newVehicleType);

        System.out.println("Courier updated successfully!");
    }
}

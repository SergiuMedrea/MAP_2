package ui;

import controller.CourierController;
import domain.Courier;
import domain.User;
import repo.inMemory.CourierRepo;
import repo.inMemory.InMemoryRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CourierUI {
    private static final CourierController courierController = CourierController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public CourierUI() {
        courierController.setRepository(CourierRepo.getInstance());
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Courier");
            System.out.println("2. View Couriers");
            System.out.println("3. Update Courier");
            System.out.println("4. Delete Courier");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createCourier();
                    break;
                case 2:
                    viewCouriers();
                    break;
                case 3:
                    updateCourier();
                    break;
                case 4:
                    deleteCourier();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createCourier() {
        System.out.print("Enter courier info\n");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter address ID: ");
        int addressID = scanner.nextInt();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter courier vehicle paymentType: ");
        String vehicleType = scanner.nextLine();

        Courier newCourier = new Courier(0, addressID, firstName, lastName, phoneNumber, vehicleType);
        Courier createdCourier = courierController.createEntity(newCourier);
        System.out.println("Courier created with ID: " + createdCourier.getUserID());
    }

    private void viewCouriers() {
        System.out.println("Couriers:");
        List<Courier> couriers = courierController.getAllEntities();
        for (Courier courier : couriers) {
            System.out.println("ID: " + courier.getUserID() +
                    ", Name: " + courier.getFirstName() + " " + courier.getLastName() +
                    ", Phone Number: " + courier.getPhoneNumber() +
                    ", Vehicle Type: " + courier.getVehicleType());
        }
    }

    private void updateCourier() {
        System.out.print("Enter courier ID to update: ");
        int courierID = scanner.nextInt();
        scanner.nextLine();

        Optional<Courier> existingCourier = courierController.getEntityById(courierID);
        if (existingCourier.isPresent()) {
            System.out.print("Enter new courier info\n");

            System.out.print("Enter new first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new address\n");
            int addressID = scanner.nextInt();
            System.out.print("Enter new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter new courier vehicle paymentType: ");
            String vehicleType = scanner.nextLine();

            Courier updatedCourier = new Courier(courierID, addressID, firstName, lastName, phoneNumber, vehicleType);
            courierController.updateEntity(updatedCourier);
            System.out.println("Courier updated successfully.");
        } else {
            System.out.println("Courier not found.");
        }
    }

    private void deleteCourier() {
        System.out.print("Enter courier ID to delete: ");
        int courierID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = courierController.deleteEntity(courierID);
        if (deleted) {
            System.out.println("Courier deleted successfully.");
        } else {
            System.out.println("Courier not found.");
        }
    }
}

package ui;

import domain.Courier;
import domain.User;
import repo.inMemory.CourierRepo;

import java.util.List;
import java.util.Scanner;

public class CourierUI {
    private static final CourierRepo courierRepo = new CourierRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
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

    private static void createCourier() {
//        System.out.print("Enter courier info\n");
//        User user = UserUI.createUser();
//        System.out.print("Enter courier vehicle paymentType: ");
//        String vehicleType = scanner.nextLine();
//
//        Courier newCourier = courierRepo.createCourier(user, vehicleType);
//        System.out.println("Courier created with ID: " + newCourier.user().userID());
    }

    private static void viewCouriers() {
//        System.out.println("Couriers:");
//        List<Courier> couriers = courierRepo.getAllCouriers();
//        for (Courier courier : couriers) {
//            System.out.println("ID: " + courier.user().userID() +
//                    ", Name: " + courier.user().firstName() +
//                    ", Phone Number: " + courier.user().phoneNumber() +
//                    ", Vehicle Type: " + courier.vehicleType());
//        }
    }

    private static void updateCourier() {
//        System.out.print("Enter courier ID to update: ");
//        Long courierID = scanner.nextLong();
//        scanner.nextLine();
//
//        Courier existingCourier = courierRepo.getCourierByID(courierID);
//        if (existingCourier != null) {
//            System.out.print("Enter new courier info\n");
//            User user = UserUI.updateUser();
//            System.out.print("Enter new courier vehicle paymentType: ");
//            String vehicleType = scanner.nextLine();
//
//            Courier updatedCourier = new Courier(user, vehicleType);
//            courierRepo.updateCourier(updatedCourier);
//            System.out.println("Courier updated successfully.");
//        } else {
//            System.out.println("Courier not found.");
//        }
    }

    private static void deleteCourier() {
//        System.out.print("Enter courier ID to delete: ");
//        Long courierID = scanner.nextLong();
//        scanner.nextLine();
//
//        boolean deleted = courierRepo.deleteCourier(courierID);
//        if (deleted) {
//            System.out.println("Courier deleted successfully.");
//        } else {
//            System.out.println("Courier not found.");
//        }
    }
}

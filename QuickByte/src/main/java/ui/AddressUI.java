package ui;

import repo.inMemory.AddressRepo;
import domain.Address;

import java.util.Scanner;

public class AddressUI {
    private static final AddressRepo addressRepo = new AddressRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Address");
            System.out.println("2. View Addresses");
            System.out.println("3. Update Address");
            System.out.println("4. Delete Address");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAddress();
                    break;
                case 2:
                    viewAddresses();
                    break;
                case 3:
                    updateAddress();
                    break;
                case 4:
                    deleteAddress();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static Address createAddress() {
//        System.out.print("Enter street: ");
//        String street = scanner.nextLine();
//        System.out.print("Enter postal code: ");
//        String postalCode = scanner.nextLine();
//        System.out.print("Enter city: ");
//        String city = scanner.nextLine();
//        System.out.print("Enter country: ");
//        String country = scanner.nextLine();
//
//        Address newAddress = addressRepo.createAddress(street, postalCode, city, country);
//        System.out.println("Address created with ID: " + newAddress.addressID());
//        return newAddress;
        return null;
    }

    private static void viewAddresses() {
//        System.out.println("Addresses:");
//        for (Address address : addressRepo.getAllAddresses()) {
//            System.out.println("ID: " + address.addressID() +
//                    ", Street: " + address.street() +
//                    ", Postal Code: " + address.postalCode() +
//                    ", City: " + address.city() +
//                    ", Country: " + address.country());
//        }
    }

    public static Address updateAddress() {
//        System.out.print("Enter address ID to update: ");
//        Long addressID = scanner.nextLong();
//        scanner.nextLine();
//        Address updatedAddress = null;
//
//        Address existingAddress = addressRepo.getAddressByID(addressID);
//        if (existingAddress != null) {
//            System.out.print("Enter new street: ");
//            String street = scanner.nextLine();
//            System.out.print("Enter new postal code: ");
//            String postalCode = scanner.nextLine();
//            System.out.print("Enter new city: ");
//            String city = scanner.nextLine();
//            System.out.print("Enter new country: ");
//            String country = scanner.nextLine();
//
//            updatedAddress = new Address(addressID, street, postalCode, city, country);
//            addressRepo.updateAddress(updatedAddress);
//            System.out.println("Address updated successfully.");
//        } else {
//            System.out.println("Address not found.");
//        }
//        return updatedAddress;
        return null;
    }

    private static void deleteAddress() {
//        System.out.print("Enter address ID to delete: ");
//        Long addressID = scanner.nextLong();
//        scanner.nextLine();
//
//        boolean deleted = addressRepo.deleteAddress(addressID);
//        if (deleted) {
//            System.out.println("Address deleted successfully.");
//        } else {
//            System.out.println("Address not found.");
//        }
    }
}


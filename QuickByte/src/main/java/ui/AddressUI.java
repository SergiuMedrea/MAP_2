package ui;

import controller.AddressController;
import domain.Address;
import repo.inMemory.AddressRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AddressUI {
    private static final AddressController addressController = AddressController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public AddressUI() {
        addressController.setRepository(AddressRepo.getInstance());
    }

    public void run() {
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

    public void createAddress() {
        System.out.print("Enter street: ");
        String street = scanner.nextLine();
        System.out.print("Enter postal code: ");
        String postalCode = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter country: ");
        String country = scanner.nextLine();

        Address newAddress = new Address(0, street, postalCode, city, country);
        Address createdAddress = addressController.createEntity(newAddress);

        System.out.println("Address created with ID: " + createdAddress.getAddressID());
    }

    private void viewAddresses() {
        System.out.println("Addresses:");
        List<Address> addresses = addressController.getAllEntities();
        addresses.forEach(address -> {
            System.out.println("ID: " + address.getAddressID() +
                    ", Street: " + address.getStreet() +
                    ", Postal Code: " + address.getPostalCode() +
                    ", City: " + address.getCity() +
                    ", Country: " + address.getCountry());
        });
    }

    public void updateAddress() {
        System.out.print("Enter address ID to update: ");
        int addressID = scanner.nextInt();
        scanner.nextLine();
        Address updatedAddress = null;

        Optional<Address> existingAddress = addressController.getEntityById(addressID);
        if (existingAddress.isPresent()) {
            System.out.print("Enter new street: ");
            String street = scanner.nextLine();
            System.out.print("Enter new postal code: ");
            String postalCode = scanner.nextLine();
            System.out.print("Enter new city: ");
            String city = scanner.nextLine();
            System.out.print("Enter new country: ");
            String country = scanner.nextLine();

            updatedAddress = new Address(addressID, street, postalCode, city, country);
            addressController.updateEntity(updatedAddress);
            System.out.println("Address updated successfully.");
        } else {
            System.out.println("Address not found.");
        }
    }

    private void deleteAddress() {
        System.out.print("Enter address ID to delete: ");
        int addressID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = addressController.deleteEntity(addressID);
        if (deleted) {
            System.out.println("Address deleted successfully.");
        } else {
            System.out.println("Address not found.");
        }
    }
}

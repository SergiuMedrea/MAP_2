package com.mergiu.QuickByteBE.domain.address;

import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddressUI implements EntityUI {

    private final AddressService addressService;

    @Autowired
    public AddressUI(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Menu:");
            System.out.println("1. List all addresses");
            System.out.println("2. Add a new address");
            System.out.println("3. Delete an address");
            System.out.println("4. Update an address");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllAddresses();
                    break;
                case 2:
                    addAddress();
                    break;
                case 3:
                    deleteAddress();
                    break;
                case 4:
                    updateAddress();
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllAddresses() {
        addressService.getAddresses().forEach(System.out::println);
    }

    private void addAddress() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter street:");
        String street = scanner.nextLine();

        System.out.println("Enter postal code:");
        String postalCode = scanner.nextLine();

        System.out.println("Enter city:");
        String city = scanner.nextLine();

        System.out.println("Enter country:");
        String country = scanner.nextLine();

        Address newAddress = new Address(street, postalCode, city, country);
        addressService.addNewAddress(newAddress);

        System.out.println("Address added successfully!");
    }

    private void deleteAddress() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter address id to delete:");
        Long addressId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        addressService.deleteAddress(addressId);

        System.out.println("Address deleted successfully!");
    }

    private void updateAddress() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter address id to update:");
        Long addressId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new street (press Enter to keep current):");
        String newStreet = scanner.nextLine();

        System.out.println("Enter new postal code (press Enter to keep current):");
        String newPostalCode = scanner.nextLine();

        System.out.println("Enter new city (press Enter to keep current):");
        String newCity = scanner.nextLine();

        System.out.println("Enter new country (press Enter to keep current):");
        String newCountry = scanner.nextLine();

        addressService.updateAddress(addressId, newStreet, newPostalCode, newCity, newCountry);

        System.out.println("Address updated successfully!");
    }
}

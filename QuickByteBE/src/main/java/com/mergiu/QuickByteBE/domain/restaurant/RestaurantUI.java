package com.mergiu.QuickByteBE.domain.restaurant;

import com.mergiu.QuickByteBE.domain.address.Address;
import com.mergiu.QuickByteBE.ui.EntityUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RestaurantUI implements EntityUI {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantUI(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Restaurant Menu:");
            System.out.println("1. List all restaurants");
            System.out.println("2. Add a new restaurant");
            System.out.println("3. Delete a restaurant");
            System.out.println("4. Update a restaurant");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    listAllRestaurants();
                    break;
                case 2:
                    addNewRestaurant();
                    break;
                case 3:
                    deleteRestaurant();
                    break;
                case 4:
                    updateRestaurant();
                    break;
                case 5:
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listAllRestaurants() {
        restaurantService.getRestaurants().forEach(System.out::println);
    }

    private void addNewRestaurant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter restaurant name:");
        String name = scanner.nextLine();

        Restaurant restaurant = new Restaurant.Builder()
                .withName(name)
//                .withAddress(address)
                .build();

        restaurantService.addNewRestaurant(restaurant);

        System.out.println("Restaurant added successfully!");
    }

    private void deleteRestaurant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter restaurant ID to delete:");
        Long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        restaurantService.deleteRestaurant(restaurantId);

        System.out.println("Restaurant deleted successfully!");
    }

    private void updateRestaurant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter restaurant ID to update:");
        Long restaurantId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline

        System.out.println("Enter new restaurant name:");
        String newName = scanner.nextLine();

        restaurantService.updateRestaurant(restaurantId, newName, null);

        System.out.println("Restaurant updated successfully!");
    }
}

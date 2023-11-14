package ui;

import domain.Address;
import domain.Restaurant;
import repo.inMemory.RestaurantRepo;

import java.util.List;
import java.util.Scanner;

public class RestaurantUI {
    private static final RestaurantRepo restaurantRepo = new RestaurantRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Restaurant");
            System.out.println("2. View Restaurants");
            System.out.println("3. Update Restaurant");
            System.out.println("4. Delete Restaurant");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createRestaurant();
                    break;
                case 2:
                    viewRestaurants();
                    break;
                case 3:
                    updateRestaurant();
                    break;
                case 4:
                    deleteRestaurant();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createRestaurant() {
//        System.out.print("Enter restaurant name: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter address\n");
//        Address address = AddressUI.createAddress();
//
//        Restaurant newRestaurant = restaurantRepo.createRestaurant(name, address);
//        System.out.println("Restaurant created with ID: " + newRestaurant.restaurantID());
    }

    private static void viewRestaurants() {
//        System.out.println("Restaurants:");
//        List<Restaurant> restaurants = restaurantRepo.getAllRestaurants();
//        for (Restaurant restaurant : restaurants) {
//            System.out.println("ID: " + restaurant.restaurantID() +
//                    ", Name: " + restaurant.name() +
//                    ", Address ID: " + restaurant.address());
//        }
    }

    private static void updateRestaurant() {
//        System.out.print("Enter restaurant ID to update: ");
//        Long restaurantID = scanner.nextLong();
//        scanner.nextLine();
//
//        Restaurant existingRestaurant = restaurantRepo.getRestaurantByID(restaurantID);
//        if (existingRestaurant != null) {
//            System.out.print("Enter new restaurant name: ");
//            String name = scanner.nextLine();
//            System.out.print("Enter new address info\n");
//            Address address = AddressUI.updateAddress();
//
//            Restaurant updatedRestaurant = new Restaurant(restaurantID, name, address);
//            restaurantRepo.updateRestaurant(updatedRestaurant);
//            System.out.println("Restaurant updated successfully.");
//        } else {
//            System.out.println("Restaurant not found.");
//        }
    }

    private static void deleteRestaurant() {
//        System.out.print("Enter restaurant ID to delete: ");
//        Long restaurantID = scanner.nextLong();
//        scanner.nextLine();
//
//        boolean deleted = restaurantRepo.deleteRestaurant(restaurantID);
//        if (deleted) {
//            System.out.println("Restaurant deleted successfully.");
//        } else {
//            System.out.println("Restaurant not found.");
//        }
    }
}

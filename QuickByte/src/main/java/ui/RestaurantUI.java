package ui;

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
            scanner.nextLine(); // Consume newline

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
        System.out.print("Enter restaurant name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address ID: ");
        Long addressID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Restaurant newRestaurant = restaurantRepo.createRestaurant(name, addressID);
        System.out.println("Restaurant created with ID: " + newRestaurant.restaurantID());
    }

    private static void viewRestaurants() {
        System.out.println("Restaurants:");
        List<Restaurant> restaurants = restaurantRepo.getAllRestaurants();
        for (Restaurant restaurant : restaurants) {
            System.out.println("ID: " + restaurant.restaurantID() +
                    ", Name: " + restaurant.name() +
                    ", Address ID: " + restaurant.addressID());
        }
    }

    private static void updateRestaurant() {
        System.out.print("Enter restaurant ID to update: ");
        Long restaurantID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Restaurant existingRestaurant = restaurantRepo.getRestaurantByID(restaurantID);
        if (existingRestaurant != null) {
            System.out.print("Enter new restaurant name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new address ID: ");
            Long addressID = scanner.nextLong();
            scanner.nextLine(); // Consume newline

            Restaurant updatedRestaurant = new Restaurant(restaurantID, name, addressID);
            restaurantRepo.updateRestaurant(updatedRestaurant);
            System.out.println("Restaurant updated successfully.");
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    private static void deleteRestaurant() {
        System.out.print("Enter restaurant ID to delete: ");
        Long restaurantID = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        boolean deleted = restaurantRepo.deleteRestaurant(restaurantID);
        if (deleted) {
            System.out.println("Restaurant deleted successfully.");
        } else {
            System.out.println("Restaurant not found.");
        }
    }
}

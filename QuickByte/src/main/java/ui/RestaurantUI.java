package ui;

import controller.RestaurantController;
import domain.Restaurant;
import repo.inMemory.InMemoryRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RestaurantUI {
    private static final RestaurantController restaurantController = new RestaurantController(new InMemoryRepo<>());
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
        System.out.print("Enter restaurant ID: ");
        int restaurantID = scanner.nextInt();
        System.out.print("Enter address ID: ");
        int addressID = scanner.nextInt();
        System.out.println("Enter restaurant name: ");
        String name = scanner.nextLine();

        Restaurant newRestaurant = new Restaurant(restaurantID, addressID, name);
        Restaurant createdRestaurant = restaurantController.createEntity(newRestaurant);
        System.out.println("Restaurant created with ID: " + createdRestaurant.getRestaurantID());
    }

    private static void viewRestaurants() {
        System.out.println("Restaurants:");
        List<Restaurant> restaurants = restaurantController.getAllEntities();
        for (Restaurant restaurant : restaurants) {
            System.out.println("ID: " + restaurant.getRestaurantID() +
                    ", Name: " + restaurant.getName() +
                    ", Address ID: " + restaurant.getAddressID());
        }
    }

    private static void updateRestaurant() {
        System.out.print("Enter restaurant ID to update: ");
        int restaurantID = scanner.nextInt();
        scanner.nextLine();

        Optional<Restaurant> existingRestaurant = restaurantController.getEntityById(restaurantID);
        if (existingRestaurant.isPresent()) {
            System.out.print("Enter new restaurant name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new address ID: ");
            int addressID = scanner.nextInt();

            Restaurant updatedRestaurant = new Restaurant(restaurantID, addressID, name);
            restaurantController.updateEntity(updatedRestaurant);
            System.out.println("Restaurant updated successfully.");
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    private static void deleteRestaurant() {
        System.out.print("Enter restaurant ID to delete: ");
        int restaurantID = scanner.nextInt();
        scanner.nextLine();

        boolean deleted = restaurantController.deleteEntity(restaurantID);
        if (deleted) {
            System.out.println("Restaurant deleted successfully.");
        } else {
            System.out.println("Restaurant not found.");
        }
    }
}

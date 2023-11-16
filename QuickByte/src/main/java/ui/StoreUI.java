package ui;

import controller.GroceryStoreController;
import controller.RestaurantController;
import domain.*;
import repo.inMemory.GroceryStoreRepo;
import repo.inMemory.RestaurantRepo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StoreUI implements EntityObserver<Restaurant> {
    private static final RestaurantController restaurantController = RestaurantController.getInstance();
    private static final GroceryStoreController groceryStoreController = GroceryStoreController.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public StoreUI() {
        restaurantController.setRepository(RestaurantRepo.getInstance());
        groceryStoreController.setRepository(GroceryStoreRepo.getInstance());
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Create Store");
            System.out.println("2. View Store");
            System.out.println("3. Update Store");
            System.out.println("4. Delete Store");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createStore();
                    break;
                case 2:
                    viewStores();
                    break;
                case 3:
                    updateStores();
                    break;
                case 4:
                    deleteStore();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createStore() {
        System.out.print("Enter address ID: ");
        int addressID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter store name: ");
        String name = scanner.nextLine();

        System.out.println("What type of store do you want to create?(grocery/restaurant)");
        String type = scanner.nextLine().toLowerCase();

        Store store = StoreFactory.getStore(type, 0, addressID, name);
        assert store != null;

        if (type.equals("restaurant")) {
            Restaurant createdRestaurant = restaurantController.createEntity((Restaurant) store);
            System.out.println("Restaurant created with ID: " + createdRestaurant.getShopID());
        } else if (type.equals("grocery")) {
            GroceryStore createdGroceryStore = groceryStoreController.createEntity((GroceryStore) store);
            System.out.println("Grocery Store created with ID: " + createdGroceryStore.getShopID());
        } else {
            System.out.println("Invalid store type.");
        }
    }

    private void viewStores() {
        System.out.println("Restaurants:");
        List<Restaurant> restaurants = restaurantController.getAllEntities();
        for (Restaurant restaurant : restaurants) {
            System.out.println("ID: " + restaurant.getShopID() +
                    ", Name: " + restaurant.getName() +
                    ", Address ID: " + restaurant.getAddressID());
        }

        System.out.println("Grocery Stores:");
        List<GroceryStore> groceryStores = groceryStoreController.getAllEntities();
        for (GroceryStore groceryStore : groceryStores) {
            System.out.println("ID: " + groceryStore.getShopID() +
                    ", Name: " + groceryStore.getName() +
                    ", Address ID: " + groceryStore.getAddressID());
        }
    }

    private void updateStores() {
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

    private void deleteStore() {
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

    @Override
    public void onEntityCreated(Restaurant entity) {

    }

    @Override
    public void onEntityUpdated(Restaurant entity) {

    }

    @Override
    public void onEntityDeleted(int entityId) {

    }
}

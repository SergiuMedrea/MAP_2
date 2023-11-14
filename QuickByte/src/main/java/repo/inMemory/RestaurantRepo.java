package repo.inMemory;

import domain.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class RestaurantRepo {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private int nextRestaurantID = 1;

    /**
     * Create a new restaurant and add it to the repository
     */
    public Restaurant createRestaurant(int addressID, String name) {
        Restaurant newRestaurant = new Restaurant(nextRestaurantID, addressID, name);
        restaurants.add(newRestaurant);
        nextRestaurantID++;
        return newRestaurant;
    }

    /**
     * Retrieve a restaurant by ID | Optional.empty() if not found
     */
    public Optional<Restaurant> getRestaurantByID(int restaurantID) {
        return restaurants.stream()
                .filter(restaurant -> Objects.equals(restaurantID, restaurant.restaurantID()))
                .findFirst();
    }

    /**
     * Retrieve all restaurants
     */
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants);
    }

    /**
     * Update an existing restaurant
     */
    public boolean updateRestaurant(Restaurant updatedRestaurant) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant existingRestaurant = restaurants.get(i);
            if (Objects.equals(existingRestaurant.restaurantID(), updatedRestaurant.restaurantID())) {
                restaurants.set(i, updatedRestaurant);
                return true; // Update successful
            }
        }
        return false; // Restaurant not found
    }

    /**
     * Delete a restaurant by ID
     */
    public boolean deleteRestaurant(int restaurantID) {
        return restaurants.removeIf(restaurant -> Objects.equals(restaurantID, restaurant.restaurantID()));
    }
}

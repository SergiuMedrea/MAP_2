package repo.inMemory;

import entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepo {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private long nextRestaurantID = 1;

    public Restaurant createRestaurant(String name, Long addressID) {
        Restaurant newRestaurant = new Restaurant(nextRestaurantID, name, addressID);
        restaurants.add(newRestaurant);
        nextRestaurantID++;
        return newRestaurant;
    }

    public Restaurant getRestaurantByID(Long restaurantID) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.restaurantID().equals(restaurantID))
                .findFirst()
                .orElse(null);
    }

    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants);
    }

    public Restaurant updateRestaurant(Restaurant updatedRestaurant) {
        for (int i = 0; i < restaurants.size(); i++) {
            Restaurant restaurant = restaurants.get(i);
            if (restaurant.restaurantID().equals(updatedRestaurant.restaurantID())) {
                restaurants.set(i, updatedRestaurant);
                return updatedRestaurant;
            }
        }

        return null;
    }

    public boolean deleteRestaurant(Long restaurantID) {
        return restaurants.removeIf(restaurant -> restaurant.restaurantID().equals(restaurantID));
    }
}

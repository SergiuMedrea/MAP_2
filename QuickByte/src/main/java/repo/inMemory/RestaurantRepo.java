package repo.inMemory;

import domain.Restaurant;

public class RestaurantRepo extends InMemoryRepo<Restaurant> {
    private static RestaurantRepo instance = null;

    private RestaurantRepo() {
    }

    public static RestaurantRepo getInstance() {
        if (instance == null) {
            instance = new RestaurantRepo();
        }

        return instance;
    }
}

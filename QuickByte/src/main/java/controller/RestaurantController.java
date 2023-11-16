package controller;

import domain.Restaurant;
import repo.inMemory.InMemoryRepo;

public class RestaurantController extends EntityController<Restaurant>{
    private static RestaurantController instance = null;

    private RestaurantController() {}

    public static RestaurantController getInstance() {
        if (instance == null) {
            instance = new RestaurantController();
        }

        return instance;
    }
}

package controller;

import domain.Restaurant;
import repo.inMemory.InMemoryRepo;

public class RestaurantController extends EntityController<Restaurant>{
    public RestaurantController(InMemoryRepo<Restaurant> repository) {
        super(repository);
    }
}

package controller;

import domain.Courier;
import repo.inMemory.InMemoryRepo;

public class CourierController extends EntityController<Courier>{
    public CourierController(InMemoryRepo<Courier> repository) {
        super(repository);
    }
}

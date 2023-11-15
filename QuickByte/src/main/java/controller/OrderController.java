package controller;

import domain.Order;
import repo.inMemory.InMemoryRepo;

public class OrderController extends EntityController<Order>{
    public OrderController(InMemoryRepo<Order> repository) {
        super(repository);
    }
}

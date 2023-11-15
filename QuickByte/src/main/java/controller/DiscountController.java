package controller;

import domain.Discount;
import repo.inMemory.InMemoryRepo;

public class DiscountController extends EntityController<Discount>{
    public DiscountController(InMemoryRepo<Discount> repository) {
        super(repository);
    }
}

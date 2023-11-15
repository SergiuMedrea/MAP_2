package controller;

import domain.MenuItem;
import repo.inMemory.InMemoryRepo;

public class MenuItemController extends EntityController<MenuItem>{
    public MenuItemController(InMemoryRepo<MenuItem> repository) {
        super(repository);
    }
}

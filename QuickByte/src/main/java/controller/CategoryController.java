package controller;

import domain.Category;
import repo.inMemory.InMemoryRepo;

public class CategoryController  extends EntityController<Category>{
    public CategoryController(InMemoryRepo<Category> repository) {
        super(repository);
    }
}

package controller;

import domain.Category;
import repo.inMemory.InMemoryRepo;

public class CategoryController  extends EntityController<Category>{
    private static CategoryController instance = null;

    private CategoryController() {}

    public static CategoryController getInstance() {
        if (instance == null) {
            instance = new CategoryController();
        }

        return instance;
    }
}

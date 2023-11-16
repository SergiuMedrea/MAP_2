package repo.inMemory;

import domain.Category;

public class CategoryRepo extends InMemoryRepo<Category> {
    private static CategoryRepo instance = null;

    private CategoryRepo() {
    }

    public static CategoryRepo getInstance() {
        if (instance == null) {
            instance = new CategoryRepo();
        }

        return instance;
    }
}

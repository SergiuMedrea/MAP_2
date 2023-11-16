package repo.inMemory;

import domain.GroceryStore;

public class GroceryStoreRepo extends InMemoryRepo<GroceryStore> {
    private static GroceryStoreRepo instance = null;

    private GroceryStoreRepo() {
    }

    public static GroceryStoreRepo getInstance() {
        if (instance == null) {
            instance = new GroceryStoreRepo();
        }

        return instance;
    }
}

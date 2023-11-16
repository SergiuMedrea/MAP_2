package repo.inMemory;

import domain.MenuItem;

public class MenuItemRepo extends InMemoryRepo<MenuItem> {
    private static MenuItemRepo instance = null;

    private MenuItemRepo() {
    }

    public static MenuItemRepo getInstance() {
        if (instance == null) {
            instance = new MenuItemRepo();
        }

        return instance;
    }
}

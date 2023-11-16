package controller;

import domain.GroceryStore;

public class GroceryStoreController extends EntityController<GroceryStore> {
    private static GroceryStoreController instance = null;

    private GroceryStoreController() {
    }

    public static GroceryStoreController getInstance() {
        if (instance == null) {
            instance = new GroceryStoreController();
        }

        return instance;
    }
}

package controller;

import domain.MenuItem;

public class MenuItemController extends EntityController<MenuItem> {
    private static MenuItemController instance = null;

    private MenuItemController() {
    }

    ;

    public static MenuItemController getInstance() {
        if (instance == null) {
            instance = new MenuItemController();
        }

        return instance;
    }
}

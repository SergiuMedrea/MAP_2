package repo.inMemory;

import entities.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuItemRepo {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private long nextMenuItemID = 1;

    public MenuItem createMenuItem(String name, int price, String description, String category, Long restaurantID) {
        MenuItem newMenuItem = new MenuItem(nextMenuItemID, name, price, description, category, restaurantID);
        menuItems.add(newMenuItem);
        nextMenuItemID++;
        return newMenuItem;
    }

    public MenuItem getMenuItemByID(Long menuItemID) {
        return menuItems.stream()
                .filter(item -> item.menuItemID().equals(menuItemID))
                .findFirst()
                .orElse(null);
    }

    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItems);
    }

    public MenuItem updateMenuItem(MenuItem updatedMenuItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            if (menuItem.menuItemID().equals(updatedMenuItem.menuItemID())) {
                menuItems.set(i, updatedMenuItem);
                return updatedMenuItem;
            }
        }

        return null;
    }

    public boolean deleteMenuItem(Long menuItemID) {
        return menuItems.removeIf(item -> item.menuItemID().equals(menuItemID));
    }
}

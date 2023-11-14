package repo.inMemory;

import domain.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MenuItemRepo {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private int nextMenuItemID = 1;

    /**
     * Create a new menu item and add it to the repository
     */
    public MenuItem createMenuItem(int categoryID, int restaurantID, String name, int price, String description) {
        MenuItem newMenuItem = new MenuItem(nextMenuItemID, categoryID, restaurantID, name, price, description);
        menuItems.add(newMenuItem);
        nextMenuItemID++;
        return newMenuItem;
    }

    /**
     * Retrieve a menu item by ID | Optional.empty() if not found
     */
    public Optional<MenuItem> getMenuItemByID(int menuItemID) {
        return menuItems.stream()
                .filter(menuItem -> Objects.equals(menuItemID, menuItem.menuItemID()))
                .findFirst();
    }

    /**
     * Retrieve all menu items
     */
    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItems);
    }

    /**
     * Update an existing menu item
     */
    public boolean updateMenuItem(MenuItem updatedMenuItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem existingMenuItem = menuItems.get(i);
            if (Objects.equals(existingMenuItem.menuItemID(), updatedMenuItem.menuItemID())) {
                menuItems.set(i, updatedMenuItem);
                return true; // Update successful
            }
        }
        return false; // Menu item not found
    }

    /**
     * Delete a menu item by ID
     */
    public boolean deleteMenuItem(int menuItemID) {
        return menuItems.removeIf(menuItem -> Objects.equals(menuItemID, menuItem.menuItemID()));
    }
}

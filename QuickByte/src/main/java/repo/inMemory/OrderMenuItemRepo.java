package repo.inMemory;

import domain.OrderMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderMenuItemRepo {
    private final List<OrderMenuItem> orderMenuItems = new ArrayList<>();
    private int nextID = 1;

    /**
     * Create a new order menu item and add it to the repository
     */
    public OrderMenuItem create(OrderMenuItem orderMenuItem) {
        orderMenuItem.setOrderID(nextID);
        orderMenuItems.add(orderMenuItem);
        nextID++;
        return orderMenuItem;
    }

    /**
     * Retrieve an order menu item by ID | Optional.empty() if not found
     */
    public Optional<OrderMenuItem> getById(int orderID, int menuItemID) {
        return orderMenuItems.stream()
                .filter(orderMenuItem -> orderMenuItem.getOrderID() == orderID && orderMenuItem.getMenuItemID() == menuItemID)
                .findFirst();
    }

    /**
     * Retrieve all order menu items
     */
    public List<OrderMenuItem> getAll() {
        return new ArrayList<>(orderMenuItems);
    }

    /**
     * Update an existing order menu item
     */
    public boolean update(OrderMenuItem updatedOrderMenuItem) {
        for (int i = 0; i < orderMenuItems.size(); i++) {
            OrderMenuItem existingOrderMenuItem = orderMenuItems.get(i);
            if (existingOrderMenuItem.getOrderID() == updatedOrderMenuItem.getOrderID() && existingOrderMenuItem.getMenuItemID() == updatedOrderMenuItem.getMenuItemID()) {
                orderMenuItems.set(i, updatedOrderMenuItem);
                return true; // Update successful
            }
        }
        return false; // Order menu item not found
    }

    /**
     * Delete an order menu item by ID
     */
    public boolean delete(int orderID, int menuItemID) {
        return orderMenuItems.removeIf(orderMenuItem -> orderMenuItem.getOrderID() == orderID && orderMenuItem.getMenuItemID() == menuItemID);
    }
}

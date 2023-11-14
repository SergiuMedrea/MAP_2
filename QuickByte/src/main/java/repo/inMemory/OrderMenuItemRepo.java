package repo.inMemory;

import domain.OrderMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderMenuItemRepo {
    private final List<OrderMenuItem> orderMenuItems = new ArrayList<>();
    private int nextOrderMenuItemID = 1;

    /**
     * Create a new order menu item and add it to the repository
     */
    public OrderMenuItem createOrderMenuItem(int orderID, int menuItemID, int quantity) {
        OrderMenuItem newOrderMenuItem = new OrderMenuItem(orderID, menuItemID, quantity);
        orderMenuItems.add(newOrderMenuItem);
        nextOrderMenuItemID++;
        return newOrderMenuItem;
    }

    /**
     * Retrieve an order menu item by ID | Optional.empty() if not found
     */
    public Optional<OrderMenuItem> getOrderMenuItemByID(int orderID) {
        return orderMenuItems.stream()
                .filter(orderMenuItem -> Objects.equals(orderID, orderMenuItem.orderID()))
                .findFirst();
    }

    /**
     * Retrieve all order menu items
     */
    public List<OrderMenuItem> getAllOrderMenuItems() {
        return new ArrayList<>(orderMenuItems);
    }

    /**
     * Update an existing order menu item
     */
    public boolean updateOrderMenuItem(OrderMenuItem updatedOrderMenuItem) {
        for (int i = 0; i < orderMenuItems.size(); i++) {
            OrderMenuItem existingOrderMenuItem = orderMenuItems.get(i);
            if (Objects.equals(existingOrderMenuItem.orderID(), updatedOrderMenuItem.orderID())) {
                orderMenuItems.set(i, updatedOrderMenuItem);
                return true; // Update successful
            }
        }
        return false; // Order menu item not found
    }

    /**
     * Delete an order menu item by ID
     */
    public boolean deleteOrderMenuItem(int orderID) {
        return orderMenuItems.removeIf(orderMenuItem -> Objects.equals(orderID, orderMenuItem.orderID()));
    }
}

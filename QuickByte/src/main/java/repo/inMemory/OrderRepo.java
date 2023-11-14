package repo.inMemory;

import domain.Order;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderRepo {
    private final List<Order> orders = new ArrayList<>();
    private int nextOrderID = 1;

    /**
     * Create a new order and add it to the repository
     */
    public Order createOrder(int userID, int courierID, int addressID, Timestamp dateTime) {
        Order newOrder = new Order(nextOrderID, userID, courierID, addressID, dateTime);
        orders.add(newOrder);
        nextOrderID++;
        return newOrder;
    }

    /**
     * Retrieve an order by ID | Optional.empty() if not found
     */
    public Optional<Order> getOrderByID(int orderID) {
        return orders.stream()
                .filter(order -> Objects.equals(orderID, order.orderID()))
                .findFirst();
    }

    /**
     * Retrieve all orders
     */
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    /**
     * Update an existing order
     */
    public boolean updateOrder(Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order existingOrder = orders.get(i);
            if (Objects.equals(existingOrder.orderID(), updatedOrder.orderID())) {
                orders.set(i, updatedOrder);
                return true; // Update successful
            }
        }
        return false; // Order not found
    }

    /**
     * Delete an order by ID
     */
    public boolean deleteOrder(int orderID) {
        return orders.removeIf(order -> Objects.equals(orderID, order.orderID()));
    }
}

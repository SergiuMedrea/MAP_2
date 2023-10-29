package repo.inMemory;

import entities.Order;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class OrderRepo {
    private final List<Order> orders = new ArrayList<>();
    private long nextOrderID = 1;

    public Order createOrder(Date date, Long userID, Long courierID, Long addressID) {
        Order newOrder = new Order(nextOrderID, date, userID, courierID, addressID);
        orders.add(newOrder);
        nextOrderID++;
        return newOrder;
    }

    public Order getOrderByID(Long orderID) {
        return orders.stream()
                .filter(order -> order.orderID().equals(orderID))
                .findFirst()
                .orElse(null);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Order updateOrder(Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.orderID().equals(updatedOrder.orderID())) {
                orders.set(i, updatedOrder);
                return updatedOrder;
            }
        }

        return null;
    }

    public boolean deleteOrder(Long orderID) {
        return orders.removeIf(order -> order.orderID().equals(orderID));
    }
}

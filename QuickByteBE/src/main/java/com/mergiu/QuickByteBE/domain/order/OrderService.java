package com.mergiu.QuickByteBE.domain.order;

import com.mergiu.QuickByteBE.domain.menuItem.MenuItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void addNewOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.findById(order.getOrderId());
        if(orderOptional.isPresent())
            throw new IllegalStateException("Order with id " + order.getOrderId() + " already exists");

        order.setOrderStatus("placed");
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));

        orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);

        if (!exists) {
            throw new IllegalStateException("Order with id " + orderId + " does not exist");
        }

        orderRepository.deleteById(orderId);
    }

    @Transactional
    public void updateOrder(Long orderId, String orderStatus) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id " + orderId + " does not exist"));

        if (orderStatus != null && !orderStatus.isEmpty() && !Objects.equals(order.getOrderStatus(), orderStatus)) {
            order.setOrderStatus(orderStatus);
        }

        if (orderStatus.equals("delivered"))
            order.setDeliveryTime(new Timestamp(System.currentTimeMillis()));

        orderRepository.save(order);
    }

    public void addMenuItemToOrder(Long orderId, MenuItem menuItem) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id " + orderId + " does not exist"));

        order.getMenuItems().add(menuItem);

        orderRepository.save(order);
    }

    public void deleteMenuItemFromOrder(Long orderId, MenuItem menuItem) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id " + orderId + " does not exist"));

        order.getMenuItems().remove(menuItem);

        orderRepository.save(order);
    }
}

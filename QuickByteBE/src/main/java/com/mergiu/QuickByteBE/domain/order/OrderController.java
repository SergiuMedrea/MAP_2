package com.mergiu.QuickByteBE.domain.order;

import com.mergiu.QuickByteBE.domain.menuItem.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public void addNewOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(
            @PathVariable Long orderId,
            @RequestParam(required = false) String orderStatus) {
        orderService.updateOrder(orderId, orderStatus);
    }

    @PostMapping("/{orderId}/menuItems")
    public void addMenuItemToOrder(@PathVariable Long orderId, @RequestBody MenuItem menuItem) {
        orderService.addMenuItemToOrder(orderId, menuItem);
    }

    @DeleteMapping("/{orderId}/menuItems/{menuItemId}")
    public void deleteMenuItemFromOrder(@PathVariable Long orderId, @PathVariable MenuItem menuItem) {
        orderService.deleteMenuItemFromOrder(orderId, menuItem);
    }
}

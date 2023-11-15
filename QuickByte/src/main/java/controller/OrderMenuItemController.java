package controller;

import domain.OrderMenuItem;
import repo.inMemory.OrderMenuItemRepo;

import java.util.List;
import java.util.Optional;

public class OrderMenuItemController {
    private final OrderMenuItemRepo orderMenuItemRepo;

    public OrderMenuItemController(OrderMenuItemRepo orderMenuItemRepo) {
        this.orderMenuItemRepo = orderMenuItemRepo;
    }

    public OrderMenuItem createOrderMenuItem(OrderMenuItem orderMenuItem) {
        return orderMenuItemRepo.create(orderMenuItem);
    }

    public Optional<OrderMenuItem> getOrderMenuItemById(int orderID, int menuItemID) {
        return orderMenuItemRepo.getById(orderID, menuItemID);
    }

    public List<OrderMenuItem> getAllOrderMenuItems() {
        return orderMenuItemRepo.getAll();
    }

    public boolean updateOrderMenuItem(OrderMenuItem updatedOrderMenuItem) {
        return orderMenuItemRepo.update(updatedOrderMenuItem);
    }

    public boolean deleteOrderMenuItem(int orderID, int menuItemID) {
        return orderMenuItemRepo.delete(orderID, menuItemID);
    }
}

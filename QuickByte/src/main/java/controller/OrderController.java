package controller;

import domain.Order;

public class OrderController extends EntityController<Order> {
    private static OrderController instance = null;

    private OrderController() {
    }

    public static OrderController getInstance() {
        if (instance == null) {
            instance = new OrderController();
        }

        return instance;
    }
}

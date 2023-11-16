package repo.inMemory;

import domain.Order;

public class OrderRepo extends InMemoryRepo<Order> {
    private static OrderRepo instance = null;

    private OrderRepo() {
    }

    public static OrderRepo getInstance() {
        if (instance == null) {
            instance = new OrderRepo();
        }

        return instance;
    }
}

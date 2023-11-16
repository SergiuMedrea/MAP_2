package repo.inMemory;

import domain.Discount;

public class DiscountRepo extends InMemoryRepo<Discount>{
    private static DiscountRepo instance = null;

    private DiscountRepo() {
    }

    public static DiscountRepo getInstance() {
        if (instance == null) {
            instance = new DiscountRepo();
        }

        return instance;
    }
}

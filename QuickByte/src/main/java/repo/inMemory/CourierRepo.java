package repo.inMemory;

import domain.Courier;

public class CourierRepo extends InMemoryRepo<Courier> {
    private static CourierRepo instance = null;

    private CourierRepo() {
    }

    public static CourierRepo getInstance() {
        if (instance == null) {
            instance = new CourierRepo();
        }

        return instance;
    }
}

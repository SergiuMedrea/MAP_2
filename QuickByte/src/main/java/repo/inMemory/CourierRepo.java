package repo.inMemory;

import domain.Courier;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CourierRepo {
    private final List<Courier> couriers = new ArrayList<>();
    private int nextCourierID = 1;

    /**
     * Create a new courier and add it to the repository
     */
    public Courier createCourier(User user, String vehicleType) {
        Courier newCourier = new Courier(user, vehicleType);
        couriers.add(newCourier);
        return newCourier;
    }

    /**
     * Retrieve a courier by user | Optional.empty() if not found
     */
    public Optional<Courier> getCourierByUser(User user) {
        return couriers.stream()
                .filter(courier -> Objects.equals(user, courier.user()))
                .findFirst();
    }

    /**
     * Retrieve all couriers
     */
    public List<Courier> getAllCouriers() {
        return new ArrayList<>(couriers);
    }

    /**
     * Update an existing courier
     */
    public boolean updateCourier(Courier updatedCourier) {
        for (int i = 0; i < couriers.size(); i++) {
            Courier existingCourier = couriers.get(i);
            if (Objects.equals(existingCourier.user(), updatedCourier.user())) {
                couriers.set(i, updatedCourier);
                return true; // Update successful
            }
        }
        return false; // Courier not found
    }

    /**
     * Delete a courier by user
     */
    public boolean deleteCourier(User user) {
        return couriers.removeIf(courier -> Objects.equals(user, courier.user()));
    }
}

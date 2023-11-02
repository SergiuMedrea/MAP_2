package repo.inMemory;

import domain.Courier;
import domain.Order;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class CourierRepo {
    private final List<Courier> couriers = new ArrayList<>();
    private long nextCourierID = 1;

    public Courier createCourier(User user, String vehicleType) {
        Courier newCourier = new Courier(user, vehicleType);
        couriers.add(newCourier);
        nextCourierID++;
        return newCourier;
    }

    public Courier getCourierByID(Long courierID) {
        return couriers.stream()
                .filter(courier -> courier.user().userID().equals(courierID))
                .findFirst()
                .orElse(null);
    }

    public List<Courier> getAllCouriers() {
        return new ArrayList<>(couriers);
    }

    public Courier updateCourier(Courier updatedCourier) {
        for (int i = 0; i < couriers.size(); i++) {
            Courier courier = couriers.get(i);
            if (courier.user().userID().equals(updatedCourier.user().userID())) {
                couriers.set(i, updatedCourier);
                return updatedCourier;
            }
        }

        return null;
    }

    public boolean deleteCourier(Long courierID) {
        return couriers.removeIf(courier -> courier.user().userID().equals(courierID));
    }
}

package repo.inMemory;

import entities.Courier;

import java.util.ArrayList;
import java.util.List;

public class CourierRepo {
    private final List<Courier> couriers = new ArrayList<>();
    private long nextCourierID = 1;

    public Courier createCourier(String name, String phoneNumber, String vehicleType) {
        Courier newCourier = new Courier(nextCourierID, name, phoneNumber, vehicleType);
        couriers.add(newCourier);
        nextCourierID++;
        return newCourier;
    }

    public Courier getCourierByID(Long courierID) {
        return couriers.stream()
                .filter(courier -> courier.courierID().equals(courierID))
                .findFirst()
                .orElse(null);
    }

    public List<Courier> getAllCouriers() {
        return new ArrayList<>(couriers);
    }

    public Courier updateCourier(Courier updatedCourier) {
        for (int i = 0; i < couriers.size(); i++) {
            Courier courier = couriers.get(i);
            if (courier.courierID().equals(updatedCourier.courierID())) {
                couriers.set(i, updatedCourier);
                return updatedCourier;
            }
        }

        return null;
    }

    public boolean deleteCourier(Long courierID) {
        return couriers.removeIf(courier -> courier.courierID().equals(courierID));
    }
}

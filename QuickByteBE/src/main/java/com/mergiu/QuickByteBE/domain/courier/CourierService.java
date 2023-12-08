//package com.mergiu.QuickByteBE.domain.courier;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class CourierService {
//    private final CourierRepository courierRepository;
//
//    @Autowired
//    public CourierService(CourierRepository courierRepository) {
//        this.courierRepository = courierRepository;
//    }
//
//    public List<Courier> getCouriers() {
//        return courierRepository.findAll();
//    }
//
//    public void addNewCourier(Courier courier) {
//        Optional<Courier> courierOptional = courierRepository.findByPhoneNumber(courier.getPhoneNumber());
//
//        if (courierOptional.isPresent())
//            throw new IllegalStateException("Phone number taken");
//
//        courierRepository.save(courier);
//    }
//
//    public void deleteCourier(Long courierId) {
//        boolean exists = courierRepository.existsById(courierId);
//
//        if (!exists)
//            throw new IllegalStateException("Courier with id " + courierId + " does not exist");
//
//        courierRepository.deleteById(courierId);
//    }
//
//    public void updateCourier(Long courierId, String firstName, String lastName, String phoneNumber, String vehicleType) {
//        Courier courier = courierRepository.findById(courierId)
//                .orElseThrow(() -> new IllegalStateException("courier with id " + courierId + " does not exist"));
//
//        if (firstName != null &&
//                !firstName.isEmpty() &&
//                !Objects.equals(courier.getFirstName(), firstName)) {
//            courier.setFirstName(firstName);
//        }
//
//        if (lastName != null &&
//                !lastName.isEmpty() &&
//                !Objects.equals(courier.getLastName(), lastName)) {
//            courier.setLastName(lastName);
//        }
//
//        if (phoneNumber != null &&
//                !phoneNumber.isEmpty() &&
//                !Objects.equals(courier.getPhoneNumber(), phoneNumber)) {
//            Optional<Courier> courierOptional = courierRepository.findByPhoneNumber(phoneNumber);
//
//            if (courierOptional.isPresent())
//                throw new IllegalStateException("Phone number taken");
//
//            courier.setPhoneNumber(phoneNumber);
//        }
//
//        if (vehicleType != null &&
//                !vehicleType.isEmpty() &&
//                !Objects.equals(courier.getVehicleType(), vehicleType)) {
//            courier.setVehicleType(vehicleType);
//        }
//
//        courierRepository.save(courier);
//    }
//}

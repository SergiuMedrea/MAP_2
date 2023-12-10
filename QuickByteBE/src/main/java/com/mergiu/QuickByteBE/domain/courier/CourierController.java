package com.mergiu.QuickByteBE.domain.courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/courier")
public class CourierController {
    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping
    public List<Courier> getCouriers() {
        return courierService.getCouriers();
    }

    @PostMapping
    public void registerNewCourier(@RequestBody Courier courier) {
        courierService.addNewCourier(courier);
    }

    @DeleteMapping(path = "{courierId}")
    public void deleteCourier(@PathVariable("courierId") Long courierId) {
        courierService.deleteCourier(courierId);
    }

    @PutMapping(path = "{courierId}")
    public void updateCourier(
            @PathVariable("courierId") Long courierId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String vehicleType
    ){
        courierService.updateCourier(courierId, firstName, lastName, phoneNumber, vehicleType);
    }

}

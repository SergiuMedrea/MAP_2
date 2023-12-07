package com.mergiu.QuickByteBE.domain.courier;

import com.mergiu.QuickByteBE.domain.address.Address;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "couriers")
public class Courier extends User {

    @Id
    @SequenceGenerator(
            name = "courier_sequence",
            sequenceName = "courier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courier_sequence"
    )
    private Long courierId;

    private String vehicleType;

    public Courier() {
    }

    public Courier(Address address, String firstName, String lastName, String phoneNumber, String vehicleType) {
        super(firstName, lastName, phoneNumber, address);
        this.vehicleType = vehicleType;
    }


    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}


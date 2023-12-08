package com.mergiu.QuickByteBE.domain.courier;

import com.mergiu.QuickByteBE.domain.address.Address;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "couriers")
//@PrimaryKeyJoinColumn(name = "courierId")
public class Courier extends User {

    private String vehicleType;

    public Courier() {
    }

    public Courier(Address address, String firstName, String lastName, String phoneNumber, String vehicleType) {
        super(firstName, lastName, phoneNumber, address);
        this.vehicleType = vehicleType;
    }


    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}


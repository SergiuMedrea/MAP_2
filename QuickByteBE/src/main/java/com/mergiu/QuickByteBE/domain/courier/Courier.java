package com.mergiu.QuickByteBE.domain.courier;

import com.mergiu.QuickByteBE.domain.address.Address;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@Table(name = "couriers")
public class Courier extends User {
    @NonNull
    private String vehicleType;

    public Courier(Long userID, Address address, String firstName, String lastName, String phoneNumber, String vehicleType) {
        super(userID, firstName, lastName, phoneNumber, address);
        this.vehicleType = vehicleType;
    }
}

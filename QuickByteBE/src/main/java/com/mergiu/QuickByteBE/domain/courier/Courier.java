package com.mergiu.QuickByteBE.domain.courier;

import com.mergiu.QuickByteBE.domain.address.Address;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "couriers")
public class Courier extends User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long courierId;
    @NonNull
    private String vehicleType;


    public Courier(Long userID, Address address, String firstName, String lastName, String phoneNumber, String vehicleType) {
        super(userID, firstName, lastName, phoneNumber, address);
        this.vehicleType = vehicleType;
    }
}

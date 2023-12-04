package com.mergiu.QuickByteBE.domain.address;

import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long addressId;
    @NonNull
    private String Street;
    @NonNull
    private String postalCode;
    @NonNull
    private String city;
    @NonNull
    private String country;
    @OneToOne(mappedBy = "address")
    private User user;
}

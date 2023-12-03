package com.mergiu.QuickByteBE.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@Data
@Table(name = "addresses")
public class Address {
    @Id
    private Long addressId;
    private String Street;
    private String postalCode;
    private String city;
    private String country;
    @OneToOne(mappedBy = "address")
    private User user;

}

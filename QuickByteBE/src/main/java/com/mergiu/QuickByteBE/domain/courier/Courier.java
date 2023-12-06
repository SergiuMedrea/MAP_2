package com.mergiu.QuickByteBE.domain.courier;

import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "couriers")
public class Courier extends User {
    @NonNull
    private String vehicleType;
}

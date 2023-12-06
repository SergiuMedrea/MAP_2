package com.mergiu.QuickByteBE.domain.discount;

import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "discounts")
public class Discount {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long discountId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "restaurantId")
    private Restaurant restaurantID;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;
    @Min(value = 0, message = "Discount percentage must be greater than or equal to 0")
    @Max(value = 100, message = "Discount percentage must be less than or equal to 100")
    private int discountPercentage;
}

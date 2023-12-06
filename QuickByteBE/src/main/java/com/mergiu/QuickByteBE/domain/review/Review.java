package com.mergiu.QuickByteBE.domain.review;

import com.mergiu.QuickByteBE.domain.courier.Courier;
import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "reviews ")
public class Review {
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
    private Long reviewId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "user_id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_courier_id", referencedColumnName = "courier_id")
    private Courier courier;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;
    @Min(value = 0, message = "Rating must be greater than or equal to 0")
    @Max(value = 5, message = "Rating must be less than or equal to 5")
    private int rating;
    @NonNull
    private String comment;
}

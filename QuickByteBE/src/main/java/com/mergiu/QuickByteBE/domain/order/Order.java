package com.mergiu.QuickByteBE.domain.order;

import com.mergiu.QuickByteBE.domain.courier.Courier;
import com.mergiu.QuickByteBE.domain.menuItem.MenuItem;
import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {
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
    private Long orderId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "restaurantId")
    private Restaurant restaurantID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "userId")
    private User userID;
    @NonNull
    private String orderStatus;
    @NonNull
    private Timestamp orderTime;
    @NonNull
    private Timestamp deliveryTime;
    @ManyToMany
    @JoinTable(
            name = "order_menuitem",
            joinColumns = @JoinColumn(name = "fk_order_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_menuitem_id")
    )
    private Set<MenuItem> menuItems;
}

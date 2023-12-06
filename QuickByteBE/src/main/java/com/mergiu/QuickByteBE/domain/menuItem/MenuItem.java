package com.mergiu.QuickByteBE.domain.menuItem;

import com.mergiu.QuickByteBE.domain.category.Category;
import com.mergiu.QuickByteBE.domain.order.Order;
import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "menuItems")
public class MenuItem {
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
    private Long menuItemId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "restaurantId")
    private Restaurant restaurantID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id", referencedColumnName = "categoryId")
    private Category categoryID;
    @NonNull
    private String name;
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private int price;
    @NonNull
    private String description;
    @ManyToMany(mappedBy = "menuItems")
    private Set<Order> menuOrders;
}

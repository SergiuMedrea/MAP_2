package com.mergiu.QuickByteBE.domain.menuItem;

import com.mergiu.QuickByteBE.domain.category.Category;
import com.mergiu.QuickByteBE.domain.order.Order;
import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;


@Entity
@Table(name = "menuItems")
public class MenuItem {

    @Id
    @SequenceGenerator(
            name = "menuitem_sequence",
            sequenceName = "menuitem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menuitem_sequence"
    )
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "id")
    private Restaurant restaurantID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id", referencedColumnName = "id")
    private Category categoryID;

    private String name;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private int price;

    private String description;

    @ManyToMany(mappedBy = "menuItems")
    private Set<Order> menuOrders;

    public MenuItem() {
    }

    public MenuItem(Restaurant restaurantID, Category categoryID, String name, int price, String description) {
        this.restaurantID = restaurantID;
        this.categoryID = categoryID;
        this.name = name;
        this.price = price;
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long menuItemId) {
        this.id = menuItemId;
    }

    public Restaurant getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Restaurant restaurantID) {
        this.restaurantID = restaurantID;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Order> getMenuOrders() {
        return menuOrders;
    }

    public void setMenuOrders(Set<Order> menuOrders) {
        this.menuOrders = menuOrders;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", restaurantID=" + restaurantID +
                ", categoryID=" + categoryID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", menuOrders=" + menuOrders +
                '}';
    }
}


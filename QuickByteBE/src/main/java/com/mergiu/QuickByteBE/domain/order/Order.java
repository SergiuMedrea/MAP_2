package com.mergiu.QuickByteBE.domain.order;

import com.mergiu.QuickByteBE.domain.address.Address;
import com.mergiu.QuickByteBE.domain.menuItem.MenuItem;
import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import com.mergiu.QuickByteBE.domain.user.SimpleUser;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private SimpleUser simpleUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id", referencedColumnName = "id")
    private Address address;

    private String orderStatus;

    private Timestamp orderTime;

    private Timestamp deliveryTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_menuitem",
            joinColumns = @JoinColumn(name = "fk_order_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_menuitem_id")
    )
    private Set<MenuItem> menuItems;

    public Order() {
    }

    public Order(Restaurant restaurant, SimpleUser simpleUser, Address address, String orderStatus, Timestamp orderTime, Timestamp deliveryTime, Set<MenuItem> menuItems) {
        this.restaurant = restaurant;
        this.simpleUser = simpleUser;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.menuItems = menuItems;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long orderId) {
        this.id = orderId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurantID) {
        this.restaurant = restaurantID;
    }

    public SimpleUser getUser() {
        return simpleUser;
    }

    public void setUser(SimpleUser simpleUserID) {
        this.simpleUser = simpleUserID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Set<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", user=" + simpleUser +
                ", address=" + address +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTime=" + orderTime +
                ", deliveryTime=" + deliveryTime +
                ", menuItems=" + menuItems +
                '}';
    }
}


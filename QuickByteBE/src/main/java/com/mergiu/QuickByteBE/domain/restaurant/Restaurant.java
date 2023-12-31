package com.mergiu.QuickByteBE.domain.restaurant;

import com.mergiu.QuickByteBE.domain.address.Address;
import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
    )
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_address_id", referencedColumnName = "id")
    private Address address;

    public Restaurant() {
    }

    public Restaurant(String name, Address address) {
        this.name = name;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long restaurantId) {
        this.id = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    // Builder class
    public static class Builder {
        private final Restaurant restaurant;

        public Builder() {
            this.restaurant = new Restaurant();
        }

        public Builder withId(Long id) {
            restaurant.id = id;
            return this;
        }

        public Builder withName(String name) {
            restaurant.name = name;
            return this;
        }

        public Builder withAddress(Address address) {
            restaurant.address = address;
            return this;
        }

        public Restaurant build() {
            if (restaurant.name == null || restaurant.name.trim().isEmpty()) {
                throw new IllegalStateException("Name cannot be null or empty");
            }

            return restaurant;
        }
    }
}


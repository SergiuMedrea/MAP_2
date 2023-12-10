package com.mergiu.QuickByteBE.domain.review;

import com.mergiu.QuickByteBE.domain.courier.Courier;
import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_courier_id", referencedColumnName = "id")
    private Courier courier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    @Min(value = 0, message = "Rating must be greater than or equal to 0")
    @Max(value = 5, message = "Rating must be less than or equal to 5")
    private int rating;

    private String comment;

    public Review() {
    }

    public Review(User user, Courier courier, Restaurant restaurant, int rating, String comment) {
        this.user = user;
        this.courier = courier;
        this.restaurant = restaurant;
        this.rating = rating;
        this.comment = comment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long reviewId) {
        this.id = reviewId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", courier=" + courier +
                ", restaurant=" + restaurant +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}


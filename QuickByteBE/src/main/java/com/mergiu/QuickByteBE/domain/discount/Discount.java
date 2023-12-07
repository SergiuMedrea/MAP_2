package com.mergiu.QuickByteBE.domain.discount;

import com.mergiu.QuickByteBE.domain.restaurant.Restaurant;
import jakarta.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;


@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @SequenceGenerator(
            name = "discount_sequence",
            sequenceName = "discount_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discount_sequence"
    )
    private Long discountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_restaurant_id", referencedColumnName = "restaurantId")
    private Restaurant restaurantID;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    @Min(value = 0, message = "Discount percentage must be greater than or equal to 0")
    @Max(value = 100, message = "Discount percentage must be less than or equal to 100")
    private int discountPercentage;

    public Discount() {
    }

    public Discount(Restaurant restaurantID, String name, String description, Date startDate, Date endDate, int discountPercentage) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
    }


    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public Restaurant getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Restaurant restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}


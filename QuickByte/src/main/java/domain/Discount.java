package domain;

import java.sql.Date;

public class Discount implements Identifiable {
    private int discountID;
    private int restaurantID;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private int discountPercentage;

    public Discount(int discountID,
                    int restaurantID,
                    String name,
                    String description,
                    Date startDate,
                    Date endDate,
                    int discountPercentage) {
        this.discountID = discountID;
        this.restaurantID = restaurantID;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int getId() {
        return getDiscountID();
    }

    @Override
    public void setId(int id) {
        setDiscountID(id);
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
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

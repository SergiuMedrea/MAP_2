package domain;

import java.sql.Timestamp;

public class Order implements Identifiable{
    private int orderID;
    private int userID;
    private int courierID;
    private int addressID;
    private Timestamp dateTime;

    public Order(int orderID, int userID, int courierID, int addressID, Timestamp dateTime) {
        this.orderID = orderID;
        this.userID = userID;
        this.courierID = courierID;
        this.addressID = addressID;
        this.dateTime = dateTime;
    }

    @Override
    public int getId() {
        return getOrderID();
    }

    @Override
    public void setId(int id) {
        setOrderID(id);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCourierID() {
        return courierID;
    }

    public void setCourierID(int courierID) {
        this.courierID = courierID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}

package domain;

public class Restaurant implements Identifiable{
    private int restaurantID;
    private int addressID;
    private String name;

    public Restaurant(int restaurantID, int addressID, String name) {
        this.restaurantID = restaurantID;
        this.addressID = addressID;
        this.name = name;
    }

    @Override
    public int getId() {
        return getRestaurantID();
    }

    @Override
    public void setId(int id) {
        setRestaurantID(id);
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

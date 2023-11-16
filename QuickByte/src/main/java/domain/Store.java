package domain;

public class Store implements Identifiable {
    private int shopID;
    private int addressID;
    private String name;

    public Store(int shopID, int addressID, String name) {
        this.shopID = shopID;
        this.addressID = addressID;
        this.name = name;
    }

    @Override
    public int getId() {
        return getShopID();
    }

    @Override
    public void setId(int id) {
        setShopID(id);
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int restaurantID) {
        this.shopID = restaurantID;
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

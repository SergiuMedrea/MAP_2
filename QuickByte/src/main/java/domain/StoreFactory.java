package domain;

public class StoreFactory {

    public static Store getStore(String type, int shopID, int addressID, String name) {
        if (type.equalsIgnoreCase("restaurant")) {
            return new Restaurant(shopID, addressID, name);
        } else if (type.equalsIgnoreCase("grocery")) {
            return new GroceryStore(shopID, addressID, name);
        }
        return null;
    }
}

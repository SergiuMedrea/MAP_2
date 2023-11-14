package domain;

public class MenuItem implements Identifiable {
    private int menuItemID;
    private int categoryID;
    private int restaurantID;
    private String name;
    private int price;
    private String descriptio;

    public MenuItem(int menuItemID,
                    int categoryID,
                    int restaurantID,
                    String name,
                    int price,
                    String descriptio) {
        this.menuItemID = menuItemID;
        this.categoryID = categoryID;
        this.restaurantID = restaurantID;
        this.name = name;
        this.price = price;
        this.descriptio = descriptio;
    }

    @Override
    public int getId() {
        return getMenuItemID();
    }

    @Override
    public void setId(int id) {
        setMenuItemID(id);
    }

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public void setDescriptio(String descriptio) {
        this.descriptio = descriptio;
    }
}

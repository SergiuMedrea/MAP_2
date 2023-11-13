package domain;

public record MenuItem(int menuItemID,
                       int categoryID,
                       int restaurantID,
                       String name,
                       int price,
                       String description) {
}

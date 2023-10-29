package entities;

public record MenuItem(Long menuItemID, String name, int price, String description, String category, Long restaurantID) {
}

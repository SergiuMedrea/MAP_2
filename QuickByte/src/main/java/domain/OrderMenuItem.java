package domain;

public record OrderMenuItem(
        int orderID,
        int menuItemID,
        int quantity) {
}

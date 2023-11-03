package domain;

public record OrderMenuItem(Long orderMenuItemID, Long orderID, Long menuItemID, int quantity) {
}

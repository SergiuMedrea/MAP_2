package entities;

public record PaymentMethod(Long paymentMethodID, String type, String accountInformation, Long UserID, Long orderID) {
}

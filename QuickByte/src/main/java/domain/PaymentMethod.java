package domain;

public record PaymentMethod(Long paymentMethodID, String type, String accountInformation, Long userID, Long orderID) {
}

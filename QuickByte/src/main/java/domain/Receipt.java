package domain;

public record Receipt(int orderID,
                      int userID,
                      int amount,
                      String paymentType,
                      String accountInformation) implements Identifiable<Integer>{
    @Override
    public Integer getId() {
        return orderID;
    }
}

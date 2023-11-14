package domain;

public class Receipt implements Identifiable {
    private int orderID;
    private int userID;
    private int amount;
    private String paymentType;
    private String accountInformation;

    public Receipt(int orderID, int userID, int amount, String paymentType, String accountInformation) {
        this.orderID = orderID;
        this.userID = userID;
        this.amount = amount;
        this.paymentType = paymentType;
        this.accountInformation = accountInformation;
    }

    @Override
    public int getId() {
        return getOrderID();
    }

    @Override
    public void setId(int id) {
        setOrderID(id);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getAccountInformation() {
        return accountInformation;
    }

    public void setAccountInformation(String accountInformation) {
        this.accountInformation = accountInformation;
    }
}

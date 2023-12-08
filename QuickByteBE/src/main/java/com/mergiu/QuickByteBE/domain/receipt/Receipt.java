package com.mergiu.QuickByteBE.domain.receipt;


import com.mergiu.QuickByteBE.domain.order.Order;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @SequenceGenerator(
            name = "receipt_sequence",
            sequenceName = "receipt_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "receipt_sequence"
    )
    private Long receiptId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "orderId")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private User user;

    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private int amount;

    private String paymentType;

    private String accountInformation;

    public Receipt() {
    }

    public Receipt(Order order, User user, int amount, String paymentType, String accountInformation) {
        this.order = order;
        this.user = user;
        this.amount = amount;
        this.paymentType = paymentType;
        this.accountInformation = accountInformation;
    }

    // Getters and Setters

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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


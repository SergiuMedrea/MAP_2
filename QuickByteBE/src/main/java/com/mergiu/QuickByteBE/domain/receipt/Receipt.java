package com.mergiu.QuickByteBE.domain.receipt;


import com.mergiu.QuickByteBE.domain.order.Order;
import com.mergiu.QuickByteBE.domain.receipt.paymentStrategy.PaymentStrategy;
import com.mergiu.QuickByteBE.domain.user.SimpleUser;
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
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "id")
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private SimpleUser simpleUser;

    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private int amount;
    private String paymentType;
    private String accountInformation;
    @Transient
    private PaymentStrategy paymentStrategy;

    public Receipt() {
    }

    public Receipt(Order order, SimpleUser simpleUser, int amount, String paymentType, String accountInformation) {
        this.order = order;
        this.simpleUser = simpleUser;
        this.amount = amount;
        this.paymentType = paymentType;
        this.accountInformation = accountInformation;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long receiptId) {
        this.id = receiptId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SimpleUser getUser() {
        return simpleUser;
    }

    public void setUser(SimpleUser simpleUser) {
        this.simpleUser = simpleUser;
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

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", order=" + order +
                ", user=" + simpleUser +
                ", amount=" + amount +
                ", paymentType='" + paymentType + '\'' +
                ", accountInformation='" + accountInformation + '\'' +
                '}';
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        if (paymentStrategy != null) {
            paymentStrategy.processPayment();
        } else {
            throw new IllegalStateException("Payment strategy not set");
        }
    }
}


package com.mergiu.QuickByteBE.domain.receipt;


import com.mergiu.QuickByteBE.domain.order.Order;
import com.mergiu.QuickByteBE.domain.user.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import javax.validation.constraints.Min;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "receipts")
public class Receipt {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long receiptId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "orderId")
    private Order order;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "userId")
    private User user;
    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private int amount;
    @NonNull
    private String paymentType;
    @NonNull
    private String accountInformation;

}

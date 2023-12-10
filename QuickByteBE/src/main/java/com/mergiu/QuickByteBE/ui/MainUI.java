package com.mergiu.QuickByteBE.ui;

import com.mergiu.QuickByteBE.domain.address.AddressUI;
import com.mergiu.QuickByteBE.domain.courier.CourierUI;
import com.mergiu.QuickByteBE.domain.receipt.ReceiptUI;
import com.mergiu.QuickByteBE.domain.restaurant.RestaurantUI;
import com.mergiu.QuickByteBE.domain.review.ReviewUI;
import com.mergiu.QuickByteBE.domain.user.UserUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainUI {

    private final UserUI userUI;
    private final CourierUI courierUI;
    private final AddressUI addressUI;
    private final ReceiptUI receiptUI;
    private final RestaurantUI restaurantUI;
    private final ReviewUI reviewUI;

    @Autowired
    public MainUI(UserUI userUI, CourierUI courierUI, AddressUI addressUI, ReceiptUI receiptUI, RestaurantUI restaurantUI, ReviewUI reviewUI) {
        this.userUI = userUI;
        this.courierUI = courierUI;
        this.addressUI = addressUI;
        this.receiptUI = receiptUI;
        this.restaurantUI = restaurantUI;
        this.reviewUI = reviewUI;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. User Menu");
            System.out.println("2. Courier Menu");
            System.out.println("3. Address Menu");
            System.out.println("4. Receipt Menu");
            System.out.println("5. Restaurant Menu");
            System.out.println("6. Review Menu");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    userUI.run();
                    break;
                case 2:
                    courierUI.run();
                    break;
                case 3:
                    addressUI.run();
                    break;
                case 4:
                    receiptUI.run();
                    break;
                case 5:
                    restaurantUI.run();
                    break;
                case 6:
                    reviewUI.run();
                    break;
                case 7:
                    System.out.println("Exiting application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

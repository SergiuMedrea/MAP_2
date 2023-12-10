package com.mergiu.QuickByteBE.ui;

import com.mergiu.QuickByteBE.domain.address.AddressUI;
import com.mergiu.QuickByteBE.domain.category.CategoryUI;
import com.mergiu.QuickByteBE.domain.courier.CourierUI;
import com.mergiu.QuickByteBE.domain.discount.DiscountUI;
import com.mergiu.QuickByteBE.domain.menuItem.MenuItemUI;
import com.mergiu.QuickByteBE.domain.order.OrderUI;
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
    private final MenuItemUI menuItemUI;
    private final OrderUI orderUI;
    private final CategoryUI categoryUI;
    private final DiscountUI discountUI;



    @Autowired
    public MainUI(UserUI userUI, CourierUI courierUI, AddressUI addressUI, ReceiptUI receiptUI, RestaurantUI restaurantUI, ReviewUI reviewUI, MenuItemUI menuItemUI, OrderUI orderUI, CategoryUI categoryUI, DiscountUI discountUI) {
        this.userUI = userUI;
        this.courierUI = courierUI;
        this.addressUI = addressUI;
        this.receiptUI = receiptUI;
        this.restaurantUI = restaurantUI;
        this.reviewUI = reviewUI;
        this.menuItemUI = menuItemUI;
        this.orderUI = orderUI;
        this.categoryUI = categoryUI;
        this.discountUI = discountUI;
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
            System.out.println("7. Menu Item Menu");
            System.out.println("8. Order Menu");
            System.out.println("9. Category Menu");
            System.out.println("10. Discount Menu");
            System.out.println("0. Exit");

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
                    menuItemUI.run();
                    break;
                case 8:
                    orderUI.run();
                    break;
                case 9:
                    categoryUI.run();
                    break;
                case 10:
                    discountUI.run();
                    break;
                case 0:
                    System.out.println("Exiting application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

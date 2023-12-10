package com.mergiu.QuickByteBE.ui;

import com.mergiu.QuickByteBE.domain.courier.CourierUI;
import com.mergiu.QuickByteBE.domain.user.UserUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainUI {

    private final UserUI userUI;
    private final CourierUI courierUI;

    @Autowired
    public MainUI(UserUI userUI, CourierUI courierUI) {
        this.userUI = userUI;
        this.courierUI = courierUI;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. User Menu");
            System.out.println("2. Courier Menu");
            System.out.println("3. Exit");

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
                    System.out.println("Exiting application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

package ui;

import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);
    private static AddressUI addressUI;
    private static CategoryUI categoryUI;
    private static CourierUI courierUI;
    private static MenuItemUI menuItemUI;
    private static OrderUI orderUI;
    private static ReceiptUI receiptUI;
    private static DiscountUI discountUI;
    private static RestaurantUI restaurantUI;
    private static ReviewUI reviewUI;
    private static UserUI userUI;

    public UI() {
        addressUI = new AddressUI();
        categoryUI = new CategoryUI();
        courierUI = new CourierUI();
        menuItemUI = new MenuItemUI();
        orderUI = new OrderUI();
        receiptUI = new ReceiptUI();
        discountUI = new DiscountUI();
        restaurantUI = new RestaurantUI();
        reviewUI = new ReviewUI();
        userUI = new UserUI();
    }

    public void run() {
        System.out.println("\n" +
                " ██████  ██    ██ ██  ██████ ██   ██ ██████  ██    ██ ████████ ███████ \n" +
                "██    ██ ██    ██ ██ ██      ██  ██  ██   ██  ██  ██     ██    ██      \n" +
                "██    ██ ██    ██ ██ ██      █████   ██████    ████      ██    █████   \n" +
                "██ ▄▄ ██ ██    ██ ██ ██      ██  ██  ██   ██    ██       ██    ██      \n" +
                " ██████   ██████  ██  ██████ ██   ██ ██████     ██       ██    ███████ \n" +
                "    ▀▀                                                                 \n" +
                "                                                                       \n");

        boolean exit = false;
        while (!exit) {
            System.out.println("0. Exit");
            System.out.println("1. Addresses Management");
            System.out.println("2. Categories Management");
            System.out.println("3. Couriers Management");
            System.out.println("4. Menu Items Management");
            System.out.println("5. Orders Management");
            System.out.println("6. Payment Methods Management");
            System.out.println("7. Promotions Management");
            System.out.println("8. Restaurants Management");
            System.out.println("9. Reviews Management");
            System.out.println("10. Users Management");

            System.out.println("\n>>");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    addressUI.run();
                    break;
                case 2:
                    categoryUI.run();
                    break;
                case 3:
                    courierUI.run();
                    break;
                case 4:
                    menuItemUI.run();
                    break;
                case 5:
                    orderUI.run();
                    break;
                case 6:
                    receiptUI.run();
                    break;
                case 7:
                    discountUI.run();
                    break;
                case 8:
                    restaurantUI.run();
                    break;
                case 9:
                    reviewUI.run();
                    break;
                case 10:
                    userUI.run();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("\n" +
                "  ____               ____             _ \n" +
                " | __ ) _   _  ___  | __ ) _   _  ___| |\n" +
                " |  _ \\| | | |/ _ \\ |  _ \\| | | |/ _ \\ |\n" +
                " | |_) | |_| |  __/ | |_) | |_| |  __/_|\n" +
                " |____/ \\__, |\\___| |____/ \\__, |\\___(_)\n" +
                "        |___/              |___/        \n");
    }
}

package ui;

import java.util.Scanner;
public class UI {
    private static final Scanner scanner = new Scanner(System.in);

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
        while(!exit) {
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
                    AddressUI.run();
                    break;
                case 2:
                    CategoryUI.run();
                    break;
                case 3:
                    CourierUI.run();
                    break;
                case 4:
                    MenuItemUI.run();
                    break;
                case 5:
                    OrderUI.run();
                    break;
                case 6:
                    PaymentMethodUI.run();
                    break;
                case 7:
                    DiscountUI.run();
                    break;
                case 8:
                    RestaurantUI.run();
                    break;
                case 9:
                    ReviewUI.run();
                    break;
                case 10:
                    UserUI.run();
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

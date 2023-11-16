package controller;

import domain.Discount;

public class DiscountController extends EntityController<Discount>{
    private static DiscountController instance = null;

    private DiscountController(){}

    public static DiscountController getInstance() {
        if (instance == null) {
            instance = new DiscountController();
        }

        return instance;
    }
}

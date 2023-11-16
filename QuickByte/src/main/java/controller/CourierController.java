package controller;

import domain.Courier;

public class CourierController extends EntityController<Courier>{
    private static CourierController instance = null;

    private CourierController(){};

    public static CourierController getInstance() {
        if (instance == null) {
            instance = new CourierController();
        }

        return instance;
    }
}

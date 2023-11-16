package controller;

import domain.Address;
import repo.inMemory.InMemoryRepo;

public class AddressController extends EntityController<Address>{
    private static AddressController instance = null;

    private AddressController() {}

    public static AddressController getInstance() {
        if (instance == null) {
            instance = new AddressController();
        }

        return instance;
    }
}

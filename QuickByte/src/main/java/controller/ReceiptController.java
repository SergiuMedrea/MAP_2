package controller;

import domain.Receipt;
import repo.inMemory.InMemoryRepo;

public class ReceiptController extends EntityController<Receipt>{
    private static ReceiptController instance = null;

    private ReceiptController() {}

    public static ReceiptController getInstance() {
        if (instance == null) {
            instance = new ReceiptController();
        }

        return instance;
    }
}

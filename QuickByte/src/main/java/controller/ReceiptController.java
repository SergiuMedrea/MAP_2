package controller;

import domain.Receipt;
import repo.inMemory.InMemoryRepo;

public class ReceiptController extends EntityController<Receipt>{
    public ReceiptController(InMemoryRepo<Receipt> repository) {
        super(repository);
    }
}

package repo.inMemory;

import domain.Receipt;

public class ReceiptRepo extends InMemoryRepo<Receipt>{
    private static ReceiptRepo instance = null;

    private ReceiptRepo() {
    }

    public static ReceiptRepo getInstance() {
        if (instance == null) {
            instance = new ReceiptRepo();
        }

        return instance;
    }
}

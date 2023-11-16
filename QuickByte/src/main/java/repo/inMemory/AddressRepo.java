package repo.inMemory;

import domain.Address;

public class AddressRepo extends InMemoryRepo<Address> {
    private static AddressRepo instance = null;

    private AddressRepo() {
    }

    public static AddressRepo getInstance() {
        if (instance == null) {
            instance = new AddressRepo();
        }

        return instance;
    }
}

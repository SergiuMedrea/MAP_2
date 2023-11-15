package controller;

import domain.Address;
import repo.inMemory.InMemoryRepo;

public class AddressController extends EntityController<Address>{
    public AddressController(InMemoryRepo<Address> repository) {
        super(repository);
    }
}

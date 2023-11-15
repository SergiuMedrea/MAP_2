package controller;

import domain.User;
import repo.inMemory.InMemoryRepo;

public class UserController extends EntityController<User>{
    public UserController(InMemoryRepo<User> repository) {
        super(repository);
    }
}

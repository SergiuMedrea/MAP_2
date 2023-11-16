package controller;

import domain.User;
import repo.inMemory.InMemoryRepo;

public class UserController extends EntityController<User>{
    private static UserController instance = null;

    private UserController() {}

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }

        return instance;
    }
}

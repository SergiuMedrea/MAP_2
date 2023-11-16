package repo.inMemory;

import domain.User;

public class UserRepo extends InMemoryRepo<User> {
    private static UserRepo instance = null;

    private UserRepo() {
    }

    public static UserRepo getInstance() {
        if (instance == null) {
            instance = new UserRepo();
        }

        return instance;
    }

}

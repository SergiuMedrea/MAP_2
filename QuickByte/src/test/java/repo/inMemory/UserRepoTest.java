package repo.inMemory;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class UserRepoTest {
    UserRepo repo = new UserRepo();

    @org.junit.jupiter.api.Test
    void createAndGetUser() {
        User created = repo.createUser("testuser1", null, "0733627436");
        User retrieved = repo.getUserByID(1L);
        assert created == retrieved;
    }

    @org.junit.jupiter.api.Test
    void getAllUsers() {
        Random rand = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 2; i < 12; i++) {
            User temp = repo.createUser("testuser" + i, null, String.valueOf(rand.nextInt()));
            users.add(temp);
        }

        assert users.equals(repo.getAllUsers());
    }

    @org.junit.jupiter.api.Test
    void updateUser() {
        User created = repo.createUser("testuser1", null, "0733627436");
        User updated = repo.updateUser(new User(created.userID(), "gion", null, created.phoneNumber()));

        assert repo.getUserByID(1L) == updated;
        assert updated.equals(new User(created.userID(), "gion", null, created.phoneNumber()));
    }

    @org.junit.jupiter.api.Test
    void deleteUser() {
        User created = repo.createUser("testuser1", null, "0733627436");
        repo.deleteUser(created.userID());

        assert repo.getUserByID(created.userID()) == null;
    }
}
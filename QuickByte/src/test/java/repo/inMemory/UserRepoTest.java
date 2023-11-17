package repo.inMemory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    @Test
    void verifySingletonInstance() {
        // Get two instances of the UserRepo
        UserRepo instance1 = UserRepo.getInstance();
        UserRepo instance2 = UserRepo.getInstance();

        // Verify that both instances are the same object
        assertSame(instance1, instance2);
    }
}
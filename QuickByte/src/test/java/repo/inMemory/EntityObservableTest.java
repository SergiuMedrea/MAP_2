package repo.inMemory;

import domain.Identifiable;
import domain.EntityObserver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityObservableTest {

    @Test
    void registerObserver() {
        EntityObservable<User> observable = new EntityObservable<>();
        TestUserObserver observer = new TestUserObserver();

        observable.registerObserver(observer);

        assertTrue(observable.getObservers().contains(observer));
    }

    @Test
    void removeObserver() {
        EntityObservable<User> observable = new EntityObservable<>();
        TestUserObserver observer = new TestUserObserver();

        observable.registerObserver(observer);
        observable.removeObserver(observer);

        assertFalse(observable.getObservers().contains(observer));
    }

    @Test
    void notifyObserversEntityCreated() {
        EntityObservable<User> observable = new EntityObservable<>();
        TestUserObserver observer = new TestUserObserver();
        observable.registerObserver(observer);

        User user = new User();
        observable.notifyObserversEntityCreated(user);

        assertTrue(observer.isEntityCreatedCalled());
        assertEquals(user, observer.getUpdatedEntity());
    }

    @Test
    void notifyObserversEntityUpdated() {
        EntityObservable<User> observable = new EntityObservable<>();
        TestUserObserver observer = new TestUserObserver();
        observable.registerObserver(observer);

        User user = new User();
        observable.notifyObserversEntityUpdated(user);

        assertTrue(observer.isEntityUpdatedCalled());
        assertEquals(user, observer.getUpdatedEntity());
    }

    @Test
    void notifyObserversEntityDeleted() {
        EntityObservable<User> observable = new EntityObservable<>();
        TestUserObserver observer = new TestUserObserver();
        observable.registerObserver(observer);

        int userId = 1;
        observable.notifyObserversEntityDeleted(userId);

        assertTrue(observer.isEntityDeletedCalled());
        assertEquals(userId, observer.getDeletedEntityId());
    }

    // Helper classes for testing
    private static class User implements Identifiable {
        private int id;

        @Override
        public int getId() {
            return id;
        }

        @Override
        public void setId(int id) {
            this.id = id;
        }
    }

    private static class TestUserObserver implements EntityObserver<User> {
        private boolean entityCreatedCalled = false;
        private boolean entityUpdatedCalled = false;
        private boolean entityDeletedCalled = false;
        private User updatedEntity;
        private int deletedEntityId;

        @Override
        public void onEntityCreated(User entity) {
            entityCreatedCalled = true;
            updatedEntity = entity;
        }

        @Override
        public void onEntityUpdated(User entity) {
            entityUpdatedCalled = true;
            updatedEntity = entity;
        }

        @Override
        public void onEntityDeleted(int entityId) {
            entityDeletedCalled = true;
            deletedEntityId = entityId;
        }

        public boolean isEntityCreatedCalled() {
            return entityCreatedCalled;
        }

        public boolean isEntityUpdatedCalled() {
            return entityUpdatedCalled;
        }

        public boolean isEntityDeletedCalled() {
            return entityDeletedCalled;
        }

        public User getUpdatedEntity() {
            return updatedEntity;
        }

        public int getDeletedEntityId() {
            return deletedEntityId;
        }
    }
}
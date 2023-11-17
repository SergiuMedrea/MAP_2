package repo.inMemory;

import domain.EntityObserver;
import domain.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class EntityObservable<T extends Identifiable> {
    private final List<EntityObserver<T>> observers = new ArrayList<>();

    public void registerObserver(EntityObserver<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(EntityObserver<T> observer) {
        observers.remove(observer);
    }

    public void notifyObserversEntityCreated(T entity) {
        for (EntityObserver<T> observer : observers) {
            observer.onEntityCreated(entity);
        }
    }

    public void notifyObserversEntityUpdated(T entity) {
        for (EntityObserver<T> observer : observers) {
            observer.onEntityUpdated(entity);
        }
    }

    public void notifyObserversEntityDeleted(int entityId) {
        for (EntityObserver<T> observer : observers) {
            observer.onEntityDeleted(entityId);
        }
    }

    public List<EntityObserver<T>> getObservers() {
        return observers;
    }
}

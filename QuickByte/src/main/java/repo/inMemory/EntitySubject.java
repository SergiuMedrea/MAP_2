package repo.inMemory;

import domain.EntityObserver;
import domain.Identifiable;

public interface EntitySubject<T extends Identifiable> {
    void registerObserver(EntityObserver<T> observer);
    void removeObserver(EntityObserver<T> observer);
    void notifyEntityCreated(T entity);
    void notifyEntityUpdated(T entity);
    void notifyEntityDeleted(int entityId);
}

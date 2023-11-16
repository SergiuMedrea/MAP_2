package domain;

public interface EntityObserver<T extends Identifiable> {
    void notifyEntityCreated(T entity);
    void notifyEntityUpdated(T entity);
    void notifyEntityDeleted(int entityId);
}


package domain;

public interface EntityObserver<T extends Identifiable> {
    void onEntityCreated(T entity);
    void onEntityUpdated(T entity);
    void onEntityDeleted(int entityId);
}


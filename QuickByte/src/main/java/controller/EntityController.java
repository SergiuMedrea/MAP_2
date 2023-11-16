package controller;

import domain.EntityObserver;
import domain.Identifiable;
import repo.inMemory.InMemoryRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntityController<T extends Identifiable> {
    private final InMemoryRepo<T> repository;
    private final List<EntityObserver<T>> observers = new ArrayList<>();

    public void setRepository(InMemoryRepo<T> repository) {
        this.repository = repository;
    }
    public T createEntity(T entity) {
        T createdEntity = repository.create(entity);
        notifyObserversEntityCreated(createdEntity);
        return createdEntity;
    }

    public Optional<T> getEntityById(int id) {
        return repository.getById(id);
    }

    public List<T> getAllEntities() {
        return repository.getAll();
    }

    public boolean updateEntity(T updatedEntity) {
        boolean isUpdated = repository.update(updatedEntity);
        if (isUpdated) {
            notifyObserversEntityUpdated(updatedEntity);
        }
        return isUpdated;
    }

    public boolean deleteEntity(int id) {
        boolean isDeleted = repository.delete(id);
        if (isDeleted) {
            notifyObserversEntityDeleted(id);
        }
        return isDeleted;
    }

    // Observer management methods
    public void registerObserver(EntityObserver<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(EntityObserver<T> observer) {
        observers.remove(observer);
    }

    private void notifyObserversEntityCreated(T entity) {
        for (EntityObserver<T> observer : observers) {
            observer.notifyEntityCreated(entity);
        }
    }

    private void notifyObserversEntityUpdated(T entity) {
        for (EntityObserver<T> observer : observers) {
            observer.notifyEntityUpdated(entity);
        }
    }

    private void notifyObserversEntityDeleted(int entityId) {
        for (EntityObserver<T> observer : observers) {
            observer.notifyEntityDeleted(entityId);
        }
    }
}


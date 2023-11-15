package controller;

import domain.Identifiable;
import repo.inMemory.InMemoryRepo;

import java.util.List;
import java.util.Optional;

public class EntityController<T extends Identifiable> {
    private final InMemoryRepo<T> repository;

    public EntityController(InMemoryRepo<T> repository) {
        this.repository = repository;
    }

    public T createEntity(T entity) {
        return repository.create(entity);
    }

    public Optional<T> getEntityById(int id) {
        return repository.getById(id);
    }

    public List<T> getAllEntities() {
        return repository.getAll();
    }

    public boolean updateEntity(T updatedEntity) {
        return repository.update(updatedEntity);
    }

    public boolean deleteEntity(int id) {
        return repository.delete(id);
    }
}

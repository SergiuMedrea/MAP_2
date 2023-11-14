package repo.inMemory;

import domain.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRepo<T extends Identifiable> {
    private final List<T> entities = new ArrayList<>();
    private int nextID = 1;

    /**
     * Create a new entity and add it to the repository
     */
    public T create(T entity) {
        entity.setId(nextID);
        entities.add(entity);
        nextID++;
        return entity;
    }

    /**
     * Retrieve an entity by ID | Optional.empty() if not found
     */
    public Optional<T> getById(int id) {
        return entities.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst();
    }

    /**
     * Retrieve all entities
     */
    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    /**
     * Update an existing entity
     *
     * @return true if the entity was found and updated, false otherwise
     */
    public boolean update(T updatedEntity) {
        for (int i = 0; i < entities.size(); i++) {
            T existingEntity = entities.get(i);
            if (existingEntity.getId() == updatedEntity.getId()) {
                entities.set(i, updatedEntity);
                return true; // Update successful
            }
        }
        return false; // Entity not found
    }

    /**
     * Delete an entity by ID
     */
    public boolean delete(int id) {
        return entities.removeIf(entity -> entity.getId() == id);
    }

}

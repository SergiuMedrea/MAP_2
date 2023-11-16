package repo.inMemory;

import domain.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRepo<T extends Identifiable> {
    private final List<T> entities = new ArrayList<>();
    private int nextID = 1;

    public T create(T entity) {
        entity.setId(nextID);
        entities.add(entity);
        nextID++;
        return entity;
    }

    public Optional<T> getById(int id) {
        return entities.stream()
                .filter(entity -> entity.getId() == id)
                .findFirst();
    }

    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    public boolean update(T updatedEntity) {
        for (int i = 0; i < entities.size(); i++) {
            T existingEntity = entities.get(i);
//            if (existingEntity.getId() == updatedEntity.getId(notifyObserversEntityUpdated(updatedEntity)) {
//                entities.set(i, updatedEntity);
//                return true;
//            }
        }
        return false;

    }
    
    public boolean delete(int id) {
        return entities.removeIf(entity -> entity.getId() == id);
    }
}
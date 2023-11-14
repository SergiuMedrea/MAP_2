package repo.inMemory;

import domain.Identifiable;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepo<A extends Identifiable>{
    private final List<A> entities = new ArrayList<>();
    private int nextID = 1;

    public A create(A entity) {
        entity.setId(nextID);
        entities.add(entity);
        nextID++;
        return entity;
    }
}

package domain;

import repo.inMemory.EntitySubject;

public interface Identifiable extends EntitySubject<Identifiable> {
    int getId();

    void setId(int id);
}

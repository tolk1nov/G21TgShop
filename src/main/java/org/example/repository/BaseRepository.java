package org.example.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T> {

    int save(T t);

    Optional<T> getById(UUID id);

    List<T> getAll();

    T update(T t);

    void remove(T t);

    void remove(UUID id);


}

package bankapp.repository;

import java.util.List;

public interface MemoryRepository<T> {

    void create(T t);

    void update(long id, T t);

    void delete(long id);

    T findById(long id);

    List<T> findAll();

}

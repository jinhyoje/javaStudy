package reservationapp.repository;

import reservationapp.common.exception.CustomException;

import java.util.List;

public interface MemRepository<T> {

    void create(T t);

    void update(long id, T t);

    void delete(long id);

    T findById(long id) throws CustomException;

    List<T> findAll();

    T findByEmail(String email);

    T findByFlightNumber(String flightNumber);
}


package reservationapp.repository.impl;

import reservationapp.common.exception.CustomException;
import reservationapp.dto.ReservationDTO;
import reservationapp.repository.MemRepository;

import java.util.List;

public class ReservationRepositoryImpl implements MemRepository<ReservationDTO> {
    List<ReservationDTO> reservations;

    public ReservationRepositoryImpl(List<ReservationDTO> list) {
        reservations = list;
    }
    @Override
    public void create(ReservationDTO reservationDTO) {
        reservations.add(reservationDTO);
    }

    @Override
    public void update(long id, ReservationDTO reservationDTO) {
    }

    @Override
    public void delete(long id) {
        reservations.removeIf(reservation -> reservation.getReservationId() == id);
    }

    @Override
    public ReservationDTO findById(long id) throws CustomException {
        return reservations.stream()
                .filter(reservation -> reservation.getReservationId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ReservationDTO> findAll() {
        return reservations;
    }

    @Override
    public ReservationDTO findByEmail(String email) {
        return null;
    }

    @Override
    public ReservationDTO findByFlightNumber(String flightNumber) {
        return null;
    }
}

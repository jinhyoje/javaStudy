package reservationapp.service;

import reservationapp.dto.ReservationDTO;
import reservationapp.repository.MemRepository;

public class ReservationService {
    private final MemRepository<ReservationDTO> reservationRepository;;

    public ReservationService(MemRepository<ReservationDTO> reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(ReservationDTO reservationDTO) {
        reservationRepository.create(reservationDTO);
    }
}

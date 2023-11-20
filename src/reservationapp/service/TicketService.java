package reservationapp.service;

import reservationapp.dto.ReservationDTO;
import reservationapp.dto.TicketDTO;
import reservationapp.repository.MemRepository;
import reservationapp.repository.impl.ReservationRepositoryImpl;
import reservationapp.repository.impl.TicketRepositoryImpl;

public class TicketService {
    private final TicketRepositoryImpl ticketRepository;

    public TicketService(TicketRepositoryImpl ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public TicketDTO createTicket(ReservationDTO reservationDTO, String seatNumber, double price) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setTicketId(TicketDTO.getNextId());
        ticketDTO.setFlight(reservationDTO.getFlight());
        ticketDTO.setPassenger(reservationDTO.getPassenger());
        ticketDTO.setSeatNumber(seatNumber);
        ticketDTO.setPrice(price);


        // 티켓을 저장소에 저장
        ticketRepository.create(ticketDTO);

        return ticketDTO;
    }
}

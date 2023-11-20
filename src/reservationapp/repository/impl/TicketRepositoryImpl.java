package reservationapp.repository.impl;

import reservationapp.common.exception.CustomException;
import reservationapp.dto.TicketDTO;
import reservationapp.repository.MemRepository;

import java.util.List;

public class TicketRepositoryImpl implements MemRepository<TicketDTO> {
    List<TicketDTO> tickets;
    public TicketRepositoryImpl(List<TicketDTO> list) {
        tickets = list;
    }
    @Override
    public void create(TicketDTO ticketDTO) {
        tickets.add(ticketDTO);

    }

    @Override
    public void update(long id, TicketDTO ticketDTO) {
        tickets.stream()
                .filter(ticket -> ticket.getTicketId() == id)
                .findFirst()
                .ifPresent(existingTicket -> {
                    existingTicket.setPrice(ticketDTO.getPrice());
                    existingTicket.setPassenger(ticketDTO.getPassenger());
                    existingTicket.setFlight(ticketDTO.getFlight());
                });

    }

    @Override
    public void delete(long id) {
        tickets.removeIf(ticket -> ticket.getTicketId() == id);

    }

    @Override
    public TicketDTO findById(long id) throws CustomException {
        return null;
    }

    @Override
    public List<TicketDTO> findAll() {
        return null;
    }

    @Override
    public TicketDTO findByEmail(String email) {
        return null;
    }

    @Override
    public TicketDTO findByFlightNumber(String flightNumber) {
        return null;
    }
}

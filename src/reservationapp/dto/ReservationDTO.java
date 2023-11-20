package reservationapp.dto;

import java.util.List;

public class ReservationDTO {
    private static Long nextId = 1L;
    private Long reservationId;
    private PassengerDTO passenger;
    private FlightDTO flight;
    private String status;
    private List<TicketDTO> tickets;


    public ReservationDTO(String reservationId, PassengerDTO passenger, FlightDTO flight, String status, List<TicketDTO> tickets) {
        this.reservationId = generateNextId();
        this.passenger = passenger;
        this.flight = flight;
        this.status = status;
        this.tickets = tickets;
    }

    public ReservationDTO() {

    }

    private static Long generateNextId() {
        Long generatedId = nextId;
        nextId++;
        return generatedId;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        ReservationDTO.nextId = nextId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }
}

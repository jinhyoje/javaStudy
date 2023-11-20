package reservationapp.dto;

public class TicketDTO {
    private static Long nextId = 1L;
    private Long ticketId;
    private FlightDTO flight;
    private PassengerDTO passenger;
    private String seatNumber;
    private double price;

    public TicketDTO(FlightDTO flight, PassengerDTO passenger, String seatNumber, double price) {
        this.ticketId = generateNextId();
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public TicketDTO() {

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
        TicketDTO.nextId = nextId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public FlightDTO getFlight() {
        return flight;
    }

    public void setFlight(FlightDTO flight) {
        this.flight = flight;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

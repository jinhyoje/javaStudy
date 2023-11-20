package reservationapp.repository;

import reservationapp.dto.FlightDTO;
import reservationapp.dto.PassengerDTO;
import reservationapp.dto.ReservationDTO;
import reservationapp.dto.TicketDTO;

import java.util.ArrayList;
import java.util.List;

public class MemStore {
    public static List<FlightDTO> flights = new ArrayList<>();
    public static List<PassengerDTO> passengers = new ArrayList<>();
    public static List<ReservationDTO> reservations = new ArrayList<>();
    public static List<TicketDTO> tickets = new ArrayList<>();
}

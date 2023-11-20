package reservationapp.repository.impl;

import reservationapp.common.exception.CustomException;
import reservationapp.common.exception.ErrorCode;
import reservationapp.dto.FlightDTO;
import reservationapp.repository.MemRepository;

import java.util.List;

public class FlightRepositoryImpl implements MemRepository<FlightDTO> {

    private List<FlightDTO> flights;

    public FlightRepositoryImpl(List<FlightDTO> list) {
        flights = list;
    }
    @Override
    public void create(FlightDTO flightDTO) {
        flights.add(flightDTO);
    }

    @Override
    public void update(long id, FlightDTO flightDTO) {
        flights.stream()
                .filter(flight -> flight.getFlightId() == id)
                .findFirst()
                .ifPresent(existingFlight -> {
                    existingFlight.setFlightNumber(flightDTO.getFlightNumber());
                    existingFlight.setDeparture(flightDTO.getDeparture());
                    existingFlight.setDestination(flightDTO.getDestination());
                    existingFlight.setDepartureTime(flightDTO.getDepartureTime());
                    existingFlight.setArrivalTime(flightDTO.getArrivalTime());
                    existingFlight.setSeatCount(flightDTO.getSeatCount());
                    existingFlight.setReservations(flightDTO.getReservations());
                });
    }

    @Override
    public void delete(long id) {
        boolean removed = flights.removeIf(flight -> flight.getFlightId() == id);

        if (!removed) {
            throw new CustomException(ErrorCode.INVALID_FLIGHT_ID);
        }

    }

    @Override
    public FlightDTO findById(long id) throws CustomException {
        return flights.stream()
                .filter(flight -> flight.getFlightId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<FlightDTO> findAll() {
        return flights;
    }

    @Override
    public FlightDTO findByEmail(String email) {
        return null;
    }

    @Override
    public FlightDTO findByFlightNumber(String flightNumber) {
        return null;
    }
}

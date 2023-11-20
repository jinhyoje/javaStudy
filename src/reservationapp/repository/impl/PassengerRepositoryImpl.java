package reservationapp.repository.impl;

import reservationapp.dto.PassengerDTO;
import reservationapp.repository.MemRepository;

import java.util.List;

public class PassengerRepositoryImpl implements MemRepository<PassengerDTO> {
    private List<PassengerDTO> passengers;

    public PassengerRepositoryImpl(List<PassengerDTO> list) {
        passengers = list;
    }
    @Override
    public void create(PassengerDTO passengerDTO) {
        passengers.add(passengerDTO);
    }

    @Override
    public void update(long id, PassengerDTO passengerDTO) {
        passengers.stream()
                .filter(passenger -> passenger.getPassengerId() == id)
                .findFirst()
                .ifPresent(existingPassenger -> {
                    existingPassenger.setName(passengerDTO.getName());
                    existingPassenger.setEmail(passengerDTO.getEmail());
                    existingPassenger.setPassword(passengerDTO.getPassword());
                });
    }

    @Override
    public void delete(long id) {
        passengers.removeIf(passenger -> passenger.getPassengerId() == id);

    }

    @Override
    public PassengerDTO findById(long id) {
        return passengers.stream()
                .filter(passenger -> passenger.getPassengerId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PassengerDTO> findAll() {
        return passengers;
    }

    @Override
    public PassengerDTO findByEmail(String email) {
        return passengers.stream()
                .filter(passenger -> passenger.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PassengerDTO findByFlightNumber(String flightNumber) {
        return null;
    }

}

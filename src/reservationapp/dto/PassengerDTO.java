package reservationapp.dto;

import java.util.List;

public class PassengerDTO {
    private static Long nextId = 1L;
    private Long passengerId;
    private String name;
    private String email;
    private String password;
    private List<ReservationDTO> reservations;

    public PassengerDTO (String name, String email, String password) {
        this.passengerId = generateNextId();
        this.name = name;
        this.email = email;
        this.password = password;
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
        PassengerDTO.nextId = nextId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ReservationDTO> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationDTO> reservations) {
        this.reservations = reservations;
    }
}

package reservationapp.controller;

import reservationapp.common.exception.CustomException;
import reservationapp.common.exception.ErrorCode;
import reservationapp.dto.FlightDTO;
import reservationapp.dto.PassengerDTO;
import reservationapp.dto.ReservationDTO;
import reservationapp.service.FlightService;
import reservationapp.service.ReservationService;
import reservationapp.service.TicketService;

public class ReservationController {
    private final ReservationService reservationService;
    private final FlightService flightService;
    private final PassengerController passengerController;
    private final TicketService ticketService;

    public ReservationController(ReservationService reservationService, FlightService flightService, PassengerController passengerController, TicketService ticketService) {
        this.reservationService = reservationService;
        this.flightService = flightService;
        this.passengerController = passengerController;
        this.ticketService = ticketService;
    }

    public void createReservation(long selectedFlightId) {
        // 선택한 항공편 ID로 항공편 정보를 가져온다.
        FlightDTO selectedFlight = flightService.getFlightById(selectedFlightId);
        PassengerDTO loggedInPassenger = passengerController.getLoggedInPassenger();

        // 좌석이 유효하면 예약 생성
        if (isValidSeat(selectedFlight)) {
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setFlight(selectedFlight);
            reservationDTO.setPassenger(loggedInPassenger);

            // 예약 생성
            reservationService.createReservation(reservationDTO);

            // 티켓 생성
            String seatNumber = "선택한 좌석 번호"; // 실제로 사용자가 선택한 좌석 번호로 대체해야 합니다.
            double price = 100.0; // 가격은 적절한 값으로 대체해야 합니다.
            ticketService.createTicket(reservationDTO, seatNumber, price);

            // 좌석 수 감소
            flightService.decreaseSeatCount(selectedFlightId);
        } else {
            throw new CustomException(ErrorCode.NO_AVAILABLE_SEATS);
        }
    }

    private boolean isValidSeat(FlightDTO selectedFlight) {
        return selectedFlight.getSeatCount() > 0;
    }

}

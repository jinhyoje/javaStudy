package reservationapp.controller;

import reservationapp.common.ResponseMessage;
import reservationapp.common.exception.CustomException;
import reservationapp.common.exception.ErrorCode;
import reservationapp.dto.FlightDTO;
import reservationapp.service.FlightService;

import java.util.List;

public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public ResponseMessage<?> createFlight(FlightDTO flightDTO) {
        if (isValidFlightDTO(flightDTO)) {
            flightService.createFlight(flightDTO);
        } else {
            throw new CustomException(ErrorCode.INVALID_FLIGHT_INFO);
        }
        return new ResponseMessage<>("항공편이 생성되었습니다.", 200, null);
    }

    private boolean isValidFlightDTO(FlightDTO flightDTO) {
        return isNotNullOrEmpty(flightDTO.getFlightNumber())
                && isNotNullOrEmpty(flightDTO.getDeparture())
                && isNotNullOrEmpty(flightDTO.getDestination())
                && isNotNullOrEmpty(flightDTO.getDepartureTime())
                && isNotNullOrEmpty(flightDTO.getArrivalTime())
                && flightDTO.getSeatCount() > 0;
    }

    private boolean isNotNullOrEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public ResponseMessage<?> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();
        return new ResponseMessage<>("항공편 목록을 조회하였습니다.", 200, flights);
    }

    public ResponseMessage<?> deleteFlight(Long flightId) {
        try {
            flightService.deleteFlight(flightId);
            return new ResponseMessage<>("항공편이 삭제되었습니다.", 200, null);
        } catch (CustomException e) {
            return new ResponseMessage<>(e.getMessage(), 400, null);
        }
    }


}


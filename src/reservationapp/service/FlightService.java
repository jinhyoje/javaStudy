package reservationapp.service;

import reservationapp.common.exception.CustomException;
import reservationapp.common.exception.ErrorCode;
import reservationapp.dto.FlightDTO;
import reservationapp.repository.MemRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightService {
    private final Map<String, String> adminCredentials;
    private final MemRepository<FlightDTO> flightRepository;


    public FlightService(MemRepository<FlightDTO> flightRepository) {
        this.flightRepository = flightRepository;
        // 관리자 계정 초기화
        this.adminCredentials = new HashMap<>();
        this.adminCredentials.put("admin@aaa.com", "admin123");
    }

    public boolean isAdmin(String email, String password) {
        // 입력된 이메일과 비밀번호가 관리자 계정과 일치하는지 확인
        return adminCredentials.containsKey(email) && adminCredentials.get(email).equals(password);
    }


    public void createFlight(FlightDTO flightDTO) {
        // 좌석 수 체크
        if (flightDTO.getSeatCount() <= 0) {
            throw new CustomException(ErrorCode.INVALID_SEAT_COUNT);
        }

        // 출발 시간과 도착 시간의 유효성 검사
        LocalDate departureTime = LocalDate.parse(flightDTO.getDepartureTime());
        LocalDate arrivalTime = LocalDate.parse(flightDTO.getArrivalTime());

        if (arrivalTime.isBefore(departureTime)) {
            throw new CustomException(ErrorCode.INVALID_DATE);
        }


        flightRepository.create(flightDTO);
    }

    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll();
    }


    public void deleteFlight(Long flightId) {
        if (flightId == null || flightId <= 0) {
            throw new CustomException(ErrorCode.INVALID_FLIGHT_ID);
        }

        // 항공편이 존재하지 않는 경우 예외 처리
        FlightDTO existingFlight = flightRepository.findById(flightId);
        if (existingFlight == null) {
            throw new CustomException(ErrorCode.FLIGHT_NOT_FOUND);
        }

        flightRepository.delete(flightId);
    }

    public void decreaseSeatCount(long flightId) {
        FlightDTO flightDTO = flightRepository.findById(flightId);
        if (flightDTO != null) {
            int currentSeatCount = flightDTO.getSeatCount();
            if (currentSeatCount > 0) {
                // 현재 좌석 수가 1 이상이면 감소시킴
                flightDTO.setSeatCount(currentSeatCount - 1);
                flightRepository.update(flightId, flightDTO);
            } else {
                // 좌석 수가 이미 0이면 처리 (예외 또는 메시지 출력 등)
                throw new CustomException(ErrorCode.NO_AVAILABLE_SEATS);
            }
        } else {
            // 해당 ID에 대한 항공편이 없으면 처리 (예외 또는 메시지 출력 등)
            throw new CustomException(ErrorCode.INVALID_FLIGHT_ID);
        }
    }

    public FlightDTO getFlightById(long selectedFlightId) {
        return flightRepository.findById(selectedFlightId);
    }
}

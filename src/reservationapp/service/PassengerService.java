package reservationapp.service;

import bankapp.repository.MemoryRepository;
import reservationapp.common.exception.CustomException;
import reservationapp.common.exception.ErrorCode;
import reservationapp.dto.PassengerDTO;
import reservationapp.repository.MemRepository;

public class PassengerService {

    private final MemRepository<PassengerDTO> passengerRepository;

    public PassengerService(MemRepository<PassengerDTO> passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public void signUp(PassengerDTO passengerDTO) {
        // 중복 이메일 확인
        if (isEmailDuplicate(passengerDTO.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }
        passengerRepository.create(passengerDTO);
    }

    public boolean isEmailDuplicate(String email) {
        PassengerDTO existingPassenger = passengerRepository.findByEmail(email);
        return existingPassenger != null;
    }

    public PassengerDTO login(String email, String password) {
        // 이메일로 사용자 찾기
        PassengerDTO existingPassenger = passengerRepository.findByEmail(email);

        if (existingPassenger != null && existingPassenger.getPassword().equals(password)) {
            // 비밀번호 일치 시 로그인 성공
            return existingPassenger;
        } else {
            // 로그인 실패
            throw new CustomException(ErrorCode.INVALID_LOGIN_INFO);
        }
    }

    public PassengerDTO getPassengerByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }
}

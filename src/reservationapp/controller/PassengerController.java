package reservationapp.controller;

import reservationapp.common.ResponseMessage;
import reservationapp.common.exception.CustomException;
import reservationapp.dto.PassengerDTO;
import reservationapp.service.PassengerService;

public class PassengerController {
    private final PassengerService passengerService;
    private PassengerDTO loggedInPassenger;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    public ResponseMessage<?> signUp(PassengerDTO passengerDTO) {
        // 이름, 이메일, 비밀번호가 null 또는 빈 문자열인지 확인
        if (isNullOrEmpty(passengerDTO.getName()) || isNullOrEmpty(passengerDTO.getEmail())
                || isNullOrEmpty(passengerDTO.getPassword())) {
            return new ResponseMessage<>("이름, 이메일, 비밀번호는 필수 입력 항목입니다.", 400, null);
        }

        // 이메일 형식이 올바른지 확인
        if (!isValidEmail(passengerDTO.getEmail())) {
            return new ResponseMessage<>("유효한 이메일 형식이 아닙니다.", 400, null);
        }

        passengerService.signUp(passengerDTO);

        return new ResponseMessage<>("회원가입이 완료되었습니다.", 200, null);
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isValidEmail(String email) {
        // 간단한 이메일 유효성 검사 예제
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }


    public ResponseMessage<?> login(String email, String password) {
        try {
            passengerService.login(email, password);
            return new ResponseMessage<>("로그인이 완료되었습니다.", 200, null);
        } catch (CustomException e) {
            return new ResponseMessage<>(e.getMessage(), 400, null);
        }
    }

    public PassengerDTO getLoggedInPassenger() {
        return loggedInPassenger;
    }



}

package reservationapp.common.exception;

public enum ErrorCode {

    DUPLICATE_EMAIL(400,"중복된 이메일이 존재합니다."),
    INVALID_LOGIN_INFO(400, "잘못된 로그인 정보입니다."),

    INVALID_SEAT_COUNT(400, "잘못된 좌석 수입니다."),
    INVALID_DATE(400, "잘못된 날짜입니다."),
    INVALID_FLIGHT_INFO(400, "잘못된 항공편 정보입니다."),
    INVALID_FLIGHT_ID(400, "잘못된 항공편 번호입니다."),
    FLIGHT_NOT_FOUND(400, "항공편이 존재하지 않습니다."),
    NO_AVAILABLE_SEATS(400, "더 이상 예약 가능한 좌석이 없습니다.");

    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}


package reservationapp.common.exception;

import reservationapp.dto.FlightDTO;

public class CustomException  extends RuntimeException{
    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }


    public int getErrorCode() {
        return errorCode.getCode();
    }

    public String getErrorMessage() {
        return errorCode.getDescription();
    }

}

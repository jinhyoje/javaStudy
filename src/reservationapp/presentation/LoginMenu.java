package reservationapp.presentation;


import reservationapp.ReservationMain;
import reservationapp.common.ResponseMessage;
import reservationapp.controller.PassengerController;
import java.util.Scanner;

public class LoginMenu {
    public static void login(Scanner scanner, PassengerController passengerController) {
        boolean loginSuccess = false;
        do {
            System.out.print("이메일을 입력하세요: ");
            String email = scanner.next();
            System.out.print("비밀번호를 입력하세요: ");
            String password = scanner.next();

            ResponseMessage<?> response = passengerController.login(email, password);

            System.out.println(response.getMsg());
            loginSuccess = response.getStatusCode() == 200;
        } while (!loginSuccess);
        ReservationMain.isLoggedIn = true;
    }

}


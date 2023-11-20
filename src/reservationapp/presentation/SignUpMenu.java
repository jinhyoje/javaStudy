package reservationapp.presentation;

import reservationapp.common.ResponseMessage;
import reservationapp.controller.PassengerController;
import reservationapp.dto.PassengerDTO;
import java.util.Scanner;

public class SignUpMenu {
    public static void signUp(Scanner scanner, PassengerController passengerController) {
        System.out.print("이름을 입력하세요: ");
        String name = scanner.next();
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.next();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.next();

        ResponseMessage<?> response = passengerController.signUp(new PassengerDTO(name, email, password));
        System.out.println(response.getMsg());

        LoginMenu.login(scanner, passengerController);
    }
}


package reservationapp.presentation;

import reservationapp.controller.FlightController;
import reservationapp.controller.PassengerController;
import reservationapp.service.FlightService;
import reservationapp.service.PassengerService;
import java.util.Scanner;

public class MainMenu {
    public static void showMainMenu(Scanner scanner, FlightService flightService, PassengerController passengerController, PassengerService passengerService) {
        System.out.println("1.로그인");
        System.out.println("2.회원가입");
        System.out.println("3.관리자로 로그인");
        System.out.println("4.종료하기");
        System.out.print("번호 선택: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                LoginMenu.login(scanner, passengerController);
                break;
            case 2:
                SignUpMenu.signUp(scanner, passengerController);
                break;
            case 3:
                AdminLoginMenu.adminLogin(scanner, flightService);
                break;
            case 4:
                System.out.println("종료하기");
                System.exit(0);
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해주세요.");
        }
    }

}


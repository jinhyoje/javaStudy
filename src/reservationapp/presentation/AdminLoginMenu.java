package reservationapp.presentation;

import reservationapp.ReservationMain;
import reservationapp.service.FlightService;
import java.util.Scanner;

public class AdminLoginMenu {
    public static void adminLogin(Scanner scanner, FlightService flightService) {
        System.out.print("관리자 이메일을 입력하세요: ");
        String email = scanner.next();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.next();

        if (flightService.isAdmin(email, password)) {
            ReservationMain.isAdminLoggedIn = true;
            System.out.println("관리자로 로그인되었습니다.");
        } else {
            System.out.println("관리자 로그인 실패: 이메일 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}


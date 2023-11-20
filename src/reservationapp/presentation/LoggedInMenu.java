package reservationapp.presentation;

import reservationapp.ReservationMain;
import reservationapp.common.ResponseMessage;
import reservationapp.controller.FlightController;
import reservationapp.controller.PassengerController;
import reservationapp.controller.ReservationController;
import reservationapp.dto.FlightDTO;
import reservationapp.dto.PassengerDTO;

import java.util.List;
import java.util.Scanner;

public class LoggedInMenu {
    public static void loggedMenu(Scanner scanner, PassengerController passengerController, ReservationController reservationController, FlightController flightController) {
        System.out.println("\nLogged In Menu:");
        System.out.println("1. 예약하기");
        System.out.println("2. 예약 취소하기");
        System.out.println("3. 티켓확인하기");
        System.out.println("4. 내 정보 확인");
        System.out.println("5. 로그아웃");
        System.out.print("번호 선택: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // 항공편 조회
                ResponseMessage<?> response = flightController.getAllFlights();

                if (response.getStatusCode() == 200) {
                    // 항공편 정보를 출력
                    List<FlightDTO> flights = (List<FlightDTO>) response.getData();
                    for (FlightDTO flight : flights) {
                        System.out.println(response.getMsg());
                        System.out.println("항공편 번호: " + flight.getFlightId());
                        System.out.println("항공편명: " + flight.getFlightNumber());
                        System.out.println("출발지: " + flight.getDeparture());
                        System.out.println("도착지: " + flight.getDestination());
                        System.out.println("출발 시간: " + flight.getDepartureTime());
                        System.out.println("도착 시간: " + flight.getArrivalTime());
                        System.out.println("좌석 수: " + flight.getSeatCount());
                        System.out.println("------------------------");
                    }
                } else {
                    System.out.println("항공편 조회 중 오류가 발생하였습니다.");
                }

                // 사용자에게 항공편 번호를 선택하도록 안내
                System.out.print("예약할 항공편 번호를 입력하세요: ");
                long selectedFlightId = scanner.nextLong();

                // 선택한 항공편에 대한 예약 생성
                reservationController.createReservation(selectedFlightId);
                break;
            case 2:
                // 예약 취소 기능 추가
                System.out.println("예약 취소 기능은 아직 구현되지 않았습니다.");
                break;
            case 3:
                // 티켓 확인 기능 추가
                System.out.println("티켓 확인 기능은 아직 구현되지 않았습니다.");
                break;
            case 4:
                // 내 정보 확인 기능 추가
                System.out.println("내 정보 확인 기능은 아직 구현되지 않았습니다.");
                break;
            case 5:
                // 로그아웃 시 로그인 상태 플래그 업데이트
                ReservationMain.isLoggedIn = false;
                System.out.println("로그아웃되었습니다.");
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해주세요.");
        }
    }

}


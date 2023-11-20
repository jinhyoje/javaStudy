package reservationapp.presentation;

import reservationapp.ReservationMain;
import reservationapp.common.ResponseMessage;
import reservationapp.controller.FlightController;
import reservationapp.dto.FlightDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    public static void adminMenu(Scanner scanner, FlightController flightController) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. 항공편 생성");
        System.out.println("2. 항공편 조회");
        System.out.println("3. 항공편 삭제");
        System.out.println("4. 돌아가기");
        System.out.print("번호 선택: ");

        int adminChoice = scanner.nextInt();
        switch (adminChoice) {
            case 1:
                createFlight(scanner, flightController);
                break;
            case 2:
                viewAllFlights(flightController);
                break;
            case 3:
                deleteFlight(scanner, flightController);
                break;
            case 4:
                ReservationMain.isAdminLoggedIn = false;
                break;
            default:
                System.out.println("유효하지 않은 선택입니다. 다시 시도해주세요.");
        }
    }

    private static void viewAllFlights(FlightController flightController) {
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
    }

    private static void deleteFlight(Scanner scanner, FlightController flightController) {
        System.out.print("삭제할 항공편 번호 입력: ");
        long flightId = scanner.nextLong();
        ResponseMessage<?> response = flightController.deleteFlight(flightId);
        System.out.println(response.getMsg());
    }

    private static void createFlight(Scanner scanner, FlightController flightController) {
        while (true) {
        System.out.print("항공편명을 입력하세요: ");
        String flightName = scanner.next();
        System.out.print("출발지를 입력하세요: ");
        String departure = scanner.next();
        System.out.print("도착지를 입력하세요: ");
        String destination = scanner.next();
        System.out.print("출발 날짜를 입력하세요 (yyyy-MM-dd): ");
        String departureTime = scanner.next();
        System.out.print("도착 날짜를 입력하세요 (yyyy-MM-dd): ");
        String arrivalTime = scanner.next();
        System.out.print("좌석 갯수를 입력하세요: ");
        int seatCount = scanner.nextInt();

            if (isValidDateFormat(departureTime) && isValidDateFormat(arrivalTime)) {
                ResponseMessage<?> response = flightController.createFlight(new FlightDTO(flightName, departure, destination, departureTime, arrivalTime, seatCount));
                System.out.println(response.getMsg());
                break;
            } else {
                System.out.println("날짜 형식이 올바르지 않습니다. 다시 입력해주세요.");
            }
        }
    }

    private static boolean isValidDateFormat(String dateString) {
        try {
            LocalDate.parse(dateString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

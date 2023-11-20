package reservationapp;

import reservationapp.controller.FlightController;
import reservationapp.controller.PassengerController;
import reservationapp.controller.ReservationController;
import reservationapp.presentation.AdminMenu;
import reservationapp.presentation.LoggedInMenu;
import reservationapp.presentation.MainMenu;
import reservationapp.repository.MemStore;
import reservationapp.repository.impl.FlightRepositoryImpl;
import reservationapp.repository.impl.PassengerRepositoryImpl;
import reservationapp.repository.impl.ReservationRepositoryImpl;
import reservationapp.repository.impl.TicketRepositoryImpl;
import reservationapp.service.FlightService;
import reservationapp.service.PassengerService;
import reservationapp.service.ReservationService;
import reservationapp.service.TicketService;

import java.util.Scanner;


public class ReservationMain {
    private static Scanner scanner = new Scanner(System.in);
    private static FlightService flightService = new FlightService(new FlightRepositoryImpl(MemStore.flights));
    private static PassengerService passengerService = new PassengerService(new PassengerRepositoryImpl(MemStore.passengers));
    private static ReservationService reservationService = new ReservationService(new ReservationRepositoryImpl(MemStore.reservations));
    private static PassengerController passengerController = new PassengerController(passengerService);
    private static FlightController flightController = new FlightController(flightService);
    private static TicketService ticketService = new TicketService(new TicketRepositoryImpl(MemStore.tickets));
    private static ReservationController reservationController = new ReservationController(reservationService, flightService, passengerController, ticketService);
    public static boolean isLoggedIn = false;
    public static boolean isAdminLoggedIn = false;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to the Reservation App!");

            if (isLoggedIn) {
                LoggedInMenu.loggedMenu(scanner, passengerController, reservationController, flightController);
            } else if (isAdminLoggedIn) {
                AdminMenu.adminMenu(scanner, flightController);
            } else {
                MainMenu.showMainMenu(scanner, flightService, passengerController, passengerService);
            }
        }
    }
}



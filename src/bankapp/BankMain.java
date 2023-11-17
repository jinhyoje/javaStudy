package bankapp;

import bankapp.controller.AccountController;
import bankapp.controller.CustomerController;
import bankapp.controller.TransactionController;
import bankapp.dto.AccountDTO;
import bankapp.dto.CustomerDTO;
import bankapp.repository.Memory;
import bankapp.repository.impl.AccountRepositoryImpl;
import bankapp.repository.impl.CustomerRepositoryImpl;
import bankapp.repository.impl.TransactionRepositoryImpl;
import bankapp.service.AccountService;
import bankapp.service.CustomerService;
import bankapp.service.TransactionService;

import java.util.Scanner;

public class BankMain {

    private static Scanner sc = new Scanner(System.in);
    private static CustomerService customerService = new CustomerService(new CustomerRepositoryImpl(Memory.customers));
    private static AccountService accountService = new AccountService(new AccountRepositoryImpl(Memory.accounts));
    private static TransactionService transactionService = new TransactionService(new TransactionRepositoryImpl(Memory.transactions));
    private static CustomerController customerController = new CustomerController(customerService);
    private static AccountController accountController = new AccountController(accountService);
    private static TransactionController transactionController = new TransactionController(transactionService);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            try {
                System.out.println("-------------------------------------");
                System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
                System.out.println("-------------------------------------");
                System.out.print("선택> ");
                int selectNo = sc.nextInt();

                switch (selectNo) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        accountList();
                        break;
                    case 3:
                        deposit();
                        break;
                    // case 4: withdraw(); break;
                    case 5:
                        run = false;
                        break;
                    default:
                        System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                }
            } catch (Exception e) {
                System.err.println("잘못된 입력입니다. 숫자를 입력하세요.");
                sc.nextLine();
            }
        }
        System.out.println("프로그램 종료");
    }


    private static void createAccount() {
        System.out.print("소유주명>");
        String name = sc.next();
        System.out.print("초기입금액>");
        while (!sc.hasNextDouble()) {
            System.out.println("숫자를 입력하세요.");
            sc.next(); // 잘못된 입력값을 읽어서 다음 입력을 받을 수 있도록 함
        }
        double balance = sc.nextDouble();

        CustomerDTO customerDTO = CustomerDTO.of(name);
        AccountDTO accountDTO = AccountDTO.of(balance);

        customerController.signUp(customerDTO);
        accountController.createAccount(accountDTO);

    }

    private static void accountList() {
        accountController.getAllAccounts();
    }

    private static void deposit() {
    }






    }


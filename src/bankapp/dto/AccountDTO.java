package bankapp.dto;

import java.util.Random;

public class AccountDTO {
    private static Long nextId = 1L;

    private Long id;
    private String accountNumber;
    private double balance;

    private AccountDTO() {
    }

    public static AccountDTO of(double balance) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.id = generateNextId();
        accountDTO.accountNumber = generateAccountNumber();
        accountDTO.balance = balance;
        return accountDTO;
    }

    private static synchronized Long generateNextId() { // 멀티스레딩 환경에서 안전하게 사용하기 위해 synchronized 키워드 사용
        // 다음 id를 생성하고 증가
        Long generatedId = nextId;
        nextId++;
        return generatedId;
    }

    private static String generateAccountNumber() {
        // 1000부터 9999 사이의 랜덤 숫자를 생성하여 4글자마다 하이픈 추가
        String randomNumber = String.format("%04d", new Random().nextInt(9000) + 1000);
        randomNumber += "-" + String.format("%04d", new Random().nextInt(9000) + 1000);
        randomNumber += "-" + String.format("%04d", new Random().nextInt(9000) + 1000);
        return randomNumber;
    }


    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "id : " + id +
                ", 계좌 번호 : " + accountNumber  +
                ", 잔고 : " + balance + "원";
    }


}

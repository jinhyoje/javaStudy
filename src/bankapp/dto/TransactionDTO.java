package bankapp.dto;

import java.time.LocalDateTime;

public class TransactionDTO {
    private static Long nextId = 1L;

    private Long id;
    private String type;
    private double amount;
    private LocalDateTime date;
    private AccountDTO account;

    private TransactionDTO() {
    }

    public static  TransactionDTO of(String type, double amount, LocalDateTime date, AccountDTO account) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.id =generateNextId();
        transactionDTO.type = type;
        transactionDTO.amount = amount;
        transactionDTO.date = date;
        transactionDTO.account = account;
        return transactionDTO;
    }
    private static synchronized Long generateNextId() { // 멀티스레딩 환경에서 안전하게 사용하기 위해 synchronized 키워드 사용
        // 다음 id를 생성하고 증가
        Long generatedId = nextId;
        nextId++;
        return generatedId;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public AccountDTO getAccount() {
        return account;
    }
}

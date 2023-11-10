package BankAccount;

public class BankAccount {
    private String ownerName; // private안하면 외부에서 조작가능
    private String accountNumber;
    private double balance;


    BankAccount(String ownerName, String accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    double deposit(double amount) {
        System.out.println("금액을 추가합니다");
        balance += amount;
        System.out.println(String.format("계좌번호: %s", balance));
        System.out.println("계좌 잔액은 : " + balance);
        return balance;
    }

    double withdraw(double amount) {
        System.out.println("금액을 차감합니다");
        if (balance >= amount && balance > 0) {
            balance -= amount;
            System.out.println("남은 금액은 " + balance);
        } else {
            System.out.println("금액이 부족합니다");
        }
        return balance;
    }

    double getBalance() {
        System.out.println("현재 잔액은 : " + balance);
        return balance;
    }

    void getAccountInfo() {
        System.out.println("소유자 이름 " + ownerName + ", 계좌 번호 " + accountNumber + ", 초기 잔액 $" + balance);
    }


}

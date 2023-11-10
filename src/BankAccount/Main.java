package BankAccount;


public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("John Doe", "123456", 1000);
        bankAccount.getAccountInfo();
        bankAccount.deposit(134);
        bankAccount.withdraw(100);
        bankAccount.withdraw(100000);
        bankAccount.getBalance();


    }
}

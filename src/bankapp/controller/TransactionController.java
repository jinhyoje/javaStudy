package bankapp.controller;

import bankapp.service.TransactionService;

public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void deposit(long id, long amount) {
        transactionService.deposit(id, amount);
    }

    public void withdraw(long id, long amount) {
        transactionService.withdraw(id, amount);
    }

}

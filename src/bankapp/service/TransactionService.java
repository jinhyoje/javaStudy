package bankapp.service;


import bankapp.dto.AccountDTO;
import bankapp.dto.TransactionDTO;
import bankapp.repository.MemoryRepository;

public class TransactionService {
    private final MemoryRepository<TransactionDTO> transactionRepository;
    public TransactionService(MemoryRepository<TransactionDTO> transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(long id, long amount) {
    }

    public void withdraw(long id, long amount) {
    }
}

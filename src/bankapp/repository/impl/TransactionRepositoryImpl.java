package bankapp.repository.impl;

import bankapp.dto.TransactionDTO;
import bankapp.repository.MemoryRepository;

import java.util.List;

public class TransactionRepositoryImpl implements MemoryRepository<TransactionDTO> {
    List<TransactionDTO> transactions;

    public TransactionRepositoryImpl(List<TransactionDTO> list) {
        transactions = list;
    }

    @Override
    public void create(TransactionDTO transactionDTO) {
        transactions.add(transactionDTO);
    }

    @Override
    public void update(long id, TransactionDTO transactionDTO) {
        transactions.stream().filter(transaction -> transaction.getId() == id).findFirst().ifPresent(transaction -> {
            TransactionDTO.of(transactionDTO.getType(), transactionDTO.getAmount(), transactionDTO.getDate(), transactionDTO.getAccount());
        });

    }

    @Override
    public void delete(long id) {
        transactions.remove((int) id);
    }

    @Override
    public TransactionDTO findById(long id) {
        return transactions.stream().filter(transactionDTO -> transactionDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<TransactionDTO> findAll() {
        return transactions;
    }
}

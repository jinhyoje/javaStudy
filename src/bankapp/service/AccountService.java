package bankapp.service;

import bankapp.dto.AccountDTO;
import bankapp.repository.MemoryRepository;

import java.util.List;


public class AccountService {
    private final MemoryRepository<AccountDTO> accountRepository;

    public AccountService(MemoryRepository<AccountDTO> accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(AccountDTO accountDTO) {
        accountRepository.create(accountDTO);

    }

    public AccountDTO getAccount(long id) {
        return accountRepository.findById(id);
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll();
    }
}

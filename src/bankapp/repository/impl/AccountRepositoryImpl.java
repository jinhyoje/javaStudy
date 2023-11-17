package bankapp.repository.impl;

import bankapp.dto.AccountDTO;
import bankapp.repository.MemoryRepository;

import java.util.List;

public class AccountRepositoryImpl implements MemoryRepository<AccountDTO> {
    List<AccountDTO> accounts;

    public AccountRepositoryImpl(List<AccountDTO> list) {
        accounts = list;
    }

    @Override
    public void create(AccountDTO accountDTO) {
        accounts.add(accountDTO);
    }

    @Override
    public void update(long id, AccountDTO accountDTO) {
        accounts.stream().filter(account -> account.getId() == id).findFirst().ifPresent(account -> {
            AccountDTO.of(account.getBalance());
        });

    }

    @Override
    public void delete(long id) {
        accounts.remove((int) id);

    }

    @Override
    public AccountDTO findById(long id) {
        return accounts.stream().filter(accountDTO -> accountDTO.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<AccountDTO> findAll() {
        return accounts;
    }
}

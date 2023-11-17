package bankapp.controller;

import bankapp.dto.AccountDTO;
import bankapp.service.AccountService;

import java.util.List;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public void createAccount(AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);
        System.out.println(String.format("계좌번호 : %s 계좌 생성이 완료되었습니다.", accountDTO.getAccountNumber()));
    }

    public AccountDTO getAccount(long id) {
        return accountService.getAccount(id);
    }

    public void getAllAccounts() {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        System.out.println("전체 계좌 목록:");
        for (AccountDTO account : accounts) {
            System.out.println(account);
        }
    }



}

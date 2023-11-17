package bankapp.repository;

import bankapp.dto.AccountDTO;
import bankapp.dto.CustomerDTO;
import bankapp.dto.TransactionDTO;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    public static List<CustomerDTO> customers = new ArrayList<>();
    public static List<AccountDTO> accounts = new ArrayList<>();
    public static List<TransactionDTO> transactions = new ArrayList<>();
}

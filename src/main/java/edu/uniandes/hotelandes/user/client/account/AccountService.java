package edu.uniandes.hotelandes.user.client.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uniandes.hotelandes.exception.EntityNotFoundException;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        final var accounts = accountRepository.insertAccount(account);
        if (accounts != 1) {
            throw new IllegalStateException();
        }
    }

    public Account getAccount(Integer id) {
        return accountRepository.selectAccountById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Account with id %s was not found", id)));
    }

    public List<Account> getAccounts() {
        return accountRepository.selectAccounts();
    }

    public Account updateAccount(Integer id, Account account) {
        final var accounts = accountRepository.selectAccountById(id);
        if (accounts.isPresent()) {
            final var a = accountRepository.updateAccount(id, account);
            if (a != 1) {
                throw new IllegalStateException("Account update went wrong");
            }
            return account;
        } else {
            throw new IllegalStateException("Account does not exist");
        }
    }
}

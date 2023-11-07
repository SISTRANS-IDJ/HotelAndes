package edu.uniandes.hotelandes.user.client.account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    int insertAccount(Account account);
    Optional<Account> selectAccountById(Integer id);
    List<Account> selectAccounts();
    int updateAccount(Integer id, Account newAccount);
    
}

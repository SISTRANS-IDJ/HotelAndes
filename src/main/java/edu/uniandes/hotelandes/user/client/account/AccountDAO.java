package edu.uniandes.hotelandes.user.client.account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
<<<<<<< HEAD
  int insertAccount(Account account);

  Optional<Account> selectAccountById(Integer id);

  List<Account> selectAccounts();

  int increaseTotal(Integer id, Float cost);

  int decreaseBalance(Integer id, Float cost);
=======
    int insertAccount(Account account);
    Optional<Account> selectAccountById(Integer id);
    List<Account> selectAccounts();
    int updateAccount(Integer id, Account newAccount);
    
>>>>>>> feature-data-generation
}

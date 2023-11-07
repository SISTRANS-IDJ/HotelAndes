package edu.uniandes.hotelandes.user.client.account;

import java.util.List;
import java.util.Optional;

public class AccountRepository implements AccountDAO {

    @Override
    public int insertAccount(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAccount'");
    }

    @Override
    public Optional<Account> selectAccountById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAccountById'");
    }

    @Override
    public List<Account> selectAccounts() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAccounts'");
    }

    @Override
    public int increaseTotal(Integer id, Float cost) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'increaseTotal'");
    }

    @Override
    public int decreaseBalance(Integer id, Float cost) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'decreaseBalance'");
    }
    
}

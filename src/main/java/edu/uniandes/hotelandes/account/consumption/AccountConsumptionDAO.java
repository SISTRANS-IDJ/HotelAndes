package edu.uniandes.hotelandes.account.consumption;

import java.util.List;
import java.util.Optional;

public interface AccountConsumptionDAO {
  int insertAccountConsumption(AccountConsumption accountConsumption);

  Optional<AccountConsumption> selectAccountConsumptionById(long id);

  List<AccountConsumption> selectAccountConsumptions();

  int updateAccountConsumption(long id, AccountConsumption role);

  int deleteAccountConsumption(long id);
}

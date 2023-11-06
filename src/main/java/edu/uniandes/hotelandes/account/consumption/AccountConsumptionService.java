package edu.uniandes.hotelandes.account.consumption;

import edu.uniandes.hotelandes.exception.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountConsumptionService {
  private final AccountConsumptionDAO accountConsumptionDAO;

  @Autowired
  public AccountConsumptionService(AccountConsumptionDAO accountConsumptionDAO) {
    this.accountConsumptionDAO = accountConsumptionDAO;
  }

  public void createAccountConsumption(AccountConsumption accountConsumption) {

    final var accountConsumptions =
        accountConsumptionDAO.selectAccountConsumptionById(accountConsumption.id());
    if (accountConsumptions.isEmpty()) {
      final var r = accountConsumptionDAO.insertAccountConsumption(accountConsumption);
      if (r != 1) {
        throw new IllegalStateException("Account consumption creation went wrong");
      }
    } else {
      throw new IllegalStateException("Account consumption already exists");
    }
  }

  public AccountConsumption getAccountConsumptionById(Long id) {
    return accountConsumptionDAO
        .selectAccountConsumptionById(id)
        .orElseThrow(
            () ->
                new EntityNotFoundException(
                    String.format("Account consumption with id %s not found", id)));
  }

  public List<AccountConsumption> getAccountConsumptions() {
    return accountConsumptionDAO.selectAccountConsumptions();
  }

  public AccountConsumption updateAccountConsumption(
      Long id, AccountConsumption accountConsumption) {
    final var accountConsumptions =
        accountConsumptionDAO.selectAccountConsumptionById(accountConsumption.id());
    if (accountConsumptions.isPresent()) {
      final var r = accountConsumptionDAO.updateAccountConsumption(id, accountConsumption);
      if (r != 1) {
        throw new IllegalStateException("Account consumption role update went wrong");
      }
      return accountConsumption;
    } else {
      throw new IllegalStateException("Account consumption role doesn't exists");
    }
  }

  public void deleteRole(Long id) {
    final var accountConsumptions = accountConsumptionDAO.selectAccountConsumptionById(id);
    accountConsumptions.ifPresentOrElse(
        role -> {
          final var result = accountConsumptionDAO.deleteAccountConsumption(id);
          if (result != 1) {
            throw new IllegalStateException("Could not delete account consumption");
          }
        },
        () -> {
          throw new EntityNotFoundException(
              String.format("Account consumption with id %s not found", id));
        });
  }
}

package edu.uniandes.hotelandes.account.consumption;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/account/consumption")
public class AccountConsumptionController {
  private final AccountConsumptionService accountConsumptionService;

  @Autowired
  public AccountConsumptionController(AccountConsumptionService accountConsumptionService) {
    this.accountConsumptionService = accountConsumptionService;
  }

  @PostMapping
  public void createAccountConsumption(@RequestBody AccountConsumption accountConsumption) {
    accountConsumptionService.createAccountConsumption(accountConsumption);
  }

  @GetMapping("{id}")
  public AccountConsumption getAccountConsumptionByID(@PathVariable("id") Long id) {
    return accountConsumptionService.getAccountConsumptionById(id);
  }

  @GetMapping
  public List<AccountConsumption> listAccountConsumptions() {
    return accountConsumptionService.getAccountConsumptions();
  }

  @PutMapping("{id}")
  public AccountConsumption updateAccountConsumption(
      @PathVariable Long id, @RequestBody AccountConsumption accountConsumption) {
    return accountConsumptionService.updateAccountConsumption(id, accountConsumption);
  }

  @DeleteMapping("{id}")
  public void deleteAccountConsumption(@PathVariable("id") Long id) {
    accountConsumptionService.deleteRole(id);
  }
}

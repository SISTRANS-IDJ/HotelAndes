package edu.uniandes.hotelandes.account.consumption;

import edu.uniandes.hotelandes.user.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/account/consumption")
public class AccountConsumptionController {
    private final AccountConsumptionService accountConsumptionService;

    @Autowired
    public AccountConsumptionController(AccountConsumptionService accountConsumptionService)
    {
        this.accountConsumptionService = accountConsumptionService;
    }
}

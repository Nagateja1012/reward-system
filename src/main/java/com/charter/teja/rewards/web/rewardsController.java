package com.charter.teja.rewards.web;
import com.charter.teja.rewards.model.Rewards;
import com.charter.teja.rewards.model.transactions;
import com.charter.teja.rewards.services.rewardsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class rewardsController {

    private final rewardsService service;
    private Rewards Rewards;

    public rewardsController(rewardsService service) {
        this.service = service;
    }

    @GetMapping("/rewards/{month1}/{month2}/{month3}")
    public List<Rewards> customers(@PathVariable String month1,@PathVariable String month2, @PathVariable String month3){
        return service.getAllCustomers(month1, month2, month3);
    }

    @GetMapping("/rewards/{id}/{month1}/{month2}/{month3}")
    public List<Rewards> customersById(@PathVariable int id,@PathVariable String month1,@PathVariable String month2, @PathVariable String month3) {
        return service.getCustomerByID(id, month1,month2,month3);
    }

    @GetMapping("/transactions")
    public List<transactions> transactions(){
        return service.getAllTransactions();
    }
}

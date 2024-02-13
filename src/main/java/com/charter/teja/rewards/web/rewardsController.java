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

    @GetMapping("/rewards")
    public List<Rewards> customers(){
        return service.getAllCustomers();
    }

    @GetMapping("/rewards/{id}")
    public Rewards customersbyid(@PathVariable int id) {
        return null;
    }

    @GetMapping("/transactions")
    public List<transactions> transactions(){
        return service.getAllTransactions();
    }
}

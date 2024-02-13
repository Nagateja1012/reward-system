package com.charter.teja.rewards.services;

import com.charter.teja.rewards.Repository.rewardsRepo;
import com.charter.teja.rewards.model.Rewards;
import com.charter.teja.rewards.model.transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rewardsService {
    @Autowired
    private rewardsRepo rewardsRepository;


    public  List<Rewards> getAllCustomers(String month1, String month2, String month3) {
      return rewardsRepository.findALLCustomers(month1,  month2,  month3);

    }
    public  List<transactions> getAllTransactions() {
        return rewardsRepository.findALLTransactions();
    }
}

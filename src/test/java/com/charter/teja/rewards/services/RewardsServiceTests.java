package com.charter.teja.rewards.services;

import com.charter.teja.rewards.Repository.rewardsRepo;
import com.charter.teja.rewards.model.Rewards;
import com.charter.teja.rewards.model.transactions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RewardsServiceTests {
    @Mock
    private rewardsRepo rewardsRepository;

    @InjectMocks
    private rewardsService rewardsService;

    @Test
    void testGetALLTransactions() {

        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);

        transactions transaction = new transactions();
        transaction.setTransId(1);
        transaction.setDate("2022-02-14");
        transaction.setAmount(120.0);
        transaction.setRewards(rewards);

        List<transactions> expectedTransactions = List.of(transaction);


        when(rewardsRepository.findALLTransactions()).thenReturn(expectedTransactions);

        List<transactions> actualTransactions = rewardsService.getAllTransactions();

        assertEquals(expectedTransactions.size(), actualTransactions.size());
        assertEquals(expectedTransactions.get(0).getTransId(), actualTransactions.get(0).getTransId());
        assertEquals(expectedTransactions.get(0).getDate(), actualTransactions.get(0).getDate());
        assertEquals(expectedTransactions.get(0).getAmount(), actualTransactions.get(0).getAmount());
        assertEquals(expectedTransactions.get(0).getRewards().getTotal(), actualTransactions.get(0).getRewards().getTotal());
        assertEquals(expectedTransactions.get(0).getRewards().getFirstname(), actualTransactions.get(0).getRewards().getFirstname());
        assertEquals(expectedTransactions.get(0).getRewards().getLastname(), actualTransactions.get(0).getRewards().getLastname());
        assertEquals(expectedTransactions.get(0).getRewards().getCustomerId(), actualTransactions.get(0).getRewards().getCustomerId());
    }

    @Test
    void testGetALLCustomers() {

        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);
        rewards.setMonth1(178);
        rewards.setMonth2(198);
        rewards.setMonth3(78);

        List<Rewards> expectedCustomer = List.of(rewards);

        when(rewardsRepository.findALLCustomers(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(expectedCustomer);


        List<Rewards> actualCustomers = rewardsService.getAllCustomers("2024-01","2024-02","2024-03");

        assertEquals(expectedCustomer.size(), actualCustomers.size());
        assertEquals(expectedCustomer.get(0).getTotal(), actualCustomers.get(0).getTotal());
        assertEquals(expectedCustomer.get(0).getFirstname(), actualCustomers.get(0).getFirstname());
        assertEquals(expectedCustomer.get(0).getLastname(), actualCustomers.get(0).getLastname());
        assertEquals(expectedCustomer.get(0).getCustomerId(), actualCustomers.get(0).getCustomerId());
        assertEquals(expectedCustomer.get(0).getMonth1(), actualCustomers.get(0).getMonth1());
        assertEquals(expectedCustomer.get(0).getMonth2(), actualCustomers.get(0).getMonth2());
        assertEquals(expectedCustomer.get(0).getMonth3(), actualCustomers.get(0).getMonth3());
    }

    @Test
    void testGetCustomerById() {

        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);
        rewards.setMonth1(178);
        rewards.setMonth2(198);
        rewards.setMonth3(78);

        List<Rewards> expectedCustomer = List.of(rewards);

        when(rewardsRepository.findCustomerById(Mockito.anyString(),Mockito.anyString(),Mockito.anyString(), Mockito.anyInt())).thenReturn(expectedCustomer);


        List<Rewards> actualCustomers = rewardsService.getCustomerByID(1,"2024-01","2024-02","2024-03");

        assertEquals(expectedCustomer.size(), actualCustomers.size());
        assertEquals(expectedCustomer.get(0).getTotal(), actualCustomers.get(0).getTotal());
        assertEquals(expectedCustomer.get(0).getFirstname(), actualCustomers.get(0).getFirstname());
        assertEquals(expectedCustomer.get(0).getLastname(), actualCustomers.get(0).getLastname());
        assertEquals(expectedCustomer.get(0).getCustomerId(), actualCustomers.get(0).getCustomerId());
        assertEquals(expectedCustomer.get(0).getMonth1(), actualCustomers.get(0).getMonth1());
        assertEquals(expectedCustomer.get(0).getMonth2(), actualCustomers.get(0).getMonth2());
        assertEquals(expectedCustomer.get(0).getMonth3(), actualCustomers.get(0).getMonth3());
    }

}

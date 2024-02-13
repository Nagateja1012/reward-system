package com.charter.teja.rewards.web;
import com.charter.teja.rewards.model.Rewards;
import com.charter.teja.rewards.model.transactions;
import com.charter.teja.rewards.services.rewardsService;
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
public class RewardsControllerTests {
    @Mock
    private rewardsService rewardsService;

    @InjectMocks
    private rewardsController rewardsController;


    @Test
    void testCustomers() {
        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);
        rewards.setMonth1(178);
        rewards.setMonth2(198);
        rewards.setMonth3(78);

        List<Rewards> expectedCustomer = List.of(rewards);

        // Mocking the rewardsService.getAllCustomers method
        when(rewardsService.getAllCustomers(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(expectedCustomer);

        // Perform the actual test
        List<Rewards> actualCustomers = rewardsController.customers("2024-01","2024-02","2024-03");

        // Verify the results
        assertEquals(expectedCustomer.size(), actualCustomers.size());
        assertEquals(expectedCustomer.get(0).getTotal(), actualCustomers.get(0).getTotal());
        assertEquals(expectedCustomer.get(0).getFirstname(), actualCustomers.get(0).getFirstname());
        assertEquals(expectedCustomer.get(0).getLastname(), actualCustomers.get(0).getLastname());
        assertEquals(expectedCustomer.get(0).getCustomerId(), actualCustomers.get(0).getCustomerId());
        assertEquals(expectedCustomer.get(0).getMonth1(), actualCustomers.get(0).getMonth1());
        assertEquals(expectedCustomer.get(0).getMonth2(), actualCustomers.get(0).getMonth2());
        assertEquals(expectedCustomer.get(0).getMonth2(), actualCustomers.get(0).getMonth2());
    }

    @Test
    void testCustomerById() {
        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);
        rewards.setMonth1(178);
        rewards.setMonth2(198);
        rewards.setMonth3(78);

        List<Rewards> expectedCustomer = List.of(rewards);

        // Mocking the rewardsService.getAllCustomers method
        when(rewardsService.getCustomerByID(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(expectedCustomer);

        // Perform the actual test
        List<Rewards> actualCustomers = rewardsController.customersById(2,"2024-01","2024-02","2024-03");

        // Verify the results
        assertEquals(expectedCustomer.size(), actualCustomers.size());
        assertEquals(expectedCustomer.get(0).getTotal(), actualCustomers.get(0).getTotal());
        assertEquals(expectedCustomer.get(0).getFirstname(), actualCustomers.get(0).getFirstname());
        assertEquals(expectedCustomer.get(0).getLastname(), actualCustomers.get(0).getLastname());
        assertEquals(expectedCustomer.get(0).getCustomerId(), actualCustomers.get(0).getCustomerId());
        assertEquals(expectedCustomer.get(0).getMonth1(), actualCustomers.get(0).getMonth1());
        assertEquals(expectedCustomer.get(0).getMonth2(), actualCustomers.get(0).getMonth2());
        assertEquals(expectedCustomer.get(0).getMonth2(), actualCustomers.get(0).getMonth2());
    }

    @Test
    void testTransactions() {
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

        // Mocking the rewardsService.getAllTransactions method
        when(rewardsService.getAllTransactions()).thenReturn(expectedTransactions);

        // Perform the actual test
        List<transactions> actualTransactions = rewardsController.transactions();

        // Verify the results
        assertEquals(expectedTransactions.size(), actualTransactions.size());
        assertEquals(expectedTransactions.get(0).getTransId(), actualTransactions.get(0).getTransId());
        assertEquals(expectedTransactions.get(0).getDate(), actualTransactions.get(0).getDate());
        assertEquals(expectedTransactions.get(0).getAmount(), actualTransactions.get(0).getAmount());
        assertEquals(expectedTransactions.get(0).getRewards().getTotal(), actualTransactions.get(0).getRewards().getTotal());
        assertEquals(expectedTransactions.get(0).getRewards().getFirstname(), actualTransactions.get(0).getRewards().getFirstname());
        assertEquals(expectedTransactions.get(0).getRewards().getLastname(), actualTransactions.get(0).getRewards().getLastname());
        assertEquals(expectedTransactions.get(0).getRewards().getCustomerId(), actualTransactions.get(0).getRewards().getCustomerId());
    }
}

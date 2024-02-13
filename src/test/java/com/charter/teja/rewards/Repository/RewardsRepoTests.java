package com.charter.teja.rewards.Repository;
import com.charter.teja.rewards.model.Rewards;
import com.charter.teja.rewards.model.transactions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RewardsRepoTests {
    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private rewardsRepo rewardsRepository;

    @Test
    void testFindAllTransactions() {

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

        when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class))).thenReturn(expectedTransactions);

        List<transactions> actualTransactions = rewardsRepository.findALLTransactions();

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
    void testPointsCalculation() {

        assertEquals(70, rewardsRepository.pointsCalculation(110.0));
        assertEquals(30, rewardsRepository.pointsCalculation(80.0));
        assertEquals(0, rewardsRepository.pointsCalculation(40.0));
        assertEquals(0, rewardsRepository.pointsCalculation(50.0));
        assertEquals(0, rewardsRepository.pointsCalculation(0.0));
        assertEquals(1, rewardsRepository.pointsCalculation(51.0));
        assertEquals(50, rewardsRepository.pointsCalculation(100.0));
        assertEquals(52, rewardsRepository.pointsCalculation(101.0));
        assertEquals(192, rewardsRepository.pointsCalculation(171.0));
    }

    @Test
    void testFindAllCustomer(){
        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);
        rewards.setMonth1(178);
        rewards.setMonth2(198);
        rewards.setMonth3(78);

        List<Rewards> expectedCustomer = List.of(rewards);

        when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class), Mockito.any(Object[].class))).thenReturn(expectedCustomer);


        List<Rewards> actualCustomers = rewardsRepository.findALLCustomers("2024-01","2024-02","2024-03");

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
    void testFindCustomerById(){
        Rewards rewards = new Rewards();
        rewards.setTotal(100);
        rewards.setFirstname("Teja");
        rewards.setLastname("Dasari");
        rewards.setCustomerId(1);
        rewards.setMonth1(178);
        rewards.setMonth2(198);
        rewards.setMonth3(78);

        List<Rewards> expectedCustomer = List.of(rewards);

        when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class), Mockito.any(Object[].class))).thenReturn(expectedCustomer);


        List<Rewards> actualCustomers = rewardsRepository.findCustomerById("2024-01","2024-02","2024-03", 1);

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







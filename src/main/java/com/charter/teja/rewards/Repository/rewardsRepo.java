package com.charter.teja.rewards.Repository;


import com.charter.teja.rewards.model.Rewards;
import com.charter.teja.rewards.model.transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class rewardsRepo  {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    public List<Rewards> findAllCustomers() {
//        String sql = "SELECT FIRSTNAME,id FROM customer";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Rewards Rewards = new Rewards();
//            Rewards.setMonth1(rs.getInt("id"));
//            Rewards.setFirstname(rs.getString("firstname"));
//            // Set other attributes as needed
//            return Rewards;
//        });
//    }

    public List<transactions> findALLTransactions(){
        String sql = "SELECT FIRSTNAME, C.CUSTOMER_ID, LASTNAME, TRANSACTION_ID , DATE, AMOUNT FROM customer C,transactions T where C.CUSTOMER_ID = T.CUSTOMER_ID";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            transactions trans = new transactions();
            Rewards Rewards = new Rewards();
            Rewards.setTotal(pointsCalculation(rs.getDouble("AMOUNT")));
            Rewards.setFirstname(rs.getString("firstname"));
            Rewards.setLastname(rs.getString("lastname"));
            Rewards.setCustomerId(rs.getInt("CUSTOMER_ID"));
            trans.setTransId(rs.getInt("TRANSACTION_ID"));
            trans.setDate(rs.getString("DATE"));
            trans.setAmount(rs.getBigDecimal("Amount"));
            trans.setRewards(Rewards);
            return trans;
        });
    }

    private int pointsCalculation(double amount) {
        int Amount = (int)amount;
        if(Amount>100){
           return ((Amount-100)*2+50);
        }else if (Amount>50){
            return Amount - 50;
        }
        return 0;
    }

}

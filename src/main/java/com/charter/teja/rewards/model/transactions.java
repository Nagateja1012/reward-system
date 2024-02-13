package com.charter.teja.rewards.model;

import java.math.BigDecimal;

public class transactions {

    private int transId;
    private BigDecimal amount;
    private String date;

    private Rewards rewards;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }
}

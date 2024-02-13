package com.charter.teja.rewards.model;



public class transactions{

    private int transId;
    private Double amount;
    private String date;

    private Rewards rewards;

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

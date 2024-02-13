package com.charter.teja.rewards.model;

public class Rewards {

        private String firstname;

        private String lastname ;
        private int month1;
    private int month2;
    private int month3;
    private int total;
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getMonth1() {
        return month1;
    }

    public void setMonth1(int month1) {
        this.month1 = month1;
    }

    public int getMonth2() {
        return month2;
    }

    public void setMonth2(int month2) {
        this.month2 = month2;
    }

    public int getMonth3() {
        return month3;
    }

    public void setMonth3(int month3) {
        this.month3 = month3;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

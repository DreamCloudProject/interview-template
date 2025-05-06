package com.mastermindcms.lessons.atm.beans;

import java.util.Map;

public class ATMResponse {

    private long amount;

    private Map<String,Long> banknotes;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Map<String, Long> getBanknotes() {
        return banknotes;
    }

    public void setBanknotes(Map<String, Long> banknotes) {
        this.banknotes = banknotes;
    }
}

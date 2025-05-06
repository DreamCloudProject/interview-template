package com.mastermindcms.lessons.atm;

import com.mastermindcms.lessons.atm.beans.ATMResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ATMImpl implements ATM {

    ReentrantLock lock = new ReentrantLock();

    private Map<String,Long> banknotes = new HashMap<>();

    @Override
    public ATMResponse withdraw(long amount) {
        ATMResponse response = new ATMResponse();
        lock.lock();
        try {
            List<String> noms = banknotes.keySet().stream().toList();
            /* request - 1000
            * 50 - 10
            * 100 - 10
            * ________
            * 1500
            * */
            for (String n : noms) {
                long needs = amount / Integer.parseInt(n);
                long remaining = banknotes.get(n) - needs;
                if(remaining >= 0) {
                    Map<String,Long> res = new HashMap<>();
                    res.put(n,needs);
                    response.setAmount(amount);
                    response.setBanknotes(res);
                    banknotes.put(n,remaining);
                    return response;
                }
            }
        } finally {
            lock.unlock();
        }
        return response;
    }

    @Override
    public void deposit(String nominal, long quantity) {
        lock.lock();
        try {
            banknotes.put(nominal, quantity);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getBalance() {
        return banknotes.entrySet().stream().mapToInt((e) -> {
            long nom = Long.parseLong(e.getKey());
            long quantity = e.getValue();
            return Math.toIntExact(nom * quantity);
        }).sum();
    }
}

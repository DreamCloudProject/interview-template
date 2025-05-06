package com.mastermindcms.lessons.atm;

import com.mastermindcms.lessons.atm.beans.ATMResponse;

public interface ATM {

    ATMResponse withdraw(long amount);

    void deposit(String nominal, long quantity);

    int getBalance();

}

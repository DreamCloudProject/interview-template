package com.mastermindcms.lessons.atm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestATM {

    @Test
    void testDeposit() throws InterruptedException {
        ATM atm = new ATMImpl();

        atm.deposit("50",10L);
        atm.deposit("100",10);
        atm.deposit("500",10);
        atm.deposit("1000",30);
        atm.deposit("5000",20);

        assertEquals(136500,atm.getBalance());
    }

    @Test
    void testWithdraw() throws InterruptedException {
        ATM atm = new ATMImpl();

        atm.deposit("50",10L);
        atm.deposit("100",10L);

        atm.withdraw(1000);

        assertEquals(500,atm.getBalance());
    }

}

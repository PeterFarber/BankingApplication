package com.peterfarber.main.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AccountTest {

    User testCustomer;
    User testCustomerJoin;
    Account testAccount;

    @Before
    public void setUp() throws Exception {

        testCustomer = new Customer("Test" ,"Customer", "Pass");
        testCustomerJoin = new Customer("Test" ,"Join", "Pass");
        testAccount = new Account(testCustomer);
        testAccount.save();

    }

    @After
    public void tearDown() throws Exception {

        //Delete Test Files
        testAccount.delete();
        testCustomer.delete();

    }

    @Test
    public void checkDeposit() {
        double currentBalance = testAccount.getBalance();

        //Deposit 100$
        testAccount.setBalance(currentBalance + 100);
        currentBalance = testAccount.getBalance();

        //Deposit 200$
        testAccount.setBalance(currentBalance + 200);
        currentBalance = testAccount.getBalance();

        assertTrue(currentBalance == 300);
    }

    @Test
    public void checkJoin() {

        //Add a user to an account!
        testAccount.join(testCustomerJoin);

        //Check if the user is in the account.
        assertTrue(testAccount.hasUser(testCustomerJoin));

    }


    @Test
    public void delete() {

        //Save
        testCustomer.save();

        //Delete
        testCustomer.delete();

        //Check if file exists!
        File tmpDir = new File("/data/users/"+ testCustomer.getId() + ".ser");
        assertTrue(!tmpDir.exists());


    }
}
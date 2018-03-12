package com.peterfarber.main.core;

import com.peterfarber.main.core.dao.AccountDao;
import com.peterfarber.main.core.dao.UserDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AccountTest {

    User testCustomer;
    User testCustomerJoin;
    Account testAccount;
    AccountDao accountDao;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        accountDao= new AccountDao();
        userDao = new UserDao();
        testCustomer = new Customer("Test" ,"Customer", "Pass");
        userDao.createPreparedStmt(testCustomer);
        testCustomerJoin = new Customer("Test" ,"Join", "Pass");
        userDao.createPreparedStmt(testCustomerJoin);

        testAccount = new Account(testCustomer.getUsername());
        testAccount.join(testCustomer);
        accountDao.createPreparedStmt(testAccount);

    }

    @After
    public void tearDown() throws Exception {

        //Delete Test Files
        accountDao.delete(testAccount.getAccountNumber());
        userDao.delete(testCustomer.getUsername());
        userDao.delete(testCustomerJoin.getUsername());

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


}
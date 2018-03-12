package com.peterfarber.main.core;

import com.peterfarber.main.core.dao.AccountDao;
import com.peterfarber.main.core.dao.UserDao;
import com.peterfarber.main.core.exceptions.BankException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterfaceTest {

    Interface testInterface;
    User customer, admin;
    Account a, b;
    AccountDao accountDao;
    UserDao userDao;


    @Before
    public void setUp() throws Exception {
        accountDao= new AccountDao();
        userDao = new UserDao();

        testInterface = new Interface();
        customer = new Customer("Customer", "Customer", "Password");
        admin = new Admin("Admin", "Admin", "Password");
        a = new Account(customer.getUsername());
        a.join(customer);
        b = new Account(customer.getUsername());
        a.join(customer);
    }


    @Test
    public void withdraw() throws BankException{
        testInterface.loggedUser = customer;
        a.setBalance(100);
        testInterface.selectedAccount = a;
        testInterface.withdraw("100");
        assertTrue(a.getBalance() == 0);
    }

    @Test
    public void deposit() throws BankException{
        testInterface.loggedUser = admin;
        a.setBalance(0);
        testInterface.selectedAccount = a;
        testInterface.deposit("100");
        assertTrue(a.getBalance() == 100);
    }


    @Test
    public void cancelAccount() {
        testInterface.loggedUser = customer;
        testInterface.selectedAccount = a;
        testInterface.cancelAccount();
        assertNull(testInterface.selectedAccount);
    }


}
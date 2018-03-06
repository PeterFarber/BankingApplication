package com.peterfarber.main.core;

import com.peterfarber.main.core.exceptions.BankException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InterfaceTest {

    Interface testInterface;
    User customer, admin;
    Account a, b;

    @Before
    public void setUp() throws Exception {
        testInterface = new Interface();
        customer = new Customer("Customer", "Customer", "Password");
        admin = new Admin("Admin", "Admin", "Password");
        a = new Account(customer);
        b = new Account(customer);
    }

    @After
    public void tearDown() throws Exception {
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
    public void transfer() throws BankException{
        testInterface.loggedUser = customer;
        a.setBalance(1000);
        b.setBalance(0);
        testInterface.selectedAccount = a;
        testInterface.accounts.add(b);
        testInterface.transfer(b.getAccountNumber().toString(), "1000");
        assertTrue(a.getBalance() == 0 && b.getBalance() == 1000);
    }

    @Test
    public void cancelAccount() {
        testInterface.loggedUser = customer;
        testInterface.selectedAccount = a;
        testInterface.cancelAccount();
        assertNull(testInterface.selectedAccount);
    }

    @Test
    public void selectAccount() throws BankException{
        testInterface.accounts.add(a);
        testInterface.loggedUser = admin;
        testInterface.selectAccount(a.getAccountNumber());
        assertTrue(testInterface.selectedAccount.equals(a));
    }

    @Test
    public void applyForAccount() throws BankException {
        testInterface.loggedUser = customer;
        testInterface.applyForAccount();
        assertNotNull(testInterface.findUserAccounts(testInterface.loggedUser));
    }

    @Test
    public void joinAccount() throws BankException{
        testInterface.loggedUser = customer;
        testInterface.selectedAccount = a;
        testInterface.accounts.add(b);
        testInterface.joinAccount(b.getAccountNumber());
        assertTrue(testInterface.selectedAccount.checkAccountForUser(customer));
    }

    @Test
    public void displayPendingAccounts() {
        testInterface.displayPendingAccounts();;
    }

    @Test
    public void approveDenyAccount() throws BankException {
        testInterface.loggedUser = customer;
        testInterface.applyForAccount();
        Account application = testInterface.accounts.getIndex(0);
        testInterface.approveDenyAccount(application.getAccountNumber(), true);
        assertTrue(application.getStatus().equals(Account.StatusEnum.ACTIVE));
    }

    @Test
    public void findUser() throws BankException {
        testInterface.users.add(customer);
        assertTrue(testInterface.findUser("Customer").equals(customer));
    }

    @Test
    public void findUserAccounts() throws BankException {
        testInterface.accounts.add(a);
        assertTrue(testInterface.findUserAccounts(customer).get(0).equals(a));
    }

    @Test
    public void findUserAccount() throws BankException{
        testInterface.accounts.add(a);
        assertTrue(testInterface.findUserAccount("Customer").equals(a));
    }

    @Test
    public void findAccount() throws BankException {
        testInterface.accounts.add(a);
        assertTrue(testInterface.findAccount(a.getAccountNumber()).equals(a));
    }
}
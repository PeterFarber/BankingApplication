package com.peterfarber.test.core;

import com.peterfarber.main.core.Account;
import com.peterfarber.main.core.Customer;
import com.peterfarber.main.core.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AccountTest {
    User user;
    Account account;
    @Before
    public void setUp() throws Exception {
        user = new Customer("Test", "Poop", "Poop");
        account = new Account(user);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        account.save();
        File file = new File("data/accounts/"+account.getId()+".ser");
        assertNotNull(file);
    }
}
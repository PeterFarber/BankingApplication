package com.peterfarber.main.core;

import java.util.ArrayList;

public class Customer extends User{

    private static final long serialVersionUID = 5699369031407555202L;

    private ArrayList<Account> accounts = new ArrayList<Account>();

    public Customer(String name, String username, String password){
        super(name, username, password);
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

}

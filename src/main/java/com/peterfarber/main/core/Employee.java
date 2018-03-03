package com.peterfarber.main.core;

import java.util.ArrayList;

public class Employee extends User {

    private static final long serialVersionUID = 293290241265238390L;

    ArrayList<Account> accounts;

    public Employee(String name, String username, String password){
        super(name, username, password);
        accounts = new ArrayList<Account>();
    }

}

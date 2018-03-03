package com.peterfarber.main.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;

public class Account implements java.io.Serializable {

    public enum StatusEnum{ PENDING, DENINED, ACTIVE }

    private static final long serialVersionUID = 1766824171086983034L;

    private StatusEnum status;

    private final String id;
    private User accountOwner;
    private final String accountNumber;

    private ArrayList<User> allowedUser;
    private ArrayList<User> pendingUsers;

    private double balance;

    public Account(User user){
        accountOwner = user;
        allowedUser = new ArrayList<User>();
        allowedUser.add(user);
        pendingUsers = new ArrayList<User>();
        this.balance = 0;
        this.status = StatusEnum.PENDING;
        this.id = UUID.randomUUID().toString();
        this.accountNumber = String.valueOf((long)(Math.random() * 999999999));
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getId() {
        return id;
    }

    public void join(User user){
        pendingUsers.add(user);
    }

    public void save(){
        try {
            FileOutputStream fileOut = new FileOutputStream("data/accounts/"+id+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

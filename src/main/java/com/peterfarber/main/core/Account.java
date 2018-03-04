package com.peterfarber.main.core;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class Account implements java.io.Serializable {

    public enum StatusEnum{ PENDING, DENINED, ACTIVE }

    private static final long serialVersionUID = 1766824171086983034L;

    private StatusEnum status;

    private final String id;
    private User accountOwner;
    private double balance;
    private String accountNumber;

    private ArrayList<User> allowedUser;
    private ArrayList<User> pendingUsers;

    public Account(User user){
        accountOwner = user;
        allowedUser = new ArrayList<User>();
        allowedUser.add(user);
        pendingUsers = new ArrayList<User>();
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

    public boolean checkAccountForUser(User user){
        if(accountOwner.getUsername().equals(user.getUsername())){
            return true;
        }
        if(allowedUser.indexOf(user) != -1){
            return true;
        }
        return false;
    }

    public void setAccountNumber(String number){
        this.accountNumber = number;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
        this.save();
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

        try {
            FileInputStream fileIn = new FileInputStream("data/accounts/"+id+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Account a = (Account)in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}

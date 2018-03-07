package com.peterfarber.main.core;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public class Account {

    public enum StatusEnum{ PENDING, DENIED, ACTIVE }

    private StatusEnum status;

    private final String id;
    private User accountOwner;
    private double balance;
    private String accountNumber;

    private ArrayList<User> allowedUsers;
    private ArrayList<User> pendingUsers;

    public Account(User user){
        accountOwner = user;
        allowedUsers = new ArrayList<User>();
        allowedUsers.add(user);
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
        if(allowedUsers.indexOf(user) != -1){
            return true;
        }
        return false;
    }

    public void setAccountNumber(String number){
        this.accountNumber = number;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
        this.save();
    }

    public void join(User user){
        allowedUsers.add(user);
    }

    public boolean hasUser(User user){
        for(int i = 0; i < allowedUsers.size(); i++){
            if(allowedUsers.get(i).equals(user)){
                return true;
            }
        }
        return false;
    }

    public void save(){

    }

    public void print(){
        System.out.println("********Account Info*********:");
        System.out.println("Id: " +  this.id);
        System.out.println("Account Owner: " +  this.accountOwner.getUsername());
        System.out.println("Account Number: " +  this.accountNumber);
        System.out.println("Balance: " +  this.balance);
        System.out.println("Approved Users: ");
        for(int i = 0; i < allowedUsers.size(); i++){
            System.out.println((i+1)+".) " + allowedUsers.get(i).getUsername());
        }

        System.out.println("Pending Users: ");
        for(int i = 0; i < pendingUsers.size(); i++){
            System.out.println((i+1)+".) " + pendingUsers.get(i).getUsername());
        }

    }

    public void delete(){

    }

}

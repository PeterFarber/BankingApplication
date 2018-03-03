package com.peterfarber.main.core.exceptions;

public class BankException extends Exception{

    public BankException(){
        super("A Bank Exception Has Been Thrown!");
    }

    public BankException(String message){
        super(message);
    }

}

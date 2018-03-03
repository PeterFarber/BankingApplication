package com.peterfarber.main.core.exceptions;


public class UserNotFound extends BankException{

    public UserNotFound(){
        super("User Was Not In Banks Database!");
    }

    public UserNotFound(String message){
        super(message);
    }

}

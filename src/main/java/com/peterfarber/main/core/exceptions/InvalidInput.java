package com.peterfarber.main.core.exceptions;

public class InvalidInput extends BankException{

    public InvalidInput(){
        super("Invalid Input.");
    }

    public InvalidInput(String message){
        super(message);
    }

    public InvalidInput(byte value, byte min, byte max){
        super("Invalid Input (Not In Range): Value: " + value + " Min: " + min + " Max: " + max + ".");
    }

}

package com.peterfarber.main.core.exceptions;

import java.io.File;

public class EmptyDirectory extends BankException{

    public EmptyDirectory(){
        super("No Files In Directory!");
    }

    public EmptyDirectory(String message){
        super(message);
    }

    public EmptyDirectory(File directory){
        super("No Files In Directory: " + directory.toString());
    }

}

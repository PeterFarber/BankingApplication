package com.peterfarber.main.core;


import com.peterfarber.LoggingUtil;

public class Main {

    public static void main(String[] args) throws Exception{

        LoggingUtil.logFatal("Fatal!");

//        User customer = new Customer("Peter Farber", "Wizkid", "12345");
//        customer.save();
//        User employee = new Employee("Peter Farber", "Wizkid_EMP", "12345");
//        employee.save();
//        Account account = new Account();
//        account.save();

        //Create an Instance of Interface class.
        Interface theInterface = new Interface();

        //Close Application!
        System.exit(1);

    }

}

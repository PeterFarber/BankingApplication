package com.peterfarber.main.core;


import com.peterfarber.LoggingUtil;

public class Main {

    public static void main(String[] args) throws Exception{


//        User customer = new Customer("Peter Farber", "Wizkid", "12345");
//        customer.save();
//        User employee = new Employee("Employee", "Employee", "pass");
//        employee.save();
//        User admin = new Admin("Admin", "Admin", "pass");
//        admin.save();
//        Account account = new Account(customer);
//        account.save();

//        DBConnection dbcInstance = DBConnection.getInstance();
//
//        dbcInstance.openConnection();
//
//        User customer = new Customer("PeterFarber", "Wizkid", "12345");
//        customer.save();
//
//        Account account = new Account(customer.getUsername());
//        account.join(customer);
//        account.save();

//        DBLoader dbLoader = new DBLoader();
//        dbLoader.loadData("Wizkid", "12345");

        //Create an Instance of Interface class.
        Interface theInterface = new Interface();
        theInterface.run();

//        dbcInstance.closeConnection();

//        //Close Application!
//        System.exit(1);


    }

}

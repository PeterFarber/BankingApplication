package com.peterfarber.main.core.gui;

import com.peterfarber.main.core.exceptions.BankException;
import com.peterfarber.main.core.exceptions.InvalidInput;

import java.util.Scanner;
import java.util.Vector;

public class Menu {

    public enum MenuEnum{ MAIN, CREATE_USER, ACCOUNT, LOGIN, ADMIN, CUSTOMER, EMPLOYEE }

    private MenuEnum currentMenu;

    Scanner input;

    public Menu(){

        this.currentMenu = MenuEnum.MAIN;
         this.input = new Scanner(System.in);

    }

    public Vector<String> displayMenu() throws BankException{
        Vector<String> result = null;
        switch(this.currentMenu){
            case MAIN:
                result = displayMainMenu();
                break;
            case CREATE_USER:
                result = displayUserCreateMenu();
                break;
            case ACCOUNT:
                result = displayAccountMenu();
                break;
            case LOGIN:
                result = displayLoginMenu();
                break;
            case ADMIN:
                result = displayAdminMenu();
                break;
            case CUSTOMER:
                result = displayCustomerMenu();
                break;
            case EMPLOYEE:
                result = displayEmployeeMenu();
                break;

        }
        return result;
    }

    public MenuEnum getMenu(){
        return this.currentMenu;
    }

    public void setMenu(MenuEnum menu){
        this.currentMenu = menu;
    }

    private Vector<String> displayMainMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 0, max = 2;
        System.out.println("Main Menu: ");
        System.out.println("1.) Login");
        System.out.println("2.) Create Account");
        System.out.print("Enter: ");

        String inputString = input.nextLine();

        menuOptionValidation(min, max, inputString);

        result.add(inputString);
        return result;
    }

    private Vector<String> displayAdminMenu() throws BankException{
        Vector<String> result = new Vector<String>();

        System.out.println("Admin Menu: ");
        System.out.print("Enter Account Number: ");
        String inputString = input.nextLine();


        result.add(inputString);
        return result;
    }

    private Vector<String> displayAccountMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 1, max = 4;
        System.out.println("Account:");
        System.out.println("1.) Withdraw");
        System.out.println("2.) Deposit");
        System.out.println("3.) Transfer Funds");
        System.out.println("4.) Check Balance");
        result.add(input.nextLine());

        menuOptionValidation(min, max, result.get(0));

        return result;
    }


    private Vector<String> displayUserCreateMenu() throws BankException{
        Vector<String> result = new Vector<String>();

        System.out.println("User Creation: ");
        System.out.print("Name: ");
        result.add(input.nextLine());
        System.out.print("Username: ");
        result.add(input.nextLine());
        System.out.print("Password: ");
        result.add(input.nextLine());

        return result;
    }

    private Vector<String> displayEmployeeMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 1, max = 2;

        System.out.println("Employee Menu: ");
        System.out.println("1.) Customer Applications");
        System.out.println("2.) Select Account");

        String inputString = input.nextLine();

        menuOptionValidation(min, max, inputString);

        result.add(inputString);

        return result;
    }

    private Vector<String> displayCustomerMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 0, max = 2;
        System.out.println("Customer Menu: ");
        System.out.println("1.) Select Account");
        System.out.println("2.) Apply For Account");
        System.out.println("3.) Join Account");
        System.out.print("Enter: ");

        String inputString = input.nextLine();

        menuOptionValidation(min, max, inputString);

        result.add(inputString);
        return result;
    }

    private Vector<String> displayLoginMenu() throws BankException{
        Vector<String> result = new Vector<String>();

        System.out.println("Login Menu: ");
        System.out.print("Enter Username: ");
        result.add(input.nextLine());
        System.out.print("Enter Password: ");
        result.add(input.nextLine());

        return result;
    }

    private void menuOptionValidation(byte min, byte max, String input) throws BankException{
        if(input.length() == 0){
            throw new InvalidInput("No Input!");
        }
        byte inputValue = Integer.valueOf(input).byteValue();
        //Make sure the input only contains one character.
        if(input.length() != 1){
            throw new InvalidInput("Invalid Input To Long!");
        }
        //Check to see if that character is a digit!
        if(!Character.isDigit(input.charAt(0))){
            throw new InvalidInput("Invalid Input Not Digit!");
        }
        //Make sure it is within the allowed options.
        if(!(inputValue >= min && inputValue <= max)){
            throw new InvalidInput(inputValue, min, max);
        }
    }


}

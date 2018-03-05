package com.peterfarber.main.core.gui;

import com.peterfarber.main.core.Validator;
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

        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString) || !Validator.withinMinMax(min, max, inputString)){
            throw new InvalidInput();
        }


        result.add(inputString);
        return result;
    }

    private Vector<String> displayAdminMenu() throws BankException{
        Vector<String> result = new Vector<String>();

        byte min = 1, max = 4;

        System.out.println("Admin Menu: ");
        System.out.println("1.) View Account");
        System.out.println("2.) Select Account");
        System.out.println("3.) Approve/Deny Applications");
        System.out.println("4.) Back");
        System.out.print("Enter: ");

        String inputString = input.nextLine();

        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString) || !Validator.withinMinMax(min, max, inputString)){
            throw new InvalidInput();
        }

        result.add(inputString);
        return result;
    }

    private Vector<String> displayAccountMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 1, max = 6;
        System.out.println("Account:");
        System.out.println("1.) Withdraw");
        System.out.println("2.) Deposit");
        System.out.println("3.) Transfer Funds");
        System.out.println("4.) Check Balance");
        System.out.println("5.) Cancel Account");
        System.out.println("6.) Back");
        System.out.print("Enter: ");

        result.add(input.nextLine());

        if(!Validator.noCharacter(result.get(0)) || !Validator.notNull(result.get(0)) || !Validator.withinMinMax(min, max, result.get(0))){
            throw new InvalidInput();
        }

        return result;
    }


    private Vector<String> displayUserCreateMenu() throws BankException{
        Vector<String> result = new Vector<String>();

        System.out.println("User Creation: ");
        System.out.print("Name: ");
        result.add(input.nextLine());
        if(!Validator.notNull(result.get(0))){
            throw new InvalidInput();
        }
        System.out.print("Username: ");
        result.add(input.nextLine());
        if( !Validator.notNull(result.get(1))){
            throw new InvalidInput();
        }
        System.out.print("Password: ");
        result.add(input.nextLine());
        if( !Validator.notNull(result.get(2))){
            throw new InvalidInput();
        }

        return result;
    }

    private Vector<String> displayEmployeeMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 1, max = 3;

        System.out.println("Employee Menu: ");
        System.out.println("1.) View Account");
        System.out.println("2.) Approve/Deny Applications");
        System.out.println("3.) Back");
        System.out.print("Enter: ");


        String inputString = input.nextLine();
        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString) || !Validator.withinMinMax(min, max, inputString)){
            throw new InvalidInput();
        }

        result.add(inputString);

        return result;
    }

    private Vector<String> displayCustomerMenu() throws BankException{
        Vector<String> result = new Vector<String>();
        byte min = 0, max = 4;
        System.out.println("Customer Menu: ");
        System.out.println("1.) Select Account");
        System.out.println("2.) Apply For Account");
        System.out.println("3.) Join Account");
        System.out.println("4.) Back");
        System.out.print("Enter: ");

        String inputString = input.nextLine();

        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString) || !Validator.withinMinMax(min, max, inputString)){
            throw new InvalidInput();
        }

        result.add(inputString);
        return result;
    }

    private Vector<String> displayLoginMenu() throws BankException{
        Vector<String> result = new Vector<String>();

        System.out.println("Login Menu: ");
        System.out.print("Enter Username: ");
        result.add(input.nextLine());
        if(!Validator.notNull(result.get(0))){
            throw new InvalidInput();
        }
        System.out.print("Enter Password: ");
        result.add(input.nextLine());
        if(!Validator.notNull(result.get(1))){
            throw new InvalidInput();
        }

        return result;
    }


}

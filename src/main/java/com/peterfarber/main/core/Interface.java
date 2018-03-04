package com.peterfarber.main.core;

import com.peterfarber.main.core.exceptions.BankException;
import com.peterfarber.main.core.exceptions.InvalidInput;
import com.peterfarber.main.core.exceptions.UserNotFound;
import com.peterfarber.main.core.gui.Menu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;


/**
 * <h1>The Applications Interface!</h1>
 * This class is a mediator between the user and
 * the application.
 * <p>
 * @author  Peter Farber
 * @version 1.0
 * @since   2018-03-1
 */
public class Interface {

    Scanner scanner;

    private boolean running;

    private Menu menu;

    private User loggedUser;
    private Account selectedAccount;

    private DirectoryLoader<User> users;
    private DirectoryLoader<Account> accounts;

    /**
     * Interface Constructor sets up the interface
     * and calls some methods for initialization.
     */
    public Interface(){
        //Initialize all variables to null! cuz ya know why not!
        this.running = true;
        this.menu = new Menu();
        this.loggedUser = null;
        this.selectedAccount = null;
        this.users = new DirectoryLoader("data/users");
        this.accounts = new DirectoryLoader("data/accounts");

        this.scanner = new Scanner(System.in);

        try {
            //Load Information from directories/database (Users and Accounts)
            this.users.load();
            this.accounts.load();

            Vector<String> value = null;

            //Run the application!
            while(running) {

                try {
                    System.out.println();
                    value = this.menu.displayMenu();
                    if(value.get(0).equals("0")){
                        System.exit(-1);
                    }
                }
                catch (BankException e){
                    System.out.println("\n*******Exception*******");
                    System.out.println(e.getMessage() + "\n");
                }
                switch(this.menu.getMenu()){
                    case MAIN:
                            mainOperations(value);
                        break;
                    case LOGIN:
                        try {
                            loginOperations(value);
                        }catch(BankException e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
                        break;
                    case CUSTOMER:
                            customerOperations(value);
                        break;
                    case EMPLOYEE:
                            employeeOperations(value);
                        break;
                    case CREATE_USER:
                        try {
                            createUserOperations(value);
                        }catch(BankException e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
                        break;
                    case ACCOUNT:
                            accountOperations(value);
                        break;
                    case ADMIN:
                            adminOperations(value);
                        break;
                }
            }
        }
        catch(BankException e){
            System.out.println("\n*******Exception*******");
            System.out.println(e.getMessage() + "\n");
        }
    }

    private void mainOperations(Vector<String> value){
        if(value != null) {
            switch (value.get(0)) {
                case "1":
                    this.menu.setMenu(Menu.MenuEnum.LOGIN);
                    break;
                case "2":
                    this.menu.setMenu(Menu.MenuEnum.CREATE_USER);
                    break;
            }
        }
    }

    private void customerOperations(Vector<String> value) throws BankException{
        if(value != null) {
            switch (value.get(0)) {
                case "1":
                    //Select Account
                    ArrayList<Account> accounts = findUserAccounts(loggedUser);
                    if(accounts.size() > 0){
                        System.out.println("\nSelect Account: ");
                        for(int i = 0; i < accounts.size(); i++){
                            System.out.println((i+1)+".) "+accounts.get(i).getAccountNumber());
                        }
                        System.out.print("Enter: ");
                        String inputString = scanner.nextLine();
                        Integer inputValue = Integer.parseInt(inputString);
                        if(inputValue > 0 && inputValue <= accounts.size()){
                            selectedAccount = accounts.get(inputValue-1);
                            menu.setMenu(Menu.MenuEnum.ACCOUNT);
                        }else{
                            throw new InvalidInput();
                        }
                    }else{
                        System.out.println("\n***********\nYou do not have any accounts!\n***********\n");
                    }
                    break;
                case "2":
                    //Apply for account
                    //Make sure user doesn't already own an account.
                    if(findUserAccount(this.loggedUser.getUsername()) == null){
                        Account account = new Account(loggedUser);
                        account.save();
                        this.accounts.add(account);
                        System.out.println("\n***********\nAccount Created! (Pending Approval)\n***********\n");
                    }else{
                        System.out.println("\n***********\nYou already own an Account!\n***********\n");
                    }
                    break;
                case "3":
                    //Join Account
                    System.out.print("Enter Account Number:");
                    String inputString = scanner.nextLine();
                    Account account = findAccount(inputString);
                    if(account != null){
                        account.join(loggedUser);
                        account.save();
                        System.out.println("\n***********\nAccount Joined! (Pending Approval)\n***********\n");
                    }
                    else{
                        System.out.println("\n***********\nAccount Doesn't Exist!\n***********\n");
                    }
                    break;
            }
        }
    }

    private void employeeOperations(Vector<String> value){
        if(value != null) {
            switch(value.get(0)){
                case "1":
                    break;
                case "2":
                    break;
            }

        }
    }

    private void accountOperations(Vector<String> value) throws BankException{
        String inputString = "";
        double balance = 0;
        if(value != null) {
            switch(value.get(0)){
                case "1":
                    System.out.print("\nEnter Amount: ");
                    inputString = scanner.nextLine();
                    balance = Double.parseDouble(inputString);
                    if(selectedAccount.getBalance() >= balance) {
                        selectedAccount.setBalance(selectedAccount.getBalance()-balance);
                    }else{
                        throw new BankException("Not Enough Money In Account To Withdraw!");
                    }
                    break;
                case "2":
                    System.out.print("\nEnter Amount: ");
                    inputString = scanner.nextLine();
                    balance = Double.parseDouble(inputString);
                    selectedAccount.setBalance(selectedAccount.getBalance()+balance);
                    break;
                case "3":
                    System.out.print("Enter Account Number:");
                    inputString = scanner.nextLine();
                    Account account = findAccount(inputString);
                    if(account != null) {
                        System.out.print("\nEnter Amount:");
                        inputString = scanner.nextLine();
                        balance = Double.parseDouble(inputString);
                        if(account.getBalance() >= balance){
                            selectedAccount.setBalance(selectedAccount.getBalance()-balance);
                            selectedAccount.save();
                            account.setBalance(account.getBalance()+balance);
                            account.save();
                        }else{
                            throw new BankException("Not Enough Money In Account To Transfer!");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Balance: $" + selectedAccount.getBalance());
                    System.out.println("Number: " + selectedAccount.getAccountNumber());
                    System.out.println("Owner: " + selectedAccount.getAccountOwner().getName());

                    break;
            }
        }

    }

    private void adminOperations(Vector<String> value){
        if(value != null) {

        }

    }

    private void createUserOperations(Vector<String> value) throws BankException{
        if(value != null) {
            User person = findUser(value.get(1));
            if (person == null) {
                User user = new Customer(value.get(0),value.get(1), value.get(2));
                user.save();
                this.users.add(user);
                loggedUser = user;
                menu.setMenu(Menu.MenuEnum.CUSTOMER);
            } else {
                menu.setMenu(Menu.MenuEnum.MAIN);
                throw new BankException("User already exists!");
            }
        }
    }

    private void loginOperations(Vector<String> value) throws BankException{
        if(value != null) {
            User person = findUser(value.get(0));
            if (person != null) {
                if (person.getPassword().equals(value.get(1))) {
                    this.loggedUser = person;
                    if (person instanceof Customer) {
                        menu.setMenu(Menu.MenuEnum.CUSTOMER);
                    } else if (person instanceof Employee) {
                        menu.setMenu(Menu.MenuEnum.EMPLOYEE);
                    } else if(person instanceof Admin){
                        menu.setMenu(Menu.MenuEnum.ADMIN);
                    }
                } else {
                    menu.setMenu(Menu.MenuEnum.MAIN);
                    throw new InvalidInput("Invalid Password.");
                }
            } else {
                menu.setMenu(Menu.MenuEnum.MAIN);
                throw new UserNotFound();
            }
        }
    }

    /**
     * Searches through the array of Users and returns a User.
     * @param username Username to find.
     * @return User if found.
     * @exception BankException On input error.
     */
    private User findUser(String username) throws BankException {
        for(int i = 0; i < this.users.getSize(); i++){
            User v = this.users.getIndex(i);
            if(username.equals(v.getUsername())){
                return v;
            }
        }
        return null;
    }

    /**
     * Searches through the array of Users and returns a User.
     * @param user Username to find.
     * @return User if found.
     * @exception BankException On input error.
     */
    private ArrayList<Account> findUserAccounts(User user) throws BankException {
        ArrayList<Account> accountReturn = new ArrayList<Account>();
        for(int i = 0; i < this.accounts.getSize(); i++){
            if(this.accounts.getIndex(i).checkAccountForUser(user)){
                accountReturn.add(this.accounts.getIndex(i));
            }
        }
        return accountReturn;
    }

    /**
     * Searches through the array of Users and returns a User.
     * @param username Username to find.
     * @return User if found.
     * @exception BankException On input error.
     */
    private Account findUserAccount(String username) throws BankException {
        for(int i = 0; i < this.accounts.getSize(); i++){
            Account v = this.accounts.getIndex(i);
            if(username.equals(v.getAccountOwner().getUsername())){
                return v;
            }
        }
        return null;
    }

    private Account findAccount(String accountNumber) throws BankException {
        for(int i = 0; i < this.accounts.getSize(); i++){
            Account v = this.accounts.getIndex(i);
            if(v.getAccountNumber().equals(accountNumber)){
                return v;
            }
        }
        return null;
    }

}

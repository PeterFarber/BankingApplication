package com.peterfarber.main.core;

import com.peterfarber.LoggingUtil;
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
                        try {
                            mainOperations(value);
                        }catch(Exception e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
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
                        try{
                            customerOperations(value);
                        }catch(BankException e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
                        break;
                    case EMPLOYEE:
                        try{
                            employeeOperations(value);
                        }catch(BankException e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
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
                        try {
                            accountOperations(value);
                        }catch(BankException e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
                        break;
                    case ADMIN:
                        try{
                            adminOperations(value);
                        }catch(BankException e){
                            System.out.println("\n*******Exception*******");
                            System.out.println(e.getMessage() + "\n");
                        }
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
                        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                            throw new InvalidInput();
                        }
                        Integer inputValue = Integer.parseInt(inputString);
                        if(inputValue > 0 && inputValue <= accounts.size()){
                            Account.StatusEnum status = accounts.get(inputValue-1).getStatus();
                            if(status.equals(Account.StatusEnum.ACTIVE)){
                                selectedAccount = accounts.get(inputValue-1);
                                LoggingUtil.logInfo(loggedUser.getUsername() + ": is accessing " + selectedAccount.getAccountNumber() + ".");
                                menu.setMenu(Menu.MenuEnum.ACCOUNT);
                            }else if (status.equals(Account.StatusEnum.DENIED)){
                                System.out.println("Account was Denied!");
                                menu.setMenu(Menu.MenuEnum.CUSTOMER);
                            }else{
                                System.out.println("Account is Pending Approval!");
                                menu.setMenu(Menu.MenuEnum.CUSTOMER);
                            }
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
                        LoggingUtil.logInfo(loggedUser.getUsername() + ": applied for an account " + account.getAccountNumber() + ".");
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
                        LoggingUtil.logInfo(loggedUser.getUsername() + ": applied to join an account " + account.getAccountNumber() + ".");
                        System.out.println("\n***********\nAccount Joined! (Pending Approval)\n***********\n");
                    }
                    else{
                        System.out.println("\n***********\nAccount Doesn't Exist!\n***********\n");
                    }
                    break;
                case "4":
                    menu.setMenu(Menu.MenuEnum.MAIN);
                    break;
            }
        }
    }

    private void employeeOperations(Vector<String> value) throws BankException{
        String inputString = null;
        Account account = null;
        if(value != null) {
            switch(value.get(0)){
                case "1":
                    System.out.print("Account Number: ");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    account = findAccount(inputString);
                    if(account != null){
                        account.print();
                        LoggingUtil.logInfo(loggedUser.getUsername() + ": printed account " + account.getAccountNumber() + ".");
                    }else{
                        throw new BankException("Account Doesn't Exist!");
                    }
                    break;
                case "2":
                    for(int i = 0; i < accounts.getSize(); i++){
                        if(accounts.getIndex(i).getStatus() == Account.StatusEnum.PENDING){
                            System.out.println((i+1)+".) "+accounts.getIndex(i).getAccountNumber());
                        }
                    }
                    System.out.print("Enter: ");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    Integer inputValue = Integer.parseInt(inputString);
                    if(inputValue > 0 && inputValue <= accounts.getSize()){
                        account = accounts.getIndex(inputValue -1);
                        System.out.println("1.) Approve");
                        System.out.println("2.) Deny");
                        System.out.print("Enter:");
                        inputString = scanner.nextLine();
                        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString) || !Validator.withinMinMax(1, 2, inputString)){
                            throw new InvalidInput();
                        }
                        if(inputString.equals("1")){
                            LoggingUtil.logInfo(loggedUser.getUsername() + ": approved account " + account.getAccountNumber() + ".");
                            account.setStatus(Account.StatusEnum.ACTIVE);
                        }else if(inputString.equals("2")){
                            LoggingUtil.logInfo(loggedUser.getUsername() + ": denied account " + account.getAccountNumber() + ".");
                            account.setStatus(Account.StatusEnum.DENIED);
                        }
                    }else{
                        throw new InvalidInput();
                    }
                    break;
                case "3":
                    menu.setMenu(Menu.MenuEnum.MAIN);
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
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    balance = Double.parseDouble(inputString);
                    if(selectedAccount.getBalance() >= balance) {
                        selectedAccount.setBalance(selectedAccount.getBalance()-balance);
                        LoggingUtil.logInfo(loggedUser.getUsername() + ": Withdrew " + balance + " from " + selectedAccount.getAccountNumber() + " account!");
                    }else{
                        throw new BankException("Not Enough Money In Account To Withdraw!");
                    }
                    break;
                case "2":
                    System.out.print("\nEnter Amount: ");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    balance = Double.parseDouble(inputString);
                    selectedAccount.setBalance(selectedAccount.getBalance()+balance);
                    LoggingUtil.logInfo(loggedUser.getUsername() + ": Deposited " + balance + " from " + selectedAccount.getAccountNumber() + " account!");
                    break;
                case "3":
                    System.out.print("Enter Account Number:");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    Account account = findAccount(inputString);
                    if(account != null) {
                        System.out.print("\nEnter Amount:");
                        inputString = scanner.nextLine();
                        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                            throw new InvalidInput();
                        }
                        balance = Double.parseDouble(inputString);
                        if(account.getBalance() >= balance){
                            selectedAccount.setBalance(selectedAccount.getBalance()-balance);
                            selectedAccount.save();
                            account.setBalance(account.getBalance()+balance);
                            account.save();
                            LoggingUtil.logInfo(loggedUser.getUsername() + ": Transferred " + balance + " from " + selectedAccount.getAccountNumber() + " to " + account.getAccountNumber() + ".");
                        }else{
                            throw new BankException("Not Enough Money In Account To Transfer!");
                        }
                    }
                    break;
                case "4":
                    System.out.println("Balance: $" + selectedAccount.getBalance());
                    break;
                case "5":
                    LoggingUtil.logInfo(loggedUser.getUsername() + ": Deleted " + selectedAccount.getAccountNumber() + ".");
                    accounts.remove(selectedAccount);
                    selectedAccount.delete();
                    selectedAccount = null;
                    if(loggedUser instanceof Admin){
                        menu.setMenu(Menu.MenuEnum.ADMIN);
                    }else{
                        menu.setMenu(Menu.MenuEnum.CUSTOMER);
                    }
                    break;
                case "6":
                    if(loggedUser instanceof Admin){
                        menu.setMenu(Menu.MenuEnum.ADMIN);
                    }else{
                        menu.setMenu(Menu.MenuEnum.CUSTOMER);
                    }
                    break;
            }
        }

    }

    private void adminOperations(Vector<String> value) throws BankException{
        String inputString = null;
        Account account = null;
        if(value != null) {
            switch(value.get(0)){
                case "1":
                    System.out.print("Account Number: ");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    account = findAccount(inputString);
                    if(account != null){
                        account.print();
                        LoggingUtil.logInfo(loggedUser.getUsername() + ": printed account " + account.getAccountNumber() + ".");
                    }else{
                        throw new BankException("Account Doesn't Exist!");
                    }
                    break;
                case "2":
                    System.out.print("Account Number: ");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    account = findAccount(inputString);
                    if(account != null){
                        LoggingUtil.logInfo(loggedUser.getUsername() + ": accessing account " + account.getAccountNumber() + ".");
                        selectedAccount = account;
                        menu.setMenu(Menu.MenuEnum.ACCOUNT);
                    }else{
                        throw new BankException("Account Doesn't Exist!");
                    }
                    break;
                case "3":
                    for(int i = 0; i < accounts.getSize(); i++){
                        if(accounts.getIndex(i).getStatus() == Account.StatusEnum.PENDING){
                            System.out.println((i+1)+".) "+accounts.getIndex(i).getAccountNumber());
                        }
                    }
                    System.out.print("Enter: ");
                    inputString = scanner.nextLine();
                    if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString)){
                        throw new InvalidInput();
                    }
                    Integer inputValue = Integer.parseInt(inputString);
                    if(inputValue > 0 && inputValue <= accounts.getSize()){
                        account = accounts.getIndex(inputValue -1);
                        System.out.println("1.) Approve");
                        System.out.println("2.) Deny");
                        System.out.print("Enter:");
                        inputString = scanner.nextLine();
                        if(!Validator.noCharacter(inputString) || !Validator.notNull(inputString) || !Validator.withinMinMax(1, 2, inputString)){
                            throw new InvalidInput();
                        }
                        if(inputString.equals("1")){
                            LoggingUtil.logInfo(loggedUser.getUsername() + ": approved account " + account.getAccountNumber() + ".");
                            account.setStatus(Account.StatusEnum.ACTIVE);
                        }else if(inputString.equals("2")){
                            LoggingUtil.logInfo(loggedUser.getUsername() + ": denied account " + account.getAccountNumber() + ".");
                            account.setStatus(Account.StatusEnum.DENIED);
                        }
                    }else{
                        throw new InvalidInput();
                    }
                    break;
                case "6":
                        menu.setMenu(Menu.MenuEnum.MAIN);
                    break;
            }

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
                LoggingUtil.logInfo(user.getUsername() + ": User Created!");
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
                    LoggingUtil.logInfo(person.getUsername() + ": Logged In!");
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

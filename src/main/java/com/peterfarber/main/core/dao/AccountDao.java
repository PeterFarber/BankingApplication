package com.peterfarber.main.core.dao;

import com.peterfarber.main.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements Dao<Account> {

    public void create(Account object){
        Connection conn = ConnectionFactory.getInstance().getConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO ACCOUNTS VALUES ('"+ object.getAccountNumber() +"','"+ getStatusInt(object) +"','"+object.getAccountOwner()+"','"+object.getBalance()+"')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account retrieveByString(String id){
        Account object = null;
        String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTS_NUMBER = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                object = getAccount(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public List<Account> retrievePending(){
        List<Account> accounts = new ArrayList<Account>();
        String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTS_STATUS_ID = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, 1);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts.add(getAccount(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Account> retrieveByUsername(String username){
        List<Account> accounts = new ArrayList<Account>();
        String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNTS_NUMBER IN (SELECT ACCOUNTS_ID FROM ACCOUNTS_USERS WHERE USERS_ID = ?)";
        try{

            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts.add(getAccount(rs));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return accounts;
    }

    public List<Account> retrieveAll(){
        List<Account> accounts = new ArrayList<Account>();

        String sql = "SELECT * FROM ACCOUNTS";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts.add(getAccount(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public void update(Account object){

        String sql = "UPDATE ACCOUNTS SET ACCOUNTS_BALANCE = ?, ACCOUNTS_STATUS_ID = ? WHERE ACCOUNTS_NUMBER = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setDouble(1, object.getBalance());
            ps.setInt(2, getStatusInt(object));
            ps.setString(3, object.getAccountNumber());
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void transferFunds(Account object, Account object_b, double ammount){

        try {
            CallableStatement cs = ConnectionFactory.getInstance().getConnection().prepareCall("{call transferFunds(?,?,?)}");
            cs.setString(1, object.getAccountNumber());
            cs.setString(2, object_b.getAccountNumber());
            cs.setDouble(3, ammount);
            int rs = cs.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id){
        String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNTS_NUMBER = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);
            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPreparedStmt(Account object){
        String sql = "INSERT INTO ACCOUNTS VALUES (?, ?, ?, ?)";

        try{
            Connection conn = ConnectionFactory.getInstance().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getAccountNumber());
            stmt.setInt(2, getStatusInt(object));
            stmt.setString(3, object.getAccountOwner());
            stmt.setDouble(4, object.getBalance());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "INSERT INTO ACCOUNTS_USERS VALUES (?, ?)";
        ArrayList<User> users = object.getAllUsers();
        for(int i = 0; i < users.size(); i++){
            try {
                Connection conn = ConnectionFactory.getInstance().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, users.get(i).getUsername());
                stmt.setString(2, object.getAccountNumber());
                stmt.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private int getStatusInt(Account object){
        int status = 0;
        switch(object.getStatus()){
            case PENDING:
                status = 1;
                break;
            case ACTIVE:
                status = 2;
                break;
            case DENIED:
                status = 3;
                break;
        }
        return status;
    }

    private Account getAccount(ResultSet rs){
        Account account = null;
        try {
            String number = rs.getString(1);
            Account.StatusEnum status = null;
            switch (rs.getInt(2)) {
                case 1:
                    status = Account.StatusEnum.PENDING;
                    break;
                case 2:
                    status = Account.StatusEnum.ACTIVE;
                    break;
                case 3:
                    status = Account.StatusEnum.DENIED;
                    break;
            }
            String owner = rs.getString(3);
            double balance = rs.getDouble(4);
            account = new Account(owner);
            account.setAccountNumber(number);
            account.setStatus(status);
            account.setBalance(balance);
            joinUsers(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    private void joinUsers(Account account){
        UserDao userDao = new UserDao();
        List<User> users = userDao.retrieveByAccountNumber(account.getAccountNumber());
        for(int i = 0; i < users.size(); i++){
            account.join(users.get(i));
        }
    }

}

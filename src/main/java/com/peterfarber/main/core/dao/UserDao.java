package com.peterfarber.main.core.dao;

import com.peterfarber.main.core.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    public void create(User object){
        int type = getUserType(object);
        Connection conn = ConnectionFactory.getInstance().getConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO USERS VALUES ('"+ object.getName() +"','"+object.getUsername()+"','"+object.getPassword()+"','"+type+"')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User retrieveByString(String id){
        User object = null;
        String sql = "SELECT * FROM USERS WHERE USERS_USERNAME = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int type = rs.getInt(4);
                String name = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                switch(type){
                    case 1:
                        object = new Customer(name, username, password);
                        break;
                    case 2:
                        object = new Employee(name, username, password);
                        break;
                    case 3:
                        object = new Admin(name, username, password);
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return object;
    }

    public List<User> retrieveByAccountNumber(String accountNumber){
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM USERS WHERE USERS_USERNAME IN (SELECT USERS_ID FROM ACCOUNTS_USERS WHERE ACCOUNTS_ID = ?)";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int type = rs.getInt(4);
                String name = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                switch(type){
                    case 1:
                        users.add(new Customer(name, username, password));
                        break;
                    case 2:
                        users.add(new Employee(name, username, password));
                        break;
                    case 3:
                        users.add(new Admin(name, username, password));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> retrieveAll(){
        List<User> users = new ArrayList<User>();

        String sql = "SELECT * FROM USERS";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int type = rs.getInt(4);
                String name = rs.getString(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                switch(type){
                    case 1:
                        users.add(new Customer(name, username, password));
                        break;
                    case 2:
                        users.add(new Employee(name, username, password));
                        break;
                    case 3:
                        users.add(new Admin(name, username, password));
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public void update(User object){

        String sql = "UPDATE USERS SET USERS_NAME = ?, USERS_USERNAME = ?, USERS_PASSWORD = ?, USERS_TYPE = ? WHERE USERS_USERNAME = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, object.getName());
            ps.setString(2, object.getUsername());
            ps.setString(5, object.getUsername());
            ps.setString(3, object.getPassword());
            int type = getUserType(object);
            ps.setInt(4, type);

            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id){
        String sql = "DELETE FROM USERS WHERE USERS_USERNAME = ?";
        try {
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, id);

            int rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPreparedStmt(User object){
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";

        try{
            Connection conn = ConnectionFactory.getInstance().getConnection();
//            conn.setAutoCommit(false);
//            Savepoint sp = conn.setSavepoint("PrepStmtFlashCard");

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getUsername());
            stmt.setString(3, object.getPassword());
            int type = getUserType(object);
            stmt.setInt(4, type);
            stmt.executeUpdate();

//            conn.rollback(sp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getUserType(User object){
        int type = 0;
        if(object instanceof Customer){
            type = 1;
        }
        else if(object instanceof Employee){
            type = 2;
        }else if(object instanceof Admin){
            type = 3;
        }
        return type;
    }

}

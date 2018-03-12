package com.peterfarber.main.core.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory cf = null;

    private ConnectionFactory(){

    }

    public static synchronized ConnectionFactory getInstance(){
        if(cf == null){
            cf = new ConnectionFactory();
        }
        return cf;
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/main/resources/database.properties"));
            //Load OJDBC driver.
            Class.forName(prop.getProperty("driver"));

            //Connection to database and save connection.
            connection= DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));

        }catch(SQLException e) {
            System.out.println("Problem Opening Connection!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return connection;
    }

}

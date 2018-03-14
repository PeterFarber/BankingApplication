package com.peterfarber.main.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogDao {

    public void createPreparedStmt(String object){
        String sql = "INSERT INTO LOGS (LOGS_TIME, LOGS_MESSAGE) VALUES (?, ?)";

        try{
            Connection conn = ConnectionFactory.getInstance().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, getCurrentTimeStamp());
            stmt.setString(2, object);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

}


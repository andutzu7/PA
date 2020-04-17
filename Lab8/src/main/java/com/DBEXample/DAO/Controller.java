package com.DBEXample.DAO;

import com.DBEXample.Database.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Controller {
    protected Connection connection = null;

    protected Connection getConnection() {
        if (connection == null) {
            try {
                connection = Database.getInstance().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    //workaround because my oracle version is outdated
    int getIdFromDB(String tableName) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "SELECT COUNT(ID) FROM " + tableName;
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }

    int getRandomId(String tableName)throws SQLException {
        int result;
        connection = getConnection();
        Statement stmt = connection.createStatement();
        String query = " SELECT id FROM (SELECT id FROM "+ tableName +" ORDER BY dbms_random.value ) WHERE rownum = 1 ";
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        result = rs.getInt(1);
        return result;
    }
}
package com.opsdevelop.playergameapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
        String username = "COMP228_F24_soh_32";
        String password = "password";
        return DriverManager.getConnection(url, username, password);
    }
}
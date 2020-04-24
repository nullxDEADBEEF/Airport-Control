package com.nullxdeadbeef.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAdapter {

    public DatabaseAdapter() {}


    private static Connection con;

    final static String username = "root";
    final static String password = "rootkode";
    final static String url = "jdbc:mysql://localhost:1337/airport?useUnicode" +
            "=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        } return con;
    }
}

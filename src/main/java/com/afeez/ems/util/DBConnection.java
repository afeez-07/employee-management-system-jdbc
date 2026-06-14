package com.afeez.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
        	Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/employee_db";
            String user = "postgres";
            String password = "Afeez2005postgresql";

            return DriverManager.getConnection(url, user, password);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
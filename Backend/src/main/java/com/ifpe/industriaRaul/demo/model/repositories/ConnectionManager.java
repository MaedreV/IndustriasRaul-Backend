package com.ifpe.industriaRaul.demo.model.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String URL = "jdbc:mysql://localhost:3306/industrias_raul";
    private static final String USER = "root";

    private static final String PASSWORD = "10002000";

    private static Connection conn = null;

    protected static Connection getCurrentConnection() throws SQLException {

        if (conn == null)
			try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;

    }

    protected static Connection getNewConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

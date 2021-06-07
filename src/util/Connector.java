package util;

import java.sql.*;

public class Connector {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String username = "root";
        String password = "3UKtp47k";
        return DriverManager.getConnection(url, username, password);
    }
}


package Service;

import java.sql.*;
import java.util.ResourceBundle;

public class Connector {
    public static Connection getConnection() throws SQLException {
//        ResourceBundle resource = ResourceBundle.getBundle("MyLibrary");
        String url = "jdbc:mysql://localhost:3306/mylibrary";
        String username = "root";
        String password = "3UKtp47k";
        return DriverManager.getConnection(url, username, password);
    }
}


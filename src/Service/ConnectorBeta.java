package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorBeta {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mylibrarybeta";
        String username = "root";
        String password = "3UKtp47k";
        return DriverManager.getConnection(url, username, password);
    }
}

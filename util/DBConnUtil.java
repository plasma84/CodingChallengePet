package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection(String propertyFileName) throws SQLException, IOException, ClassNotFoundException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionString = DBPropertyUtil.getConnectionString(propertyFileName);
        return DriverManager.getConnection(connectionString);
    }
}
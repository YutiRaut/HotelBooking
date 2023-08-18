package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class MainConnection {
    private static MainConnection dbConnection = new MainConnection();
    private Connection connection = null;
    private final String URL = "jdbc:mysql://localhost:3306/hotel-booking";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private MainConnection() {

    }

    public static MainConnection getInstance() {return dbConnection;}

    public Connection getMainConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}



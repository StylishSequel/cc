package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private String hostName = "localhost:5432";
    private String databaseName = "test";
    private String username = "postgres";
    private String password = "123456";

    private String connectionURL = "jdbc:postgresql://" + hostName + "/" + databaseName;

    public Connection connect() {
        Connection con = null;

        try {
            con = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
}

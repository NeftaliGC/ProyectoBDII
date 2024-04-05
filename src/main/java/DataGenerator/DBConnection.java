package DataGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private String server;
    private String database;
    private String port;
    private String user;
    private String password;

    public DBConnection(String server, String database, String port, String user, String password) {
        this.server = server;
        this.database = database;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://" + this.server + ":" + this.port + "/" + this.database;
        Properties props = new Properties();
        props.setProperty("user", this.user);
        props.setProperty("password", this.password);
        Connection connection = DriverManager.getConnection(url, props);
        return connection;
    }
}
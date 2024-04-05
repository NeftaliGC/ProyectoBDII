/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.tablesSql.CategoriaSQL;
import DataGenerator.tablesSql.TableSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jesus
 */
public class DatabaseAccess {

    private final Connection conn;

    public DatabaseAccess(String user, String pass, String databaseName) throws SQLException {
        String url = "jdbc:postgresql://localhost/".concat(databaseName);
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pass);
        props.setProperty("ssl", "false");
        conn = (Connection) DriverManager.getConnection(url, props);
    }

    public Connection getConnection() {
        return conn;
    }

    public static void main(String[] args) {
        try {

            CategoryGenerator c = new CategoryGenerator();

            DatabaseAccess access = new DatabaseAccess("jesus", "1234", "farmacia");
            CategoriaSQL transaction = new CategoriaSQL(access);

            TableSQL.printList(transaction.select());

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

}

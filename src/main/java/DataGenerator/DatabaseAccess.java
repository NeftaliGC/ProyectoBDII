/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author jesus
 */
public class DatabaseAccess {

    public DatabaseAccess() {
        try {
            
            CategoryGenerator c = new CategoryGenerator();
            List<CategoryGenerator.Category> categories = c.getAllCategories();
            IdGenerator i = new IdGenerator();
            
            DriverDB driverDB = new DriverDB("jesus", "1234", "farmacia");
            CategoriaSQL transaction = new CategoriaSQL(driverDB);
            
            for (CategoryGenerator.Category category : categories) {
                transaction.executeInsert(i.getID(15, IdGenerator.ALPHANUMERIC), category.getName(), category.getDescription());
            }

            

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        DatabaseAccess d = new DatabaseAccess();
    }

    class DriverDB {

        private final Connection conn;

        /**
         *
         * @param user
         * @param password
         * @param databaseName
         * @throws SQLException
         */
        public DriverDB(String user, String pass, String databaseName) throws SQLException {
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

    }

    class CategoriaSQL {

        private Statement st;
        private PreparedStatement pst;
        private final Connection connection;

        public CategoriaSQL(DriverDB driverDB) throws SQLException {
            connection = driverDB.getConnection();
            st = connection.createStatement();
        }

        public void executeSelect() throws SQLException {
            ResultSet rs = st.executeQuery("SELECT * FROM categoria");

            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(", ");
                System.out.print(rs.getInt(2));
                System.out.print(", ");
                System.out.print(rs.getString(3));
                System.out.print(", ");
                System.out.println(rs.getString(4));
            }
            rs.close();
            st.close();

        }

        public void executeInsert(String idCategoria, String nombreCategoria, String descripcion) throws SQLException {
            String sql = String.format("INSERT INTO categoria (Id_categoria, Nombre_categoria, Descripcion ) VALUES "
                    + "('%s', '%s', '%s')", idCategoria, nombreCategoria, descripcion);
            System.out.println(sql);
            pst = connection.prepareStatement(sql);
            pst.executeUpdate();
            pst.close();
        }
    }
}

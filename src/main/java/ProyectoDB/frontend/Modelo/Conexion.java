package Modelo;
import conexionProyecto.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conectar = null;
    private static Conexion instance = null;
    private String user = "postgres";
    private String puerto = "5432";
    
    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }
    
    public boolean establecerConexion(connectionData conData) {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close(); // Cierra la conexión previa si está abierta
            }

            String cadena = "jdbc:postgresql://" + conData.ip + ":" + puerto + "/" + conData.db + "?currentSchema=" + conData.schema;
            Class.forName("org.postgresql.Driver");
            conectar = DriverManager.getConnection(cadena, user, conData.password);
            System.out.println("La conexion fue exitosa");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar base de datos, error: " + e.toString());
            return false;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver de la base de datos, error: " + e.toString());
            return false;
        }
    }
    
    public Connection getConectar() {
        System.out.println("Se llamo la conexion");
        return conectar;
    }
    
    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
                System.out.println("La conexión fue cerrada exitosamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión de base de datos, error: " + e.toString());
        }
    }
}

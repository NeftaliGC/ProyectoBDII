package DataGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryGenerator {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "";

        // Establecer la cantidad de registros de inventario
        int numRecords = 500000;

        // Instancia de la clase IdGenerator
        IdGenerator idGenerator = new IdGenerator();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("¡Conectado a la base de datos!");

                // SQL para insertar registros en la tabla de inventario
                String sql = "INSERT INTO dbiiproj.inventario (Id_inventario, Cantidad_disponible, Cantidad_minima, Cantidad_limite) VALUES (?, ?, ?, ?)";

                // Preparar la declaración SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de inventario
                for (int i = 0; i < numRecords; i++) {
                    // Generar un ID de inventario
                    String idInventario = idGenerator.getID(10, IdGenerator.ALPHANUMERIC);

                    // Generar cantidades aleatorias
                    double cantidadDisponible = Math.random() * 900 + 100; // Rango: 100 - 1000
                    double cantidadMinima = cantidadDisponible * (Math.random() * 0.1 + 0.1); // Rango: 10% - 20% de cantidad disponible
                    double cantidadLimite = cantidadDisponible * (Math.random() * 0.5 + 1.5); // Rango: 1.5 - 2 veces cantidad disponible

                    // Establecer los parámetros en la declaración SQL
                    statement.setString(1, idInventario);
                    statement.setDouble(2, cantidadDisponible);
                    statement.setDouble(3, cantidadMinima);
                    statement.setDouble(4, cantidadLimite);

                    // Ejecutar la inserción
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Se insertó un nuevo registro de inventario correctamente.");
                    }
                }
            } else {
                System.out.println("¡Error al establecer la conexión!");
            }
        } catch (SQLException e) {
            System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}

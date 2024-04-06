package DataGenerator;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class InventoryGenerator {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "password123";

        int numRecords = 1;

        IdGenerator idGenerator = new IdGenerator();

        Random random = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("¡Conectado a la base de datos!");

                String sql = "INSERT INTO dbiiproj.inventario (Id_inventario, Cantidad_disponible, Cantidad_minima, Cantidad_limite) VALUES (?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql);

                // FileWriter para guardar registros en un archivo de texto
                FileWriter writer = new FileWriter("inventario.txt", true);

                // Generar registros de inventario
                for (int i = 0; i < numRecords; i++) {
                    String idInventario = idGenerator.getID(10, IdGenerator.ALPHANUMERIC);

                    // Generar números enteros para cantidad_disponible, cantidad_minima y cantidad_limite
                    int cantidadDisponible = random.nextInt(801) + 100; // Números entre 100 y 900
                    int cantidadMinima = (int) (cantidadDisponible * (random.nextDouble() * 0.1 + 0.1));
                    int cantidadLimite = (int) (cantidadDisponible * (random.nextDouble() * 0.5 + 1.5));

                    statement.setString(1, idInventario);
                    statement.setInt(2, cantidadDisponible);
                    statement.setInt(3, cantidadMinima);
                    statement.setInt(4, cantidadLimite);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Se insertó un nuevo registro de inventario correctamente.");

                        // Escribir en el archivo de texto
                        writer.write(idInventario + "," + cantidadDisponible + "," + cantidadMinima + "," + cantidadLimite + "\n");
                    }
                }
                writer.close(); // Cerrar el FileWriter al finalizar
            } else {
                System.out.println("¡Error al establecer la conexión!");
            }
        } catch (SQLException e) {
            System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

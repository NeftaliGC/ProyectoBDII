package DataGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Random;

public class InventoryControlGenerator {

    // Genera una fecha aleatoria en el rango especificado
    public static Date generateRandomDate() {
        Random rand = new Random();
        int year = 2000 + rand.nextInt(25); // Años entre 2000 y 2024
        int month = 1 + rand.nextInt(12); // Meses entre 1 y 12
        int day = 1 + rand.nextInt(28); // Días entre 1 y 28 (suponiendo todos los meses tienen 28 días)
        return new Date(year - 1900, month - 1, day);
    }

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "password123";

        Random rand = new Random();
        int min = 1000;
        int max = 1000000;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             BufferedWriter writer = new BufferedWriter(new FileWriter("inventory_control.txt"))) {
            if (conn != null) {
                System.out.println("¡Conectado a la base de datos!");

                // Especificar el esquema con la tabla que contenga a proveedor
                String sql = "INSERT INTO dbiiproj.Control_Inventario(fecha_registro, cantidad_vendida, id_inventario, id_producto) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    for (int i = 0; i < 10; i++) { // Generar 10 registros de control de inventario
                        // Generar datos aleatorios
                        Date date = generateRandomDate();
                        int cantidad = rand.nextInt(max - min + 1) + min;
                        
                        // Asignar valores válidos para id_inventario e id_producto (cambiar por valores reales)
                        String idInventario = "inventario_id_" + i;
                        String idProducto = "producto_id_" + i;

                        statement.setDate(1, date);
                        statement.setInt(2, cantidad);
                        statement.setString(3, idInventario);
                        statement.setString(4, idProducto);

                        // Ejecutar la inserción
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("¡Se insertó un nuevo control de inventario correctamente!");
                            // Escribir en el archivo
                            writer.write(date + "/" + cantidad + "/" + idInventario + "/" + idProducto + "\n");
                        }
                    }
                }
            } else {
                System.out.println("¡Error al establecer la conexión!");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

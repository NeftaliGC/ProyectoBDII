package DataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class GeneradorConInventario {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Nintech1904";

        // Instancia las cases generativas necesarias
        DateGenerator dateGenerator = new DateGenerator();
        Random Random = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conectado a la base de datos!");

                // SQL para insertar registros en la tabla de control de inventario
                String sql = "INSERT INTO farma.control_inventario (fecha_registro, cantidad_vendida, id_producto, id_inventario) VALUES (?, ?, ?, ?)";

                // Preparar la declaración SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de control de inventario
                for (int i = 0; i < 16; i++) {
                    String fechaRegistro = dateGenerator.generateRandomDate(true);
                    int cantidadVendida = Random.nextInt(100);
                    String idProducto = "";
                    String idInventario = "";

                    // Selecciona un producto de la tabla de productos
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT id_producto FROM farma.producto ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idProducto = rs.getString("id_producto");
                    }

                    // Selecciona un inventario de la tabla de inventario
                    rs = stmt.executeQuery("SELECT id_inventario FROM farma.inventario ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idInventario = rs.getString("id_inventario");
                    }

                    statement.setDate(1, Date.valueOf(fechaRegistro));
                    statement.setInt(2, cantidadVendida);
                    statement.setString(3, idProducto);
                    statement.setString(4, idInventario);

                    statement.executeUpdate();

                    // Registra los cambios en un txt

                    try {
                        FileWriter myWriter = new FileWriter("src/main/resources/data/Tablas/control_inventario.txt", true);
                        myWriter.write("('" + fechaRegistro + "', " + cantidadVendida + ", '" + idProducto + "', '" + idInventario + "')\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }

                System.out.println("Registros de control de inventario generados con éxito.");


            } else {
                System.out.println("No se pudo conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());

        }

    }
}

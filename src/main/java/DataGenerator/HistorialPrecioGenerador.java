package DataGenerator;

import java.io.IOException;
import java.sql.*;
import java.util.Random;
import java.io.FileWriter;

public class HistorialPrecioGenerador {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Nintech1904";

        // Instancia las cases generativas necesarias
        DateGenerator dateGenerator = new DateGenerator();
        Random random = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conectado a la base de datos!");

                // SQL para insertar registros en la tabla de historial de precios
                String sql = "INSERT INTO farma.historial_precio (fecha_cambio, costo_actual, costo_previo, id_producto) VALUES (?, ?, ?, ?)";

                // Preparar la declaración SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de historial de precios
                for (int i = 0; i < 16; i++) {
                    String fechaCambio = dateGenerator.generateRandomDate(true);
                    double costoActual = 0.00;
                    double costoPrevio = random.nextDouble() * 1000;
                    String idProducto = "";


                    // Selecciona un producto de la tabla de productos
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT id_producto, precio_unitario FROM farma.producto ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idProducto = rs.getString("id_producto");
                        costoActual = rs.getDouble("precio_unitario");
                    }

                    statement.setDate(1, Date.valueOf(fechaCambio));
                    statement.setDouble(2, costoActual);
                    statement.setDouble(3, costoPrevio);
                    statement.setString(4, idProducto);

                    statement.executeUpdate();

                    // Registra los cambios en un txt
                    try {
                        FileWriter myWriter = new FileWriter("src/main/resources/data/Tablas/historial_precio.txt", true);
                        myWriter.write("('" + fechaCambio + "', " + costoActual + ", " + costoPrevio + ", '" + idProducto + "')\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}

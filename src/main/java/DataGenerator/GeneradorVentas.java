package DataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.sql.*;

public class GeneradorVentas {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Nintech1904";

        // Instancia las cases generativas necesarias
        IdGenerator idGenerator = new IdGenerator();
        Random Random = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conectado a la base de datos!");

                // SQL para insertar registros en la tabla de ventas
                String sql = "INSERT INTO farma.venta (id_venta, cantidad_vendida, total_venta, receta_medicina, id_producto, rfc, id_ticket) VALUES (?, ?, ?, ?, ?, ?, ?)";

                // Preparar la declaración SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de ventas
                for (int i = 0; i < 16; i++) {
                    // Generar un ID de venta
                    String idVenta = idGenerator.getID(10, IdGenerator.ALPHANUMERIC);
                    int cantidadVendida = Random.nextInt(100);
                    double totalVenta = Random.nextDouble() * 1000;
                    boolean recetaMedicina = Random.nextBoolean();
                    String idProducto = "";
                    String rfc = "";
                    Long idTicket = 0L;

                    // Selecciona un producto de la tabla de productos
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT id_producto FROM farma.producto ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idProducto = rs.getString("id_producto");
                    }

                    // Selecciona un cliente de la tabla de clientes
                    rs = stmt.executeQuery("SELECT rfc FROM farma.cliente ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        rfc = rs.getString("rfc");
                    }

                    // Selecciona un ticket de la tabla de tickets
                    rs = stmt.executeQuery("SELECT id_ticket FROM farma.ticket ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idTicket = rs.getLong("id_ticket");
                    }

                    statement.setString(1, idVenta);
                    statement.setInt(2, cantidadVendida);
                    statement.setDouble(3, totalVenta);
                    statement.setBoolean(4, recetaMedicina);
                    statement.setString(5, idProducto);
                    statement.setString(6, rfc);
                    statement.setLong(7, idTicket);

                    statement.executeUpdate();

                    // Registra los cambios en un txt

                    try {
                        FileWriter myWriter = new FileWriter("src/main/resources/data/Tablas/ventas.txt", true);
                        myWriter.write("('" + idVenta + "', " + cantidadVendida + ", " + totalVenta + ", " + recetaMedicina + ", '" + idProducto + "', '" + rfc + "', " + idTicket + ")\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No se pudo conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package DataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Random;

public class RegisRepoGenerador {
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
                String sql = "INSERT INTO farma.registro_reposicion (fecha_reposicion, cantidad_lote, id_lote, id_inventario) VALUES (?, ?, ?, ?)";

                // Preparar la declaración SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de control de inventario
                for (int i = 0; i < 5; i++) {
                    String fecha_reposicion = dateGenerator.generateRandomDate(true);
                    int cantidad_lote = Random.nextInt(100);
                    String idlote = "";
                    String idInventario = "";

                    // Selecciona un lote de la tabla de lote
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT id_lote FROM farma.lote ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idlote = rs.getString("id_lote");
                    }

                    // Selecciona un inventario de la tabla de inventario
                    rs = stmt.executeQuery("SELECT id_inventario FROM farma.inventario ORDER BY RANDOM() LIMIT 1");
                    while (rs.next()) {
                        idInventario = rs.getString("id_inventario");
                    }

                    statement.setDate(1, Date.valueOf(fecha_reposicion));
                    statement.setInt(2, cantidad_lote);
                    statement.setString(3, idlote);
                    statement.setString(4, idInventario);

                    statement.executeUpdate();

                    // Registra los cambios en un txt

                    try {
                        FileWriter myWriter = new FileWriter("src/main/resources/data/Tablas/registro_reposicion.txt", true);
                        myWriter.write("('" + fecha_reposicion + "', " + cantidad_lote + ", '" + idlote + "', '" + idInventario + "')\n");
                        myWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

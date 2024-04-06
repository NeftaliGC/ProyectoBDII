/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

/**
 *
 * @author estebandhm2912
 */

 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ReplacementRegistrationGenerator {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "";

        Random rand = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (BufferedReader loteReader = new BufferedReader(new FileReader("C:\\Users\\52722\\Downloads\\loteExport.txt"));
                 BufferedReader inventarioReader = new BufferedReader(new FileReader("C:\\Users\\52722\\ProyectoBDII\\inventario.txt"))) {
                if (conn != null) {
                    System.out.println("¡Conectado a la base de datos!");

                    String loteLine;
                    String inventarioLine;

                    String sql = "INSERT INTO dbiiproj.Registro_Reposicion(fecha_reposicion, cantidad_lote, id_lote, id_inventario) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int i = 0; i < 9; i++) { // Generar 10 registros
                        String date = generateRandomDate();
                        int cantidad = rand.nextInt(1000) + 1;

                        if ((loteLine = loteReader.readLine()) != null && (inventarioLine = inventarioReader.readLine()) != null) {
                            String idLote = getIdFromLine(loteLine);
                            String idInventario = getIdFromLine(inventarioLine);

                            statement.setString(1, date);
                            statement.setInt(2, cantidad);
                            statement.setString(3, idLote);
                            statement.setString(4, idInventario);

                            int rowsInserted = statement.executeUpdate();

                            if (rowsInserted > 0) {
                                System.out.println("¡Se insertó un nuevo registro de reposicion correctamente!");
                            }
                        }
                    }
                } else {
                    System.out.println("¡Error al establecer la conexión!");
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    private static String generateRandomDate() {
        // Implementa tu generador de fecha aleatoria aquí
        return null;
    }

    private static String getIdFromLine(String line) {
        String[] parts = line.split(",");
        return parts[0];
    }

}

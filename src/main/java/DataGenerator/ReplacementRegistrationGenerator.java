/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

/**
 *
 * @author estebandhm2912
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class ReplacementRegistrationGenerator {

    public static void main(String[] args) {
        //Cambiar conexion
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "12345";

        // Instancias de las clases de generación de datos
        DateGenerator DG = new DateGenerator();
        Random rand = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("RegistroReposicion.txt"))) {
                if (conn != null) {
                    System.out.println("¡Conectado a la base de datos!");

                    //Esoesificar el esquema con la tabla que contenga a proveedor
                    String sql = "INSERT INTO Registro_Reposicion(fecha_reposicion, cantidad_lote, id_lote, id_inventario) VALUES (?, ?, ?, ?)";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int i = 0; i < 9; i++) { // Generar 10 proveedores
                        // Generar datos aleatorios
                        String date = DG.generateRandomDate(false);
                        int cantidad = rand.nextInt(1000) + 1;

                        statement.setString(1, date);
                        statement.setInt(2, cantidad);
                        statement.setString(3, null);
                        statement.setString(4, null);

                        // Ejecutar la inserción
                        int rowsInserted = statement.executeUpdate();
                        writer.write(date + "/" + cantidad + "/null/null\n");
                        if (rowsInserted > 0) {
                            System.out.println("¡Se insertó un nuevo registro de reposicion correctamente!");
                        }
                    }
                } else {
                    System.out.println("¡Error al establecer la conexión!");
                }
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}

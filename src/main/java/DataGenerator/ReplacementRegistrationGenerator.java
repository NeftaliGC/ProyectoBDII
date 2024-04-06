package DataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ReplacementRegistrationGenerator {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "password123";

        Random rand = new Random();
        DateGenerator dateGenerator = new DateGenerator();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             BufferedReader loteReader = new BufferedReader(new FileReader("loteExport.txt"));
             BufferedReader inventarioReader = new BufferedReader(new FileReader("inventario.txt"))) {

            if (conn != null) {
                System.out.println("¡Conectado a la base de datos!");

                String loteLine;
                String inventarioLine;

                String sql = "INSERT INTO dbiiproj.Registro_Reposicion(fecha_reposicion, cantidad_lote, id_lote, id_inventario) " +
                             "VALUES (?, ?, ?, ?) " +
                             "ON CONFLICT (fecha_reposicion, id_lote, id_inventario) DO NOTHING";
                PreparedStatement statement = conn.prepareStatement(sql);

                try (FileWriter writer = new FileWriter("registro_reposicion.txt", true)) {
                    for (int i = 0; i < 1000000; i++) { // Generar 10 registros
                        String dateStr = dateGenerator.generateRandomDate(true);
                        int cantidad = rand.nextInt(1000) + 1;

                        if ((loteLine = loteReader.readLine()) != null && (inventarioLine = inventarioReader.readLine()) != null) {
                            String idLote = getIdFromLine(loteLine);
                            String idInventario = getIdFromLine(inventarioLine);

                            // Convertir la fecha de String a java.sql.Date
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            java.sql.Date date = null;
                            try {
                                Date parsed = format.parse(dateStr);
                                date = new java.sql.Date(parsed.getTime());
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                            if (date != null) {
                                statement.setDate(1, date);
                                statement.setInt(2, cantidad);
                                statement.setString(3, idLote);
                                statement.setString(4, idInventario);

                                int rowsInserted = statement.executeUpdate();

                                if (rowsInserted > 0) {
                                    System.out.println("¡Se insertó un nuevo registro de reposicion correctamente!");

                                    // Escribir en el archivo de texto
                                    writer.write(dateStr + "," + cantidad + "," + idLote + "," + idInventario + "\n");
                                }
                            }
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

    private static String getIdFromLine(String line) {
        String[] parts = line.split(",");
        return parts[0];
    }
}

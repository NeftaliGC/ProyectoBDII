package DataGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class FarmaciaGenerator {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "";

        IdGenerator idGenerator = new IdGenerator();
        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator();
        EmailGeneratorFarmacias emailGenerator = new EmailGeneratorFarmacias();
        NameFarmaGenerator nameFarmaGenerator = new NameFarmaGenerator();

        try {
            List<String> direcciones = Files.readAllLines(Paths.get("src/FarnaciaGeneratos/addressesFarmacias.txt"));

            Random rand = new Random();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("¡Conectado a la base de datos!");

                    String sql = "INSERT INTO esquema.farmacia (Id_farmacia, Nombre_farmacia, Direccion, Horario, Correo_electronico, Telefono, Licencia_permiso) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int i = 0; i < 20; i++) {
                        String idFarmacia = idGenerator.getID(10, IdGenerator.ALPHANUMERIC);
                        String nombreFarmacia = nameFarmaGenerator.generateRandomNameFarma();
                        String direccion = direcciones.get(rand.nextInt(direcciones.size()));
                        String horario = generarHorario(); // Establecer el horario de apertura aleatorio dentro de 5:00 a 11:00
                        String correo = emailGenerator.generateProfessionalEmail(nombreFarmacia);
                        String telefono = phoneNumberGenerator.generatePhoneNumber(false);
                        boolean licenciaPermiso = generarLicenciaPermiso();

                        statement.setString(1, idFarmacia);
                        statement.setString(2, nombreFarmacia);
                        statement.setString(3, direccion);
                        statement.setString(4, horario);
                        statement.setString(5, correo);
                        statement.setString(6, telefono);
                        statement.setBoolean(7, licenciaPermiso);

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("¡Se insertó una nueva farmacia correctamente!");
                        }
                    }
                } else {
                    System.out.println("¡Error al establecer la conexión!");
                }
            } catch (SQLException e) {
                System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error leyendo los archivos de texto: " + e.getMessage());
        }
    }

    public static String generarHorario() {
        Random rand = new Random();
        int hour = rand.nextInt(3) + 8; // Genera un número aleatorio entre 8 y 10
        int minute = rand.nextInt(60);
        int second = rand.nextInt(60);
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
    

    public static boolean generarLicenciaPermiso() {
        Random rand = new Random();
        int num = rand.nextInt(100); // Genera un número aleatorio entre 0 y 99
        return num < 55; // Devuelve true si el número es menor que 70
    }
    
}

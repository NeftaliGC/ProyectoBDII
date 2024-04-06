package DataGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
            List<String> direcciones = Files.readAllLines(Paths.get("src/main/resources/data/addressesFarmacias.txt"));

            Random rand = new Random();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("¡Conectado a la base de datos!");

                    String sql = "INSERT INTO esquema.farmacia (Id_farmacia, Nombre_farmacia, Direccion, Horario, Correo_electronico, Telefono, Licencia_permiso) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int i = 0; i < 25; i++) {
                        String idFarmacia = idGenerator.getID(10, IdGenerator.ALPHANUMERIC);
                        String nombreFarmacia = nameFarmaGenerator.generateRandomNameFarma();
                        String direccion = direcciones.get(rand.nextInt(direcciones.size()));
                        Timestamp horario = generarHorario(); // Establecer el horario de apertura aleatorio dentro de 5:00 a 11:00
                        String correo = emailGenerator.generateProfessionalEmail(nombreFarmacia);
                        String telefono = phoneNumberGenerator.generatePhoneNumber(true);
                        long telefonoNumerico = Long.parseLong("6" + telefono.substring(0, 8)); // Agrega un prefijo para garantizar que tenga 9 dígitos
                        boolean licenciaPermiso = generarLicenciaPermiso();

                        statement.setString(1, idFarmacia);
                        statement.setString(2, nombreFarmacia);
                        statement.setString(3, direccion);
                        statement.setTimestamp(4, horario);
                        statement.setString(5, correo);
                        statement.setLong(6, telefonoNumerico);
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

    public static Timestamp generarHorario() {
        Random rand = new Random();
        int hour = rand.nextInt(3) + 8; // Genera un número aleatorio entre 8 y 10
        int minute = rand.nextInt(60);
        int second = rand.nextInt(60);
        LocalDateTime time = LocalDateTime.of(1, 1, 1, hour, minute, second);
        return Timestamp.valueOf(time);
    }

    public static boolean generarLicenciaPermiso() {
        Random rand = new Random();
        int num = rand.nextInt(100); // Genera un número aleatorio entre 0 y 99
        return num < 55; // Devuelve true si el número es menor que 70
    }
}

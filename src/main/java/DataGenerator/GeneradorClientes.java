package DataGenerator;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GeneradorClientes {
    public static void main(String[] args) {
        //Cambiar conexion
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Nintech1904";

        // Instancias de las clases de generación de datos
        FullNamesGenerator fullNamesGenerator = new FullNamesGenerator();
        RFCGenerator rfcGenerator = new RFCGenerator();
        EmailGenerator emailGenerator = new EmailGenerator();
        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator();
        PostalCodeGenerator postalCodeGenerator = new PostalCodeGenerator();

        try {
            // Leer los archivos de texto
            List<String> direcciones = Files.readAllLines(Paths.get("src/main/resources/data/addresses.txt"));

            Random rand = new Random();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("¡Conectado a la base de datos!");

                    //Esoesificar el esquema con la tabla que contenga a cliente
                    String sql = "INSERT INTO farmacia.cliente (rfc_cliente, nombre, primer_apellido, segundo_apellido, telefono, correo_electronico, direccion, codigo_postal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int i = 0; i < 50560; i++) { // Generar 100 clientes
                        // Generar datos aleatorios
                        String[] nombreCompleto = fullNamesGenerator.generateFullName();
                        String nombre = nombreCompleto[0];
                        String apellido1 = nombreCompleto[1];
                        String apellido2 = nombreCompleto[2];
                        String rfc = rfcGenerator.generateRFC(nombre, apellido1);
                        String correo = emailGenerator.generatePersonalEmail(nombre, apellido1, apellido2);
                        String codigoPostal = postalCodeGenerator.generatePostalCode();
                        long telefono = Long.parseLong(phoneNumberGenerator.generatePhoneNumber(true));
                        String direccion = direcciones.get(rand.nextInt(direcciones.size()));

                        statement.setString(1, rfc);
                        statement.setString(2, nombre);
                        statement.setString(3, apellido1);
                        statement.setString(4, apellido2);
                        statement.setLong(5, telefono);
                        statement.setString(6, correo);
                        statement.setString(7, direccion);
                        statement.setInt(8, Integer.parseInt(codigoPostal));

                        // Ejecutar la inserción
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("¡Se insertó un nuevo usuario correctamente!" + i);
                        }

                        // Escribir en el archivo de texto
                        try {
                            FileWriter writer = new FileWriter("src/main/resources/data/Tablas/cliente.txt", true);
                            writer.write(rfc + "," + nombre + "," + apellido1 + "," + apellido2 + "," + telefono + "," + correo + "," + direccion + "," + codigoPostal + "\n");
                            writer.close();
                        } catch (Exception e) {
                            System.err.println("Error escribiendo en el archivo de texto: " + e.getMessage());
                        }
                    }
                } else {
                    System.out.println("¡Error al establecer la conexión!");
                }
            } catch (SQLException e) {
                System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error leyendo los archivos de texto: " + e.getMessage());
        }
    }
}

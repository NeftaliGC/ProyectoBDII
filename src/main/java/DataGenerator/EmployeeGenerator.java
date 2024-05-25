package DataGenerator;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class EmployeeGenerator {
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

                    // Especificar el esquema con la tabla que contiene a cliente
                    String sql = "INSERT INTO farma.empleado (rfc, nombre, primer_apellido, segundo_apellido, telefono, correo_electronico, direccion, codigo_postal, id_empleado, fecha_contratacion, id_empleo, id_farmacia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int i = 0; i < 6; i++) { // Generar 100 clientes
                        // Generar datos aleatorios
                        String[] nombreCompleto = fullNamesGenerator.generateFullName();
                        String nombre = nombreCompleto[0];
                        String apellido1 = nombreCompleto[1];
                        String apellido2 = nombreCompleto[2];
                        String rfc = rfcGenerator.generateRFC(nombre, apellido1, apellido2);
                        String correo = emailGenerator.generatePersonalEmail(nombre, apellido1, apellido2);
                        String codigoPostal = postalCodeGenerator.generatePostalCode();
                        long telefono = Long.parseLong(phoneNumberGenerator.generatePhoneNumber(true));
                        String direccion = direcciones.get(rand.nextInt(direcciones.size()));
                        String idEmpleado = new IdGenerator().getID(10, IdGenerator.ALPHANUMERIC);
                        String fechaContratacion = new DateGenerator().generateRandomDate(true);
                        System.out.println("Fecha de contratación: " + fechaContratacion);
                        String getIdEmpleo = "SELECT id_empleo FROM farma.puesto_empleo ORDER BY RANDOM() LIMIT 1";
                        String getIdFarmacia = "SELECT id_farmacia FROM farma.farmacia ORDER BY RANDOM() LIMIT 1";

                        int idEmpleo = 0;
                        String idFarmacia = "";

                        try {
                            PreparedStatement statement2 = conn.prepareStatement(getIdEmpleo);
                            ResultSet rs1 = statement2.executeQuery();
                            if (rs1.next()) {
                                idEmpleo = rs1.getInt(1);
                            }

                            PreparedStatement statement3 = conn.prepareStatement(getIdFarmacia);
                            ResultSet rs2 = statement3.executeQuery();
                            if (rs2.next()) {
                                idFarmacia = rs2.getString(1);
                            }
                        } catch (SQLException e) {
                            System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
                        }

                        System.out.println("ID Empleo: " + idEmpleo);

                        statement.setString(1, rfc);
                        statement.setString(2, nombre);
                        statement.setString(3, apellido1);
                        statement.setString(4, apellido2);
                        statement.setLong(5, telefono);
                        statement.setString(6, correo);
                        statement.setString(7, direccion);
                        statement.setInt(8, Integer.parseInt(codigoPostal));
                        statement.setString(9,idEmpleado);
                        statement.setDate(10, java.sql.Date.valueOf(fechaContratacion));
                        statement.setInt(11, idEmpleo);
                        statement.setString(12, idFarmacia);

                        // Ejecutar la inserción
                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("¡Se insertó un nuevo usuario correctamente!");

                            // Escribir en el archivo de texto
                            try {
                                FileWriter writer = new FileWriter("src/main/resources/data/Tablas/employee.txt", true);
                                writer.write("('"+ rfc + "'" + "," + "'" + nombre + "'" + "," + "'" + apellido1 + "'" + "," + "'" + apellido2 + "'" + "," + telefono + "," + "'" + correo + "'" + "," + "'" + direccion + "'" + "," + codigoPostal + "," + "'" + idEmpleado + "'" + "," + "'" + fechaContratacion + "'" + "," + idEmpleo + "," + "'" + idFarmacia + "'" + ")\n");
                                writer.close();
                            } catch (Exception e) {
                                System.err.println("Error escribiendo en el archivo de texto: " + e.getMessage());
                            }
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

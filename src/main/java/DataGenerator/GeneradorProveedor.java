package DataGenerator;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GeneradorProveedor {
    public static void main(String[] args) {
        //Cambiar conexion
        String url = "jdbc:postgresql://localhost:5432/";
        String user = "postgres";
        String password = "Nintech1904";

        // Instancias de las clases de generación de datos
        IdGenerator idGenerator = new IdGenerator();
        ProvidersGenerator providersGenerator = new ProvidersGenerator();
        RFCGenerator rfcGenerator = new RFCGenerator();
        EmailGenerator emailGenerator = new EmailGenerator();
        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("¡Conectado a la base de datos!");

                //Esoesificar el esquema con la tabla que contenga a proveedor
                String sql = "INSERT INTO farmacia.proveedor (id_proveedor, Rfc, Nombre, Telefono, correo_electronico) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql);
                String[] proveedores;
                proveedores = providersGenerator.getAllProvidersList();

                for (int i = 0; i < 10; i++) { // Generar 10 proveedores
                    // Generar datos aleatorios
                    int id = Integer.parseInt(idGenerator.getID(3,1));
                    String Nombreproveedor = proveedores[i];
                    String rfc = rfcGenerator.generateRFC(Nombreproveedor);
                    String correo = emailGenerator.generateProfessionalEmail(Nombreproveedor);
                    long telefono = Long.parseLong(phoneNumberGenerator.generatePhoneNumber(true));

                    statement.setInt(1, id);
                    statement.setString(2, rfc);
                    statement.setString(3, Nombreproveedor);
                    statement.setLong(4, telefono);
                    statement.setString(5, correo);

                    // Ejecutar la inserción
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("¡Se insertó un nuevo proveedor correctamente!");
                    }

                    // Escribir en el archivo de texto
                    try {
                        FileWriter writer = new FileWriter("src/main/resources/data/Tablas/proveedor.txt", true);
                        writer.write(id + "," + rfc + "," + Nombreproveedor + "," + telefono + "," + correo + "\n");
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
    }
}

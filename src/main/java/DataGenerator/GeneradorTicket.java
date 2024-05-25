package DataGenerator;

import java.io.FileWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

public class GeneradorTicket {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Nintech1904";

        /*
        * id_ticket
        * fecha_ticket
        * metodo_pago
        * subtotal
        * iva
        * total
        * id_factura
        * id_empleado
        * id_farmacia
        */

        // Instancia las cases generativas necesarias
        IdGenerator idGenerator = new IdGenerator();
        DateGenerator dateGenerator = new DateGenerator();
        GenerarHoras horaGenerator = new GenerarHoras();
        String[] metodosPago = {"efectivo", "tarjeta", "otro"};
        GeneradorPrecios precioGenerator = new GeneradorPrecios();

        Random Random = new Random();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("�Conectado a la base de datos!");

                // SQL para insertar registros en la tabla de inventario
                String sql = "INSERT INTO farma.ticket (Id_ticket, Fecha_ticket, Hora_ticket, Metodo_pago, Subtotal, Iva, Total, id_factura, id_empleado, id_Farmacia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Preparar la declaraci�n SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de ticket
                for (int i = 0; i < 16; i++) {
                    // Generar un ID de ticket
                    Long idTicket = Long.parseLong(idGenerator.getID(10, IdGenerator.NUMERICAL));
                    String fechaTicket = dateGenerator.generateRandomDate(true);
                    Timestamp horaTicket = generarHorario();
                    String metodoPago = metodosPago[(int) (Math.random() * metodosPago.length)];
                    String idFarmacia = "";
                    String idFactura = "";
                    double subtotal = 0.0;
                    String idEmpleado = "";

                    Statement stmt = conn.createStatement();
                    // Selecciona al azar una farmacia de 1 a 25
                    ResultSet rs = stmt.executeQuery("SELECT * FROM farma.farmacia OFFSET " + Random.nextInt(3) + " LIMIT 1");
                    if (!rs.next()) {
                        System.out.println("No se encontr� la farmacia en la base de datos.");
                        return;
                    } else {
                        idFarmacia = rs.getString("Id_farmacia");
                    }
                    rs = stmt.executeQuery("SELECT * FROM farma.factura OFFSET " + (i + 1) + " LIMIT 1");
                    if (!rs.next()) {
                        System.out.println("No se encontró la factura en la base de datos.");
                        return;
                    } else {
                        idFactura = rs.getString("Id_factura");
                        subtotal = rs.getDouble("Subtotal_factura");
                    }
                    rs = stmt.executeQuery("SELECT * FROM farma.empleado WHERE id_farmacia = '" + idFarmacia + "' LIMIT 1");
                    if (!rs.next()) {
                        System.out.println("No se encontró el empleado en la base de datos.");
                        return;
                    } else {
                        idEmpleado = rs.getString("id_empleado");
                    }
                    double iva = subtotal * 0.16;
                    double total = subtotal + iva;

                    // Establecer los par�metros en la declaraci�n SQL
                    statement.setLong(1,idTicket);
                    statement.setDate(2, Date.valueOf(fechaTicket));
                    statement.setTimestamp(3, horaTicket);
                    statement.setString(4, metodoPago);
                    statement.setDouble(5, subtotal);
                    statement.setDouble(6, iva);
                    statement.setDouble(7, total);
                    statement.setString(8, idFactura);
                    statement.setString(9, idEmpleado);
                    statement.setString(10, idFarmacia);

                    // Ejecutar la inserci�n
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Se insert� un nuevo registro de inventario correctamente.");
                    }

                    // Escribir en el archivo de texto
                    try {
                        FileWriter writer = new FileWriter("src/main/resources/data/Tablas/ticket.txt", true);
                        writer.write("(" + idTicket + ", '" + fechaTicket + "', '" + horaTicket + "', '" + metodoPago + "', " + subtotal + ", " + iva + ", " + total + ", '" + idFactura + "', '" + idEmpleado + "', '" + idFarmacia + "'),\n");
                        writer.close();
                    } catch (Exception e) {
                        System.err.println("Error escribiendo en el archivo de texto: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("�Error al establecer la conexi�n!");
            }
        } catch (SQLException e) {
            System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
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
}
package DataGenerator;

import java.io.FileWriter;
import java.sql.*;
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
                System.out.println("¡Conectado a la base de datos!");

                // SQL para insertar registros en la tabla de inventario
                String sql = "INSERT INTO farmacia.ticket (Id_ticket, Fecha_ticket, Hora_ticket, Metodo_pago, Subtotal, Iva, Total, id_Farmacia, id_factura, id_empleado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                // Preparar la declaración SQL
                PreparedStatement statement = conn.prepareStatement(sql);

                // Generar registros de ticket
                for (int i = 0; i < 440589; i++) {
                    // Generar un ID de ticket
                    String idTicket = idGenerator.getID(10, IdGenerator.NUMERICAL);
                    String fechaTicket = dateGenerator.generateRandomDate(true);
                    String horaTicket = horaGenerator.getRandomHour();
                    String metodoPago = metodosPago[(int) (Math.random() * metodosPago.length)];
                    String idFarmacia = "";
                    String idFactura = "";
                    double subtotal = 0.0;
                    String idEmpleado = "";

                    Statement stmt = conn.createStatement();
                    // Selecciona al azar una farmacia de 1 a 25
                    ResultSet rs = stmt.executeQuery("SELECT * FROM farmacia.farmacia OFFSET " + Random.nextInt(25) + " LIMIT 1");
                    if (!rs.next()) {
                        System.out.println("No se encontró la farmacia en la base de datos.");
                        return;
                    } else {
                        idFarmacia = rs.getString("Id_farmacia");
                    }
                    rs = stmt.executeQuery("SELECT * FROM farmacia.factura OFFSET " + (i + 1) + " LIMIT 1");
                    if (!rs.next()) {
                        System.out.println("No se encontró la factura en la base de datos.");
                        return;
                    } else {
                        idFactura = rs.getString("Id_factura");
                        subtotal = rs.getDouble("Subtotal_factura");
                    }
                    rs = stmt.executeQuery("SELECT * FROM farmacia.empleado WHERE id_empleado = '" + idEmpleado + "' AND id_farmacia = '" + idFarmacia + "' LIMIT 1");
                    if (!rs.next()) {
                        System.out.println("No se encontró el empleado en la base de datos.");
                        return;
                    } else {
                        idEmpleado = rs.getString("id_empleado");
                    }
                    double iva = subtotal * 0.16;
                    double total = subtotal + iva;

                    // Establecer los parámetros en la declaración SQL
                    statement.setString(1,idTicket);
                    statement.setDate(2, Date.valueOf(fechaTicket));
                    statement.setTime(3, Time.valueOf(horaTicket));
                    statement.setString(4, metodoPago);
                    statement.setDouble(5, subtotal);
                    statement.setDouble(6, iva);
                    statement.setDouble(7, total);
                    statement.setString(8, idFarmacia);
                    statement.setString(9, idFactura);
                    statement.setString(10, idEmpleado);

                    // Ejecutar la inserción
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Se insertó un nuevo registro de inventario correctamente.");
                    }

                    // Escribir en el archivo de texto
                    try {
                        FileWriter writer = new FileWriter("src/main/resources/data/Tablas/ticket.txt", true);
                        writer.write(idTicket + "," + fechaTicket + "," + horaTicket + "," + metodoPago + "," + subtotal + "," + iva + "," + total + "," + idFarmacia + "," + idFactura + "," + idEmpleado + "\n");
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

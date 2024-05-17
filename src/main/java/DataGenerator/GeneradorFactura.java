package DataGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Random;

public class GeneradorFactura {
    public static void main(String[] args) throws IOException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "Nintech1904";
        
        IdGenerator idGenerator = new IdGenerator();
        DateGenerator dateGenerator = new DateGenerator();
        GeneradorPrecios generarPrecio = new GeneradorPrecios();
        SatNumberGenerator generator = new SatNumberGenerator();
        
        try {
            //Le
            List<String> horas = Files.readAllLines(Paths.get("src/main/resources/data/combinaciones_horas.txt"));
            double precios[] = generarPrecio.generarPrecios(100, 20, 10000);
            Random rand = new Random();
            
            try (Connection conn = DriverManager.getConnection(url, user, password)){
                if (conn != null) {
                    System.out.println("¡Conectado a la base de datos!");
                    
                    
                    String query = "INSERT INTO farmacia.factura(Id_factura, Fecha_factura, Hora_Factura, Numero_certificado_sat, Metodo_pago, Subtotal_factura, Iva_factura, Total_factura, Rfc_cliente) VALUES (?,?,?,?,?,?,?,?,?)";
                    PreparedStatement st = conn.prepareStatement(query);
                    // Generar datos para insertarlos
                    for(int i = 189888; i < 1000000; i++){
                        int opcion = rand.nextInt(3);
                        int indiceAleatorio = rand.nextInt(precios.length);
                        //Generar datos
                        String id = idGenerator.getID(10, 0);
                        String fecha = dateGenerator.generateRandomDate(true);
                        String hora = horas.get(rand.nextInt(horas.size()));
                        String numeroSerieSAT = generator.generateNumeroSerieSAT(20);
                        String metodoPag = (opcion == 0) ? "efectivo" : (opcion == 1) ? "tarjeta" : "otro";
                        double subTotal = precios[indiceAleatorio];
                        double iva = 0.16 * subTotal;
                        double total = subTotal + iva;
                        String rfc = "";
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM farmacia.cliente OFFSET " + i + " LIMIT 1");
                        if(rs.next()){
                            rfc = rs.getString("rfc_cliente");
                        }else{
                            System.out.printf("No se encontró el rfc en la base de datos en la posición %d\n", i);
                        }

                        java.sql.Date fechaSql = java.sql.Date.valueOf(fecha);
                        java.sql.Timestamp horaSql = java.sql.Timestamp.valueOf(fecha + " " + hora);

                        st.setString(1, id);
                        st.setDate(2, fechaSql);
                        st.setTimestamp(3, horaSql);
                        st.setString(4, numeroSerieSAT);
                        st.setString(5, metodoPag);
                        st.setDouble(6, subTotal);
                        st.setDouble(7, iva);
                        st.setDouble(8, total);
                        st.setString(9, rfc);

                        //Ejecuta la instruccion
                        int rowsInserted = st.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println((i+1)+"¡Se insertó una factura.txt correctamente!");
                        }
                        // Escribir en el archivo de texto
                        try {
                            FileWriter writer = new FileWriter("src/main/resources/data/Tablas/factura.txt", true);
                            writer.write(id + "," + fecha + "," + hora + "," + numeroSerieSAT + "," + metodoPag + "," + subTotal + "," + iva + "," + total + "," + rfc + "\n");
                            writer.close();
                        } catch (Exception e) {
                            System.err.println("Error escribiendo en el archivo de texto: " + e.getMessage());
                        }
                    }
                }else {
                    System.out.println("¡Error al establecer la conexión!");
                }
            } catch (SQLException e) {
                System.err.format("Estado SQL: %s\n%s", e.getSQLState(), e.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error leyendo los archivos de texto: " + e.getMessage());
        }
    }
    
}

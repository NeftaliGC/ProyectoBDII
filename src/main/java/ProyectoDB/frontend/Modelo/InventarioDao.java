package Modelo;
import conexionProyecto.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InventarioDao {
    private Conexion cc;
    private Connection con;

    public InventarioDao() {
        cc = new Conexion();
    }
    
    
    public void insertInventory(Inventario inv){
        
        try {
            String query = "INSERT INTO farma.inventario (id_inventario, cantidad_disponible, cantidad_minima, cantidad_limite) VALUES (?, ?, ?, ?)";
            con = cc.establecerConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, inv.getId_inventario());
            ps.setDouble(2, inv.getCantidadDis());
            ps.setDouble(3, inv.getCantidadMin());
            ps.setDouble(4, inv.getCantidadLim());
            ps.executeUpdate();
            
            
            System.out.println("Exito al insertar");
            
        } catch (Exception e) {
            System.out.println("Erro al insertar: "+e);
        }
    }
    
    public void deleteInventory(String idInventario){
        try {
            String query = "DELETE FROM farma.inventario WHERE id_inventario = ?";
            con = cc.establecerConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, idInventario);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Registro eliminado correctamente.");
            } else {
                System.out.println("No se encontró ningún registro con el ID especificado.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void modifyInventory(Inventario inv) {
        try {
            String query = "UPDATE farma.inventario SET cantidad_disponible = ?, cantidad_minima = ?, cantidad_limite = ? WHERE id_inventario = ?";
            con = cc.establecerConexion();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, inv.getCantidadDis());
            ps.setDouble(2, inv.getCantidadMin());
            ps.setDouble(3, inv.getCantidadLim());
            ps.setString(4, inv.getId_inventario());

            int filasAfectadas = ps.executeUpdate(); // Aquí se ejecuta la actualización

            if (filasAfectadas > 0) {
                System.out.println("Registro modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún registro con el ID especificado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showInventory(){
        try {
            String query = "SELECT * FROM farma.inventario";
            con = cc.establecerConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String idInventario = rs.getString("id_inventario");
                double cantidadDisponible = rs.getDouble("cantidad_disponible");
                double cantidadMinima = rs.getDouble("cantidad_minima");
                double cantidadLimite = rs.getDouble("cantidad_limite");

                System.out.println("ID de Inventario: " + idInventario);
                System.out.println("Cantidad Disponible: " + cantidadDisponible);
                System.out.println("Cantidad Mínima: " + cantidadMinima);
                System.out.println("Cantidad Límite: " + cantidadLimite);
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
}

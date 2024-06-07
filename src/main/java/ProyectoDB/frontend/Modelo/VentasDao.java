package ProyectoDB.frontend.Modelo;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentasDao {
    Conexion cc = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar() {
        List<VentasData> datos = new ArrayList<>();
        String query = "SELECT * FROM farma.venta ORDER BY id_venta ASC";
        try {
            con = cc.establecerConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                VentasData vtaData = new VentasData();
                vtaData.setIdVenta(rs.getString(1));
                vtaData.setCantVendida(rs.getBigDecimal(2));
                vtaData.setTotalVenta(rs.getBigDecimal(3));
                vtaData.setReceta(rs.getBoolean(4));
                vtaData.setIdProducto(rs.getString(5));
                vtaData.setRfc(rs.getString(6));
                vtaData.setIdTicket(rs.getBigDecimal(7));
                datos.add(vtaData);
            }
            System.out.println("Mostrado con exito");
        } catch (Exception e) {
            System.out.println("Error, No Se Puede Mostrar Registros");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return datos;
    }
    
    public void insertSales(VentasData venta){
        con = cc.establecerConexion();
        CallableStatement cs = null;
        try {
            String query = "{call insertar_venta(?, ?, ?, ?, ?, ?, ?)}";
            cs = con.prepareCall(query);
            cs.setString(1, venta.getIdVenta());
            cs.setBigDecimal(2, venta.getCantVendida());
            cs.setBigDecimal(3, venta.getTotalVenta());
            cs.setBoolean(4, venta.isReceta());
            cs.setString(5, venta.getIdProducto());
            cs.setString(6, venta.getRfc());
            cs.setBigDecimal(7, venta.getIdTicket());
            cs.executeUpdate();
            System.out.println("Insertado con exito");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String deleteSale(String idVenta) {
        con = cc.establecerConexion();
        String resultMessage = null;
        try {
            con = cc.establecerConexion();
            ps = con.prepareStatement("SELECT eliminar_venta(?)");

            ps.setString(1, idVenta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String mensaje = rs.getString(1);
                System.out.println(mensaje);
            }
            
            ps.close();
            con.close();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Error en el delete"+e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error en el delete"+e);
            }
        }
        return resultMessage;
    }
    
}

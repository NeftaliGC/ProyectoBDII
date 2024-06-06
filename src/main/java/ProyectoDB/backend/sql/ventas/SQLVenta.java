/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.ventas;

import ProyectoDB.backend.objetos.venta.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ProyectoDB.backend.objetos.venta.VentaInterface;
import ProyectoDB.backend.sql.Operable;
import java.sql.Types;

/**
 *
 * @author jft314
 */
public class SQLVenta implements Operable<Venta, String>, VentaInterface {

    private final Connection connection;

    public SQLVenta(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Venta alta(Venta venta) {
        String sql = String.format("call insertar_venta(%s)", venta);

        System.out.println(sql);
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.execute();
            return venta;
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String baja(String id) {
        String sql = String.format("{? = call eliminar_venta('%s')}", id);
        System.out.println(sql);
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.execute();

            return callableStatement.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * actualizar_venta( id_venta, id_producto, rfc, id_ticket,
     * cantidad_vendida)
     *
     * @param venta
     * @return
     */
    @Override
    public Venta modifica(Venta venta) {
        String sql = String.format(
                "select actualizar_venta( '%s', '%s', '%s', %d, %d)",
                venta.getIdVenta(),
                venta.getIdProducto(),
                venta.getRfcCliente(),
                venta.getIdTicket(),
                venta.getCantidadVendida());
        System.out.println(sql);

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.execute();
            return venta;
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Debido a que el resultado obtenido se fuciono en una sola columna tipo
     * string se descompone internamente.
     *
     * @param id
     * @return
     */
    @Override
    public Venta consulta(String id) {
        String sql = String.format("select consultar_venta('%s')", id);
        System.out.println(sql);

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();

            resultSet.next();

            String row = resultSet.getString(1);

            row = row.replace("(", "");
            row = row.replace(")", "");

            String tokens[] = row.split(",");

            return new Venta(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Boolean.parseBoolean(tokens[3]),
                    tokens[4],
                    tokens[5],
                    Long.parseLong(tokens[6]));
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Venta> reporte() {
        String sql = "select * from reporte_venta()";
        List<Venta> ventas = null;

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();

            ventas = new ArrayList<>();

            while (resultSet.next()) {
                ventas.add(new Venta(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getBoolean(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getLong(7)));
            }

            return ventas;
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ventas;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.control_inventario;

import ProyectoDB.backend.objetos.control_inventario.ControlInventario;
import ProyectoDB.backend.objetos.venta.Venta;
import ProyectoDB.backend.sql.Operable;
import ProyectoDB.backend.sql.ventas.SQLVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * s
 *
 * @author jft314
 */
public class SQLControlInventario implements Operable<ControlInventario, String> {

    private final Connection connection;

    public SQLControlInventario(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ControlInventario alta(ControlInventario controlInventario) {
        String sql = String.format("call alta_control_inventario(%s)", controlInventario);

        System.out.println(sql);
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.execute();
            return controlInventario;
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String bajaId(String id_producto, String id_inventario) {
        String sql = String.format(
                "{? = call baja_control_inventario('%s', '%s')}",
                id_producto,
                id_inventario);

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

    @Override
    public ControlInventario modifica(ControlInventario param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ControlInventario consulta(String param) {

        return null;
    }

    @Override
    public List<ControlInventario> reporte() {
        String sql = "select  consultar_control_inventario() ";
        List<ControlInventario> controlInventario = null;

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();

            controlInventario = new ArrayList<>();

            while (resultSet.next()) {
                String row = resultSet.getString(1);
                row = row.replace("(", "").replace(")", "").trim();

                String tokens[] = row.split(",");

                controlInventario.add(new ControlInventario(
                        Timestamp.valueOf(tokens[0].concat(" 00:00:00")),
                        Integer.parseInt(tokens[1]),
                        tokens[2],
                        tokens[3]));
            }

            return controlInventario;
        } catch (SQLException ex) {
            Logger.getLogger(SQLVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return controlInventario;

    }

    /**
     * No usar para este tipo de Dato Control Inventario
     *
     * @param param
     * @return
     */
    @Override
    public String baja(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.control_inventario;

import ProyectoDB.backend.objetos.control_inventario.ControlInventario;
import ProyectoDB.backend.sql.Operable;
import ProyectoDB.backend.sql.ventas.SQLVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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

    @Override
    public String baja(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ControlInventario modifica(ControlInventario param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ControlInventario consulta(String param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ControlInventario> reporte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

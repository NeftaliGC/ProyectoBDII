/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoDB.backend.sql.inventario;

/**
 *
 * @author Esteban
 */
import ProyectoDB.backend.objetos.inventario.Inventario;
import ProyectoDB.backend.sql.Operable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLInventario implements Operable<Inventario, String> {

    private final Connection connection;

    public SQLInventario(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Inventario alta(Inventario inventario) {
        String sql = String.format("{call alta_inventario(%s)}", inventario.toString());

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.execute();
            return inventario;
        } catch (SQLException ex) {
            Logger.getLogger(SQLInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String baja(String id) {
        String sql = String.format("{call baja_inventario(%s)}", id);

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.registerOutParameter("mensaje", java.sql.Types.VARCHAR);
            callableStatement.execute();

            return callableStatement.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(SQLInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

//    @Override
//    public Inventario modifica(String id) {
//        String sql = String.format("{call modificar_inventarioo(%s)}", id);
//
//        try {
//            CallableStatement callableStatement = connection.prepareCall(sql);
//            callableStatement.execute();
//            return null;
//        } catch (SQLException ex) {
//            Logger.getLogger(SQLInventario.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    @Override
    public Inventario consulta(String id) {
        String sql = String.format("{call consultar_inventario(%s)}", id);

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.execute();

            return new Inventario(
                    callableStatement.getString(1),
                    callableStatement.getInt(2),
                    callableStatement.getInt(3),
                    callableStatement.getInt(4));
        } catch (SQLException ex) {
            Logger.getLogger(SQLInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Inventario> reporte() {
        String sql = "{call generar_reporte_inventario()}";
        List<Inventario> inventarios = null;

        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();

            inventarios = new ArrayList<>();

            while (resultSet.next()) {
                inventarios.add(new Inventario(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)));
            }

            return inventarios;
        } catch (SQLException ex) {
            Logger.getLogger(SQLInventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventarios;
    }

    @Override
    public Inventario modifica(Inventario param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

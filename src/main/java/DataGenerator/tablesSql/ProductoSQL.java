/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.tablesSql;

import DataGenerator.DatabaseAccess;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jesus
 */
public class ProductoSQL extends TableSQL {

    public ProductoSQL(DatabaseAccess access) throws SQLException {
        super(access, "producto");
    }
    
    public void executeInsert(
            String idProducto,
            String nombreProducto,
            String descripcion,
            double precioUnitario,
            String idCategoria,
            String idLote,
            String idFarmacia) throws SQLException {

        String sql = String.format("INSERT INTO %s (Id_producto, Nombre_producto, Descripcion, Precio_unitario, Id_categoria, Id_lote, Id_farmacia) VALUES "
                + "('%s', '%s', '%s', %f, '%s','%s','%s')",
                tableName,
                idProducto,
                nombreProducto,
                descripcion,
                precioUnitario,
                idCategoria,
                idLote,
                idFarmacia);
        //System.out.println(sql);

        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public <T> List<T> select() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.tablesSql;

import DataGenerator.DatabaseAccess;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author jesus
 */
public final class BatchSQL extends TableSQL {

    public BatchSQL(DatabaseAccess access) throws SQLException {
        super(access, "lote");
    }

    public void executeInsert(
            String idLote,
            int cantidadStock,
            LocalDate fechaFabricacion,
            LocalDate fechaCaducidad,
            LocalDate fechaEntrega,
            double coste,
            double iva,
            double totalLote,
            int idProveedor) throws SQLException {

        String sql = String.format("INSERT INTO %s (Id_lote, Cantidad_Stock, Fecha_fabricacion, Fecha_caducidad, Fecha_entrega, Coste, IVA, Total_lote, Id_proveedor) VALUES "
                + "('%s', %d, '%s', '%s', '%s', %f, %f, %f, %d)",
                tableName,
                idLote,
                cantidadStock,
                fechaFabricacion,
                fechaCaducidad,
                fechaEntrega,
                coste,
                iva,
                totalLote,
                idProveedor);
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

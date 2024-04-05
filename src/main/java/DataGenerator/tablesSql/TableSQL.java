/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.tablesSql;

import DataGenerator.DatabaseAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author jesus
 */
public abstract class TableSQL implements Manageable {

    protected final Statement st;
    protected PreparedStatement pst;
    protected final Connection connection;
    protected final String tableName;

    public TableSQL(DatabaseAccess access, String tableName) throws SQLException {
        connection = access.getConnection();
        st = connection.createStatement();
        this.tableName = tableName;
    }

    /**
     * Pregeriblemente no usar tipos de datos primitivos en esta funcion.
     *
     * @param <T>
     * @param list
     */
    public static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t.toString());
        }
    }
}

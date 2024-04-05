/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.tablesSql;

import DataGenerator.DatabaseAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jesus
 */
public class ProveedorSQL extends TableSQL {

    private final ArrayList<Integer> ids;
    private final Random random = new Random();

    public ProveedorSQL(DatabaseAccess access) throws SQLException {
        super(access, "proveedor");
        ids = getIdColumn();
    }

    private ArrayList<Integer> getIdColumn() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT Id_proveedor FROM ".concat(tableName));
        ArrayList<Integer> ids = new ArrayList<>();

        while (rs.next()) {

            ids.add(rs.getInt(1));
        }
        rs.close();
        st.close();

        return ids;
    }

    public ArrayList<Integer> getIds() {
        return ids;
    }

    public Integer getRandomId() {
        return ids.get(random.nextInt(ids.size()));
    }

    @Override
    public <T> List<T> select() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

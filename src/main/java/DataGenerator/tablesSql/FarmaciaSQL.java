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

/**
 *
 * @author jesus
 */
public class FarmaciaSQL extends TableSQL {

    private final ArrayList<String> ids;

    public FarmaciaSQL(DatabaseAccess access) throws SQLException {
        super(access, "farmacia");
        ids = getIdColumn();
    }

    private ArrayList<String> getIdColumn() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT Id_farmacia FROM ".concat(tableName));
        ArrayList<String> ids = new ArrayList<>();

        while (rs.next()) {

            ids.add(rs.getString(1));
        }
        rs.close();

        return ids;
    }

    public String getRandomId() {
        return ids.get(random.nextInt(ids.size()));
    }

    @Override
    public <T> List<T> select() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

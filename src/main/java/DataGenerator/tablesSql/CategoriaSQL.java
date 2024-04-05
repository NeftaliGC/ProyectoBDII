/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator.tablesSql;

import DataGenerator.DatabaseAccess;
import DataGenerator.objectsDb.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesus
 */
public final class CategoriaSQL extends TableSQL {

    private final ArrayList<String> ids;

    public CategoriaSQL(DatabaseAccess access) throws SQLException {
        super(access, "CATEGORIA");
        ids = getIdColumn();
    }

    private ArrayList<String> getIdColumn() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT Id_categoria FROM ".concat(tableName));
        ArrayList<String> ids = new ArrayList<>();

        while (rs.next()) {

            ids.add(rs.getString(1));
        }
        rs.close();

        return ids;
    }

    public void executeInsert(
            String idCategoria,
            String nombreCategoria,
            String descripcion) throws SQLException {

        String sql = String.format("INSERT INTO %s (Id_categoria, Nombre_categoria, Descripcion ) VALUES "
                + "('%s', '%s', '%s')",
                tableName,
                idCategoria,
                nombreCategoria,
                descripcion);
        System.out.println(sql);

        pst = connection.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
    }

    @Override
    public List<Category> select() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM ".concat(tableName));
        ArrayList<Category> categories = new ArrayList<>();

        while (rs.next()) {

            categories.add(
                    new Category(
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4)));
        }
        rs.close();
        st.close();

        return categories;
    }

    public String getRandomId() {
        return ids.get(random.nextInt(ids.size()));
    }
   
}

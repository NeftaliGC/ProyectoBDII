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

    public CategoriaSQL(DatabaseAccess access) throws SQLException {
        super(access, "CATEGORIA");
    }

    public void executeInsert(String idCategoria, String nombreCategoria, String descripcion) throws SQLException {
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
        ResultSet rs = st.executeQuery("SELECT * FROM categoria");
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

}

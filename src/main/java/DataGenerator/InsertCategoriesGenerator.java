/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.objectsDb.Category;
import DataGenerator.tablesSql.CategoriaSQL;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jesus
 */
public class InsertCategoriesGenerator {

    public InsertCategoriesGenerator() {
        try {
            /**
             * Aqui debe de ir los dtaos correctos de la base de datos local
             */
            DatabaseAccess d = new DatabaseAccess("jesus", "1234", "farmacia"); //acceso a la base de datos
            CategoriaSQL categoriaSQL = new CategoriaSQL(d); //Contiene algunos sql prearmados para la tabla indicada en el nombre de la funcion
            CategoryGenerator c = new CategoryGenerator(); //se obtiene todas las categorias
            IdGenerator i = new IdGenerator(); //para generar los ids de la tabla.

            ArrayList<Category> l = (ArrayList<Category>) c.getAllCategories();

            if (l.isEmpty()) {
                System.out.println("lista vacia");
            } else {
                for (Category category : l) { //iteramos por todas las categorias y las agregamos a la tabla de la base de datos.
                    categoriaSQL.executeInsert(
                            i.getID(15, IdGenerator.ALPHANUMERIC),
                            category.getName(),
                            category.getDescription());
                }
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        new InsertCategoriesGenerator();
    }
}

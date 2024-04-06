/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.objectsDb.Category;
import DataGenerator.tablesSql.CategoriaSQL;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

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
            DatabaseAccess d = new DatabaseAccess("postgres", "Nintech1904", "postgres"); //acceso a la base de datos
            CategoriaSQL categoriaSQL = new CategoriaSQL(d); //Contiene algunos sql prearmados para la tabla indicada en el nombre de la funcion
            CategoryGenerator c = new CategoryGenerator(); //se obtiene todas las categorias
            IdGenerator i = new IdGenerator(); //para generar los ids de la tabla.

            ArrayList<Category> l = (ArrayList<Category>) c.getAllCategories();
            File file = new File("src/main/resources/data/Tablas/categoriaExport.txt");
            Formatter formatter = new Formatter(file);

            boolean toFile = true;
            if (l.isEmpty()) {
                System.out.println("lista vacia");
            } else {
                for (Category category : l) { //iteramos por todas las categorias y las agregamos a la tabla de la base de datos.
                    if (toFile) {

                        formatter.format("%s,%s,'%s'\n",
                                i.getID(15, IdGenerator.ALPHANUMERIC),
                                category.getName(),
                                category.getDescription());
                    } else {
                        categoriaSQL.executeInsert(
                                i.getID(15, IdGenerator.ALPHANUMERIC),
                                category.getName(),
                                category.getDescription());
                    }
                }
                formatter.close();
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        new InsertCategoriesGenerator();
    }
}

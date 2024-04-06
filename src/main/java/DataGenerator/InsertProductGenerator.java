/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.objectsDb.Category;
import DataGenerator.tablesSql.BatchSQL;
import DataGenerator.tablesSql.CategoriaSQL;
import DataGenerator.tablesSql.FarmaciaSQL;
import DataGenerator.tablesSql.ProductoSQL;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

/**
 *
 * @author jesus
 */
public class InsertProductGenerator {

    public InsertProductGenerator() {
        try {
            /**
             * Aqui debe de ir los datos correctos de la base local
             */
            DatabaseAccess d = new DatabaseAccess("jesus", "1234", "farmacia"); //acceso a la base de datos
            IdGenerator i = new IdGenerator(); //para generar los ids de la tabla.
            //llaves foraneas existentes
            BatchSQL b = new BatchSQL(d);//Contiene algunos sql prearmados para la tabla indicada en el nombre de la funcion 
            FarmaciaSQL f = new FarmaciaSQL(d);
            CategoriaSQL c = new CategoriaSQL(d);
            DrugGenerator dg = new DrugGenerator();
            
            ProductoSQL p = new ProductoSQL(d);
            
            ArrayList<Category> arr = (ArrayList<Category>) c.select();
            
            File file = new File("productosExport.txt");
            Formatter formatter = new Formatter(file);
            
            for (int j = 0; j < 200000; j++) { //ajustar para llegar a 200,000 o mas.
                String drugName = dg.getRandomDrugName();
                
                String idLote = b.getRandomId();
                double precio = b.getPrice(idLote);
                
                String desc = dg.getDescription(drugName).substring(0, 50);
                
                String idCategoriaAdecuado = dg.getIdCategoriByDrugName(drugName, arr, d);//busca la categoria por nombre en la base de datos retornando su id.

                boolean toFile = true; //para cambiar entre acceso a la base o enviar a un archivo.

                if (toFile) {
                    formatter.format("'%s'< '%s'< '%s'< %.2f< '%s'< '%s'< '%s'\n",
                            i.getID(9, IdGenerator.ALPHANUMERIC),
                            drugName,
                            desc,
                            precio * 1.25,
                            c.getRandomId(),
                            idLote,
                            f.getRandomId());
                } else {
                    p.executeInsert(
                            i.getID(10, IdGenerator.ALPHANUMERIC),
                            drugName,
                            desc,
                            precio * 1.25,
                            c.getRandomId(),
                            idLote,
                            f.getRandomId());
                    
                    if (j % 1000 == 0) {
                        System.out.println("Va por los " + j);
                    }
                }
            }
            formatter.close();
            
        } catch (SQLException ex) {
            System.err.println(ex);
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public static void main(String[] args) {
        new InsertProductGenerator();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.tablesSql.BatchSQL;
import DataGenerator.tablesSql.ProveedorSQL;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;

/**
 *
 * @author jesus
 */
public class InsertBatchGenerator {

    public InsertBatchGenerator() {
        try {
            /**
             * Aqui debe de ir los dtaos correctos de la base de datos local
             */
            DatabaseAccess d = new DatabaseAccess("jesus", "1234", "farmacia"); //acceso a la base de datos
            ProveedorSQL p = new ProveedorSQL(d); //Contiene algunos sql prearmados para la tabla indicada en el nombre de la funcion
            IdGenerator i = new IdGenerator(); //para generar los ids de la tabla.
            DateGenerator birthDay = new DateGenerator();
            BatchSQL b = new BatchSQL(d);//Contiene algunos sql prearmados para la tabla indicada en el nombre de la funcion 

            ArrayList<Integer> l = (ArrayList<Integer>) p.getIds();
            Random r = new Random(); // para obtener cantidades aleatorias

            boolean toFile = true;
            File file = new File("loteExport.txt");
            Formatter formatter = new Formatter(file);

            for (int j = 0; j < 1000000; j++) { //ajustar para llegar al millon o mas.
                LocalDate fab = birthDay.birthday(1, 2);// de 1 a 2 anios
                LocalDate cad = birthDay.addYears(fab, r.nextInt(5) + 1); //se le agregan de 1 a 5 anios
                LocalDate ent = birthDay.addMonths(fab, r.nextInt(8) + 1);//se le agregan de 1 a 8 meses
                double precio = (r.nextDouble() + 0.1) * (r.nextInt(1000) + 20);//simula el precio
                int cantidad = r.nextInt(100) + 10; //simula la cantidad entre 10 y 100
                double total = (cantidad * precio) + (cantidad * precio) * 0.16; // calcula el total considerando el IVA

                if (toFile) {

                    formatter.format("('%s', %d, '%s', '%s', '%s', %f, %f, %f, %d),\n", 
                            i.getID(10, IdGenerator.ALPHANUMERIC),
                            cantidad,
                            fab,
                            cad,
                            ent,
                            precio,
                            16.0,
                            total,
                            p.getRandomId());
                } else {
                    b.executeInsert(
                            i.getID(10, IdGenerator.ALPHANUMERIC),
                            cantidad,
                            fab,
                            cad,
                            ent,
                            precio,
                            16,
                            total,
                            p.getRandomId()); //asigna un proveedor existente en la base de datos no es actualizable en ejecucion

                }
                if (j % 1000 == 0) {
                    System.out.println("Va por los " + j);
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
        new InsertBatchGenerator();
    }

    /**
     * Desafortunadamente el DateGenerator que ya estaba no fue util debido a
     * que se requeria sumar tiempo a las fechas generadas
     */
    private class DateGenerator {

        private final Random r;

        public DateGenerator() {

            r = new Random();
        }

        public LocalDate birthday(int minYears, int maxYears) {
            LocalDate l = LocalDate.now();
            int currentYear = maxYears - minYears;
            currentYear = r.nextInt(currentYear) + minYears;
            currentYear = l.getYear() - currentYear;
            int month = r.nextInt(12) + 1;
            int days = 0;

            switch (month) {
                case 1:
                    days = r.nextInt(31);
                    break;
                case 2:
                    days = r.nextInt(28);
                    break;
                case 3:
                    days = r.nextInt(31);
                    break;
                case 4:
                    days = r.nextInt(30);
                    break;
                case 5:
                    days = r.nextInt(31);
                    break;
                case 6:
                    days = r.nextInt(30);
                    break;
                case 7:
                    days = r.nextInt(31);
                    break;
                case 8:
                    days = r.nextInt(31);
                    break;
                case 9:
                    days = r.nextInt(30);
                    break;
                case 10:
                    days = r.nextInt(31);
                    break;
                case 11:
                    days = r.nextInt(30);
                    break;
                case 12:
                    days = r.nextInt(31);
                    break;

            }

            LocalDate a = LocalDate.of(currentYear, month, days + 1);

            return a;
        }

        public LocalDate addYears(LocalDate time, int years) {
            return time.plusYears(years);
        }

        public LocalDate addMonths(LocalDate time, int monts) {
            return time.plusMonths(monts);
        }

        public LocalDate addDays(LocalDate time, int days) {
            return time.plusDays(days);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.objectsDb.Drug;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class DrugGenerator {

    private final List<Drug> drugs;
    private final static Random RANDOM = new Random();

    private final String path = "src/main/resources/data/drugs.txt";

    /**
     * Haciendo uso de la funcion getRandomDrug se pueden obtener todas las
     * caracteristicas de farmaco generado aleatoriamente solo con enviar el
     * nombre del farmaco como parametro.
     */
    public DrugGenerator() {
        drugs = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(Paths.get(path));

            while (scanner.hasNext()) {
                String drugLine[] = scanner.nextLine().split("@");

                if (drugLine.length == 4) {
                    drugs.add(
                            new Drug(
                                    drugLine[0].trim(),
                                    drugLine[1].trim(),
                                    drugLine[2].trim(),
                                    drugLine[3].trim()));
                } else {
                    System.err.println(
                            "----" + drugLine[0] + " Corregir, Error de formato");
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     *
     * @return Devuelve el nombre de un farmaco aleatorio
     */
    public String getRandomDrugName() {
        return drugs.get(
                RANDOM.nextInt(
                        drugs.size())).getName();
    }

    /**
     *
     * @param drugName Nombre del farmaco
     * @return aplication Es el tipo de aplicacion del farmaco
     */
    public String getAplication(String drugName) {
        String res = null;
        for (Drug drug : drugs) {
            if (drug.getName().equals(drugName)) {
                res = drug.getAplicacion();
                break;
            }
        }
        return res;
    }

    /**
     *
     * @param drugName Nombre del farmaco
     * @return type Es la clasificacion del farmaco
     */
    public String getType(String drugName) {
        String res = null;
        for (Drug drug : drugs) {
            if (drug.getName().equals(drugName)) {
                res = drug.getType();
                break;
            }
        }
        return res;
    }

    /**
     *
     * @param drugName Nombre del farmaco
     * @return description Es la descripcion del farmco, puede contener
     * descripciones de uso y algunas notas, tambien puede contener varias 
     * lineas como un parrafo o varios.
     */
    public String getDescription(String drugName) {
        String res = null;
        for (Drug drug : drugs) {
            if (drug.getName().equals(drugName)) {
                res = drug.getDescription();
                break;
            }
        }
        return res;
    }
    
    public List<Drug> getAllDrugs(){
        return drugs;
    }

    public static void main(String[] args) {

        DrugGenerator g = new DrugGenerator();
        String name = g.getRandomDrugName();
        String aplic = g.getAplication(name);
        String type = g.getType(name);
        String descr = g.getDescription(name);
        System.out.printf("%s\n%s\n%s\n%s", name, aplic, type, descr);
        
        ArrayList<Drug> all = (ArrayList<Drug>) g.getAllDrugs();
        
        for (Drug drug : all) {
            
            System.out.println(drug);
        }

    }

}

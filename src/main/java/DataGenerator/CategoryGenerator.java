/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import java.util.HashSet;

/**
 *
 * @author jesus
 */
public class CategoryGenerator {

    public CategoryGenerator() {
        DrugGenerator d = new DrugGenerator();

        HashSet<String> categorias = new HashSet<>();

        for (DrugGenerator.Drug next : d.getAllDrugs()) {
            String cats []= next.getType().split(",");
            for (String cat : cats) {
                categorias.add(cat.trim());
            }
        }
        for (String categoria : categorias) {
            System.out.println(categoria);
        }
    }
    
    public static void main(String[] args) {
        CategoryGenerator c = new CategoryGenerator();
    }

}

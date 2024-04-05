/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class PrescriptionGenerator {

    private final Random random;

    public PrescriptionGenerator() {
        random = new Random();
    }

    /**
     * El porcentaje define la probabilidad de que sea verdadero, solo valores
     * entre 0 y 100 de otra forma sera falso
     *
     * @param percentage
     * @return
     */
    public boolean isPrescriptionShow(int percentage) {
        if (percentage >= 0 && percentage <= 100) {
            return percentage >= random.nextInt(100) + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        PrescriptionGenerator p = new PrescriptionGenerator();

        for (int i = 0; i < 10; i++) {
            System.out.println(p.isPrescriptionShow(50));
        }
    }

}

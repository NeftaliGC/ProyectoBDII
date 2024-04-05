package DataGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class GeneradorSalarios {
    public static void main(String[] args) {
        double[] salarios = generarSalarios(50, 4500, 8000);
	 System.out.println("Salarios generados:");
        System.out.println("------------------");
        imprimirSalarios(salarios);
        guardarSalariosEnArchivo(salarios, "salarios.txt");
    }

    public static double[] generarSalarios(int cantidad, double min, double max) {
        double[] salarios = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            salarios[i] = min + Math.random() * (max - min);
            salarios[i] = Math.round(salarios[i] * 100.0) / 100.0; // Redondear a dos decimales
        }
        return salarios;
    }

    public static void imprimirSalarios(double[] salarios) {
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < salarios.length; i++) {
            System.out.println(df.format(salarios[i]));
        }
    }

    public static void guardarSalariosEnArchivo(double[] salarios, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            DecimalFormat df = new DecimalFormat("#.00");
            for (double salario : salarios) {
                writer.write(df.format(salario) + "\n"); // Escribir cada precio en una línea separada
            }
            System.out.println("Salarios guardados en el archivo '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}


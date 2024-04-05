import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class GeneradorPrecios {
    public static void main(String[] args) {
        double[] precios = generarPrecios(1000, 50, 500);

        System.out.println("Precios generados:");
        System.out.println("------------------");
        imprimirPrecios(precios);

        guardarPreciosEnArchivo(precios, "precios.txt");
    }

    public static double[] generarPrecios(int cantidad, double min, double max) {
        double[] precios = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            precios[i] = min + Math.random() * (max - min);
            precios[i] = Math.round(precios[i] * 100.0) / 100.0; // Redondear a dos decimales
        }
        return precios;
    }

    public static void imprimirPrecios(double[] precios) {
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < precios.length; i++) {
            System.out.println(df.format(precios[i]));
        }
    }

    public static void guardarPreciosEnArchivo(double[] precios, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            DecimalFormat df = new DecimalFormat("#.00");
            for (double precio : precios) {
                writer.write(df.format(precio) + "\n"); // Escribir cada precio en una l�nea separada
            }
            System.out.println("Precios guardados en el archivo '" + nombreArchivo + "'.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}


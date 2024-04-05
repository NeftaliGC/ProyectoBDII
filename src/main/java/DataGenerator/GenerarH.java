package DataGenerator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarH {
    public static void main(String[] args) {
        generarArchivoCombinacionesHoras("combinaciones_horas.txt");
    }

    public static void generarArchivoCombinacionesHoras(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int hora = 0; hora < 24; hora++) {
                for (int minuto = 0; minuto < 60; minuto++) {
                    for (int segundo = 0; segundo < 60; segundo++) {
                        String horaFormateada = String.format("%02d:%02d:%02d", hora, minuto, segundo);
                        writer.write(horaFormateada);
                        writer.newLine();
                    }
                }
            }
            System.out.println("Archivo de combinaciones de horas generado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar el archivo de combinaciones de horas: " + e.getMessage());
        }
    }
}
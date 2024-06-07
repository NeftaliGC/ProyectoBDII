package DataGenerator;

import java.io.*;

public class GenerarHoras {


    public String getRandomHour() {
        // genera un numero aleatorio entre 1 y 86400
        int random = (int) (Math.random() * 86400) + 1;
        // abre el archivo de combinaciones de horas
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/combinaciones_horas.txt"))) {
            String hora = null;
            // lee el archivo de combinaciones de horas
            for (int i = 0; i < random; i++) {
                hora = reader.readLine();
            }
            return hora;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de combinaciones de horas: " + e.getMessage());
            return null;
        }
    }

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

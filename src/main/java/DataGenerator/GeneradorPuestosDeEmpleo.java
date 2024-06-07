package DataGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorPuestosDeEmpleo {
    public static void main(String[] args) {
        String[] puestosDeEmpleo = {
            "Farmacéutico",
            "Técnico de Farmacia",
            "Cajero",
            "Asistente de Ventas",
            "Gerente de Farmacia",
            "Personal de Almacén",
            "Atención al Cliente",
            "Técnico de Laboratorio",
            "Encargado de Marketing"
        };

        guardarPuestosDeEmpleoEnArchivo(puestosDeEmpleo, "puestos_de_empleo.txt");
        System.out.println("Puestos de empleo guardados en el archivo 'puestos_de_empleo.txt'.");
    }

    public static void guardarPuestosDeEmpleoEnArchivo(String[] puestosDeEmpleo, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (String puesto : puestosDeEmpleo) {
                writer.write(puesto + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

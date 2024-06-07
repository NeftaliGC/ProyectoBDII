package DataGenerator;

import java.util.Random;
import DataGenerator.DateGenerator;
public class RFCGenerator {

    String letters = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    String numbers = "1234567890";
    Random random = new Random();

    // Este método genera un RFC a partir de un nombre, apellido paterno y apellido materno
    String generateRFC(String nombre, String apellidoPaterno, String apellidoMaterno) {
        String rfc = "";
        rfc += apellidoPaterno.substring(0, 2);
        rfc += apellidoMaterno.substring(0, 1);
        rfc += nombre.substring(0, 1);
        rfc += new DateGenerator().generateRandomDate(false);
        System.out.printf("rfc: %s\n", rfc);
        rfc += generateHomoclave();

        rfc = rfc.toUpperCase();
        return rfc;
    }

    String generateRFC(String nombre, String apellidoPaterno) {
        String rfc = "";
        rfc += apellidoPaterno.substring(0, 2);
        rfc += nombre.substring(0, 1);
        rfc += getRandomLetter();
        rfc += new DateGenerator().generateRandomDate(false);
        rfc += generateHomoclave();

        rfc = rfc.toUpperCase();
        return rfc;
    }

    String generateRFC(String nombre) {
        String rfc = "";
        rfc += nombre.substring(0, 3);
        rfc += new DateGenerator().generateRandomDate(false);
        rfc += generateHomoclave();

        rfc = rfc.toUpperCase();
        return rfc;
    }

    // Este método genera una homoclave aleatoria
    private String generateHomoclave() {
        StringBuilder homoclave = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            homoclave.append(letters.charAt(random.nextInt(letters.length())));
        }
        homoclave.append(numbers.charAt(random.nextInt(numbers.length())));

        // System.out.println(homoclave); // Descomentar en caso de querer ver la homoclave generada (opcion de depuración)

        return homoclave.toString();
    }

    private char getRandomLetter() {
        return letters.charAt(random.nextInt(letters.length()));
    }


    public static void main(String[] args) {
        RFCGenerator rfcGenerator = new RFCGenerator();
        System.out.println(rfcGenerator.generateRFC("Jose", "Gomez", "Martinez"));
    }

}

package DataGenerator;

import java.util.Random;
import java.util.Calendar;
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
        rfc += generateBirthday();
        rfc += generateHomoclave();

        rfc = rfc.toUpperCase();
        return rfc;
    }

    String generateRFC(String nombre, String apellidoPaterno) {
        String rfc = "";
        rfc += apellidoPaterno.substring(0, 2);
        rfc += nombre.substring(0, 1);
        rfc += getRandomLetter();
        rfc += generateBirthday();
        rfc += generateHomoclave();

        rfc = rfc.toUpperCase();
        return rfc;
    }

    String generateRFC(String nombre) {
        String rfc = "";
        rfc += nombre.substring(0, 3);
        rfc += generateBirthday();
        rfc += generateHomoclave();

        rfc = rfc.toUpperCase();
        return rfc;
    }


    // Este método genera una fecha de nacimiento aleatoria
    private String generateBirthday() {
        String birthday = "";

        int year = random.nextInt(2025 - 1970) + 1970; // Genera un año entre 1970 y 2024
        int month = random.nextInt(12) + 1; // Genera un mes entre 1 y 12
        int maxDays = getMaxDays(year, month);
        int day = random.nextInt(maxDays) + 1; // Genera un día entre 1 y maxDays

        birthday += String.valueOf(year).substring(2, 4); // Año
        birthday += month < 10 ? "0" + month : month;   // Mes
        birthday += day < 10 ? "0" + day : day;         // Día

        /*System.out.println(year + "-" + month + "-" + day);
        System.out.println(birthday);*/
        // Descomentar en caso de querer ver la fecha de nacimiento generada (opcion de depuración)

        return birthday;
    }

    // Este método regresa el número máximo de días que tiene un mes en un año dado
    private static int getMaxDays(int year, int month) {
        int maxDays;

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);

        int i = (month == 4 || month == 6 || month == 9 || month == 11) ? 30 : 31; // Si el mes es 4, 6, 9 u 11, maxDays = 30, si no, maxDays = 31
        if (cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) {
            maxDays = (month == 2) ? 28 : i; // Si el año es bisiesto, maxDays = 28, si no, maxDays = i
        } else {
            maxDays = (month == 2) ? 29 : i; // Si el año no es bisiesto, maxDays = 29, si no, maxDays = i
        }
        return maxDays;
    }

    // Este método genera una homoclave aleatoria
    private String generateHomoclave() {
        StringBuilder homoclave = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            homoclave.append(letters.charAt(random.nextInt(letters.length())));
        }
        homoclave.append(numbers.charAt(random.nextInt(numbers.length())));

        // System.out.println(homoclave); // Descomentar en caso de querer ver la homoclave generada (opcion de depuración)

        return homoclave.toString();
    }

    private char getRandomLetter() {
        return letters.charAt(random.nextInt(letters.length()));
    }
}

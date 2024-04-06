package DataGenerator;

import java.util.Random;

public class DateGenerator {

    Random random = new Random();

    // Este método genera una fecha aleatoria en el formato "YYYY-MM-DD"
    public String generateRandomDate(boolean isFormatted) {
        int year = random.nextInt(2025 - 1970) + 1970; // Genera un año entre 1970 y 2024
        int month = random.nextInt(12) + 1; // Genera un mes entre 1 y 12
        int maxDays = getMaxDays(year, month);
        int day = random.nextInt(maxDays) + 1; // Genera un día entre 1 y maxDays

        if (isFormatted) {
            return String.format("%04d-%02d-%02d", year, month, day); // Formato "YYYY-MM-DD"
        } else {
            return String.format("%02d%02d%02d", year % 100, month, day); // Formato "YYMMDD"
        }
    }

    // Este método regresa el número máximo de días que tiene un mes en un año dado
    private static int getMaxDays(int year, int month) {
        switch (month) {
            case 2: // Febrero
                if (isLeapYear(year)) {
                    return 29; // Año bisiesto
                } else {
                    return 28; // Año no bisiesto
                }
            case 4: case 6: case 9: case 11: // Abril, junio, septiembre, noviembre
                return 30;
            default:
                return 31; // Enero, marzo, mayo, julio, agosto, octubre, diciembre
        }
    }

    // Este método verifica si un año es bisiesto
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

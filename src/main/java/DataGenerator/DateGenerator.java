package DataGenerator;
import java.util.Random;
import java.util.Calendar;

public class DateGenerator {

    Random random = new Random();

    // Este método genera una fecha de nacimiento aleatoria
    public String generateRandomDate(boolean isFormated) {
        String birthday = "";

        int year = random.nextInt(2025 - 1970) + 1970; // Genera un año entre 1970 y 2024
        int month = random.nextInt(12) + 1; // Genera un mes entre 1 y 12
        int maxDays = getMaxDays(year, month);
        int day = random.nextInt(maxDays) + 1; // Genera un día entre 1 y maxDays

        birthday += String.valueOf(year).substring(2, 4); // Año
        birthday += month < 10 ? "0" + month : month;   // Mes
        birthday += day < 10 ? "0" + day : day;         // Día
        if (isFormated) {
            String formattedDate = String.format("%04d-%02d-%02d", year, month, day);
            return formattedDate;
        }

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

}

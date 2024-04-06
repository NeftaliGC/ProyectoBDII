package DataGenerator;
import java.util.Random;

public class SatNumberGenerator {
    Random random = new Random();

    public String generateNumeroSerieSAT(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // Genera un dígito aleatorio
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 20; // Longitud del número de serie (puedes ajustar esto según tus necesidades)
        SatNumberGenerator generator = new SatNumberGenerator();
        String numeroSerieSAT = generator.generateNumeroSerieSAT(length);
        System.out.println("Número de serie del SAT generado: " + numeroSerieSAT);
    }
}

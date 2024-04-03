package DataGenerator;

import java.util.Random;
import java.util.HashSet;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class PostalCodeGenerator {
    Random random = new Random();
    HashSet<String> generatedCodes = new HashSet<String>();

    String generatePostalCode() {
        String postalCode = "";
        do {
            // Numero aleatorio entre 1 y 99
            int randomNum = random.nextInt(99) + 1;
            while (randomNum > 16 && randomNum < 20) {
                randomNum = random.nextInt(99) + 1;
            }
            postalCode = randomNum < 10 ? "0" + randomNum : Integer.toString(randomNum);

            int randomNum2 = random.nextInt(989) + 11; // Genera un número entre 11 y 999
            postalCode += randomNum2 < 100 ? "0" + randomNum2 : Integer.toString(randomNum2);
        } while (generatedCodes.contains(postalCode));
        
        generatedCodes.add(postalCode);
        return postalCode;
    }

    public static void main(String[] args) {
        PostalCodeGenerator postalCodeGenerator = new PostalCodeGenerator();
        try {
            PrintWriter writer = new PrintWriter(new File("postal_codes.txt"));
            for (int i = 0; i < 1000000; i++) {
                writer.println(postalCodeGenerator.generatePostalCode());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

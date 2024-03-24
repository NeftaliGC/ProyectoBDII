package DataGenerator;

import java.util.Random;

public class PostalCodeGenerator {
    Random random = new Random();

    String generatePostalCode() {
        String postalCode = "";
        // Numero aleatorio entre 1 y 99
        int randomNum = random.nextInt(99) + 1;
        while (randomNum > 16 && randomNum < 20) {
            randomNum = random.nextInt(99) + 1;
        }
        postalCode += randomNum < 10 ? "0" + randomNum : randomNum;

        int randomNum2 = random.nextInt(989) + 11; // Genera un número entre 11 y 999
        postalCode += randomNum2 < 100 ? "0" + randomNum2 : randomNum2;

        return postalCode;
    }

    public static void main(String[] args) {
        PostalCodeGenerator postalCodeGenerator = new PostalCodeGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(postalCodeGenerator.generatePostalCode());
        }
    }
}

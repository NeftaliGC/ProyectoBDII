package DataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
public class PhoneNumberGenerator {

    String numbers = "1234567890";
    Random random = new Random();

    String generatePhoneNumber(Boolean isCellphone) {
        String phoneNumber = "";
        for (int i = 0; i < 10; i++) {
            phoneNumber += numbers.charAt(random.nextInt(numbers.length()));
        }
        if (!isCellphone) {
            String lada = generateRandomLada();
            phoneNumber = lada + phoneNumber;
        }

        return phoneNumber;
    }

    String generateRandomLada() {
        String lada = "";
        String filePath = "src/main/resources/data/ladas.txt";
        int randomNum = random.nextInt(6) + 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int currentLine = 1;

            while ((lada = br.readLine()) != null) {
                if (currentLine == randomNum) {
                    break;
                }
                currentLine++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lada;
    }

    public static void main(String[] args) {

        PhoneNumberGenerator phoneNumberGenerator = new PhoneNumberGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(phoneNumberGenerator.generatePhoneNumber(false));
        }
    }
}

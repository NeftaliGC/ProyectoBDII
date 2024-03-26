package DataGenerator;

import java.io.*;
import java.util.Random;

public class ProvidersGenerator {

    Random random = new Random();

    String generateRandomProviderName() {
        String name = "";
        String filePath = "src/main/resources/data/namesProviders.txt";
        int randomNum = random.nextInt(10) + 1;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            int currentLine = 1;

            while ((name = br.readLine()) != null) {
                if (currentLine == randomNum) {
                    break;
                }
                currentLine++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return name;
    }

}

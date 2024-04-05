package DataGenerator;

import java.io.*;
import java.util.ArrayList;
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

    String[] getAllProvidersList() {
        String filePath = "src/main/resources/data/namesProviders.txt";
        ArrayList<String> nombres = new ArrayList<>();
        String name = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((name = br.readLine()) != null) {
                nombres.add(name);
            }

            String[] names = new String[nombres.size()];

            for (int i = 0; i < nombres.size(); i++) {
                names[i] = nombres.get(i);
            }

            br.close();
            return names;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

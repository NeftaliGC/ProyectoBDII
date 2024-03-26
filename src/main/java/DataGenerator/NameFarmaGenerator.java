package DataGenerator;

import java.io.*;
import java.util.Random;

public class NameFarmaGenerator {

    Random random = new Random();

    String generateRandomNameFarma() {
        String name = "";
        String filePath = "src/main/resources/data/namesFarmacias.txt";
        // Si se desea cambiar el rango de nombres, se debe cambiar el valor del random.nextInt
        int randomNum = random.nextInt(5) + 1;

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

    public static void main(String[] args) {
        NameFarmaGenerator nameFarmaGenerator = new NameFarmaGenerator();
        System.out.println(nameFarmaGenerator.generateRandomNameFarma());
    }

}

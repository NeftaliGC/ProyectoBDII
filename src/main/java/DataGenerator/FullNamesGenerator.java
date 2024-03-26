package DataGenerator;

import java.io.*;
import java.util.Random;

public class FullNamesGenerator {
    Random random = new Random();
    String[] generateFullName() {
        String[] fullName = new String[3];
        fullName[0] = generateRandomName_LastName("name");
        fullName[1] = generateRandomName_LastName("lastName");
        fullName[2] = generateRandomName_LastName("lastName");

        return fullName;
    }

    String generateRandomName_LastName(String opc) {
        // numero aleatorio entre 1 y 2000
        String name = "";
        String filePath;

        switch(opc) {
            case "lastName":
                filePath = "src/main/resources/data/lastNames.txt";
                break;
            case "name":
            default:
                filePath = "src/main/resources/data/names.txt";
        }

        int randomNum = random.nextInt(2000) + 1;

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
        FullNamesGenerator f = new FullNamesGenerator();
        String[] name = f.generateFullName();
        System.out.println(name[0] + " " + name[1] + " " + name[2]);

    }
}

package DataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmailGenerator {

    Random random = new Random();
    String simbols = ".-_";
    String numbers = "123456789";

    String generateEmail(String nombre, String apellidoPaterno, String apellidoMaterno) {
        String email = "";
        email += nombre.substring(0, 1);
        email += apellidoPaterno;
        email += apellidoMaterno.substring(0, 1);
        for (int i = 0; i < 1; i++) {
            if (random.nextBoolean()) {
                email += simbols.charAt(random.nextInt(simbols.length()));
                email += numbers.charAt(random.nextInt(numbers.length()));
                email += numbers.charAt(random.nextInt(numbers.length()));
            }
        }

        email += "@";
        email += generateDomain();

        email = email.toLowerCase();


        return email;
    }

    private String generateDomain() {
        String domain = "";
        List<String> domains = new ArrayList<>();
        try {
            String filePath = "src/main/resources/data/domains.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = br.readLine()) != null) {
                domains.add(line);
            }
            br.close();
            int randomNum = random.nextInt(domains.size());
            domain = domains.get(randomNum);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return domain;
    }

    public static void main(String[] args) {
        EmailGenerator emailGenerator = new EmailGenerator();
        for (int i = 0; i < 20; i++) {
            String[] fullName = new FullNamesGenerator().generateFullName();
            System.out.println(emailGenerator.generateEmail(fullName[0], fullName[1], fullName[2]));
        }
    }
}

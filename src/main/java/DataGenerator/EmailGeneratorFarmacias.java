package DataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmailGeneratorFarmacias {

    Random random = new Random();
    String simbols = ".-_";
    String numbers = "123456789";

    String generatePersonalEmail(String farmaciaName) {
        String email = "";
        email += farmaciaName.toLowerCase().replaceAll("\\s+", "");
        email += generateRandomString(3);

        email += generateDomain();

        return email;
    }

    public String generateProfessionalEmail(String farmaciaName) {
        String email = "provider";
        email += "@" + farmaciaName.toLowerCase().replaceAll("\\s+", "");

        email += ".com";

        return email;
    }

    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(simbols.charAt(random.nextInt(simbols.length())));
        }
        return sb.toString();
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

        domain = "@" + domain;

        return domain;
    }

    public static void main(String[] args) {
        EmailGeneratorFarmacias emailGenerator = new EmailGeneratorFarmacias();
        for (int i = 0; i < 20; i++) {
            String farmaciaName = new NameFarmaGenerator().generateRandomNameFarma();
            System.out.println(emailGenerator.generateProfessionalEmail(farmaciaName));
        }
    }
}

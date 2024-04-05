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

    // Este metodo genera un correo personal a partir de un nombre y apellidos
    String generatePersonalEmail(String nombre, String apellidoPaterno, String apellidoMaterno) {
        String email = "";
        email += nombre.substring(0, 1);
        email += apellidoPaterno.substring(0,3);
        email += apellidoMaterno.substring(0, 1);
        for (int i = 0; i < 1; i++) {
            if (random.nextBoolean()) {
                email += simbols.charAt(random.nextInt(simbols.length()));
                email += numbers.charAt(random.nextInt(numbers.length()));
                email += numbers.charAt(random.nextInt(numbers.length()));
            }
        }

        email += generateDomain();

        email = email.toLowerCase();


        return email;
    }

    // Este metodo genera un correo profesional a partir del nombre de la empresa
    public String generateProfessionalEmail(String company) {
        String email = "provider";
        email += "@";

        // Debido a que las tendran un dominio personalizado, se tomara el nombre de la empresa
        if (company.contains(" ")) {
            // Si el nombre de la empresa tiene espacios, se separa en partes
            String[] parts = company.split(" ");
            // Por consideracion de la longitud se tomara el nombre en primera posicion de la compania
            email += parts[1].toLowerCase();
        } else {
            // Si no tiene espacios, se toma el nombre completo
            email += company.toLowerCase();
        }

        email += ".com";

        return email;
    }


    // Este metodo genera un dominio aleatorio
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
        EmailGenerator emailGenerator = new EmailGenerator();
        for (int i = 0; i < 20; i++) {
            String fullName = new ProvidersGenerator().generateRandomProviderName();
            System.out.println(emailGenerator.generateProfessionalEmail( fullName));
        }
    }
}

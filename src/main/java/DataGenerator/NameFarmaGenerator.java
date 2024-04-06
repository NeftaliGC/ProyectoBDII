package DataGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameFarmaGenerator {

    Random random = new Random();
    List<String> farmaciaNames = new ArrayList<>();

    public NameFarmaGenerator() {
        try {
            String filePath = "src/main/resources/data/namesFarmacias.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String name;
            while ((name = br.readLine()) != null) {
                farmaciaNames.add(name);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String generateRandomNameFarma() {
        if (farmaciaNames.isEmpty()) {
            // Si la lista está vacía, recargar los nombres de farmacias
            reloadFarmaciaNames();
        }
        int randomIndex = random.nextInt(farmaciaNames.size());
        return farmaciaNames.remove(randomIndex);
    }

    private void reloadFarmaciaNames() {
        farmaciaNames.clear();
        try {
            String filePath = "src/main/resources/data/namesFarmacias.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String name;
            while ((name = br.readLine()) != null) {
                farmaciaNames.add(name);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NameFarmaGenerator nameFarmaGenerator = new NameFarmaGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.println(nameFarmaGenerator.generateRandomNameFarma());
        }
    }
}

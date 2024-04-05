/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import DataGenerator.objectsDb.Category;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jesus
 */
public class CategoryGenerator {

    private final List<Category> categories;
    private final static Random RANDOM = new Random();

    private final String path = "src/main/resources/data/categories.txt";

    public CategoryGenerator() {
        categories = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(Paths.get(path));

            while (scanner.hasNext()) {
                String categoryLine[] = scanner.nextLine().split("@");

                if (categoryLine[0].equals("#")) {
                    break;
                } else {
                    categories.add(
                            new Category(
                                    categoryLine[0].trim(),
                                    categoryLine[1].trim()));
                }

            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public String getDescription(String categoryName) {
        String res = null;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                res = category.getDescription();
                break;
            }
        }
        return res;
    }

    public String getRandomCategoryName() {
        return categories.get(
                RANDOM.nextInt(
                        categories.size())).getName();
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public static void main(String[] args) {
        CategoryGenerator c = new CategoryGenerator();
        String cat = c.getRandomCategoryName();
        String desc = c.getDescription(cat);
        System.out.println(cat + " - " + desc);
    }
}

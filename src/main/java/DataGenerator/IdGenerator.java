/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataGenerator;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class IdGenerator {

    private final static char ALPHABET[]
            = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z'};

    private final static char NUMBERS[]
            = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static final int ALPHABETICAL = 0;
    public static final int NUMERICAL = 1;
    public static final int ALPHANUMERIC = 2;

    public IdGenerator() {

    }

    public String getID(int length, int type) {
        StringBuilder builder = new StringBuilder(length);
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            switch (type) {
                case ALPHABETICAL:
                    builder.append(ALPHABET[r.nextInt(ALPHABET.length)]);
                    break;
                case NUMERICAL:
                    builder.append(NUMBERS[r.nextInt(NUMBERS.length)]);
                    break;
                case ALPHANUMERIC:
                    if (r.nextBoolean()) {
                        builder.append(ALPHABET[r.nextInt(ALPHABET.length)]);
                    } else {
                        builder.append(NUMBERS[r.nextInt(NUMBERS.length)]);
                    }
                    break;

            }
        }
        return builder.toString().toUpperCase();
    }
    
    public static void main(String[] args) {
        IdGenerator id = new IdGenerator();
        
        String r = id.getID(20, NUMERICAL);
        System.out.println(r);
        
        r = id.getID(10, ALPHABETICAL);
        System.out.println(r);
        
        r = id.getID(5, ALPHANUMERIC);
        System.out.println(r);
    }
}

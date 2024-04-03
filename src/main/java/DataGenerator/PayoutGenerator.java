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
public class PayoutGenerator {

    /**
     * Separe los tipos de pago en caso de que se pretendan hacer 
     * comparaciones en un futuro, solo se deben de poner como
     * publicos las constantes.
     */
    private final static String CREDIT_CARD = "tarjeta de crédito";
    private final static String DEBIT_CARD = "tarjeta de débito";
    private final static String CASH = "efectivo";
    private final static String WIRE_TRANSFER = "transferencia bancaria";
    private final static String BANK_DEPOSIT = "deposito bancario";
    private final static String PAYPAL = "PayPal";
    private final static String PAYMENT_COUPON = "cupón de pago";

    private final static String PAYS[] = {
        CREDIT_CARD,
        DEBIT_CARD,
        CASH,
        WIRE_TRANSFER,
        BANK_DEPOSIT,
        PAYPAL,
        PAYMENT_COUPON,};
    
    
    private static final Random RANDOM = new Random();

    public PayoutGenerator() {
        //Solo para tener constructor por defecto
    }

    /**
     *
     * @return se obtiene un tipo de dato aleatorio
     */
    public String getRandomPayout() {
        return PAYS[RANDOM.nextInt(PAYS.length)];
    }

    public String[] getAllPayouts() {
        return PAYS;
    }

    public static void main(String[] args) {
        PayoutGenerator p = new PayoutGenerator();
        
        System.out.println(p.getRandomPayout());
        
        String all[] = p.getAllPayouts();
        
        for (String pay : all) {
            System.out.println(pay);
        }
    }
}

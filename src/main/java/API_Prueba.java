/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Webotes
 */
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class API_Prueba {

    public static void main(String[] args) {
        String apiUrl = "http://172.26.52.36:8000/desgloseCompletoVentasProductoGrafico"; // URL de tu API

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                byte[] imageBytes = EntityUtils.toByteArray(entity);
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

                if (image != null) {
                    // Mostrar la imagen en un JFrame
                    ImageIcon icon = new ImageIcon(image);
                    JLabel label = new JLabel(icon);
                    JFrame frame = new JFrame();
                    frame.setTitle("Gráfica");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.getContentPane().add(label, BorderLayout.CENTER);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } else {
                    System.err.println("No se pudo convertir la respuesta en una imagen.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
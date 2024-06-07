package main.java.ProyectoDB.backend.API;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class API {
    
    private String FechaIni;
    private String FechaFin;
    
    public API(String FechaIni,String FechaFin){
        this.FechaIni=FechaIni;
        this.FechaFin=FechaFin;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Da fecha Inicial");
        String FechaIni=sc.nextLine();
        System.out.println("Da fecha Final");
        String FechaFin=sc.nextLine();
        //String apiUrl="http://172.26.52.36:8000/denserankingVentasGrafico?fecha_inicio=2000-09-28&fecha_fin=2008-08-01";
        String encodedFechaIni = URLEncoder.encode(FechaIni, StandardCharsets.UTF_8);
        String encodedFechaFin = URLEncoder.encode(FechaFin, StandardCharsets.UTF_8);
        String apiUrl = "http://172.26.52.36:8000/denserankingVentasGrafico?fecha_inicio=" + encodedFechaIni + "&fecha_fin=" + encodedFechaFin;
        
 

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

                    frame.setTitle("Grafica");
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

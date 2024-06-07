package ProyectoDB.backend.API;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class API {

    public static void main(String[] args) {
        String apiUrl = "http://172.26.52.36:8000/desgloseCompletoVentasProductoGrafico"; // URL de tu API

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONObject jsonResponse = new JSONObject(result);

                // Suponiendo que la respuesta JSON contiene los datos necesarios para la gráfica
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                jsonResponse.getJSONArray("data").forEach(item -> {
                    JSONObject dataPoint = (JSONObject) item;
                    dataset.addValue(dataPoint.getDouble("value"), "Series1", dataPoint.getString("category"));
                });

                JFreeChart barChart = ChartFactory.createBarChart(
                        "Gráfica de Ejemplo",
                        "Categoría",
                        "Valor",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true, true, false);

                ChartPanel chartPanel = new ChartPanel(barChart);
                chartPanel.setPreferredSize(new Dimension(800, 600));

                JFrame frame = new JFrame();
                frame.setTitle("Gráfica");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(chartPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
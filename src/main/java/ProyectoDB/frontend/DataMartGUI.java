package ProyectoDB.frontend;

import javax.swing.*;
import java.awt.*;

public class DataMartGUI extends JFrame {
    private JLabel imageLabel;

    public DataMartGUI() {
        imageLabel = new JLabel();
        add(imageLabel);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

        // Cargamos la imagen al iniciar la GUI
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/flower.png")); // Asegúrese de que esta es la ruta correcta a su imagen
        setImage(imageIcon);
    }

    public void setImage(ImageIcon imageIcon) {
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        new DataMartGUI();
    }
}
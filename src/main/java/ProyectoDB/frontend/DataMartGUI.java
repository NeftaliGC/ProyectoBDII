package ProyectoDB.frontend;

import javax.swing.*;
import java.awt.*;

public class DataMartGUI extends JFrame {
    private JLabel imageLabel;
    private JPanel panel;

    public DataMartGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
        imageLabel.setIcon(new ImageIcon(DataMartGUI.class.getResource("/images/flower.png")));

        panel = new JPanel();
        panel.add(imageLabel);

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void setImage(ImageIcon imageIcon) {
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        new DataMartGUI();
    }
}
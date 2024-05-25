import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ventana_Ventas {
	public Ventana_Ventas(Connection connection) {
        this.connection = connection;
        initialize();
    	}

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventas");

        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);

        JPanel panelBotones = new JPanel(new GridBagLayout());
        panelBotones.setBackground(new Color(173, 216, 230)); // Establecer el color de fondo aquí

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(25, 25, 25, 25);

        JLabel tituloLabel = new JLabel("Ventas");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panelBotones.add(tituloLabel, gbc);

        String[] textosBotones = {"Dar de alta", "Dar de baja", "Cambios", "Consultas", "Reportes(Datamart)"};

        for (int i = 0; i < 5; i++) {
            JButton boton = new JButton(textosBotones[i]);
            panelBotones.add(boton, gbc);

            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String textoBoton = ((JButton) e.getSource()).getText();
                    System.out.println(textoBoton);
                    switch (textoBoton) {
                        case "Dar de alta":
                            //new ();
                            break;
                        case "Dar de baja":
                            //new();
                            break;
                        case "Cambios":
                            //new();
                            break;
                        case "Consultas":
                            //new();
                            break;
                        case "Reportes(Datamart)":
                            //new();
                            break;
                    }
                }
            });
        }

        ventana.add(panelBotones);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}


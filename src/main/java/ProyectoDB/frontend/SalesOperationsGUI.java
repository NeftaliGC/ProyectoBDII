package ProyectoDB.frontend;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalesOperationsGUI extends JFrame {
    private Connection connection;

    public SalesOperationsGUI(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void regresarAlMainPanel() {
        MainPanelGUI ventanaMainGui = new MainPanelGUI(connection);
        ventanaMainGui.setVisible(true);
        dispose();
    }

    private void initialize() {
        setTitle("Main Panel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblWelcome = new JLabel("Bienvenido de operaciones!");
        lblWelcome.setBounds(200, 50, 200, 30);
        panel.add(lblWelcome);

        JButton btnAltaVentas = new JButton("Alta Ventas");
        btnAltaVentas.setBounds(200, 100, 200, 50);
        panel.add(btnAltaVentas);

        btnAltaVentas.addActionListener(e -> {
            HighSalesGUI altaVentasGUI = new HighSalesGUI(connection);
            altaVentasGUI.setVisible(true);
            this.dispose(); // Cierra el panel principal después de abrir AltaVentasGUI
        });
        
        // Botón para regresar al panel principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(new Color(28, 232, 49));
        btnRegresar.setBounds(150, 200, 283, 50);
        panel.add(btnRegresar);

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regresarAlMainPanel();
            }
        }); // Aquí es donde faltaba el paréntesis
    }
}

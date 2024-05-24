package ProyectoDB;

import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanelGUI extends JFrame {
    private Connection connection;

    public MainPanelGUI(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void initialize() {
        setTitle("Main Panel");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblWelcome = new JLabel("Bienvenido al panel principal!");
        lblWelcome.setBounds(200, 50, 200, 30);
        panel.add(lblWelcome);

        JButton btnAltaVentas = new JButton("Operaciones en Ventas");
        btnAltaVentas.setBounds(200, 100, 200, 50);
        panel.add(btnAltaVentas);

        btnAltaVentas.addActionListener(e -> {
            SalesOperationsGUI ventasOperacionesGUI = new SalesOperationsGUI(connection);
            ventasOperacionesGUI.setVisible(true);
            this.dispose();
        });
    }
}
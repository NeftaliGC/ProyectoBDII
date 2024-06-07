package ProyectoDB.frontend;

import ProyectoDB.frontend.MainPanelGUI;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class InventarioAltaGUI extends JFrame implements ActionListener {

    private Connection connection;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JButton btnBuscarTicket;
    private JButton btnBuscarFarmacia;
    private JButton btnBuscarEmpleado;

    public InventarioAltaGUI(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void regresarAlMainPanel() {
        MainPanelGUI ventanaMainGui = new MainPanelGUI(connection);
        ventanaMainGui.setVisible(true);
        dispose();
    }

    private void initialize() {
        setTitle("Alta de Inventario");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        panel.setBackground(new Color(240, 240, 240));

        JLabel lblIdentificadorV = new JLabel("Identificador de venta:");
        lblIdentificadorV.setBounds(50, 50, 150, 30);
        lblIdentificadorV.setForeground(Color.BLACK);
        lblIdentificadorV.setFont(new Font("Arial", Font.PLAIN, 12));
        lblIdentificadorV.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblIdentificadorV);

        JLabel lblCantidadV = new JLabel("Cantidad vendida:");
        lblCantidadV.setBounds(50, 100, 150, 30);
        lblCantidadV.setForeground(Color.BLACK);
        lblCantidadV.setFont(new Font("Arial", Font.PLAIN, 12));
        lblCantidadV.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblCantidadV);

        JLabel lblReceta = new JLabel("Receta:");
        lblReceta.setBounds(50, 150, 150, 30);
        lblReceta.setForeground(Color.BLACK);
        lblReceta.setFont(new Font("Arial", Font.PLAIN, 12));
        lblReceta.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblReceta);

        JLabel lblTicket = new JLabel("Ticket:");
        lblTicket.setBounds(50, 200, 150, 30);
        lblTicket.setForeground(Color.BLACK);
        lblTicket.setFont(new Font("Arial", Font.PLAIN, 12));
        lblTicket.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblTicket);

        JLabel lblFarmacia = new JLabel("Farmacia:");
        lblFarmacia.setBounds(50, 250, 150, 30);
        lblFarmacia.setForeground(Color.BLACK);
        lblFarmacia.setFont(new Font("Arial", Font.PLAIN, 12));
        lblFarmacia.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblFarmacia);

        JLabel lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setBounds(50, 300, 150, 30);
        lblEmpleado.setForeground(Color.BLACK);
        lblEmpleado.setFont(new Font("Arial", Font.PLAIN, 12));
        lblEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(lblEmpleado);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(200, 350, 100, 30);
        btnGuardar.addActionListener(this);
        panel.add(btnGuardar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(320, 350, 100, 30);
        btnCancelar.addActionListener(this);
        panel.add(btnCancelar);

        btnBuscarTicket = new JButton("Buscar");
        btnBuscarTicket.setBounds(400, 200, 80, 30);
        btnBuscarTicket.addActionListener(this);
        panel.add(btnBuscarTicket);

        btnBuscarFarmacia = new JButton("Buscar");
        btnBuscarFarmacia.setBounds(400, 250, 80, 30);
        btnBuscarFarmacia.addActionListener(this);
        panel.add(btnBuscarFarmacia);

        btnBuscarEmpleado = new JButton("Buscar");
        btnBuscarEmpleado.setBounds(400, 300, 80, 30);
        btnBuscarEmpleado.addActionListener(this);
        panel.add(btnBuscarEmpleado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            // Lógica para guardar los datos en la base de datos
            // ...
        } else if (e.getSource() == btnCancelar) {
            regresarAlMainPanel();
        } else if (e.getSource() == btnBuscarTicket) {
            // Lógica para buscar por ticket
            // ...
        } else if (e.getSource() == btnBuscarFarmacia) {
            // Lógica para buscar por farmacia
            // ...
        } else if (e.getSource() == btnBuscarEmpleado) {
            // Lógica para buscar por empleado
            // ...
        }
    }
}
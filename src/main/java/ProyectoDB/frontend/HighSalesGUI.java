package ProyectoDB.frontend;

import ProyectoDB.frontend.SalesOperationsGUI;
import ProyectoDB.frontend.SearchEmployeeGUI;
import ProyectoDB.frontend.SearchPharmacyGUI;
import ProyectoDB.frontend.SearchTicketGUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class HighSalesGUI extends JFrame {
    private JTextField textFieldCantidad;
    JCheckBox checkBoxSi = new JCheckBox("Sí");
    JCheckBox checkBoxNo = new JCheckBox("No");
    JCheckBox checkBoxReceta = new JCheckBox("Receta");
    private static Connection connection;

    int xx, xy;

    public HighSalesGUI(Connection connection) {
        this.connection = connection;
        initialize();
    }

    private void initialize() {

        // Configuración de la ventana principal
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 450);
        setLocationRelativeTo(null);
        setUndecorated(true);

        // Panel principal
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear el panel
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 350, 450);
        contentPane.add(panel);
        panel.setLayout(null);

        // Crear la etiqueta para la imagen
        JLabel label = new JLabel();
        label.setBounds(0, 0, 420, 450); // Tamaño proporcionado

        // Cargar la imagen desde un archivo
        try {
            BufferedImage image = ImageIO.read(new File("src/main/resources/images/flowers.jpeg")); // Ruta de la imagen
            ImageIcon imageIcon = new ImageIcon(image);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Añadir la etiqueta al panel
        panel.add(label);
        
        // TextField para la cantidad vendida
        JLabel lblCantidad = new JLabel("Cantidad Vendida:");
        lblCantidad.setBounds(395, 20, 200, 14);
        contentPane.add(lblCantidad);

        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(395, 40, 283, 36);
        contentPane.add(textFieldCantidad);
        textFieldCantidad.setColumns(10);

        // Buscador para los tickets
        JLabel lblTicket = new JLabel("Ticket:");
        lblTicket.setBounds(395, 80, 200, 14);
        contentPane.add(lblTicket);

        JButton btnSearchTicket = new JButton("Buscar Ticket");
        btnSearchTicket.setForeground(Color.WHITE);
        btnSearchTicket.setBackground(new Color(30, 144, 255));
        btnSearchTicket.setBounds(395, 100, 283, 36);
        contentPane.add(btnSearchTicket);

        btnSearchTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchTicketGUI buscadorTicket = new SearchTicketGUI(connection, null);
                buscadorTicket.setVisible(true);
            }
        });

        // Buscador para las farmacias
        JLabel lblFarmacia = new JLabel("Farmacia:");
        lblFarmacia.setBounds(395, 140, 200, 14);
        contentPane.add(lblFarmacia);

        JButton btnSearchPharmacy = new JButton("Buscar Farmacia");
        btnSearchPharmacy.setForeground(Color.WHITE);
        btnSearchPharmacy.setBackground(new Color(30, 144, 255));
        btnSearchPharmacy.setBounds(395, 160, 283, 36);
        contentPane.add(btnSearchPharmacy);

        btnSearchPharmacy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchPharmacyGUI buscadorFarmacia = new SearchPharmacyGUI(connection);
                buscadorFarmacia.setVisible(true);
            }
        });

        // Buscador para los empleados
        JLabel lblEmpleado = new JLabel("Empleado:");
        lblEmpleado.setBounds(395, 200, 200, 14);
        contentPane.add(lblEmpleado);

        JButton btnSearchEmployee = new JButton("Buscar Empleado");
        btnSearchEmployee.setForeground(Color.WHITE);
        btnSearchEmployee.setBackground(new Color(30, 144, 255));
        btnSearchEmployee.setBounds(395, 220, 283, 36);
        contentPane.add(btnSearchEmployee);

        btnSearchEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchEmployeeGUI buscadorEmpleado = new SearchEmployeeGUI(connection);
                buscadorEmpleado.setVisible(true);
            }
        });

        // CheckBox para la receta
        JLabel lblReceta = new JLabel("¿Requiere Receta?");
        lblReceta.setBounds(395, 260, 200, 14);
        contentPane.add(lblReceta);

        // Checkbox para "Sí"
        JCheckBox checkBoxSi = new JCheckBox("Sí");
        checkBoxSi.setBounds(395, 280, 50, 20);
        contentPane.add(checkBoxSi);

        // Checkbox para "No"
        JCheckBox checkBoxNo = new JCheckBox("No");
        checkBoxNo.setBounds(455, 280, 50, 20);
        contentPane.add(checkBoxNo);

        // Agregar un ActionListener a checkBoxSi
        checkBoxSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxSi.isSelected()) {
                    checkBoxNo.setSelected(false); // Deseleccionar checkBoxNo si checkBoxSi está seleccionado
                    checkBoxReceta.setText("Sí"); // Actualizar el texto de checkBoxReceta
                    System.out.println("checkBoxReceta guarda: " + checkBoxReceta.getText()); // Imprimir en la consola lo que guarda checkBoxReceta
                } else {
                    checkBoxReceta.setText("No"); // Actualizar el texto de checkBoxReceta si checkBoxSi no está seleccionado
                    System.out.println("checkBoxReceta guarda: " + checkBoxReceta.getText()); // Imprimir en la consola lo que guarda checkBoxReceta
                }
            }
        });

        // Agregar un ActionListener a checkBoxNo
        checkBoxNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxNo.isSelected()) {
                    checkBoxSi.setSelected(false); // Deseleccionar checkBoxSi si checkBoxNo está seleccionado
                    checkBoxReceta.setText("No"); // Actualizar el texto de checkBoxReceta
                    System.out.println("checkBoxReceta guarda: " + checkBoxReceta.getText()); // Imprimir en la consola lo que guarda checkBoxReceta
                } else {
                    checkBoxReceta.setText("Sí"); // Actualizar el texto de checkBoxReceta si checkBoxNo no está seleccionado
                    System.out.println("checkBoxReceta guarda: " + checkBoxReceta.getText()); // Imprimir en la consola lo que guarda checkBoxReceta
                }
            }
        });

        // Botón para dar de alta la venta
        JButton btnAltaVenta = new JButton("Dar de Alta Venta");
        btnAltaVenta.setForeground(Color.WHITE);
        btnAltaVenta.setBackground(new Color(241, 57, 83));
        btnAltaVenta.setBounds(395, 320, 283, 50);
        contentPane.add(btnAltaVenta);

        btnAltaVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                darDeAltaVenta();
            }
        });

        // Botón para regresar al panel principal
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBackground(new Color(28, 232, 49));
        btnRegresar.setBounds(395, 380, 283, 50);
        contentPane.add(btnRegresar);

        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regresarAlVentasPanel();
            }
        });

        // Botón para cerrar la ventana
        JLabel lblClose = new JLabel("X");
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0);
            }
        });

        lblClose.setHorizontalAlignment(SwingConstants.CENTER);
        lblClose.setForeground(new Color(241, 57, 83));
        lblClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblClose.setBounds(691, 0, 37, 27);
        contentPane.add(lblClose);
    }

    private void darDeAltaVenta() {
        try {
            String cantidad = textFieldCantidad.getText();
            // Placeholder values for ticket, farmacia, and empleado until integrated with search functionality
            String ticket = "ticket_id"; // Replace with actual value
            String farmacia = "pharmacy_id"; // Replace with actual value
            String empleado = "employee_id"; // Replace with actual value
            boolean requiereReceta = checkBoxReceta.getText().equals("Sí");
    
            // Usar una secuencia para el campo id
            String insertQuery = "INSERT INTO ventas (id, cantidad, ticket, farmacia, empleado, receta) VALUES (nextval('ventas_id_seq'), ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setString(1, cantidad);
            pst.setString(2, ticket);
            pst.setString(3, farmacia);
            pst.setString(4, empleado);
            pst.setBoolean(5, requiereReceta);
    
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Venta registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la venta.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al registrar la venta: " + e.getMessage());
        }
    }

    private void regresarAlVentasPanel() {
        SalesOperationsGUI ventaSalesOperationsGUI = new SalesOperationsGUI(connection);
        ventaSalesOperationsGUI.setVisible(true);
        dispose();
    }

    public void setTicketID(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTicketID'");
    }
}

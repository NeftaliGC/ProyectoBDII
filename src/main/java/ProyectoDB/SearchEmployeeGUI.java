package ProyectoDB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchEmployeeGUI extends JFrame {
    private Connection connection;
    private JTextField rfcField, nombreField, primerApellidoField, correoElectronicoField;
    private JTextArea resultArea;

    public SearchEmployeeGUI(Connection connection) {
        this.connection = connection;

        setTitle("Búsqueda de Empleados");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                    null, "¿Estás seguro que quieres salir?", 
                    "Confirmación", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == 0) {
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    dispose();
                }
            }
        });

        setSize(650, 450);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblRfc = new JLabel("RFC:");
        lblRfc.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblRfc.setBounds(20, 20, 200, 25);
        contentPane.add(lblRfc);

        rfcField = new JTextField();
        rfcField.setBounds(180, 20, 150, 25);
        rfcField.setColumns(10);
        rfcField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(rfcField);
            }
        });
        contentPane.add(rfcField);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombre.setBounds(20, 50, 200, 25);
        contentPane.add(lblNombre);

        nombreField = new JTextField();
        nombreField.setBounds(180, 50, 150, 25);
        nombreField.setColumns(10);
        nombreField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(nombreField);
            }
        });
        contentPane.add(nombreField);

        JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
        lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPrimerApellido.setBounds(20, 80, 200, 25);
        contentPane.add(lblPrimerApellido);

        primerApellidoField = new JTextField();
        primerApellidoField.setBounds(180, 80, 150, 25);
        primerApellidoField.setColumns(10);
        primerApellidoField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(primerApellidoField);
            }
        });
        contentPane.add(primerApellidoField);

        JLabel lblCorreoElectronico = new JLabel("Correo Electrónico:");
        lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCorreoElectronico.setBounds(20, 110, 200, 25);
        contentPane.add(lblCorreoElectronico);

        correoElectronicoField = new JTextField();
        correoElectronicoField.setBounds(180, 110, 150, 25);
        correoElectronicoField.setColumns(10);
        correoElectronicoField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(correoElectronicoField);
            }
        });
        contentPane.add(correoElectronicoField);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBuscar.setBackground(new Color(28, 232, 49));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(300, 150, 100, 30);
        btnBuscar.addActionListener(e -> buscarEmpleados());
        contentPane.add(btnBuscar);

        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBounds(10, 200, 620, 150);
        contentPane.add(resultPanel);
        resultPanel.setLayout(new BorderLayout(0, 0));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Tahoma", Font.PLAIN, 12));
        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    private void disableFields(JTextField field) {
        rfcField.setEnabled(field == rfcField);
        nombreField.setEnabled(field == nombreField);
        primerApellidoField.setEnabled(field == primerApellidoField);
        correoElectronicoField.setEnabled(field == correoElectronicoField);
    }

    private void enableFields() {
        rfcField.setEnabled(true);
        nombreField.setEnabled(true);
        primerApellidoField.setEnabled(true);
        correoElectronicoField.setEnabled(true);
    }

    private void buscarEmpleados() {
        String rfc = rfcField.getText();
        String nombre = nombreField.getText();
        String primerApellido = primerApellidoField.getText();
        String correoElectronico = correoElectronicoField.getText();

        String query = "SELECT * FROM empleado WHERE 1=1";

        if (!rfc.isEmpty()) {
            query += " AND rfc = '" + rfc + "'";
        }

        if (!nombre.isEmpty()) {
            query += " AND nombre ILIKE '%" + nombre + "%'";
        }

        if (!primerApellido.isEmpty()) {
            query += " AND primer_apellido ILIKE '%" + primerApellido + "%'";
        }

        if (!correoElectronico.isEmpty()) {
            query += " AND correo_electronico ILIKE '%" + correoElectronico + "%'";
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            resultArea.setText("");
            while (rs.next()) {
                resultArea.append("RFC: " + rs.getString("rfc") + "\n");
                resultArea.append("Nombre: " + rs.getString("nombre") + "\n");
                resultArea.append("Primer Apellido: " + rs.getString("primer_apellido") + "\n");
                resultArea.append("Segundo Apellido: " + rs.getString("segundo_apellido") + "\n");
                resultArea.append("Teléfono: " + rs.getLong("telefono") + "\n");
                resultArea.append("Correo Electrónico: " + rs.getString("correo_electronico") + "\n");
                resultArea.append("Dirección: " + rs.getString("direccion") + "\n");
                resultArea.append("Código Postal: " + rs.getInt("codigo_postal") + "\n");
                resultArea.append("ID Empleado: " + rs.getString("id_empleado") + "\n");
                resultArea.append("Fecha Contratación: " + rs.getDate("fecha_contratacion") + "\n");
                resultArea.append("ID Empleo: " + rs.getInt("id_empleo") + "\n");
                resultArea.append("ID Farmacia: " + rs.getString("id_farmacia") + "\n");
                resultArea.append("-------------------\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private abstract class SimpleDocumentListener implements DocumentListener {
        public void insertUpdate(DocumentEvent e) { update(); }
        public void removeUpdate(DocumentEvent e) { update(); }
        public void changedUpdate(DocumentEvent e) { update(); }
        public abstract void update();
    }
}

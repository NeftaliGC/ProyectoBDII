package ProyectoDB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchPharmacyGUI extends JFrame {
    private Connection connection;
    private JTextField idFarmaciaField, nombreFarmaciaField, correoElectronicoField, telefonoField;
    private JTextArea resultArea;

    public SearchPharmacyGUI(Connection connection) {
        this.connection = connection;

        setTitle("Búsqueda de Farmacias");
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

        JLabel lblIdFarmacia = new JLabel("ID Farmacia:");
        lblIdFarmacia.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblIdFarmacia.setBounds(20, 20, 200, 25);
        contentPane.add(lblIdFarmacia);

        idFarmaciaField = new JTextField();
        idFarmaciaField.setBounds(180, 20, 150, 25);
        idFarmaciaField.setColumns(10);
        idFarmaciaField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(idFarmaciaField);
            }
        });
        contentPane.add(idFarmaciaField);

        JLabel lblNombreFarmacia = new JLabel("Nombre Farmacia:");
        lblNombreFarmacia.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNombreFarmacia.setBounds(20, 50, 200, 25);
        contentPane.add(lblNombreFarmacia);

        nombreFarmaciaField = new JTextField();
        nombreFarmaciaField.setBounds(180, 50, 150, 25);
        nombreFarmaciaField.setColumns(10);
        nombreFarmaciaField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(nombreFarmaciaField);
            }
        });
        contentPane.add(nombreFarmaciaField);

        JLabel lblCorreoElectronico = new JLabel("Correo Electrónico:");
        lblCorreoElectronico.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCorreoElectronico.setBounds(20, 80, 200, 25);
        contentPane.add(lblCorreoElectronico);

        correoElectronicoField = new JTextField();
        correoElectronicoField.setBounds(180, 80, 150, 25);
        correoElectronicoField.setColumns(10);
        correoElectronicoField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(correoElectronicoField);
            }
        });
        contentPane.add(correoElectronicoField);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTelefono.setBounds(20, 110, 200, 25);
        contentPane.add(lblTelefono);

        telefonoField = new JTextField();
        telefonoField.setBounds(180, 110, 150, 25);
        telefonoField.setColumns(10);
        telefonoField.getDocument().addDocumentListener(new SimpleDocumentListener() {
            @Override
            public void update() {
                disableFields(telefonoField);
            }
        });
        contentPane.add(telefonoField);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBuscar.setBackground(new Color(28, 232, 49));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(300, 150, 100, 30);
        btnBuscar.addActionListener(e -> buscarFarmacias());
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
        idFarmaciaField.setEnabled(field == idFarmaciaField);
        nombreFarmaciaField.setEnabled(field == nombreFarmaciaField);
        correoElectronicoField.setEnabled(field == correoElectronicoField);
        telefonoField.setEnabled(field == telefonoField);
    }

    private void enableFields() {
        idFarmaciaField.setEnabled(true);
        nombreFarmaciaField.setEnabled(true);
        correoElectronicoField.setEnabled(true);
        telefonoField.setEnabled(true);
    }

    private void buscarFarmacias() {
        String idFarmacia = idFarmaciaField.getText();
        String nombreFarmacia = nombreFarmaciaField.getText();
        String correoElectronico = correoElectronicoField.getText();
        String telefono = telefonoField.getText();

        String query = "SELECT * FROM farma.farmacia WHERE 1=1";

        if (!idFarmacia.isEmpty()) {
            query += " AND id_farmacia = '" + idFarmacia + "'";
        }

        if (!nombreFarmacia.isEmpty()) {
            query += " AND nombre_farmacia ILIKE '%" + nombreFarmacia + "%'";
        }

        if (!correoElectronico.isEmpty()) {
            query += " AND correo_electronico ILIKE '%" + correoElectronico + "%'";
        }

        if (!telefono.isEmpty()) {
            query += " AND telefono = " + telefono;
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            resultArea.setText("");
            while (rs.next()) {
                resultArea.append("ID Farmacia: " + rs.getString("id_farmacia") + "\n");
                resultArea.append("Nombre Farmacia: " + rs.getString("nombre_farmacia") + "\n");
                resultArea.append("Dirección: " + rs.getString("direccion") + "\n");
                resultArea.append("Horario: " + rs.getTimestamp("horario") + "\n");
                resultArea.append("Correo Electrónico: " + rs.getString("correo_electronico") + "\n");
                resultArea.append("Teléfono: " + rs.getLong("telefono") + "\n");
                resultArea.append("Licencia/Permiso: " + rs.getBoolean("licencia_permiso") + "\n");
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

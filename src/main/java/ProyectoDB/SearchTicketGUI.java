package ProyectoDB;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SearchTicketGUI extends JFrame {
    private JTextField idTicketField, fechaInicioField, fechaFinField, metodoPagoField;
    private JTextArea resultArea;
    private JTextField selectedIdTicketField; // Field to display selected ticket ID
    private Connection connection;
    private HighSalesGUI highSalesGUI;

    public SearchTicketGUI(Connection connection, HighSalesGUI highSalesGUI) {
        this.connection = connection;
        this.highSalesGUI = highSalesGUI;

        setTitle("Búsqueda de Tickets");
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
        contentPane.setLayout(null); // Use null layout for absolute positioning

        JLabel lblIdTicket = new JLabel("ID Ticket:");
        lblIdTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblIdTicket.setBounds(20, 20, 200, 25);
        contentPane.add(lblIdTicket);

        idTicketField = new JTextField();
        idTicketField.setBounds(180, 20, 150, 25);
        idTicketField.setColumns(10);
        idTicketField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableFields(idTicketField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used
            }
        });
        contentPane.add(idTicketField);

        JLabel lblFechaInicio = new JLabel("Fecha Inicio (YYYY-MM-DD):");
        lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFechaInicio.setBounds(20, 50, 200, 25);
        contentPane.add(lblFechaInicio);

        fechaInicioField = new JTextField();
        fechaInicioField.setBounds(180, 50, 150, 25);
        fechaInicioField.setColumns(10);
        fechaInicioField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableFields(fechaInicioField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used
            }
        });
        contentPane.add(fechaInicioField);

        JLabel lblFechaFin = new JLabel("Fecha Fin (YYYY-MM-DD):");
        lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFechaFin.setBounds(20, 80, 200, 25);
        contentPane.add(lblFechaFin);

        fechaFinField = new JTextField();
        fechaFinField.setBounds(180, 80, 150, 25);
        fechaFinField.setColumns(10);
        fechaFinField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableFields(fechaFinField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used
            }
        });
        contentPane.add(fechaFinField);

        JLabel lblMetodoPago = new JLabel("Método de Pago:");
        lblMetodoPago.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblMetodoPago.setBounds(20, 110, 200, 25);
        contentPane.add(lblMetodoPago);

        metodoPagoField = new JTextField();
        metodoPagoField.setBounds(180, 110, 150, 25);
        metodoPagoField.setColumns(10);
        metodoPagoField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                disableFields(metodoPagoField);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                enableFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used
            }
        });
        contentPane.add(metodoPagoField);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBuscar.setBackground(new Color(28, 232, 49));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setBounds(300, 150, 100, 30);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarTickets();
            }
        });
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

        JLabel lblSelectedIdTicket = new JLabel("ID Ticket Seleccionado:");
        lblSelectedIdTicket.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblSelectedIdTicket.setBounds(20, 370, 150, 25);
        contentPane.add(lblSelectedIdTicket);

        selectedIdTicketField = new JTextField();
        selectedIdTicketField.setBounds(180, 370, 150, 25);
        selectedIdTicketField.setColumns(10);
        selectedIdTicketField.setEditable(false);
        contentPane.add(selectedIdTicketField);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSeleccionar.setBackground(new Color(28, 232, 49));
        btnSeleccionar.setForeground(Color.WHITE);
        btnSeleccionar.setBounds(350, 370, 100, 30);
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarTicket();
            }
        });
        contentPane.add(btnSeleccionar);
    }

    private void disableFields(JTextField field) {
        idTicketField.setEnabled(field == idTicketField);
        fechaInicioField.setEnabled(field == fechaInicioField);
        fechaFinField.setEnabled(field == fechaFinField);
        metodoPagoField.setEnabled(field == metodoPagoField);
    }

    private void enableFields() {
        idTicketField.setEnabled(true);
        fechaInicioField.setEnabled(true);
        fechaFinField.setEnabled(true);
        metodoPagoField.setEnabled(true);
    }

    private void buscarTickets() {
        String idTicket = idTicketField.getText();
        String fechaInicio = fechaInicioField.getText();
        String fechaFin = fechaFinField.getText();
        String metodoPago = metodoPagoField.getText();

        String query = "SELECT * FROM farma.ticket WHERE 1=1";

        if (!idTicket.isEmpty()) {
            query += " AND id_ticket = " + Long.parseLong(idTicket);
        }

        if (!fechaInicio.isEmpty() && !fechaFin.isEmpty()) {
            query += " AND fecha_ticket BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "'";
        } else if (!fechaInicio.isEmpty()) {
            query += " AND fecha_ticket >= '" + fechaInicio + "'";
        } else if (!fechaFin.isEmpty()) {
            query += " AND fecha_ticket <= '" + fechaFin + "'";
        }

        if (!metodoPago.isEmpty()) {
            query += " AND metodo_pago = '" + metodoPago + "'";
        }

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            resultArea.setText("");
            while (rs.next()) {
                resultArea.append("Id_ticket: " + rs.getLong("id_ticket") + "\n");
                resultArea.append("Fecha_ticket: " + rs.getDate("fecha_ticket") + "\n");
                resultArea.append("Método_pago: " + rs.getString("metodo_pago") + "\n");
                resultArea.append("-------------------\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void seleccionarTicket() {
        String selectedText = resultArea.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            String[] lines = selectedText.split("\n");
            for (String line : lines) {
                if (line.startsWith("Id_ticket: ")) {
                    String idTicket = line.substring("Id_ticket: ".length());
                    selectedIdTicketField.setText(idTicket);
                    highSalesGUI.setTicketID(Integer.parseInt(idTicket)); // Establece el ID del ticket en HighSalesGUI
                    dispose();
                    break;
                }
            }
        }
    }

    public String getSelectedIdTicket() {
        return selectedIdTicketField.getText();
    }
}

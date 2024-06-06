package ProyectoDB.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataMartGUI extends JFrame {
    private JLabel imageLabel;
    private JPanel mainPanel;
    private JPanel imagePanel;
    private JPanel checkBoxPanel;
    private JPanel textPanel;  // Panel for the JTextField
    private JPanel datePanel;  // Panel for the first set of JComboBoxes
    private JPanel datePanel2;  // New panel for the second set of JComboBoxes
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JTextField textField;
    private JLabel textFieldLabel;  // New JLabel
    private JComboBox<String> comboBox1;  // JComboBox for the first date
    private JComboBox<String> comboBox2;  // JComboBox for the first date
    private JComboBox<String> comboBox3;  // JComboBox for the first date
    private JComboBox<String> comboBox4;  // New JComboBox for the second date
    private JComboBox<String> comboBox5;  // New JComboBox for the second date
    private JComboBox<String> comboBox6;  // New JComboBox for the second date
    private JButton selectDateButton;  // JButton for the first date
    private JButton selectDateButton2;  // New JButton for the second date

    public DataMartGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
        imageLabel.setIcon(new ImageIcon(DataMartGUI.class.getResource("/images/flower.png")));

        checkBox1 = new JCheckBox("Resumen venta de productos");
        checkBox1.setFont(new Font("Arial", Font.BOLD, 14));
        checkBox2 = new JCheckBox("Resumen venta de farmacia");
        checkBox2.setFont(new Font("Arial", Font.BOLD, 14));
        checkBox3 = new JCheckBox("Desglose ventas por producto");
        checkBox3.setFont(new Font("Arial", Font.BOLD, 14));

        textField = new JTextField(20);  // Increased the number of columns
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textFieldLabel = new JLabel("Nombre del producto: ");  // Create the new JLabel

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }

        String[] months = {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};

        String[] years = new String[81];
        for (int i = 0; i < 81; i++) {
            years[i] = Integer.toString(i + 1945);
        }

        comboBox1 = new JComboBox<>(days);  // Create the new JComboBox
        comboBox2 = new JComboBox<>(months);  // Create the new JComboBox
        comboBox3 = new JComboBox<>(years);  // Create the new JComboBox

        comboBox4 = new JComboBox<>(days);  // Create the new JComboBox for the second date
        comboBox5 = new JComboBox<>(months);  // Create the new JComboBox for the second date
        comboBox6 = new JComboBox<>(years);  // Create the new JComboBox for the second date

        selectDateButton = new JButton("Fecha inicial ");
        selectDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDay = (String) comboBox1.getSelectedItem();
                String selectedMonth = (String) comboBox2.getSelectedItem();
                String selectedYear = (String) comboBox3.getSelectedItem();

                System.out.println("Fecha inicial: " + selectedDay + " " + selectedMonth + " " + selectedYear);
            }
        });

        selectDateButton2 = new JButton("Fecha final");
        selectDateButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDay = (String) comboBox4.getSelectedItem();
                String selectedMonth = (String) comboBox5.getSelectedItem();
                String selectedYear = (String) comboBox6.getSelectedItem();

                System.out.println("Fecha final " + selectedDay + " " + selectedMonth + " " + selectedYear);
            }
        });

        textPanel = new JPanel();  // Create the new panel
        textPanel.add(textFieldLabel);  // Add the JLabel to the new panel
        textPanel.add(textField);  // Add the JTextField to the new panel

        datePanel = new JPanel(new FlowLayout());  // Change to FlowLayout
        datePanel.add(comboBox1);  // Add the JComboBox to the new panel
        datePanel.add(comboBox2);  // Add the JComboBox to the new panel
        datePanel.add(comboBox3);  // Add the JComboBox to the new panel
        datePanel.add(selectDateButton);  // Add the JButton to the new panel

        datePanel2 = new JPanel(new FlowLayout());  // Create the new panel for the second date
        datePanel2.add(comboBox4);  // Add the JComboBox to the new panel
        datePanel2.add(comboBox5);  // Add the JComboBox to the new panel
        datePanel2.add(comboBox6);  // Add the JComboBox to the new panel
        datePanel2.add(selectDateButton2);  // Add the JButton to the new panel

        imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setPreferredSize(new Dimension(300, 300));  // Set the preferred size

        checkBoxPanel = new JPanel(new FlowLayout());  // Change to FlowLayout
        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);
        checkBoxPanel.add(checkBox3);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(10, 0)));  // Add horizontal space
        checkBoxPanel.add(textPanel);  // Add the new panel to the checkBoxPanel
        checkBoxPanel.add(datePanel);  // Add the new panel to the checkBoxPanel
        checkBoxPanel.add(datePanel2);  // Add the new panel to the checkBoxPanel

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(imagePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(checkBoxPanel);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to change the size of the image panel
    public void setImagePanelSize(int width, int height) {
        imagePanel.setPreferredSize(new Dimension(width, height));
        imagePanel.revalidate();  // Update the panel
    }

    // Method to change the font size of the text field
    public void setTextFieldFontSize(int size) {
        textField.setFont(new Font("Arial", Font.PLAIN, size));
    }

    public static void main(String[] args) {
        new DataMartGUI();
    }
}
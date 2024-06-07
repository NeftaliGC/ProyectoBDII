package main.java.ProyectoDB.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataMartGUI extends JFrame {
    private JLabel imageLabel;
    private JPanel mainPanel;
    private JPanel imagePanel;
    private JPanel checkBoxPanel;
    private JPanel textPanel;
    private JPanel datePanel;
    private JPanel datePanel2;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JTextField textField;
    private JLabel textFieldLabel;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JComboBox<String> comboBox5;
    private JComboBox<String> comboBox6;
    private JButton selectDateButton;
    private JButton selectDateButton2;

    public DataMartGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 1000);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setVerticalAlignment(SwingConstants.TOP);
        imageLabel.setIcon(new ImageIcon(DataMartGUI.class.getResource("/images/flower.png")));

        checkBox1 = new JCheckBox("Resumen venta de productos");
        checkBox1.setFont(new Font("Georgia", Font.BOLD, 14));
        checkBox2 = new JCheckBox("Resumen venta de farmacia");
        checkBox2.setFont(new Font("Georgia", Font.BOLD, 14));
        checkBox3 = new JCheckBox("Desglose ventas por producto");
        checkBox3.setFont(new Font("Georgia", Font.BOLD, 14));

        textField = new JTextField(20);
        textField.setFont(new Font("Georgia", Font.PLAIN, 14));
        textFieldLabel = new JLabel("Nombre del producto: ");

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }

        String[] months = {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};

        String[] years = new String[81];
        for (int i = 0; i < 81; i++) {
            years[i] = Integer.toString(i + 1945);
        }

        comboBox1 = new JComboBox<>(days);
        comboBox2 = new JComboBox<>(months);
        comboBox3 = new JComboBox<>(years);

        comboBox4 = new JComboBox<>(days);
        comboBox5 = new JComboBox<>(months);
        comboBox6 = new JComboBox<>(years);

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

        textPanel = new JPanel();
        textPanel.add(textFieldLabel);
        textPanel.add(textField);

        datePanel = new JPanel(new FlowLayout());
        datePanel.add(comboBox1);
        datePanel.add(comboBox2);
        datePanel.add(comboBox3);
        datePanel.add(selectDateButton);

        datePanel2 = new JPanel(new FlowLayout());
        datePanel2.add(comboBox4);
        datePanel2.add(comboBox5);
        datePanel2.add(comboBox6);
        datePanel2.add(selectDateButton2);

        imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setPreferredSize(new Dimension(500, 500));

        checkBoxPanel = new JPanel(new FlowLayout());
        checkBoxPanel.add(checkBox1);
        checkBoxPanel.add(checkBox2);
        checkBoxPanel.add(checkBox3);
        checkBoxPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        checkBoxPanel.add(textPanel);
        checkBoxPanel.add(datePanel);
        checkBoxPanel.add(datePanel2);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(imagePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(checkBoxPanel);

        add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }


    public void setImagePanelSize(int width, int height) {
        imagePanel.setPreferredSize(new Dimension(width, height));
        imagePanel.revalidate();
    }


    public void setTextFieldFontSize(int size) {
        textField.setFont(new Font("Georgia", Font.PLAIN, size));
    }

    public static void main(String[] args) {
        new DataMartGUI();
    }
}
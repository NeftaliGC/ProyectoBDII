package ProyectoDB;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class loginsGUI extends JFrame {
    private JTextField textField; // Campo de texto para la dirección del servidor (IP/localhost)
    private JTextField textField_1; // Campo de texto para la base de datos
    private JTextField textField_2; // Campo de texto para el puerto
    private JTextField textField_lbluser; // Campo de texto para el nombre de usuario
    private JPasswordField passwordField; // Campo de contraseña para verificar la contraseña

    int xx, xy;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginsGUI loginframe = new loginsGUI();
                    loginframe.setUndecorated(true);
                    loginframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginsGUI() {
        // Configuración de la ventana principal
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(729, 450); // Establecer el tamaño del marco
        setLocationRelativeTo(null); // Centrar el marco en la pantalla

        // Panel principal
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Panel izquierdo con elementos gráficos y mensaje aleatorio
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 350, 450);
        contentPane.add(panel);
        panel.setLayout(null);

        // Lista de mensajes
        String[] mensajes = { "¡Empezando un nuevo viaje!", "¡Creando nuevas posibilidades!",
                "¡Bienvenido al comienzo de algo genial!", "¡Estás a un paso de la aventura!",
                "¡Prepárate para explorar!", "¡Tu nueva experiencia comienza aquí!" };

        int indiceAleatorio = new Random().nextInt(mensajes.length);

        // Crea el JLabel con el mensaje aleatorio
        JLabel lblNewLabel = new JLabel(mensajes[indiceAleatorio]);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(new Color(240, 248, 255));
        lblNewLabel.setBounds(0, 315, 350, 27);
        panel.add(lblNewLabel);

        JLabel label = new JLabel();

        // Captura del evento de arrastrar la ventana
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xx = e.getX();
                xy = e.getY();
            }
        });
        label.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                int x = arg0.getXOnScreen();
                int y = arg0.getYOnScreen();
                setLocation(x - xx, y - xy);
            }
        });

        label.setBounds(-38, 0, 420, 300);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setIcon(new ImageIcon(loginsGUI.class.getResource("src/main/resources/images/flower.png")));
        panel.add(label);        

        JLabel lblWeGotYou = new JLabel("... Estamos aquí para ayudarte ...");
        lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
        lblWeGotYou.setForeground(new Color(240, 248, 255));
        lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblWeGotYou.setBounds(70, 343, 200, 27);
        panel.add(lblWeGotYou);

        // Boton Login
        JButton buttonLogin = new JButton("Iniciar Servidor!");
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBackground(new Color(241, 57, 83));
        buttonLogin.setBounds(395, 363, 283, 50);
        contentPane.add(buttonLogin);

        JLabel lblAlreadyHaveProblem = new JLabel("¿Tienes problemas?");
        lblAlreadyHaveProblem.setForeground(new Color(30, 144, 255));
        lblAlreadyHaveProblem.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAlreadyHaveProblem.setBounds(395, 325, 300, 27);
        lblAlreadyHaveProblem.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(lblAlreadyHaveProblem);
        lblAlreadyHaveProblem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String message = "Abre la línea de comandos (CMD).\n" +
                        "Navega hasta la carpeta donde está instalado PostgreSQL. Por lo general, es algo como C:\\Program Files\\PostgreSQL\\13\\bin. Puedes hacerlo con el comando cd, por ejemplo:\n" +
                        "cd \"C:\\Program Files\\PostgreSQL\\13\\bin\"\n\n" +
                        "Conéctate a la base de datos PostgreSQL con el comando psql. Necesitarás proporcionar el nombre de la base de datos, el nombre de usuario y la contraseña. Aquí te dejo un ejemplo:\n" +
                        "psql -h localhost -p 5433 -U postgres -d postgres\n\n" +
                        "Una vez que estés conectado, puedes ejecutar el siguiente comando SQL para obtener la información que necesitas:\n" +
                        "SELECT current_database(), inet_server_port(), inet_server_addr(), current_user;";

                JOptionPane.showMessageDialog(loginsGUI.this, message);
            }
        });


        // TextField para la dirección del servidor
        textField = new JTextField();
        textField.setBounds(395, 40, 283, 36);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblUsername = new JLabel("SERVIDOR (IP/LOCALHOST):");
        lblUsername.setBounds(395, 20, 200, 14);
        contentPane.add(lblUsername);

        JLabel lblEmail = new JLabel("BASE DE DATOS:");
        lblEmail.setBounds(395, 80, 150, 14);
        contentPane.add(lblEmail);

        // TextField para la base de datos
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(395, 100, 283, 36);
        contentPane.add(textField_1);

        JLabel lblPassword = new JLabel("PUERTO [5432]:");
        lblPassword.setBounds(395, 140, 150, 14);
        contentPane.add(lblPassword);

        // TextField para el puerto
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(395, 160, 283, 36);
        contentPane.add(textField_2);

        JLabel lbluser = new JLabel("USUARIO:");
        lbluser.setBounds(395, 200, 150, 14);
        contentPane.add(lbluser);

        // TextField para el nombre de usuario
        textField_lbluser = new JTextField();
        textField_lbluser.setColumns(10);
        textField_lbluser.setBounds(395, 220, 283, 36);
        contentPane.add(textField_lbluser);

        JLabel lblRepeatPassword = new JLabel("CONTRASEÑA:");
        lblRepeatPassword.setBounds(395, 260, 150, 14);
        contentPane.add(lblRepeatPassword);

        // Campo de contraseña para verificar la contraseña
        passwordField = new JPasswordField();
        passwordField.setBounds(395, 280, 283, 36);
        contentPane.add(passwordField);

        // Botón para cerrar la ventana
        JLabel lbl_close = new JLabel("X");
        lbl_close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.exit(0); // Sale de la aplicación al hacer clic
            }
        });

        lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_close.setForeground(new Color(241, 57, 83));
        lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbl_close.setBounds(691, 0, 37, 27);
        contentPane.add(lbl_close);
    }

    public void connectToServer() {
        String server = textField.getText();
        String database = textField_1.getText();
        String port = textField_2.getText(); // Puerto
        String user = textField_lbluser.getText(); // Nombre de usuario
        String password = new String(passwordField.getPassword());

        if (server.isEmpty() || database.isEmpty() || port.isEmpty() || user.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos");
            return;
        }

        DBConnection dbConnection = new DBConnection(server, database, port, user, password);

        try {
            Connection connection = dbConnection.getConnection();
            if (connection != null) {
                JOptionPane.showMessageDialog(this, "Conexión exitosa!"); // Muestra un mensaje si la conexión es exitosa
                System.out.println(server + " " + database + " " + port + " " + user + " " + password);
                // Agregar estas líneas para cerrar la interfaz actual y abrir otra interfaz
                dispose();
                /*new OtraInterfaz().setVisible(true);*/

            } else {
                JOptionPane.showMessageDialog(this, "Error al conectar al servidor."); // Muestra un mensaje de error si no se puede conectar
                System.out.println(server + " " + database + " " + port + " " + user + " " + password);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar al servidor: " + ex.getMessage()); // Muestra un mensaje de error detallado
            System.out.println(server + " " + database + " " + port + " " + user + " " + password);
        }
    }
}
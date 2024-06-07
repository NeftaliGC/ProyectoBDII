package ProyectoDB.frontend;

import ProyectoDB.DBConnection;
import ProyectoDB.componentes.JlabelPersonalizado;
import java.awt.Color;
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

    private final JTextField textFieldServer;
    private final JTextField textFieldDatabase;
    private final JTextField textFieldPort;
    private final JTextField textFieldUser;
    private final JPasswordField passwordField;
    int xx, xy;

    public loginsGUI() {
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(729, 450);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 350, 450);
        contentPane.add(panel);
        panel.setLayout(null);

        String[] mensajes = {"¡Empezando un nuevo viaje!", "¡Creando nuevas posibilidades!",
            "¡Bienvenido al comienzo de algo genial!", "¡Estás a un paso de la aventura!",
            "¡Prepárate para explorar!", "¡Tu nueva experiencia comienza aquí!"};

        int indiceAleatorio = new Random().nextInt(mensajes.length);

        JLabel lblNewLabel = new JLabel(mensajes[indiceAleatorio]);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setForeground(new Color(240, 248, 255));
        lblNewLabel.setBounds(0, 315, 350, 27);
        panel.add(lblNewLabel);

        JLabel label = new JLabel();
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
        label.setIcon(new ImageIcon(loginsGUI.class.getResource("/images/flower.png")));
        panel.add(label);

        JLabel lblWeGotYou = new JLabel("... Estamos aquí para ayudarte ...");
        lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
        lblWeGotYou.setForeground(new Color(240, 248, 255));
        lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblWeGotYou.setBounds(70, 343, 200, 27);
        panel.add(lblWeGotYou);

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

        JlabelPersonalizado lblAlreadyHaveProblem = new JlabelPersonalizado("¿Tienes problemas?");
        lblAlreadyHaveProblem.setBounds(395, 325, 300, 27);
        contentPane.add(lblAlreadyHaveProblem);
        lblAlreadyHaveProblem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String message = "Abre la línea de comandos (CMD).\n"
                        + "Navega hasta la carpeta donde está instalado PostgreSQL. Por lo general, es algo como C:\\Program Files\\PostgreSQL\\13\\bin. Puedes hacerlo con el comando cd, por ejemplo:\n"
                        + "cd \"C:\\Program Files\\PostgreSQL\\13\\bin\"\n\n"
                        + "Conéctate a la base de datos PostgreSQL con el comando psql. Necesitarás proporcionar el nombre de la base de datos, el nombre de usuario y la contraseña. Aquí te dejo un ejemplo:\n"
                        + "psql -h localhost -p 5433 -U postgres -d postgres\n\n"
                        + "Una vez que estés conectado, puedes ejecutar el siguiente comando SQL para obtener la información que necesitas:\n"
                        + "SELECT current_database(), inet_server_port(), inet_server_addr(), current_user;";

                JOptionPane.showMessageDialog(loginsGUI.this, message);
            }
        });

        textFieldServer = new JTextField();
        textFieldServer.setBounds(395, 40, 283, 36);
        contentPane.add(textFieldServer);
        textFieldServer.setColumns(10);

        JLabel lblUsername = new JLabel("SERVIDOR (IP/LOCALHOST):");
        lblUsername.setBounds(395, 20, 200, 14);
        contentPane.add(lblUsername);

        JLabel lblEmail = new JLabel("BASE DE DATOS:");
        lblEmail.setBounds(395, 80, 150, 14);
        contentPane.add(lblEmail);

        textFieldDatabase = new JTextField();
        textFieldDatabase.setColumns(10);
        textFieldDatabase.setBounds(395, 100, 283, 36);
        contentPane.add(textFieldDatabase);

        JLabel lblPassword = new JLabel("PUERTO [5432]:");
        lblPassword.setBounds(395, 140, 150, 14);
        contentPane.add(lblPassword);

        textFieldPort = new JTextField();
        textFieldPort.setColumns(10);
        textFieldPort.setBounds(395, 160, 283, 36);
        contentPane.add(textFieldPort);

        JLabel lblUser = new JLabel("USUARIO:");
        lblUser.setBounds(395, 200, 150, 14);
        contentPane.add(lblUser);

        textFieldUser = new JTextField();
        textFieldUser.setColumns(10);
        textFieldUser.setBounds(395, 220, 283, 36);
        contentPane.add(textFieldUser);

        JLabel lblRepeatPassword = new JLabel("CONTRASEÑA:");
        lblRepeatPassword.setBounds(395, 260, 150, 14);
        contentPane.add(lblRepeatPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(395, 280, 283, 36);
        contentPane.add(passwordField);

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

    public void connectToServer() {
        String server = textFieldServer.getText();
        String database = textFieldDatabase.getText();
        String port = textFieldPort.getText();
        String user = textFieldUser.getText();
        String schema = "farma";
        String password = new String(passwordField.getPassword());

        if (server.isEmpty() || database.isEmpty() || port.isEmpty() || user.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos");
            return;
        }

        DBConnection dbConnection = new DBConnection(server, database, schema, port, user, password);

        try {
            Connection connection = dbConnection.getConnection();
            if (connection != null) {
                //JOptionPane.showMessageDialog(this, "Conexión exitosa!");
                dispose();
                new MainPanelGUI(connection).setVisible(true); // Aquí pasamos la conexión a AltaVentasGUI
            } else {
                JOptionPane.showMessageDialog(this, "Error al conectar al servidor.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar al servidor: " + ex.getMessage());
        }
    }

}

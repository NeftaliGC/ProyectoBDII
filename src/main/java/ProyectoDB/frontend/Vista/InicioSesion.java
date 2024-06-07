package ProyectoDB.frontend.Vista;
import java.awt.Color;
import main.java.ProyectoDB.frontend.Controlador.ControladorVista;

public class InicioSesion extends javax.swing.JFrame {
    int xMouse, yMouse;
    private ControladorVista control;
    //Register reg;
    public InicioSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        panelCambio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        loginbtn = new javax.swing.JPanel();
        accederTxt = new javax.swing.JLabel();
        dataBaseTxt = new javax.swing.JTextField();
        passTxt = new javax.swing.JPasswordField();
        pRegistrar = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        serverTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        schemaTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vector-patron-medico-fisuras-microscopio-medicina-cinta-roja-yeso-antibiotico-sangre-pulso-vitamina-.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 330, 600));

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Header.setPreferredSize(new java.awt.Dimension(800, 40));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        exitTxt.setText(" X");
        exitTxt.setToolTipText("");
        exitTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 760, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelCambio.setBackground(new java.awt.Color(255, 255, 255));
        panelCambio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel5.setText("Contraseña");
        panelCambio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel2.setText("Iniciar Sesión");
        panelCambio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));
        panelCambio.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 370, 10));

        loginbtn.setBackground(new java.awt.Color(17, 17, 13));
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginbtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accederTxt.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        accederTxt.setForeground(new java.awt.Color(255, 255, 255));
        accederTxt.setText("       Acceder");
        accederTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accederTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accederTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accederTxtMouseExited(evt);
            }
        });
        loginbtn.add(accederTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        panelCambio.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, -1, -1));

        dataBaseTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dataBaseTxt.setForeground(new java.awt.Color(204, 204, 204));
        dataBaseTxt.setText("Enter your Database");
        dataBaseTxt.setBorder(null);
        dataBaseTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataBaseTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dataBaseTxtMousePressed(evt);
            }
        });
        panelCambio.add(dataBaseTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 370, 30));

        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("************");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        panelCambio.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 370, 30));

        pRegistrar.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/anadir.png"))); // NOI18N
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pRegistrarLayout = new javax.swing.GroupLayout(pRegistrar);
        pRegistrar.setLayout(pRegistrarLayout);
        pRegistrarLayout.setHorizontalGroup(
            pRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        pRegistrarLayout.setVerticalGroup(
            pRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        panelCambio.add(pRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 460, -1, -1));
        panelCambio.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 370, 10));

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel4.setText("Database");
        panelCambio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        panelCambio.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 370, 10));

        serverTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        serverTxt.setForeground(new java.awt.Color(204, 204, 204));
        serverTxt.setText("Enter your Server");
        serverTxt.setBorder(null);
        serverTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        serverTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                serverTxtMousePressed(evt);
            }
        });
        panelCambio.add(serverTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 370, 30));

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel6.setText("Server");
        panelCambio.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        panelCambio.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 370, 10));

        schemaTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        schemaTxt.setForeground(new java.awt.Color(204, 204, 204));
        schemaTxt.setText("Enter your Schema");
        schemaTxt.setToolTipText("");
        schemaTxt.setBorder(null);
        schemaTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        schemaTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                schemaTxtMousePressed(evt);
            }
        });
        panelCambio.add(schemaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 370, 30));

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel7.setText("Schema");
        panelCambio.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jPanel1.add(panelCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 470, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
        this.getDefaultCloseOperation();
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void accederTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accederTxtMouseClicked
        String server = serverTxt.getText();
        String db = dataBaseTxt.getText();
        String schema = schemaTxt.getText();
        char[] pass = passTxt.getPassword();
        String passString = new String(pass);

        control = new ControladorVista();
        if(control.validate(server, db, schema, passString)){
            this.dispose();
        };
    }//GEN-LAST:event_accederTxtMouseClicked

    private void accederTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accederTxtMouseEntered
        loginbtn.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_accederTxtMouseEntered

    private void accederTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accederTxtMouseExited
        loginbtn.setBackground(new Color (17,17,13));
    }//GEN-LAST:event_accederTxtMouseExited

    private void dataBaseTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataBaseTxtMousePressed
        if(dataBaseTxt.getText().equals("Enter your Database")){
            dataBaseTxt.setText("");
            dataBaseTxt.setForeground(Color.black);
        }
        if(serverTxt.getText().isEmpty()){
            serverTxt.setText("Enter your Server");
            serverTxt.setForeground(new Color (204,204,204));
        }
        if(schemaTxt.getText().isEmpty()){
            schemaTxt.setText("Enter your Schema");
            schemaTxt.setForeground(new Color (204,204,204));
        }
        if(String.valueOf(passTxt.getPassword()).isEmpty()){
            passTxt.setText("************");
            passTxt.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_dataBaseTxtMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if(String.valueOf(passTxt.getPassword()).equals("************")){
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if(dataBaseTxt.getText().isEmpty()){
            dataBaseTxt.setText("Enter your Database");
            dataBaseTxt.setForeground(new Color (204,204,204));
        }
        if(serverTxt.getText().isEmpty()){
            serverTxt.setText("Enter your Server");
            serverTxt.setForeground(new Color (204,204,204));
        }
        if(schemaTxt.getText().isEmpty()){
            schemaTxt.setText("Enter your Schema");
            schemaTxt.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_passTxtMousePressed

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        /*reg = new Register();
        this.setVisible(false);
        this.dispose();
        reg.setVisible(true);*/
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        pRegistrar.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        pRegistrar.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void serverTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serverTxtMousePressed
       if(serverTxt.getText().equals("Enter your Server")){
            serverTxt.setText("");
            serverTxt.setForeground(Color.black);
        }
        if(dataBaseTxt.getText().isEmpty()){
            dataBaseTxt.setText("Enter your Database");
            dataBaseTxt.setForeground(new Color (204,204,204));
        }
        if(schemaTxt.getText().isEmpty()){
            schemaTxt.setText("Enter your Schema");
            schemaTxt.setForeground(new Color (204,204,204));
        }
        if(String.valueOf(passTxt.getPassword()).isEmpty()){
            passTxt.setText("************");
            passTxt.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_serverTxtMousePressed

    private void schemaTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schemaTxtMousePressed
        if(schemaTxt.getText().equals("Enter your Schema")){
            schemaTxt.setText("");
            schemaTxt.setForeground(Color.black);
        }
        if(dataBaseTxt.getText().isEmpty()){
            dataBaseTxt.setText("Enter your Database");
            dataBaseTxt.setForeground(new Color (204,204,204));
        }
        if(serverTxt.getText().isEmpty()){
            serverTxt.setText("Enter your Server");
            serverTxt.setForeground(new Color (204,204,204));
        }
        if(String.valueOf(passTxt.getPassword()).isEmpty()){
            passTxt.setText("************");
            passTxt.setForeground(new Color (204,204,204));
        }
    }//GEN-LAST:event_schemaTxtMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }
    public void cerrar(){
        this.setVisible(false);
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel accederTxt;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JTextField dataBaseTxt;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPanel loginbtn;
    private javax.swing.JPanel pRegistrar;
    private javax.swing.JPanel panelCambio;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JTextField schemaTxt;
    private javax.swing.JTextField serverTxt;
    // End of variables declaration//GEN-END:variables
}

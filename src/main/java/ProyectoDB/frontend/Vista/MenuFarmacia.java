package main.java.ProyectoDB.frontend.Vista;
import main.java.ProyectoDB.frontend.Controlador.ControladorVista;
import java.awt.BorderLayout;
import java.awt.Color;

public class MenuFarmacia extends javax.swing.JFrame {
    int xMouse;
    int yMouse;
    ControladorVista controlVista;
    Ventas ventas;
    
    public MenuFarmacia() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        //Mostrar Panel Inicio En El Dashboard
        ventas = new Ventas();
        ventas.setSize(750, 640);
        ventas.setLocation(0,0);
        pPrincipal.removeAll();
        pPrincipal.add(ventas, BorderLayout.CENTER);
        pPrincipal.revalidate();
        pPrincipal.repaint();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pVentas = new javax.swing.JPanel();
        btnVentas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pInventario = new javax.swing.JPanel();
        btnInven = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pDatamart = new javax.swing.JPanel();
        btnDatamart = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pCerrarS = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnCerrarS = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        minBtn = new javax.swing.JPanel();
        minTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_user_25px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 32, 150, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/7645092.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 180, -1));

        pVentas.setBackground(new java.awt.Color(153, 204, 255));
        pVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVentas.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnVentas.setText("Ventas");
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasMouseExited(evt);
            }
        });
        pVentas.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ventas.png"))); // NOI18N
        pVentas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jPanel1.add(pVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 240, 40));

        pInventario.setBackground(new java.awt.Color(153, 204, 255));
        pInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInven.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnInven.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInven.setText("                  Control Inventario");
        btnInven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInvenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvenMouseExited(evt);
            }
        });
        pInventario.add(btnInven, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/inventario.png"))); // NOI18N
        pInventario.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jPanel1.add(pInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 240, 40));

        pDatamart.setBackground(new java.awt.Color(153, 204, 255));
        pDatamart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDatamart.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDatamart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDatamart.setText("   DataMart");
        btnDatamart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDatamartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDatamartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDatamartMouseExited(evt);
            }
        });
        pDatamart.add(btnDatamart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grafico-de-barras.png"))); // NOI18N
        pDatamart.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        jPanel1.add(pDatamart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 240, 40));

        pCerrarS.setBackground(new java.awt.Color(153, 204, 255));
        pCerrarS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cerrar-sesion.png"))); // NOI18N
        pCerrarS.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 40));

        btnCerrarS.setBackground(new java.awt.Color(102, 102, 255));
        btnCerrarS.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnCerrarS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrarS.setText("            Cerra Sesion");
        btnCerrarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSMouseExited(evt);
            }
        });
        pCerrarS.add(btnCerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jPanel1.add(pCerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 240, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 680));

        Header.setBackground(new java.awt.Color(255, 255, 255));
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
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));

        exitTxt.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        exitTxt.setText(" X");
        exitTxt.setToolTipText("");
        exitTxt.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(exitTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Header.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

        minBtn.setBackground(new java.awt.Color(255, 255, 255));

        minTxt.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        minTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_subtract_30px.png"))); // NOI18N
        minTxt.setToolTipText("");
        minTxt.setAlignmentX(1.0F);
        minTxt.setAlignmentY(1.0F);
        minTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minTxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        minTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout minBtnLayout = new javax.swing.GroupLayout(minBtn);
        minBtn.setLayout(minBtnLayout);
        minBtnLayout.setHorizontalGroup(
            minBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        minBtnLayout.setVerticalGroup(
            minBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(minTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Header.add(minBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 40, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_ambulance_40px_1.png"))); // NOI18N
        Header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 40, 40));

        jLabel6.setBackground(new java.awt.Color(121, 92, 52));
        jLabel6.setFont(new java.awt.Font("Poor Richard", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(121, 92, 52));
        jLabel6.setText("MedicineList");
        Header.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 190, 40));

        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 40));

        pPrincipal.setFocusable(false);

        javax.swing.GroupLayout pPrincipalLayout = new javax.swing.GroupLayout(pPrincipal);
        pPrincipal.setLayout(pPrincipalLayout);
        pPrincipalLayout.setHorizontalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        pPrincipalLayout.setVerticalGroup(
            pPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        getContentPane().add(pPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseEntered
        pVentas.setBackground(new Color (102,102,255) );
        btnVentas.setForeground(Color.white);
    }//GEN-LAST:event_btnVentasMouseEntered

    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        pVentas.setBackground(new Color (153,204,255));
        btnVentas.setForeground(Color.black);
    }//GEN-LAST:event_btnVentasMouseExited

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(Color.white);
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void minTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_minTxtMouseClicked

    private void minTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseEntered
        minBtn.setBackground(new Color (230,230,230));
    }//GEN-LAST:event_minTxtMouseEntered

    private void minTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minTxtMouseExited
        minBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_minTxtMouseExited

    private void btnDatamartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatamartMouseEntered
        pDatamart.setBackground(new Color (102,102,255) );
        btnDatamart.setForeground(Color.white);
    }//GEN-LAST:event_btnDatamartMouseEntered

    private void btnDatamartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatamartMouseExited
        pDatamart.setBackground(new Color (153,204,255));
        btnDatamart.setForeground(Color.black);
    }//GEN-LAST:event_btnDatamartMouseExited

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void btnInvenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvenMouseEntered
        pInventario.setBackground(new Color (102,102,255) );
        btnInven.setForeground(Color.white);
    }//GEN-LAST:event_btnInvenMouseEntered

    private void btnInvenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvenMouseExited
        pInventario.setBackground(new Color (153,204,255));
        btnInven.setForeground(Color.black);
    }//GEN-LAST:event_btnInvenMouseExited

    private void btnCerrarSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSMouseEntered
        pCerrarS.setBackground(Color.RED);
        btnCerrarS.setForeground(Color.white);
    }//GEN-LAST:event_btnCerrarSMouseEntered

    private void btnCerrarSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSMouseExited
        pCerrarS.setBackground(new Color (153,204,255));
        btnCerrarS.setForeground(Color.black);
    }//GEN-LAST:event_btnCerrarSMouseExited

    private void btnCerrarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSMouseClicked
        controlVista = new ControladorVista();
        controlVista.returnStart();
        this.dispose();
    }//GEN-LAST:event_btnCerrarSMouseClicked

    private void btnDatamartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDatamartMouseClicked
        /*compras = new Compras();
        compras.setSize(750, 640);
        compras.setLocation(0,0);
        pPrincipal.removeAll();
        pPrincipal.add(compras, BorderLayout.CENTER);
        pPrincipal.revalidate();
        pPrincipal.repaint();*/
    }//GEN-LAST:event_btnDatamartMouseClicked

    private void btnInvenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvenMouseClicked
        /*catego = new Categorias();
        catego.setSize(750, 640);
        catego.setLocation(0,0);
        pPrincipal.removeAll();
        pPrincipal.add(catego, BorderLayout.CENTER);
        pPrincipal.revalidate();
        pPrincipal.repaint();*/
    }//GEN-LAST:event_btnInvenMouseClicked

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        try {
            ventas = new Ventas();
            ventas.setSize(750, 640);
            ventas.setLocation(0,0);
            pPrincipal.removeAll();
            pPrincipal.add(ventas, BorderLayout.CENTER);
            pPrincipal.revalidate();
            pPrincipal.repaint();
            System.out.println("Exito");
        } catch (Exception e) {
            System.out.println(""+e);
        }
        
    }//GEN-LAST:event_btnVentasMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFarmacia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JLabel btnCerrarS;
    private javax.swing.JLabel btnDatamart;
    private javax.swing.JLabel btnInven;
    private javax.swing.JLabel btnVentas;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel minBtn;
    private javax.swing.JLabel minTxt;
    private javax.swing.JPanel pCerrarS;
    private javax.swing.JPanel pDatamart;
    private javax.swing.JPanel pInventario;
    public javax.swing.JPanel pPrincipal;
    private javax.swing.JPanel pVentas;
    // End of variables declaration//GEN-END:variables
}

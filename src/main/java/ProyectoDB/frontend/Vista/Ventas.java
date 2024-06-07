package main.java.ProyectoDB.frontend.Vista;
import java.awt.Color;
import java.awt.event.ActionListener;
import main.java.ProyectoDB.frontend.Modelo.VentasDao;
import main.java.ProyectoDB.frontend.Modelo.VentasData;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JPanel implements ActionListener{
    //ControlDatos controlDatos;
    VentasData vtaData;
    VentasDao vtaDao;
    public DefaultTableModel modelo = new DefaultTableModel();
    
    public Ventas() {
        initComponents();
        tabVentas.getTableHeader().setFont(new Font("Roboto", 1, 14));
        // cambia el fondo del encabezado de la tabla
        tabVentas.getTableHeader().setBackground(new Color(153,204,255));
        // cambia el color de la letra del encabezado de la tabla
        tabVentas.getTableHeader().setForeground(Color.white);
        scrollClientes.setBorder(BorderFactory.createEmptyBorder());
  
        vtaData = new VentasData();
        vtaDao = new VentasDao();
        
        btnInsert.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnFiltrar.addActionListener(this);
        modelo = (DefaultTableModel)tabVentas.getModel();
        listar();
        //autoIncrement();
    }
    
    public void autoIncrement(){
        //int id = cDao.id_autoincrement();
        //txtClienteID.setText(""+id);
    }
    
    public void limpiarTablaC(){
        for (int i = 0; i < tabVentas.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void listar(){
        List<VentasData> lista = vtaDao.listar();
        Object[] object  = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIdVenta();
            object[1] = lista.get(i).getCantVendida();
            object[2] = lista.get(i).getTotalVenta();
            object[3] = lista.get(i).isReceta();
            object[4] = lista.get(i).getIdProducto();
            object[5] = lista.get(i).getRfc();
            object[6] = lista.get(i).getIdTicket();
            modelo.addRow(object);
        }
        tabVentas.setModel(modelo);
    }
    
    public void buscar(){
        /*List<ClientesData> lista = cDao.buscar(txtFiltrar.getText());
        Object[] object  = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getClienteID();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getDireccion();
            object[3] = lista.get(i).getTelefono();
            object[4] = lista.get(i).getCorreo();
            object[5] = lista.get(i).getFecRegistro();
            object[6] = lista.get(i).getUltCompra();
            object[7] = lista.get(i).getDescAplicado();
            modelo.addRow(object);
        }
        tabClientes.setModel(modelo);*/
    }
    
    public void limpiar(){
        txtIDVenta.setText("");
        txtCantidadVendida.setText("");
        txtTotalVenta.setText("");
        txtReceta.setText("");
        txtIDProducto.setText("");
        txtRFC.setText("");
        txtIDTicket.setText("");
    }
    
    public void agregar(){
        String id = txtIDVenta.getText();
        BigDecimal cantidadVendida = new BigDecimal(txtCantidadVendida.getText());
        BigDecimal totalVenta = new BigDecimal(txtTotalVenta.getText());
        boolean recetaMedicina = Boolean.parseBoolean(txtReceta.getText()); // Asumiendo que txtReceta contiene un valor booleano en forma de String
        String idProducto = txtIDProducto.getText(); // Se obtiene directamente del campo de texto
        String rfc = txtRFC.getText(); // Se obtiene directamente del campo de texto
        BigDecimal idTicket = new BigDecimal(txtIDTicket.getText()); // Se obtiene directamente del campo de texto

        // Luego de recopilar los datos, los estableces en un objeto de tipo VentasData
        VentasData vtaData = new VentasData();
        vtaData.setIdVenta(id);
        vtaData.setCantVendida(cantidadVendida);
        vtaData.setTotalVenta(totalVenta);
        vtaData.setReceta(recetaMedicina);
        vtaData.setIdProducto(idProducto);
        vtaData.setRfc(rfc);
        vtaData.setIdTicket(idTicket);

        // Luego, se llama al método insertSales de vtaDao para insertar los datos en la base de datos
        vtaDao.insertSales(vtaData);

    }
    
    public void actualizar(){
        /*int clienteID = Integer.parseInt(txtClienteID.getText());
        String nombre = txtNombre.getText();
        String direccion = txtDirecc.getText();
        String telefono = txtTelef.getText();
        String correo = txtCorreo.getText();
        String fecRegistro = txtFecReg.getText();
        String ultCompra = txtUltCompra.getText();
        float DescAplicado = Float.valueOf(txtDescAplica.getText());
        cData.setClienteID(clienteID);
        cData.setNombre(nombre);
        cData.setDireccion(direccion);
        cData.setTelefono(telefono);
        cData.setCorreo(correo);
        cData.setFecRegistro(fecRegistro);
        cData.setUltCompra(ultCompra);
        cData.setDescAplicado(DescAplicado);
        cDao.actualizar(cData);*/
    }
    
    public void eliminar(){
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtFiltrar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnInsert = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();
        scrollClientes = new javax.swing.JScrollPane();
        tabVentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIDVenta = new javax.swing.JTextField();
        txtCantidadVendida = new javax.swing.JTextField();
        txtTotalVenta = new javax.swing.JTextField();
        txtReceta = new javax.swing.JTextField();
        txtIDProducto = new javax.swing.JTextField();
        txtRFC = new javax.swing.JTextField();
        txtIDTicket = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFiltrar.setBackground(new java.awt.Color(217, 217, 217));
        txtFiltrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txtFiltrar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFiltrar.setText("Filtrar...");
        txtFiltrar.setBorder(null);
        txtFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtFiltrarMousePressed(evt);
            }
        });
        jPanel2.add(txtFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 300, 30));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel10.setText("VENTAS");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        btnInsert.setBackground(new java.awt.Color(153, 204, 255));
        btnInsert.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnInsert.setText("Insertar");
        btnInsert.setBorder(null);
        btnInsert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInsertMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInsertMouseExited(evt);
            }
        });
        jPanel2.add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 90, 30));

        btnLimpiar.setBackground(new java.awt.Color(153, 204, 255));
        btnLimpiar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        jPanel2.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 90, 30));

        btnModificar.setBackground(new java.awt.Color(153, 204, 255));
        btnModificar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificarMouseExited(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 90, 30));

        btnEliminar.setBackground(new java.awt.Color(153, 204, 255));
        btnEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 90, 30));

        btnFiltrar.setBackground(new java.awt.Color(153, 204, 255));
        btnFiltrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnFiltrar.setText("Buscador");
        btnFiltrar.setBorder(null);
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseExited(evt);
            }
        });
        jPanel2.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 90, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 350));

        scrollClientes.setBorder(null);

        tabVentas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdVenta", "CantidadVendida", "TotalVenta", "RecetaMedicina", "IdProducto", "RFC", "IdTicket"
            }
        ));
        tabVentas.setGridColor(new java.awt.Color(255, 255, 255));
        tabVentas.setSelectionBackground(new java.awt.Color(203, 170, 131));
        tabVentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabVentasMouseClicked(evt);
            }
        });
        scrollClientes.setViewportView(tabVentas);

        add(scrollClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 730, 260));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("IDVenta: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Can Vendida: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Total Venta: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Receta Med: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("IDProducto: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("RFC: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("IDTicket: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Datos de Ventas");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        txtIDVenta.setEditable(false);
        txtIDVenta.setBackground(new java.awt.Color(217, 217, 217));
        txtIDVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDVenta.setBorder(null);
        txtIDVenta.setFocusable(false);
        jPanel3.add(txtIDVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 130, 20));

        txtCantidadVendida.setBackground(new java.awt.Color(217, 217, 217));
        txtCantidadVendida.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCantidadVendida.setBorder(null);
        jPanel3.add(txtCantidadVendida, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 20));

        txtTotalVenta.setBackground(new java.awt.Color(217, 217, 217));
        txtTotalVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTotalVenta.setBorder(null);
        jPanel3.add(txtTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, 20));

        txtReceta.setBackground(new java.awt.Color(217, 217, 217));
        txtReceta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtReceta.setBorder(null);
        jPanel3.add(txtReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 130, 20));

        txtIDProducto.setBackground(new java.awt.Color(217, 217, 217));
        txtIDProducto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDProducto.setBorder(null);
        jPanel3.add(txtIDProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 130, 20));

        txtRFC.setBackground(new java.awt.Color(217, 217, 217));
        txtRFC.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRFC.setBorder(null);
        jPanel3.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 130, 20));

        txtIDTicket.setBackground(new java.awt.Color(217, 217, 217));
        txtIDTicket.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtIDTicket.setBorder(null);
        jPanel3.add(txtIDTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 20));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 260, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseEntered
        btnInsert.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_btnInsertMouseEntered

    private void btnInsertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseExited
        btnInsert.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btnInsertMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        btnModificar.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        btnModificar.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        btnLimpiar.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        btnLimpiar.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void tabVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabVentasMouseClicked
        
        int fila = tabVentas.getSelectedRow();
        if (fila >= 0) {
            // Obtener los valores de la tabla
            String id = (String) tabVentas.getValueAt(fila, 0);
            BigDecimal cantidadVendida = new BigDecimal(tabVentas.getValueAt(fila, 1).toString());
            BigDecimal totalVenta = new BigDecimal(tabVentas.getValueAt(fila, 2).toString());
            Boolean recetaMedicina = (Boolean) tabVentas.getValueAt(fila, 3);
            String idProducto = (String) tabVentas.getValueAt(fila, 4);
            String rfc = (String) tabVentas.getValueAt(fila, 5);
            BigDecimal idTicket = new BigDecimal(tabVentas.getValueAt(fila, 6).toString());

            // Establecer los valores en los campos de texto
            txtIDVenta.setText(id);
            txtCantidadVendida.setText(cantidadVendida.toString());
            txtTotalVenta.setText(totalVenta.toString());
            txtReceta.setText(recetaMedicina != null ? recetaMedicina.toString() : "false");
            txtIDProducto.setText(idProducto);
            txtRFC.setText(rfc);
            txtIDTicket.setText(idTicket.toString());
        } else {
            System.out.println("Debe seleccionar una fila de la tabla");
        }


    }//GEN-LAST:event_tabVentasMouseClicked

    private void txtFiltrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltrarMousePressed
        txtFiltrar.setText("");
    }//GEN-LAST:event_txtFiltrarMousePressed

    private void btnFiltrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseEntered
        btnFiltrar.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_btnFiltrarMouseEntered

    private void btnFiltrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseExited
        btnFiltrar.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btnFiltrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnFiltrar;
    public javax.swing.JButton btnInsert;
    public final javax.swing.JButton btnLimpiar = new javax.swing.JButton();
    public javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scrollClientes;
    public javax.swing.JTable tabVentas;
    public javax.swing.JTextField txtCantidadVendida;
    public javax.swing.JTextField txtFiltrar;
    public javax.swing.JTextField txtIDProducto;
    public javax.swing.JTextField txtIDTicket;
    public javax.swing.JTextField txtIDVenta;
    public javax.swing.JTextField txtRFC;
    public javax.swing.JTextField txtReceta;
    public javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnFiltrar){
            if(txtFiltrar.getText() == "Filtrar..."){
                JOptionPane.showMessageDialog(null, "No Ingreso Nada");
            }
            if(txtFiltrar.getText() == ""){
                limpiarTablaC();
                listar();
            }else{
                limpiarTablaC();
                buscar();
            }
        }
        if(e.getSource() == btnInsert){
            agregar();
            limpiarTablaC();
            listar();
            //autoIncrement();
        }
        if(e.getSource() == btnEliminar){
            int fila = tabVentas.getSelectedRow();
            String id = (String) tabVentas.getValueAt(fila, 0);
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Seleccionar un registro");
            }else{
                vtaDao.deleteSale(id);
            }
            limpiarTablaC();
            listar();
            limpiar();
            //autoIncrement();
        }
        if(e.getSource() == btnModificar){
            actualizar();
            limpiarTablaC();
            listar();
            autoIncrement();
        }
        if(e.getSource() == btnLimpiar){
            limpiar();
            autoIncrement();
        }
    }
}

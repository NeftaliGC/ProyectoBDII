package Vista;
import Modelo.CategoriaDao;
import Modelo.CategoriaData;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventario extends javax.swing.JPanel implements ActionListener{
    CategoriaData catData;
    CategoriaDao catDao;
    public DefaultTableModel modelo = new DefaultTableModel();
    
    public Inventario() {
        initComponents();
        tableCategoria.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        // cambia el fondo del encabezado de la tabla
        tableCategoria.getTableHeader().setBackground(new Color(121,92,52));
        // cambia el color de la letra del encabezado de la tabla
        tableCategoria.getTableHeader().setForeground(Color.white);
        scrollCategoria.setBorder(BorderFactory.createEmptyBorder());
  
        catData = new CategoriaData();
        catDao = new CategoriaDao();
        
        btnInsert.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnLimpiar.addActionListener(this);
        btnFiltrar.addActionListener(this);
        modelo = (DefaultTableModel)tableCategoria.getModel();
        listar();
        autoIncrement();
    }
    
    public void autoIncrement(){
        int id = catDao.id_autoincrement();
        txtCategoriaID.setText(""+id);
    }
    
    public void limpiarTabla(){
        for (int i = 0; i < tableCategoria.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void limpiar(){
        txtCategoriaID.setText("");
        txtNombre.setText("");
        txtDesc.setText("");
        txtCodigo.setText("");
        txtFecCreacion.setText("");
        txtUltimaModif.setText("");
        txtCantidad.setText("");
        txtCantidadStock.setText("");
    }
    
    public void listar(){
        List<CategoriaData> lista = catDao.listar();
        Object[] object  = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCategoriaID();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getDescripcion();
            object[3] = lista.get(i).getCodigo();
            object[4] = lista.get(i).getFechaCreacion();
            object[5] = lista.get(i).getUltimaModificacion();
            object[6] = lista.get(i).getCantMedicamento();
            object[7] = lista.get(i).getCantMinimaEnStock();
            modelo.addRow(object);
        }
        tableCategoria.setModel(modelo);
    }
    public void buscar(){
        List<CategoriaData> lista = catDao.buscador(txtFiltrar.getText());
        Object[] object  = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getCategoriaID();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getDescripcion();
            object[3] = lista.get(i).getCodigo();
            object[4] = lista.get(i).getFechaCreacion();
            object[5] = lista.get(i).getUltimaModificacion();
            object[6] = lista.get(i).getCantMedicamento();
            object[7] = lista.get(i).getCantMinimaEnStock();
            modelo.addRow(object);
        }
        tableCategoria.setModel(modelo);
    }
    
    public void agregar(){
        int CategoriaID = Integer.parseInt(txtCategoriaID.getText());
        String nombre = txtNombre.getText();
        String Descripcion = txtDesc.getText();
        String Codigo = txtCodigo.getText();
        String FechaCreacion = txtFecCreacion.getText();
        String UltimaModificacion = txtUltimaModif.getText();
        int CantMedicamento = Integer.parseInt(txtCantidad.getText());
        int CantMinimaEnStock = Integer.parseInt(txtCantidadStock.getText());
        catData.setCategoriaID(CategoriaID);
        catData.setNombre(nombre);
        catData.setDescripcion(Descripcion);
        catData.setCodigo(Codigo);
        catData.setFechaCreacion(FechaCreacion);
        catData.setUltimaModificacion(UltimaModificacion);
        catData.setCantMedicamento(CantMedicamento);
        catData.setCantMinimaEnStock(CantMinimaEnStock);
        catDao.agregar(catData);
    }
    public void actualizar(){
        int CategoriaID = Integer.parseInt(txtCategoriaID.getText());
        String nombre = txtNombre.getText();
        String Descripcion = txtDesc.getText();
        String Codigo = txtCodigo.getText();
        String FechaCreacion = txtFecCreacion.getText();
        String UltimaModificacion = txtUltimaModif.getText();
        int CantMedicamento = Integer.parseInt(txtCantidad.getText());
        int CantMinimaEnStock = Integer.parseInt(txtCantidadStock.getText());
        catData.setCategoriaID(CategoriaID);
        catData.setNombre(nombre);
        catData.setDescripcion(Descripcion);
        catData.setCodigo(Codigo);
        catData.setFechaCreacion(FechaCreacion);
        catData.setUltimaModificacion(UltimaModificacion);
        catData.setCantMedicamento(CantMedicamento);
        catData.setCantMinimaEnStock(CantMinimaEnStock);
        catDao.actualizar(catData);
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
        scrollCategoria = new javax.swing.JScrollPane();
        tableCategoria = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidadStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCategoriaID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtFecCreacion = new javax.swing.JTextField();
        txtUltimaModif = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();

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
        jLabel10.setText("Edicion de Categoria");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        btnInsert.setBackground(new java.awt.Color(121, 92, 52));
        btnInsert.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
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

        btnLimpiar.setBackground(new java.awt.Color(121, 92, 52));
        btnLimpiar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
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

        btnModificar.setBackground(new java.awt.Color(121, 92, 52));
        btnModificar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
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

        btnEliminar.setBackground(new java.awt.Color(121, 92, 52));
        btnEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
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

        btnFiltrar.setBackground(new java.awt.Color(121, 92, 52));
        btnFiltrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setBorder(null);
        jPanel2.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 90, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 460, 350));

        scrollCategoria.setBorder(null);

        tableCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CategoriaID", "Nombre", "Descripcion", "Codigo", "FechaCreacion", "UltimaModificación", "Cantidad_Medicamentos", "Stock"
            }
        ));
        tableCategoria.setGridColor(new java.awt.Color(255, 255, 255));
        tableCategoria.setSelectionBackground(new java.awt.Color(203, 170, 131));
        tableCategoria.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCategoriaMouseClicked(evt);
            }
        });
        scrollCategoria.setViewportView(tableCategoria);
        if (tableCategoria.getColumnModel().getColumnCount() > 0) {
            tableCategoria.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableCategoria.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableCategoria.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        add(scrollCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 730, 260));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("CategoriaID: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        txtCantidadStock.setBackground(new java.awt.Color(217, 217, 217));
        txtCantidadStock.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCantidadStock.setBorder(null);
        jPanel3.add(txtCantidadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 130, 20));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Nombre: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Descripción: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Codigo: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Fec_Creacion: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("UltimaModifi: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 20));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Cantidad_Medi: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, 20));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("CantidadStock:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Datos de los Categoria");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        txtCategoriaID.setEditable(false);
        txtCategoriaID.setBackground(new java.awt.Color(217, 217, 217));
        txtCategoriaID.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCategoriaID.setBorder(null);
        jPanel3.add(txtCategoriaID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 130, 20));

        txtNombre.setBackground(new java.awt.Color(217, 217, 217));
        txtNombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNombre.setBorder(null);
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 20));

        txtDesc.setBackground(new java.awt.Color(217, 217, 217));
        txtDesc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDesc.setBorder(null);
        jPanel3.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 130, 20));

        txtCodigo.setBackground(new java.awt.Color(217, 217, 217));
        txtCodigo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodigo.setBorder(null);
        jPanel3.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 130, 20));

        txtFecCreacion.setBackground(new java.awt.Color(217, 217, 217));
        txtFecCreacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtFecCreacion.setBorder(null);
        jPanel3.add(txtFecCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 130, 20));

        txtUltimaModif.setBackground(new java.awt.Color(217, 217, 217));
        txtUltimaModif.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtUltimaModif.setBorder(null);
        jPanel3.add(txtUltimaModif, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 130, 20));

        txtCantidad.setBackground(new java.awt.Color(217, 217, 217));
        txtCantidad.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCantidad.setBorder(null);
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 130, 20));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 260, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseEntered
        btnInsert.setBackground(new Color(121,104,84));
    }//GEN-LAST:event_btnInsertMouseEntered

    private void btnInsertMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseExited
        btnInsert.setBackground(new Color(121,92,52));
    }//GEN-LAST:event_btnInsertMouseExited

    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        btnLimpiar.setBackground(new Color(121,104,84));
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        btnLimpiar.setBackground(new Color(121,92,52));
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseEntered
        btnModificar.setBackground(new Color(121,104,84));
    }//GEN-LAST:event_btnModificarMouseEntered

    private void btnModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseExited
        btnModificar.setBackground(new Color(121,92,52));
    }//GEN-LAST:event_btnModificarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(new Color(121,104,84));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new Color(121,92,52));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void tableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCategoriaMouseClicked
        int fila = tableCategoria.getSelectedRow();
        if(fila == -1){
            System.out.println("Seleccione una fila");
        }else{
            int CategoriaID = Integer.parseInt(tableCategoria.getValueAt(fila, 0).toString());
            String nombre = (String) tableCategoria.getValueAt(fila, 1);
            String Descripcion = (String) tableCategoria.getValueAt(fila, 2);
            String Codigo = (String) tableCategoria.getValueAt(fila, 3);
            String FechaCreacion = (String) tableCategoria.getValueAt(fila, 4);
            String UltimaModificacion = (String) tableCategoria.getValueAt(fila, 5);
            int CantMedicamento = Integer.parseInt(tableCategoria.getValueAt(fila, 6).toString());
            int CantMinimaEnStock = Integer.parseInt( tableCategoria.getValueAt(fila, 7).toString());
            txtCategoriaID.setText(""+CategoriaID);
            txtNombre.setText(nombre);
            txtDesc.setText(Descripcion);
            txtCodigo.setText(Codigo);
            txtFecCreacion.setText(FechaCreacion);
            txtUltimaModif.setText(UltimaModificacion);
            txtCantidad.setText(""+CantMedicamento);
            txtCantidadStock.setText(""+CantMinimaEnStock);
        }
    }//GEN-LAST:event_tableCategoriaMouseClicked

    private void txtFiltrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFiltrarMousePressed
        txtFiltrar.setText("");
    }//GEN-LAST:event_txtFiltrarMousePressed


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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane scrollCategoria;
    public javax.swing.JTable tableCategoria;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtCantidadStock;
    public javax.swing.JTextField txtCategoriaID;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtDesc;
    public javax.swing.JTextField txtFecCreacion;
    public javax.swing.JTextField txtFiltrar;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtUltimaModif;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnFiltrar){
            if(txtFiltrar.getText() == "Filtrar..."){
                JOptionPane.showMessageDialog(null, "No Ingreso Nada");
            }
            if(txtFiltrar.getText() == ""){
                limpiarTabla();
                listar();
            }else{
                limpiarTabla();
                buscar();
            }
        }
        if(e.getSource() == btnInsert){
            agregar();
            limpiarTabla();
            listar();
            autoIncrement();
        }
        if(e.getSource() == btnEliminar){
            int fila = tableCategoria.getSelectedRow();
            int id = Integer.parseInt(tableCategoria.getValueAt(fila, 0).toString());
            if(fila == -1){
                JOptionPane.showMessageDialog(null, "Seleccionar un registro");
            }else{
                catDao.delete(id);
            }
            limpiarTabla();
            listar();
            limpiar();
            autoIncrement();
        }
        if(e.getSource() == btnModificar){
            actualizar();
            limpiarTabla();
            listar();
            autoIncrement();
        }
        if(e.getSource() == btnLimpiar){
            limpiar();
            autoIncrement();
        }
    }
}

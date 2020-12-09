/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Modelo.Equipo;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Jhon_kq
 */
public class EquipoIG extends javax.swing.JInternalFrame {

    /**
     * Creates new form EquipoIG
     */
    public EquipoIG() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
    }

        //Borra todas la filas del jTable
     private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
     
     //Carga los datos de las comunas en el jTable
    public void cargarEquipos(ArrayList<Equipo> listadoActores){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();        
        limpiarListadoTabla();
        for(int i= 0; i < listadoActores.size(); i++){
              
              modelo.addRow(new Object[]{
                  listadoActores.get(i).getSerial(),
                  listadoActores.get(i).getMarca(),
                  listadoActores.get(i).getIp(),
                  listadoActores.get(i).getEstado(),
                  listadoActores.get(i).getCaracteristicas(),
                  listadoActores.get(i).getIdUsuario(),
                  listadoActores.get(i).getArea(),
                  listadoActores.get(i).getTipo(),
                  listadoActores.get(i).getFechaIngreso()
              });
        }
    }
    
    public String getSerial(){
        return txtSerial.getText().trim();
    }
    public String getMarca(){
        return txtMarca.getText().trim();
    }
    public String getIp(){
        return txtIp.getText().trim();
    }
    public String getEstado(){
        return txtEstado.getText().trim();
    }
    public String getCaracteristicas(){
        return txtCaracteristicas.getText().trim();
    }
    public String getIdUsuario(){
        return txtIdUsuario.getText().trim();
    }
    public String getArea(){
        return txtArea.getText().trim();
    }
    public String getTipo(){
        return txtTipo.getText().trim();
    }
    public String getFechaIngreso(){
        return txtFechaIngreso.getText().trim();
    }
    
    public void addListenerBtnNuevo(ActionListener listenPrograma){
        btnNuevo.addActionListener(listenPrograma);
    }
    
    public void addListenerBtnModificar(ActionListener listenPrograma){
        btnCerrar.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnBorrar(ActionListener listenPrograma){
        btnBorrar.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnCerrar(ActionListener listenPrograma){
        btnModificar.addActionListener(listenPrograma);        
    }    
             
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
    
    public void activarControles(boolean estado){
        txtSerial.setEnabled(estado);
        txtMarca.setEnabled(estado);   
        txtIp.setEnabled(estado); 
        txtEstado.setEnabled(estado);
        txtCaracteristicas.setEnabled(estado);   
        txtIdUsuario.setEnabled(estado); 
        txtArea.setEnabled(estado);
        txtTipo.setEnabled(estado);   
        txtFechaIngreso.setEnabled(estado); 
        btnBorrar.setEnabled(!estado);
        btnCerrar.setEnabled(!estado);
        jtListado.setEnabled(!estado);
    }
    
        public void modificarAction(){
        if(btnModificar.getText().equals("Modificar")){
            if(jtListado.getSelectedRow() == -1){
               if(jtListado.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"No hay registros");
               }
               else{
                   JOptionPane.showMessageDialog(this,"Seleccione una fila");
               }
            }else{ 
                activarControles(true); 
                txtSerial.setEnabled(false);
                btnNuevo.setText("Actualizar");
                btnNuevo.setActionCommand("Actualizar");            
                btnModificar.setText("Cancelar");
                btnModificar.setActionCommand("Cancelar");
                btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/save-program.png"))); // NOI18N
                btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/cancel.png"))); // NOI18N
                txtSerial.requestFocusInWindow();
            }
        }else{
            activarControles(false);            
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/new-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/update-program.png"))); // NOI18N
            btnNuevo.requestFocusInWindow();
        }
    }
        
     public void nuevoAction(){          
        if(btnNuevo.getText().equals("Nuevo")){  
            txtSerial.setText("");
            txtMarca.setText("");
            txtIp.setText("");
            txtEstado.setText("");
            txtCaracteristicas.setText("");
            txtIdUsuario.setText("");
            txtArea.setText("");
            txtTipo.setText("");
            txtFechaIngreso.setText("");
            activarControles(true); 
            btnNuevo.setText("Grabar");
            btnNuevo.setActionCommand("Grabar");            
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/save-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/cancel.png"))); // NOI18N
            txtSerial.requestFocusInWindow();
        }
        else{
            activarControles(false);            
            btnNuevo.setText("Nuevo");
            btnNuevo.setActionCommand("Nuevo");
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnNuevo.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/new-program.png"))); // NOI18N
            btnModificar.setIcon(new ImageIcon(getClass().
                    getResource("/recursos/update-program.png"))); // NOI18N
            btnNuevo.requestFocusInWindow();
        }
    }  
     
    public void cancelarAction(){
        txtSerial.setEnabled(false);
        txtMarca.setEnabled(false);   
        txtIp.setEnabled(false); 
        txtEstado.setEnabled(false);
        txtCaracteristicas.setEnabled(false);   
        txtIdUsuario.setEnabled(false); 
        txtArea.setEnabled(false);
        txtTipo.setEnabled(false);   
        txtFechaIngreso.setEnabled(false); 
        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(false);
        btnCerrar.setEnabled(false);
        jtListado.setEnabled(true);
    }
    
    public void cerrarAction(){
        dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jtListado = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSerial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtIp = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        txtFechaIngreso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCaracteristicas = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setVisible(true);

        jtListado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 112, 99)));
        jtListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Serial", "Marca", "Ip", "Estado", "Caracteristicas", "Id Usuario", "Area", "Tipo", "Fecha Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListado);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Equipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(80, 112, 99))); // NOI18N

        jLabel1.setText("Serial:");

        txtSerial.setForeground(new java.awt.Color(255, 255, 255));
        txtSerial.setEnabled(false);

        jLabel2.setText("Marca:");

        jLabel3.setText("Ip:");

        jLabel4.setText("Estado:");

        txtMarca.setEnabled(false);
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        txtIp.setEnabled(false);

        txtEstado.setEnabled(false);

        jLabel7.setText("Id Usuario:");

        jLabel8.setText("Area:");

        jLabel9.setText("Tipo:");

        jLabel6.setText("Fecha Ingreso:");

        txtIdUsuario.setEnabled(false);

        txtArea.setEnabled(false);

        txtTipo.setEnabled(false);

        txtFechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaIngreso.setEnabled(false);

        txtCaracteristicas.setColumns(20);
        txtCaracteristicas.setRows(5);
        txtCaracteristicas.setEnabled(false);
        jScrollPane1.setViewportView(txtCaracteristicas);

        jLabel5.setText("Caracteristicas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8)
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(67, 67, 67)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(80, 112, 99))); // NOI18N

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/usuario.png"))); // NOI18N
        btnNuevo.setText("  Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/lapiz.png"))); // NOI18N
        btnModificar.setText("Modificar");

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancelar.png"))); // NOI18N
        btnBorrar.setText("  Borrar");
        btnBorrar.setToolTipText("");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/proximo.png"))); // NOI18N
        btnCerrar.setText("   Salir");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void jtListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoMouseClicked
                // TODO add your handling code here:
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtListado.getModel();
                            
        if(jtListado.getSelectedRow()==-1){
            if(jtListado.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"No hay registros");
            }
            else{
                JOptionPane.showMessageDialog(this,"Seleccione una fila");
            }
        }else {                               
            txtSerial.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 0).toString());            
            txtMarca.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 1).toString());
            txtIp.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 2).toString());
            txtEstado.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 3).toString());
            txtCaracteristicas.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 4).toString());
            txtIdUsuario.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 5).toString());
            txtArea.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 6).toString());
            txtTipo.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 7).toString());
            txtFechaIngreso.setText(modelo.getValueAt(
                    jtListado.getSelectedRow(), 8).toString());
        }
    }//GEN-LAST:event_jtListadoMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtListado;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextArea txtCaracteristicas;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtSerial;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

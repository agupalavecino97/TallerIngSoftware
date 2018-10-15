
package corralon.vistas.proveedores;

import corralon.DAO.DAOManager;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.modelos.proveedor;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaProveedores extends javax.swing.JFrame {

   
 private DAOManager manager;
 
 private ProveedorTableModel model;
 
 public ListaProveedores(DAOManager manager){
     initComponents();
     this.manager= manager;
     this.model = new ProveedorTableModel(manager.getproveedorDao());
     this.model.updateModel();
     this.Tabla.setModel(model);
//     this.Tabla.getSelectionModel().addListSelectionListener(e ->{
//            boolean seleccionValida = (Tabla.getSelectedRow() != 1);
//            modificar.setEnabled(seleccionValida);
//            eliminar.setEnabled(seleccionValida);
//     });
             
 }
 
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        añadir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        detalleProveedores1 = new corralon.vistas.proveedores.detalleProveedores();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setRollover(true);

        añadir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/add.png"))); // NOI18N
        añadir.setText("Añadir");
        añadir.setFocusable(false);
        añadir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        añadir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        jToolBar1.add(añadir);
        jToolBar1.add(jSeparator1);

        modificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/update.png"))); // NOI18N
        modificar.setText("Modificar");
        modificar.setFocusable(false);
        modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(modificar);

        eliminar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/delete.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setFocusable(false);
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(eliminar);
        jToolBar1.add(jSeparator2);

        guardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/save.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/delete.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setEnabled(false);
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelar);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalleProveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(detalleProveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        detalleProveedores1.setProveedor(null);
        detalleProveedores1.loadData();
        detalleProveedores1.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_añadirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
       detalleProveedores1.setProveedor(getProveedorSeleccionado());
       detalleProveedores1.setEditable(true);
       detalleProveedores1.loadData();
       guardar.setEnabled(true);
       cancelar.setEnabled(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
         if(JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres borrar este proveedor?","borrar proveedor", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            manager.getproveedorDao().eliminar(getProveedorSeleccionado());            
        }
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_eliminarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
try {
         detalleProveedores1.saveData();
     } catch (ParseException ex) {
         Logger.getLogger(ListaProveedores.class.getName()).log(Level.SEVERE, null, ex);
     }
        proveedor c=detalleProveedores1.getProveedor();    
        proveedor control=manager.getproveedorDao().obtener(c.getCuitProveedor()); //para controlar si el cliente existe ya comparando el cuit con los existentes en la base de datos, si existte se actualizan los datos si no se inserta un nuevo cliente
        if(control==null){
            manager.getproveedorDao().insertar(c);
        }else manager.getproveedorDao().modificar(c);
       //para que se limpie todo
       detalleProveedores1.setProveedor(null);
       detalleProveedores1.setEditable(false);
       detalleProveedores1.loadData();
       Tabla.clearSelection();
       guardar.setEnabled(false);
       cancelar.setEnabled(false);
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalleProveedores1.setProveedor(null);
        detalleProveedores1.setEditable(false);
        detalleProveedores1.loadData();
        Tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    
    private proveedor getProveedorSeleccionado(){
         Long id = (Long) Tabla.getValueAt(Tabla.getSelectedRow(),0);
        return manager.getproveedorDao().obtener(id);
    }
    
    
    
    
    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
//    
//    public static void main(String args[]) throws SQLException {
//        DAOManager manager = new MySQLDAOManager("localhost", "taller", "root", "root");
//                
//        java.awt.EventQueue.invokeLater(() -> {
//            new ListaProveedores(manager).setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton añadir;
    private javax.swing.JButton cancelar;
    private corralon.vistas.proveedores.detalleProveedores detalleProveedores1;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables
}


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
     this.Tabla.getSelectionModel().addListSelectionListener(e ->{
            boolean seleccionValida = (Tabla.getSelectedRow() != 1);
            modificar.setEnabled(seleccionValida);
            eliminar.setEnabled(seleccionValida);
     });
             
 }
 
 
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        detalle = new corralon.vistas.proveedores.detalleProveedores();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 50));

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

        guardar.setText("Guardar");
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jToolBar1.add(guardar);

        cancelar.setText("Cancelar");
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelar);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(252, 402));

        Tabla.setAutoCreateRowSorter(true);
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cuit", "RazonSocial", "Direccion", "Telefono"
            }
        ));
        Tabla.setPreferredSize(new java.awt.Dimension(200, 64));
        jScrollPane1.setViewportView(Tabla);

        jPanel2.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        detalle.setProveedor(null);
        detalle.loadData();
        detalle.setEditable(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_añadirActionPerformed

    
    private proveedor getProveedorSeleccionado(){
        Long id = (Long) Tabla.getValueAt(Tabla.getSelectedRow(),0);
        return manager.getproveedorDao().obtener(id);
    }
    
    
    
    
    
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
       proveedor proveedor = getProveedorSeleccionado();
       detalle.setProveedor(proveedor);
       detalle.setEditable(true);
       detalle.loadData();
       guardar.setEnabled(true);
       cancelar.setEnabled(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalle.setProveedor(null);
        detalle.setEditable(false);
        detalle.loadData();
        Tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        proveedor c=detalle.getProveedor();    
        proveedor control=manager.getproveedorDao().obtener(c.getCuitProveedor()); //para controlar si el cliente existe ya comparando el cuit con los existentes en la base de datos, si existte se actualizan los datos si no se inserta un nuevo cliente
        if(control==null){
            manager.getproveedorDao().insertar(c);
        }else manager.getproveedorDao().modificar(c);
       //para que se limpie todo
       detalle.setProveedor(null);
       detalle.setEditable(false);
       detalle.loadData();
       Tabla.clearSelection();
       guardar.setEnabled(false);
       cancelar.setEnabled(false);
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
        
        
//        try {
//            detalle.saveData();
//        } catch (ParseException ex) {
//            Logger.getLogger(ListaProveedores.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        proveedor c=detalle.getProveedor();
//        proveedor control=manager.getproveedorDao().obtener(c.getCuitProveedor()); //para controlar si el cliente existe ya comparando el cuit con los existentes en la base de datos, si existte se actualizan los datos si no se inserta un nuevo cliente
//        if(control==null){
//            manager.getproveedorDao().insertar(c);
//        }else manager.getproveedorDao().modificar(c);
//       //para que se limpie todo
//       detalle.setProveedor(null);
//       detalle.setEditable(false);
//       detalle.loadData();
//       Tabla.clearSelection();
//       guardar.setEnabled(false);
//       cancelar.setEnabled(false);
//       //para actualizar la tabla
//       model.updateModel();
//       model.fireTableDataChanged();
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres borrar este cliente?","borrar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            proveedor c=getProveedorSeleccionado();
            manager.getproveedorDao().eliminar(c);            
        }
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_eliminarActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    
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
    private corralon.vistas.proveedores.detalleProveedores detalle;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modificar;
    // End of variables declaration//GEN-END:variables
}

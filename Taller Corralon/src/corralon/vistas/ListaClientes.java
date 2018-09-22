
package corralon.vistas;

import corralon.DAO.DAOManager;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.modelos.cliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaClientes extends javax.swing.JFrame {

    private DAOManager manager;
    private Clientestablemodel model;
    
     public ListaClientes(DAOManager manager){
        initComponents();
        this.manager=manager;
        this.model=new Clientestablemodel(manager.getclienteDao());
        this.model.updateModel();
        this.Tabla.setModel(model); 
        //modificar.setEnabled(false);
        //eliminar.setEnabled(false);
        guardar.setEnabled(false);
        cancelar.setEnabled(false); 
        //Aqui se habilitan los botones al seleccionar un cliente para que de la opcion de eliminar o mdificar sus datos
        //La cosa es que no se como hacer que los botones esten deshabilitados desede unn pricipio, asi que lo dejo pendiente
        //El problema que da es que como ya estan habilitados desde un principio los botones al habilitarlos de vuelta debe entender que se tiene que deshabilitar

//        this.Tabla.getSelectionModel().addListSelectionListener(c ->{
//            boolean seleccionValida= (tabla.getSelectedRow()!=-1);
//            modificar.setEnabled(seleccionValida);
//            eliminar.setEnabled(seleccionValida);
//            });
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalleCliente1 = new corralon.vistas.detalleCliente();
        jPanel1 = new javax.swing.JPanel();
        toolbar = new javax.swing.JToolBar();
        añadir = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        detalle = new corralon.vistas.detalleCliente();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        toolbar.setRollover(true);

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
        toolbar.add(añadir);

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/update.png"))); // NOI18N
        modificar.setText("Modificar");
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.setDisabledSelectedIcon(null);
        modificar.setFocusPainted(false);
        modificar.setFocusable(false);
        modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        toolbar.add(modificar);

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/delete.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setDisabledSelectedIcon(null);
        eliminar.setFocusable(false);
        eliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        eliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        toolbar.add(eliminar);

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/save.png"))); // NOI18N
        guardar.setText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.setDisabledSelectedIcon(null);
        guardar.setFocusable(false);
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        toolbar.add(guardar);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setDisabledSelectedIcon(null);
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        toolbar.add(cancelar);

        getContentPane().add(toolbar, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

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
        jScrollPane2.setViewportView(Tabla);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);
        jPanel2.add(detalle, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres borrar este cliente?","borrar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            cliente c=getClienteSeleccionado();
            manager.getclienteDao().eliminar(c);            
        }
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_eliminarActionPerformed
  
    private cliente getClienteSeleccionado(){
        Long id=(Long) Tabla.getValueAt(Tabla.getSelectedRow(), 0);   
        return manager.getclienteDao().obtener(id);
    } 
    
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        cliente cliente=getClienteSeleccionado();
        detalle.setCliente(cliente);
        detalle.setEditable(true);
        detalle.loadData();
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
       detalle.setCliente(null);
       detalle.setEditable(false);
       detalle.loadData();
       tabla.clearSelection();
       guardar.setEnabled(false);
       cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
       detalle.setCliente(null);
       detalle.setEditable(true);
       detalle.loadData();
       guardar.setEnabled(true);
       cancelar.setEnabled(true);
    }//GEN-LAST:event_añadirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            detalle.saveData();
        } catch (ParseException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente c=detalle.getCliente();
        cliente control=manager.getclienteDao().obtener(c.getCuitCliente()); //para controlar si el cliente existe ya comparando el cuit con los existentes en la base de datos, si existte se actualizan los datos si no se inserta un nuevo cliente
        if(control==null){
            manager.getclienteDao().insertar(c);
        }else manager.getclienteDao().modificar(c);
       //para que se limpie todo
       detalle.setCliente(null);
       detalle.setEditable(false);
       detalle.loadData();
       tabla.clearSelection();
       guardar.setEnabled(false);
       cancelar.setEnabled(false);
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_guardarActionPerformed

 
//    public static void main(String args[]) throws SQLException {
//        
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        DAOManager manager=new MySQLDAOManager("localhost","taller","root","root");
//        java.awt.EventQueue.invokeLater(()-> {        
//                new ListaClientes(manager).setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton añadir;
    private javax.swing.JButton cancelar;
    private corralon.vistas.detalleCliente detalle;
    private corralon.vistas.detalleCliente detalleCliente1;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables

    
}

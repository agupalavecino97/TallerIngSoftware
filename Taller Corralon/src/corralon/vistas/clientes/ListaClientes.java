    
package corralon.vistas.clientes;

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
        this.tabla.setModel(model); 
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

        jToolBar1 = new javax.swing.JToolBar();
        añadir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        detalle = new corralon.vistas.clientes.DetalleClientes();

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
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
       detalle.setCliente(null);
       detalle.setEditable(true);
       detalle.loadData();
       guardar.setEnabled(true);
       cancelar.setEnabled(true);
    }//GEN-LAST:event_añadirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        detalle.setCliente(getClienteSeleccionado());
        detalle.setEditable(true);
        detalle.loadData();
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
          if(JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres borrar este cliente?","borrar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            manager.getclienteDao().eliminar(getClienteSeleccionado());            
        }
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_eliminarActionPerformed

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

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
         detalle.setCliente(null);
       detalle.setEditable(false);
       detalle.loadData();
       tabla.clearSelection();
       guardar.setEnabled(false);
       cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed
  
    private cliente getClienteSeleccionado(){
          Long id=(Long) tabla.getValueAt(tabla.getSelectedRow(), 0);   
        return manager.getclienteDao().obtener(id);
    } 
    
// 
//public static void main(String args[]) throws SQLException {
//
//        DAOManager manager=new MySQLDAOManager("localhost","taller","root","root");
//        java.awt.EventQueue.invokeLater(()-> {        
//                new ListaClientes(manager).setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadir;
    private javax.swing.JButton cancelar;
    private corralon.vistas.clientes.DetalleClientes detalle;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    
}

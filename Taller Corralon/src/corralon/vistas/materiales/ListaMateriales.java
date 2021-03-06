
package corralon.vistas.materiales;

import corralon.DAO.DAOManager;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.modelos.stock;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaMateriales extends javax.swing.JFrame {

    private DAOManager manager;
    private MaterialesTableModel model;
    
    
    public ListaMateriales(DAOManager manager) {
        initComponents();
        this.manager=manager;
        this.model=new MaterialesTableModel(manager.getmaterialDao());
        this.model.updateModel();
        this.tabla.setModel(model); 
        //modificar.setEnabled(false);
        //eliminar.setEnabled(false);
        guardar.setEnabled(false);
        cancelar.setEnabled(false); 
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
        tabla = new javax.swing.JTable();
        detalleMateriales1 = new corralon.vistas.materiales.detalleMateriales();

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
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalleMateriales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(detalleMateriales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private stock getMaterialSeleccionado(){
        Long id=(Long) tabla.getValueAt(tabla.getSelectedRow(),0);  
        //System.out.println(id);
        return manager.getmaterialDao().obtener(id);
    } 
    
    
    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        detalleMateriales1.setMaterial(null);
        detalleMateriales1.setEditable(true);
        detalleMateriales1.loadData();
        guardar.setEnabled(true);
        cancelar.setEnabled(true);       
    }//GEN-LAST:event_añadirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
     
      try {
          detalleMateriales1.saveData();
      } catch (ParseException ex) {
          Logger.getLogger(ListaMateriales.class.getName()).log(Level.SEVERE, null, ex);
      }
        stock material=detalleMateriales1.getMaterial();

        //System.out.println(material);
       // System.out.println(material);  //para ver si se ingresa bien el amterial
//        Long a=Long.parseLong(String.valueOf(3));
//        Long b=Long.parseLong(String.valueOf(2));
//        Long c=Long.parseLong(String.valueOf(2));
//        Long d=Long.parseLong(String.valueOf(2));
//        Long e=Long.parseLong(String.valueOf(2));
//        stock g=new stock(a,"nombremodificado",b,"deascr",c,d,e,true);
//        manager.getmaterialDao().insertar(material);
        stock control=manager.getmaterialDao().obtener(material.getCodMaterial());
        //System.out.println(control);


//        Long a=Long.parseLong(String.valueOf(3));
//        Long b=Long.parseLong(String.valueOf(2));
//        Long c=Long.parseLong(String.valueOf(2));
//        Long d=Long.parseLong(String.valueOf(2));
//        Long e=Long.parseLong(String.valueOf(2));
//        stock g=new stock(a,"nombremodificado",b,"deascr",c,d,e,true);
//        manager.getmaterialDao().insertar(material);
//        stock control=manager.getmaterialDao().obtener(material.getCodMaterial());
//        if(control==null){
//            manager.getmaterialDao().insertar(material);          
//        }
//        else{
//            manager.getmaterialDao().modificar(material);
//        }

        //ya estaba definida arriba
       // stock control=manager.getmaterialDao().obtener(material.getCodMaterial());

        if(control==null){
            manager.getmaterialDao().insertar(material);          
        }
        else{
            manager.getmaterialDao().modificar(material);
        }

        //para que se limpie todo
       detalleMateriales1.setMaterial(null);
       detalleMateriales1.setEditable(false);
       detalleMateriales1.loadData();
       tabla.clearSelection();
       guardar.setEnabled(false);
       cancelar.setEnabled(false);
       //para actualizar la tabla
       model.updateModel();
       model.fireTableDataChanged();
    }//GEN-LAST:event_guardarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        detalleMateriales1.setMaterial(getMaterialSeleccionado());
        detalleMateriales1.setEditable(true);
        detalleMateriales1.loadData();
        //System.out.println(getMaterialSeleccionado());
        guardar.setEnabled(true);
        cancelar.setEnabled(true);      
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
         if(JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres borrar este material?","borrar material", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
         manager.getmaterialDao().eliminar(getMaterialSeleccionado());
         }
         model.updateModel();
         model.fireTableDataChanged();
    }//GEN-LAST:event_eliminarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        detalleMateriales1.setMaterial(null);
        detalleMateriales1.setEditable(false);
        detalleMateriales1.loadData();
        tabla.clearSelection();
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    
 
    
    
    
    
    
    
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
//            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListaMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//           
//        DAOManager manager=new MySQLDAOManager("localhost","taller","root","root");
//        java.awt.EventQueue.invokeLater(() -> {
//            new ListaMateriales(manager).setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadir;
    private javax.swing.JButton cancelar;
    private corralon.vistas.materiales.detalleMateriales detalleMateriales1;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

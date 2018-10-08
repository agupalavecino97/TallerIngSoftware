
package corralon.vistas.GenerarUnPresupuesto;

import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.DAOManager;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.modelos.stock;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SeleccionarMateriales extends javax.swing.JFrame {

    
   private DAOManager manager;
   private materialesTalbeModel2 model;
   private Long CuitClienteIngresado=null;
   public  static List<pedidoConCantidad> pedido=new ArrayList();
   
    public SeleccionarMateriales(DAOManager manager) {
        initComponents();
        this.manager=manager;
        this.model=new materialesTalbeModel2(manager.getmaterialDao());
        this.model.updateModel();
        this.tabla.setModel(model); 
    }

    public List<pedidoConCantidad> getPedido() {
        return pedido;
    }

    public void setPedido(List<pedidoConCantidad> pedido) {
        this.pedido = pedido;
    }

    
    public void setCuitClienteIngresado(Long CuitClienteIngresado) {
        this.CuitClienteIngresado = CuitClienteIngresado;
    }

    private stock getMaterialSeleccionado(){
        Long id=(Long) tabla.getValueAt(tabla.getSelectedRow(),0);   
        return manager.getmaterialDao().obtener(id);
     
    } 
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Continuar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cantidadMateriales2 = new corralon.vistas.GenerarUnPresupuesto.cantidadMateriales();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Materiales disponibles:");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(Continuar, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.LINE_END);
        jPanel1.add(cantidadMateriales2, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stock material=getMaterialSeleccionado();
        cantidadMateriales2.setMaterial(material);
        cantidadMateriales2.setEditable(true);
        cantidadMateriales2.loadData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        setPedido(cantidadMateriales2.getLista());
        System.out.print("lista enviada:");
        System.out.println(getPedido());
       validacionPresupuesto vistaSiguiente=new validacionPresupuesto(manager);
//       vistaSiguiente.setPedidoRecibido(pedido);
       vistaSiguiente.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_ContinuarActionPerformed

   
    
    
//    public static void main(String args[]) throws SQLException {
//        /* Set the Nimbus look and feel */
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
//            java.util.logging.Logger.getLogger(SeleccionarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SeleccionarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SeleccionarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SeleccionarMateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        DAOManager manager=new MySQLDAOManager("localhost","taller","root","root");
//        java.awt.EventQueue.invokeLater(() -> {
//            new SeleccionarMateriales(manager).setVisible(false);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private corralon.vistas.GenerarUnPresupuesto.cantidadMateriales cantidadMateriales2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

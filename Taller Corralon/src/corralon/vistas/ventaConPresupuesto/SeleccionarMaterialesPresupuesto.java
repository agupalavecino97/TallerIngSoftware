
package corralon.vistas.ventaConPresupuesto;

import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.DAOManager;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.modelos.pedidoMaterial;
import corralon.modelos.stock;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static corralon.vistas.ventaConPresupuesto.verificarExsistenciaPresupuesto.codPedido;

public class SeleccionarMaterialesPresupuesto extends javax.swing.JFrame {

    
   private DAOManager manager;
   private materialesTalbeModel3 model;
   private List<pedidoMaterial> datos=new ArrayList();
   private List<pedidoMaterial> datos2=new ArrayList();
   private List<pedidoMaterialConNombre> datosConNombre=new ArrayList();
   
   public  static List<pedidoConCantidad> pedido=new ArrayList();
   
    public SeleccionarMaterialesPresupuesto(DAOManager manager) {
        initComponents();
        this.manager=manager;
        datos=manager.getpedidoMaterialDao().obtenerTodos();
        System.out.println(datos);
        for(pedidoMaterial m:datos){
            if(m.getCodMaterial()==codPedido)
                datos2.add(m);
        }
        System.out.println(datos2);
        for(pedidoMaterial mat:datos2){
            stock nombre=manager.getmaterialDao().obtener(mat.getCodMaterial());
            
            pedidoMaterialConNombre matNombre=new pedidoMaterialConNombre(mat.getCodMaterial(),mat.getCantidadMaterial(),mat.getSubTotalMat(),nombre.getNombreMaterial(),nombre.getPrecio());
            datosConNombre.add(matNombre);
        }  
        System.out.println(datosConNombre);
        this.model=new materialesTalbeModel3(datosConNombre);
        this.model.updateModel();
        this.tabla.setModel(model); 
    }

    public List<pedidoConCantidad> getPedido() {
        return pedido;
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
        cantidadMaterialesPresupuesto1 = new corralon.vistas.ventaConPresupuesto.cantidadMaterialesPresupuesto();

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
        jPanel1.add(cantidadMaterialesPresupuesto1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        stock material=getMaterialSeleccionado();
        cantidadMaterialesPresupuesto1.setMaterial(material);
        cantidadMaterialesPresupuesto1.setEditable(true);
        cantidadMaterialesPresupuesto1.loadData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        
        System.out.print("lista enviada:");
        System.out.println(getPedido());
       validacionVenta vistaSiguiente=new validacionVenta(manager);
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
//            java.util.logging.Logger.getLogger(SeleccionarMaterialesPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SeleccionarMaterialesPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SeleccionarMaterialesPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SeleccionarMaterialesPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
//            new SeleccionarMaterialesPresupuesto(manager).setVisible(false);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private corralon.vistas.ventaConPresupuesto.cantidadMaterialesPresupuesto cantidadMaterialesPresupuesto1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}


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
   public static List<pedidoMaterialConNombre> datosConNombre=new ArrayList();
   private Long codigoPedido;
   public static int index;
   
   public  static List<pedidoConCantidad> pedido=new ArrayList();
   
    public SeleccionarMaterialesPresupuesto(DAOManager manager) {
        initComponents();
        this.manager=manager;
        System.out.println("el codigo de pedido ingresado:");
        System.out.println(codPedido);
        datos=manager.getpedidoMaterialDao().obtenerTodosDeUnPedido(codPedido);
        System.out.println(datos);
        for(pedidoMaterial mat:datos){
            stock nombre=manager.getmaterialDao().obtener(mat.getCodMaterial());
            pedidoMaterialConNombre matNombre=new pedidoMaterialConNombre(mat.getCodMaterial(),mat.getCantidadMaterial(),mat.getSubTotalMat(),nombre.getPrecio(),nombre.getNombreMaterial());
            datosConNombre.add(matNombre);
        }  
        System.out.println(datosConNombre);
        this.model=new materialesTalbeModel3(datosConNombre);
        this.tabla.setModel(model); 
        
    }

    public static int getIndex() {
        return index;
    }

    public static void setIndex(int index) {
        SeleccionarMaterialesPresupuesto.index = index;
    }

    
    public List<pedidoConCantidad> getPedido() {
        return pedido;
    }

  
    private stock getMaterialSeleccionado(){
        Long id=(Long) tabla.getValueAt(tabla.getSelectedRow(),0);   
        return manager.getmaterialDao().obtener(id);
     
    } 
   
    
    
    private pedidoMaterial getMaterialSeleccionado2(){
        Long id=(Long)tabla.getValueAt(tabla.getSelectedRow(),0);  
        setIndex(tabla.getSelectedRow());
        return manager.getpedidoMaterialDao().obtener(codPedido);
     
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Continuar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
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
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/update.png"))); // NOI18N
        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel1.add(modificar, java.awt.BorderLayout.LINE_END);
        jPanel1.add(cantidadMaterialesPresupuesto1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        stock material=getMaterialSeleccionado();
        pedidoMaterial materialSelec=getMaterialSeleccionado2();
        System.out.println("material seleccionado");
        System.out.println(materialSelec);
        cantidadMaterialesPresupuesto1.setMaterial(material);
        cantidadMaterialesPresupuesto1.setPedMat(materialSelec);
        cantidadMaterialesPresupuesto1.setEditable(true);
        cantidadMaterialesPresupuesto1.loadData();
        
    }//GEN-LAST:event_modificarActionPerformed

    private void actualiarTabla(List<pedidoMaterialConNombre> nuevaLista){
        this.model=new materialesTalbeModel3(nuevaLista);
        this.tabla.setModel(model); 
    }
            
            
    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed

       validacionVentaConPresupuesto vistaSiguiente=new validacionVentaConPresupuesto(manager);
//       vistaSiguiente.setPedidoRecibido(pedido);
        vistaSiguiente.setLocationRelativeTo(null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

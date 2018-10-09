

package corralon.vistas.pedidoProveedor;

import corralon.DAO.DAOManager;
import static corralon.vistas.pedidoProveedor.cantidadMaterialesPedir.listaPedir;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;



public class confirmarPedido extends javax.swing.JFrame {
    private DAOManager manager;
    private confirmarPedidoTableModel model;
    public static float precioTotalCompraActual;
    //public static pedidoCliente pedidoclientes;
   
   
   
   
   public confirmarPedido(DAOManager manager) {
        initComponents();
        this.manager=manager;
        //SeleccionarMateriales vista=new SeleccionarMateriales(manager);
//        System.out.print("lista recibida:");
//        System.out.print(vista.pedido);
        this.model=new confirmarPedidoTableModel(listaPedir);
        this.tabla.setModel(model); 
        String preciototalobtenido=ObtenerPrecioTotal(listaPedir);
        total.setText(preciototalobtenido);
    }

       public String ObtenerPrecioTotal(List<elementosDePedido> pedido) {
        float precioTotal = 0;
        for(elementosDePedido c: pedido) {
            int i = (Integer) c.getCantidad();
           float prova2 = ((float) i);
            precioTotal += (c.getPrecio()*prova2);

        }
        setPrecioTotalCompraActual(precioTotal);
        return String.valueOf(precioTotal);
   } 
       
//       
//         public static Long castObjectToLong(Object object) {
//    return ((Long)object);
//    }

    public static float getPrecioTotalCompraActual() {
        return precioTotalCompraActual;
    }

    public static void setPrecioTotalCompraActual(float precioTotalCompraActual) {
        confirmarPedido.precioTotalCompraActual = precioTotalCompraActual;
    }
         
         
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel1.setText("jLabel1");

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");

        continuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/accept.png"))); // NOI18N
        continuar.setText("Confirmar Compra");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        jLabel2.setText("Total de la compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(cancelar)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(continuar)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(cancelar))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continuar)
                    .addComponent(jLabel2)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        finalizarPedido siguienteVista = new finalizarPedido(manager);
        siguienteVista.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_continuarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
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
//            java.util.logging.Logger.getLogger(confirmarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(confirmarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(confirmarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(confirmarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new confirmarPedido(manager).setVisible(true);
//                
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton continuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables

}


package corralon.vistas.GenerarUnPresupuesto;

import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.DAOManager;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.modelos.pedidoCliente;
import static corralon.vistas.GenerarUnPresupuesto.SeleccionarMateriales.pedido;
import static corralon.vistas.GenerarUnPresupuesto.verificarExsistenciaCliente.cuitClienteIngresado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class validacionPresupuesto extends javax.swing.JFrame {

    private DAOManager manager;
    private validarVentaTableModel model;
    public static Long precioTotal;
    public static pedidoCliente pedidoclientes;
    
    public validacionPresupuesto(DAOManager manager) {
        initComponents();
        this.manager=manager;
        //SeleccionarMateriales vista=new SeleccionarMateriales(manager);
//        System.out.print("lista recibida:");
//        System.out.print(vista.pedido);
        this.model=new validarVentaTableModel(pedido);
        this.tabla.setModel(model); 
        String preciototalobtenido=ObtenerPrecioTotal(pedido);
        total.setText(preciototalobtenido);
    }

    public static pedidoCliente getPedidocliente() {
        return pedidoclientes;
    }

    public static void setPedidocliente(pedidoCliente pedidocliente) {
        validacionPresupuesto.pedidoclientes = pedidocliente;
    }

    
    public String ObtenerPrecioTotal(List<pedidoConCantidad> pedido) {
        int precioTotal = 0;
       for(pedidoConCantidad c: pedido) {
            precioTotal += (c.getCantidad().intValue())*(c.getPrecio().intValue());
        }
        setPrecioTotal(Long.valueOf(precioTotal));
    return Integer.toString(precioTotal);
   }

    public static void setPrecioTotal(Long precioTotal) {
        validacionPresupuesto.precioTotal = precioTotal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        continuar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Confirme el presupuesto");

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

        continuar.setText("Confirmar");
        continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarActionPerformed(evt);
            }
        });

        jLabel2.setText("Total de la compra:");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(continuar)
                    .addComponent(jLabel2)
                    .addComponent(total)))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //volver al menu principal
       pedido.clear(); //limpiar la lista?? nuse
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarActionPerformed
        //pasar a la vista siguiente, confirmar pago
        Long cuitClie=Long.valueOf(cuitClienteIngresado);
        java.util.Date date=new java.util.Date();
        java.sql.Date fechaPedidoClie=new java.sql.Date(date.getTime());
        pedidoCliente pedido=new pedidoCliente(cuitClie,fechaPedidoClie,precioTotal, "presupuesto");
        manager.getpedidoClienteDao().insertar(pedido);
        setPedidocliente(pedido);       
        detallePrespuesto vistanueva=new detallePrespuesto(manager);
        vistanueva.setVisible(true);
        this.setVisible(false);         
    }//GEN-LAST:event_continuarActionPerformed

  
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
//            java.util.logging.Logger.getLogger(validacionPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(validacionPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(validacionPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(validacionPresupuesto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        DAOManager manager=new MySQLDAOManager("localhost","taller","root","root");
//        java.awt.EventQueue.invokeLater(() -> {
//            new validacionPresupuesto(manager).setVisible(false);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}

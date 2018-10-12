
package corralon.vistas.recibirPedido;

import corralon.DAO.DAOManager;
import corralon.modelos.detallePedidoProveedor;
import corralon.modelos.pedidoProveedor;
import corralon.modelos.proveedor;
import corralon.modelos.remito;
import corralon.modelos.stock;
import static corralon.vistas.recibirPedido.verificacionPedido.pedidoIngresado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class mostrarMateriales extends javax.swing.JFrame {


    private DAOManager manager;
    private pedidoTableModel model;
    private List<detallePedidoProveedor> detalle=new ArrayList();
    
    public mostrarMateriales(DAOManager manager) {
        initComponents();
        this.manager=manager;
        detalle=manager.getdetallePedidoProveedor().obtenerTodosDeUnPedido(pedidoIngresado.getCodigoPedidoProveedor());         
        List<pedidoProveedorConNombre> detalleConNombre=new ArrayList();
        for(detallePedidoProveedor producto:detalle){
            stock prod=manager.getmaterialDao().obtener(Long.valueOf(producto.getCodigoMaterial()));
            pedidoProveedorConNombre pedidoNombre=new pedidoProveedorConNombre(producto.getCodigoMaterial(),prod.getNombreMaterial(),producto.getCantidadSolicitada(),producto.getPrecioActual(),producto.getSubtotalPedidoProveedor());
            detalleConNombre.add(pedidoNombre);
        }
        this.model=new pedidoTableModel(detalleConNombre);
        tabla.setModel(model);
        codigoDePedido.setText("Codigo de pedido: "+pedidoIngresado.getCodigoPedidoProveedor());
        FechaPedido.setText("Fecha del pedido: "+pedidoIngresado.getFechaPedidoProveedor());
        Total.setText("total"+pedidoIngresado.getTotalPedidoProveedor());
        proveedor proveedor=manager.getproveedorDao().obtener(pedidoIngresado.getCuitProveedor());
        cuitProv.setText("CUIT del proveedor:"+ proveedor.getCuitProveedor());
        NombreProveedor.setText("Nombre del proveedor: "+proveedor.getNombreProveedor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        codigoDePedido = new javax.swing.JLabel();
        FechaPedido = new javax.swing.JLabel();
        NombreProveedor = new javax.swing.JLabel();
        cuitProv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setForeground(new java.awt.Color(0, 51, 153));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 102, 153));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Verifique el pedido ingresado");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(704, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

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

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/accept.png"))); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        Total.setFont(Total.getFont().deriveFont(Total.getFont().getSize()+2f));
        Total.setText("Valor total del pedido:");

        codigoDePedido.setFont(codigoDePedido.getFont().deriveFont(codigoDePedido.getFont().getSize()+2f));
        codigoDePedido.setText("Codigo de Pedido:");

        FechaPedido.setFont(FechaPedido.getFont().deriveFont(FechaPedido.getFont().getSize()+2f));
        FechaPedido.setText("Fecha del Pedido:");

        NombreProveedor.setFont(NombreProveedor.getFont().deriveFont(NombreProveedor.getFont().getSize()+2f));
        NombreProveedor.setText("Proveedor:");

        cuitProv.setFont(cuitProv.getFont().deriveFont(cuitProv.getFont().getSize()+2f));
        cuitProv.setText("Proveedor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoDePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuitProv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(NombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoDePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cuitProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(11, 11, 11))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
      //pedidoIngresado=null;
      //tabla.setModel(null);
      this.setVisible(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        pedidoProveedor pedidoModificado =new pedidoProveedor(pedidoIngresado.getCodigoPedidoProveedor(),pedidoIngresado.getCuitProveedor(),pedidoIngresado.getFechaPedidoProveedor(),pedidoIngresado.getTotalPedidoProveedor(),"completo");
        manager.getpedidoProveedorDao().modificar(pedidoModificado);
        java.util.Date date=new java.util.Date();
        java.sql.Date fechaDeHoy=new java.sql.Date(date.getTime());
        remito remito=new remito(pedidoIngresado.getCuitProveedor(),pedidoIngresado.getCodigoPedidoProveedor(),pedidoIngresado.getTotalPedidoProveedor(),fechaDeHoy,"completo");
        System.out.println(remito);
        manager.getremitoDao().insertar(remito);
        for(detallePedidoProveedor detalleMaterial:detalle){
            stock material=manager.getmaterialDao().obtener(Long.valueOf(detalleMaterial.getCodigoMaterial()));
            Long nuevaCantidad=material.getCantidadExistente()+detalleMaterial.getCantidadSolicitada();
            stock materialModificado=new stock(material.getCodMaterial(),material.getNombreMaterial(),material.getPrecio(),material.getDescripcionMaterial(),nuevaCantidad,material.getStockMinimo(),material.getStockMaximo(),true);
            manager.getmaterialDao().modificar(materialModificado);
        }
        JOptionPane.showMessageDialog(rootPane,"El stock  fue actualizado exitosamente.");
        this.setVisible(false);
    }//GEN-LAST:event_aceptarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FechaPedido;
    private javax.swing.JLabel NombreProveedor;
    private javax.swing.JLabel Total;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel codigoDePedido;
    private javax.swing.JLabel cuitProv;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

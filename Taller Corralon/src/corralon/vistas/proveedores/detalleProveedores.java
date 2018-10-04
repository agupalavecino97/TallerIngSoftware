
package corralon.vistas.proveedores;

import corralon.modelos.proveedor;
import java.text.ParseException;

public class detalleProveedores extends javax.swing.JPanel {


    public detalleProveedores() {
        initComponents();
    }

      private proveedor proveedor;
    private boolean editable;
    
     public proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        cuit.setEditable(editable);
        nombre.setEditable(editable);
        direccion.setEditable(editable);
        telefono.setEditable(editable);
    }
    
    
    public void loadData(){
        if(proveedor!=null){
            String cu=String.valueOf(proveedor.getCuitProveedor());
            cuit.setText(cu);
            nombre.setText(proveedor.getNombreProveedor());
            direccion.setText(proveedor.getDireccionProveedor());
            String tel=String.valueOf(proveedor.getTelefonoProveedor());
            telefono.setText(tel);                      
        }
        else{
            cuit.setText("");
            nombre.setText("");
            direccion.setText("");
            telefono.setText("");
        }     
        cuit.requestFocus();
    }
    
        public void saveData()throws ParseException{
       if(proveedor==null) {
           proveedor=new proveedor();        
       }
       //material.setIdMaterial((Long)id.getValu);
       //int cod=Integer.parseInt(codigo.getText());
       Long cu=Long.valueOf(cuit.getText());
       proveedor.setCuitProveedor(cu);
       proveedor.setNombreProveedor(nombre.getText());
       proveedor.setDireccionProveedor(direccion.getText());
       Long te=Long.valueOf(telefono.getText());
       proveedor.setTelefonoProveedor(te);
       //System.out.println(material);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cuit = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();

        jLabel1.setText("Cuit:");

        jLabel2.setText("Razon social:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Telefono:");

        cuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuitActionPerformed(evt);
            }
        });

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(cuit))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(direccion))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoActionPerformed

    private void cuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cuitActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cuit;
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}

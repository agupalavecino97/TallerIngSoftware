
package corralon.vistas.pedidoProveedor;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import corralon.modelos.catalogo;
import corralon.modelos.stock;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class cantidadMaterialesPedir extends javax.swing.JPanel {
  private boolean editable;
    private Object cantidadMaterial;
    public static List<elementosDePedido> listaPedir = new ArrayList();
    
    public cantidadMaterialesPedir() {
        initComponents();
        aceptar.setEnabled(false);
        cancelar.setEnabled(false);
        nombre.setEditable(false);
        precio.setEditable(false);    
    }
    
        
    private catalogoUnProveedor catalogo;

    public catalogoUnProveedor getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(catalogoUnProveedor catalogo) {
        this.catalogo = catalogo;
    }


  
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        nombre.setEditable(editable);
        precio.setEditable(editable);
    }
    
    public void loadData(){
        if(catalogo!=null){
            aceptar.setEnabled(true);
            cancelar.setEnabled(true);
            String cod=String.valueOf(catalogo.getCodProducto());
            codigo.setText(cod);
            nombre.setText(catalogo.getNombrePr());
            String pre=String.valueOf(catalogo.getPrecio());
            precio.setText(pre);
                              
        }
        else{
            nombre.setText("");
            precio.setText("");
        }        
    }
     
    public void saveData()throws ParseException{
       if(catalogo==null) {
           catalogo=new catalogoUnProveedor();        
       }
       Long cod=Long.valueOf(codigo.getText());
       catalogo.setCodProducto(cod);
       catalogo.setNombrePr(nombre.getText());
       Long pre=Long.valueOf(precio.getText());
       catalogo.setPrecio(pre);
       cantidadMaterial=cantidad.getValue(); 
       System.out.println("cantidadMaterialtomadaaa");
       System.out.println(cantidadMaterial);
    }
    
    public static Long castObjectToLong(Object object) {
    return ((Long)object);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();

        jLabel1.setText("Nombre Material:");

        jLabel2.setText("Cantidad a pedir:");

        jLabel3.setText("Precio unitario:");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/accept.png"))); // NOI18N
        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo:");

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
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
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombre)
                            .addComponent(precio)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cantidad))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(cancelar)
                        .addGap(68, 68, 68)
                        .addComponent(aceptar)
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(64, 64, 64)
                        .addComponent(codigo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        cantidadMaterial=cantidad.getValue(); 
        System.out.println(listaPedir);
        elementosDePedido elementos = new elementosDePedido(catalogo.getCodProducto(), catalogo.getNombrePr(), catalogo.getPrecio(), cantidadMaterial);
        listaPedir.add(elementos);
        setCatalogo(null);
        loadData();
        cantidad.setValue(0);
        System.out.println(listaPedir);
    }//GEN-LAST:event_aceptarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}

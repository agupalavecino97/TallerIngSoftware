package corralon.vistas.ventaSinPresupuesto;

import corralon.DAO.DAOManager;
import corralon.modelos.stock;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class cantidadMateriales extends javax.swing.JPanel {

    
    private DAOManager manager;
   
    public cantidadMateriales() {
        initComponents();
        aceptar.setEnabled(false);
        cancelar.setEnabled(false);
        nombre.setEditable(false);
        precio.setEditable(false);    
    }

    
    private stock material; 
    private boolean editable;
    private Long cantidadMaterial;
    private List<pedidoConCantidad> pedido=new ArrayList();
    
    
    public stock getMaterial() {
        return material;
    }
    public List getLista(){
        return pedido;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setMaterial(stock material) {
        this.material = material;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        nombre.setEditable(editable);
        precio.setEditable(editable);
    }
    
     public void loadData(){
        if(material!=null){
            aceptar.setEnabled(true);
            cancelar.setEnabled(true);
            nombre.setText(material.getNombreMaterial());
            String pre=String.valueOf(material.getPrecio());
            precio.setText(pre);
            for(pedidoConCantidad ped:pedido){
                if(ped.getCodMaterial()==material.getCodMaterial()){
                    cantidad.setValue(ped.getCantidad());
                }
            }  
        }
        else{
            nombre.setText("");
            precio.setText("");
        }        
    }
     
    public boolean saveData()throws ParseException{
       if(material==null) {
           material=new stock();        
       }
       
       material.setNombreMaterial(nombre.getText());
       Long pre=Long.valueOf(precio.getText());
       material.setPrecio(pre);
       String stringToConvert = String.valueOf(cantidad.getValue());
       Long convertedLong = Long.parseLong(stringToConvert);
       if(convertedLong<=material.getCantidadExistente()){
           cantidadMaterial=convertedLong; 
           return true;
           
       }
           return false;
                
       //System.out.println(cantidadMaterial);
    }
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cantidad = new javax.swing.JSpinner();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        jLabel1.setText("Producto");

        jLabel2.setText("Precio");

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad");

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/accept.png"))); // NOI18N
        aceptar.setText("aceptar");
        aceptar.setFocusable(false);
        aceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/cancel.png"))); // NOI18N
        cancelar.setText("cancelar");
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
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
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre)
                            .addComponent(precio)
                            .addComponent(cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptar)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(aceptar)
                    .addComponent(cancelar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        setEditable(false);
        setMaterial(null);
        loadData();
        cantidad.setValue(0);
        aceptar.setEnabled(false);
        cancelar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        try {
            if(saveData()){
                Long codigo=material.getCodMaterial();
                String nombre=material.getNombreMaterial();
                Long cantidad2=Long.valueOf(cantidadMaterial);
                Long precio=material.getPrecio();
                pedidoConCantidad pedidoc=new pedidoConCantidad(codigo,nombre,cantidad2,precio);
                if(buscarEnLista(material)){
//                    for(pedidoConCantidad ped:pedido){
//                        if (ped.getCodMaterial()==codigo){
//                            
//                            ped.setCantidad(ped.getCantidad()+cantidad2);
//                        }
//                    }
                    
                    int posicion=(pedido.lastIndexOf(material));
                    pedidoConCantidad nuevoPedido=pedido.get(posicion);
                    nuevoPedido.setCantidad(nuevoPedido.getCantidad()+cantidad2);
//                    if(nuevoPedido.getCantidad()<=manager.getmaterialDao().obtenerCantidad(nuevoPedido.getCodMaterial())){
                         pedido.set(posicion,nuevoPedido);
//                    }else{
//                        setMaterial(null);
//                        loadData();
//                        cantidad.setValue(0);
//                    }
                }else{
                     pedido.add(pedidoc);
                }
                setEditable(false);
                setMaterial(null);
                loadData();
                aceptar.setEnabled(false);
                cancelar.setEnabled(false);
                this.cantidad.setValue(0);
            }
                   //JOptionPane.showMessageDialog(rootPane,"La cantidad ingresada supera el stock existente, por favor ingrese una cantidad menor");

        } catch (ParseException ex) {
            Logger.getLogger(cantidadMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    
    public boolean buscarEnLista(stock material){
        if(pedido.contains(material)){
            return true;
        }else return false;               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}

package corralon.vistas.ventaConPresupuesto;

import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.DAOManager;
import corralon.modelos.pedidoMaterial;
import corralon.modelos.stock;
import static corralon.vistas.ventaConPresupuesto.SeleccionarMaterialesPresupuesto.datosConNombre;
import static corralon.vistas.ventaConPresupuesto.SeleccionarMaterialesPresupuesto.index;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cantidadMaterialesPresupuesto extends javax.swing.JPanel {

    
    private DAOManager manager;
   
    public cantidadMaterialesPresupuesto() {
        initComponents();
        aceptar.setEnabled(false);
        cancelar.setEnabled(false);
        nombre.setEditable(false);
        precio.setEditable(false);    
    }

    
    private stock material; 
    private boolean editable;
    private Long cantidadMaterial;
    private pedidoMaterial pedMat;
    //private List<pedidoConCantidad> pedido=new ArrayList();

    public pedidoMaterial getPedMat() {
        return pedMat;
    }

    public void setPedMat(pedidoMaterial pedMat) {
        this.pedMat = pedMat;
    }
    
    
    public stock getMaterial() {
        return material;
    }
    public List getLista(){
        return datosConNombre;
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
            for(pedidoMaterialConNombre ped:datosConNombre){
                //if(ped.getCodMaterial()==material.getCodMaterial()){
                    cantidad.setValue(ped.getCantidadMaterial());
                //}else cantidad.setValue(0);
            }  
        }
        else{
            nombre.setText("");
            precio.setText("");
            cantidad.setValue(0);
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
        System.out.println("primero");
        System.out.println(material);
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
        jToolBar1 = new javax.swing.JToolBar();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        cantidad = new javax.swing.JSpinner();

        jLabel1.setText("Producto");

        jLabel2.setText("Precio");

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        jLabel3.setText("Cantidad");

        jToolBar1.setRollover(true);

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
        jToolBar1.add(cancelar);

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
        jToolBar1.add(aceptar);

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
                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(precio)
                            .addComponent(cantidad)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        setEditable(false);
        setMaterial(null);
        loadData();
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
                System.out.println("segundo");
                System.out.println(material);
                System.out.println(getPedMat());
                pedidoMaterialConNombre pedidoc=new pedidoMaterialConNombre(codigo,cantidad2,getPedMat().getCantidadMaterial(),material.getPrecio(),nombre);
                int posicion=(datosConNombre.lastIndexOf(codigo));
                datosConNombre.set(index,pedidoc);
                System.out.println("nueva lista con cantidad cambiada");
                System.out.println(datosConNombre);
//                    for(pedidoConCantidad ped:pedido){
//                        if (ped.getCodMaterial()==codigo){
//                            
//                            ped.setCantidad(ped.getCantidad()+cantidad2);
//                        }
//                    }
            
//                    int posicion=(datosConNombre.lastIndexOf(codigo));
//                    pedidoConCantidad nuevoPedido=datosConNombre.get(posicion);
//                    nuevoPedido.setCantidad(nuevoPedido.getCantidad()+cantidad2);
//                    if(nuevoPedido.getCantidad()<=manager.getmaterialDao().obtenerCantidad(nuevoPedido.getCodMaterial())){
//                         datosConNombre.set(posicion,nuevoPedido);
//                    }else{
//                        setMaterial(null);
//                        loadData();
//                        cantidad.setValue(0);
//                    }
//              
                //materialesTalbeModel3 model=new materialesTalbeModel3(datosConNombre);
                setEditable(false);
                setMaterial(null);
                loadData();
                aceptar.setEnabled(false);
                cancelar.setEnabled(false);
                this.cantidad.setValue(0);
                
            }else
            System.out.println("la cantidad ingresada supera el stock disponible");
        } catch (ParseException ex) {
            Logger.getLogger(cantidadMaterialesPresupuesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    
    public boolean buscarEnLista(Long cod){
        if(datosConNombre.contains(cod)){
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
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}

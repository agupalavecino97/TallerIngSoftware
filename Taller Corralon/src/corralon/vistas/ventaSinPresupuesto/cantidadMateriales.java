
package corralon.vistas.ventaSinPresupuesto;

import corralon.modelos.stock;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class cantidadMateriales extends javax.swing.JPanel {

   
    public cantidadMateriales() {
        initComponents();
    }

    
    private stock material; //me aprece que no se usa
    private boolean editable;
    private int cantidadMaterial;
    private List<Long> pedido=new ArrayList();
    
    
    public stock getMaterial() {
        return material;
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
        cantidad.setEditable(editable);
    }
    
     public void loadData(){
        if(material!=null){
            nombre.setText(material.getNombreMaterial());
            String pre=String.valueOf(material.getPrecio());
            precio.setText(pre);
                              
        }
        else{
            nombre.setText("");
            precio.setText("");
        }        
    }
     
    public void saveData()throws ParseException{
       if(material==null) {
           material=new stock();        
       }
       
       material.setNombreMaterial(nombre.getText());
       Long pre=Long.valueOf(precio.getText());
       material.setPrecio(pre);
       cantidadMaterial=cantidad.getItemCount();
       System.out.println(cantidadMaterial);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cantidad = new javax.swing.JComboBox<>();
        jToolBar1 = new javax.swing.JToolBar();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();

        jLabel1.setText("Producto");

        jLabel2.setText("Precio");

        jLabel3.setText("Cantidad");

        cantidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/cancel.png"))); // NOI18N
        cancelar.setText("cancelar");
        cancelar.setFocusable(false);
        cancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(cancelar);

        aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/corralon/Icons/accept.png"))); // NOI18N
        aceptar.setText("aceptar");
        aceptar.setFocusable(false);
        aceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(aceptar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre)
                            .addComponent(precio)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 211, Short.MAX_VALUE)))))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed

    }//GEN-LAST:event_cantidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox<String> cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}

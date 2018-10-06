
package corralon.vistas.ventaSinPresupuesto;
import corralon.DAO.DAOManager;
import corralon.vistas.clientes.*;
import corralon.modelos.cliente;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleClientes extends javax.swing.JPanel {

    private cliente cliente;
    private boolean editable;
    private DAOManager manager;

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
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
        if(cliente!=null){
           cuit.setValue(cliente.getCuitCliente());
           nombre.setText(cliente.getRazonSocial());
           direccion.setText(cliente.getDireccionCliente());
           telefono.setValue(cliente.getTelefonoCliente());
        }
        else{
            cuit.setValue(null);
            nombre.setText("");
            direccion.setText("");
            telefono.setValue(null);
        }
        cuit.requestFocus();
        guardar.setEnabled(true);
       // nombre.requestFocus();
    }
    
    public void saveData() throws ParseException{
        if(cliente==null){
            cliente=new cliente();
        }
              Long cu=Long.valueOf(cuit.getText());
              cliente.setCuitCliente(cu);
              cliente.setRazonSocial(nombre.getText());
              cliente.setDireccionCliente(direccion.getText());
              Long te=Long.valueOf(telefono.getText());
              cliente.setTelefonoCliente(te);
//            cliente.setCuitCliente((Long)cuit.getValue());
//            cliente.setRazonSocial(nombre.getText());
//            cliente.setDireccionCliente(direccion.getText());
//            telefono.commitEdit(); 
//            cliente.setTelefonoCliente((int) telefono.getValue());          
    }
            
    
    
    public DetalleClientes() {
        initComponents();
        //cuit.enable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telefono = new javax.swing.JFormattedTextField();
        da = new javax.swing.JLabel();
        cuit = new javax.swing.JFormattedTextField();
        guardar = new javax.swing.JButton();

        jLabel2.setText("Razon Social:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Telefono:");

        da.setText("CUIT:");

        cuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuitActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.setEnabled(false);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
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
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(telefono))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(da))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(cuit))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardar)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(da)
                    .addComponent(cuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuitActionPerformed
    
    }//GEN-LAST:event_cuitActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        try {
            saveData();
        } catch (ParseException ex) {
            Logger.getLogger(DetalleClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(manager.getclienteDao().obtener(cliente.getCuitCliente())==null){
            manager.getclienteDao().insertar(cliente);
        } 
        //aqui tendria que saltar a la otra vista seleccionar materiales
        
    }//GEN-LAST:event_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField cuit;
    private javax.swing.JLabel da;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombre;
    private javax.swing.JFormattedTextField telefono;
    // End of variables declaration//GEN-END:variables
}

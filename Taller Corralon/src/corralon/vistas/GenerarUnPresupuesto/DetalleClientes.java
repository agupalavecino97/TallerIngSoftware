
package corralon.vistas.GenerarUnPresupuesto;
import corralon.vistas.ventaSinPresupuesto.*;
import corralon.DAO.DAOManager;
import corralon.modelos.cliente;
import static corralon.vistas.ventaSinPresupuesto.verificarExsistenciaCliente.cuitClienteIngresado;
import static corralon.vistas.ventaSinPresupuesto.verificarExsistenciaCliente.setCuitClienteIngresado;
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
        nombre.setEditable(editable);
        direccion.setEditable(editable);
        telefono.setEditable(editable);

    }
    
    public void loadData(){
        if(cliente!=null){
           nombre.setText(cliente.getRazonSocial());
           direccion.setText(cliente.getDireccionCliente());
           telefono.setValue(cliente.getTelefonoCliente());
        }
        else{
            nombre.setText("");
            direccion.setText("");
            telefono.setValue(null);
        }
        nombre.setFocusable(true);
       // nombre.requestFocus();
    }
    
    public void saveData() throws ParseException{
        if(cliente==null){
            cliente=new cliente();
        }
              Long cu=cuitClienteIngresado;
              cliente.setCuitCliente(cu);
              cliente.setRazonSocial(nombre.getText());
              cliente.setDireccionCliente(direccion.getText());
              Long te=Long.valueOf(telefono.getText());
              cliente.setTelefonoCliente(te);
              cliente.setEstadoClie(true);
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
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Razon Social:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Telefono:");

        jLabel1.setText("El cliente ingresado no existe en el sistema, proporcione sus datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefono)
                            .addComponent(direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField direccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nombre;
    private javax.swing.JFormattedTextField telefono;
    // End of variables declaration//GEN-END:variables
}

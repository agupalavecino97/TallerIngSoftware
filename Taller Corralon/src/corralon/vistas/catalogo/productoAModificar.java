
package corralon.vistas.catalogo;

import corralon.modelos.catalogo;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class productoAModificar extends javax.swing.JPanel {
  private boolean editable;
    private catalogo catalogo;

    public productoAModificar() {
        initComponents();
        aceptar.setEnabled(false);
        cancelar.setEnabled(false);
        codigo.setEnabled(true);
        fecha.setEnabled(true);
        precio.setEditable(true);    
    }

    public catalogo getCat() {
        return catalogo;
    }

    public void setCat(catalogo cat) {
        this.catalogo = cat;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        precio.setEditable(true);
        
    }

 public void loadData(){
        if(catalogo!=null){
            aceptar.setEnabled(true);
            cancelar.setEnabled(true);
            String cod=String.valueOf(catalogo.getCodProductoCatalogo());
            codigo.setText(cod);
            java.util.Date date=new java.util.Date();
            java.sql.Date fechaDeHoy=new java.sql.Date(date.getTime());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(fechaDeHoy);
            fecha.setText(today);
            String pre=String.valueOf(catalogo.getPrecioUnitario());
            precio.setText(pre);
                              
        }
        else{
            codigo.setText("");
            precio.setText("");
        }        
    }
     
    public void saveData()throws ParseException{
       if(catalogo==null) {
           catalogo=new catalogo();        
       }
                   java.util.Date date=new java.util.Date();
            java.sql.Date fechaDeHoy=new java.sql.Date(date.getTime());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String today = formatter.format(fechaDeHoy);
       catalogo.setCodProductoCatalogo(catalogo.getCodProductoCatalogo());
       catalogo.setCuitProveedor(catalogo.getCuitProveedor());
       catalogo.setFechaVigencia(fechaDeHoy);
       Long pre=Long.valueOf(precio.getText());
       catalogo.setPrecioUnitario(pre);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        codigo = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();

        jLabel1.setText("Codigo:");

        jLabel2.setText("Fecha Actualizacion:");

        jLabel3.setText("Precio:");

        cancelar.setText("Cancelar");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelar)
                        .addGap(54, 54, 54)
                        .addComponent(aceptar))
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(aceptar))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField precio;
    // End of variables declaration//GEN-END:variables
}

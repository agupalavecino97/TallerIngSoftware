
package corralon.vistas.catalogo;

import corralon.DAO.DAOManager;
import corralon.modelos.catalogo;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.DAO.productoCatalogoDAO;
import static corralon.vistas.catalogo.actualizarPrecios.catSel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ldap.ManageReferralControl;
import corralon.vistas.catalogo.productoAModificar;
import static corralon.vistas.catalogo.seleccionProveedor.idProveedorSelec;


public class productoAModificar extends javax.swing.JPanel {
  private boolean editable;
    private catalogo catalogo;
    private DAOManager manager;
    

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
//           catalogo datos = manager.getcatalogoDao().obtener(catSel.getCodProductoCatalogo());
////          catalogo datos = manager.getcatalogoDao().obtener(actualizarPrecios.catSel.getCodProductoCatalogo());
//          System.out.println("OBTENER UNOOOOOOooooooooooooooooooooooooooOOOO");
//          System.out.println(datos);
       java.util.Date date=new java.util.Date();
       java.sql.Date fechaDeHoy=new java.sql.Date(date.getTime());
//       DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//       String today = formatter.format(fechaDeHoy);
//       catalogo.setCodProductoCatalogo(catalogo.getCodProductoCatalogo());
//       catalogo.setCuitProveedor(catalogo.getCuitProveedor());
       catalogo.setFechaVigencia(fechaDeHoy);
       Long pre=Long.valueOf(precio.getText());
       catalogo.setPrecioUnitario(pre);
//       System.out.println("llega");
//       System.out.println(catalogo);
//       System.out.println("llega");
       //System.out.println("pasa");

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



        try {
                              Long a=Long.valueOf(1);
          catalogo datos = manager.getcatalogoDao().obtener(a);
//          catalogo datos = manager.getcatalogoDao().obtener(actualizarPrecios.catSel.getCodProductoCatalogo());
          System.out.println("OBTENER UNOOOOOOooooooooooooooooooooooooooOOOO");
          System.out.println(datos);
                                           
          saveData();
      } catch (ParseException ex) {
          Logger.getLogger(productoAModificar.class.getName()).log(Level.SEVERE, null, ex);
      }
          //System.out.println(manager.getcatalogoDao().obtenerTodos());

          Long b=Long.valueOf(5);
          float c = 52;
//          catalogo.setCodProductoCatalogo(a);
          catalogo.setCuitProveedor(b);
        java.util.Date date=new java.util.Date();
       java.sql.Date fechaDeHoy=new java.sql.Date(date.getTime());
       catalogo.setFechaVigencia(fechaDeHoy);
       catalogo.setPrecioUnitario(c);
       
         manager.getcatalogoDao().insertar(catalogo);
          //manager.getcatalogoDao().modificarCantidad(catalogo.getCodProductoCatalogo(), idProveedorSelec, catalogo.getFechaVigencia(), catalogo.getPrecioUnitario());
          System.out.println(manager.getcatalogoDao().ObtenerUnProductoDeUnProveedor(idProveedorSelec,getCat().getCodProductoCatalogo()));
      
          
          
          
//  
//          Long a=Long.valueOf(1);
//
//                  System.out.println(datos);
//          Long b=Long.valueOf(5);
//          
//          catalogo.setCodProductoCatalogo(a);
//          System.out.println(catalogo.getCodProductoCatalogo());
//          catalogo.setCuitProveedor(b);
//          java.util.Date date=new java.util.Date();
//          java.sql.Date fechaDeHoy=new java.sql.Date(date.getTime());
//          catalogo.setFechaVigencia(fechaDeHoy);
//          float c = 52;
//          catalogo.setPrecioUnitario(c);
//          System.out.println("AQUI ESTA EL CATALOGOGOGASAD");
//          System.out.println(catalogo);
//          manager.getcatalogoDao().insertar(catalogo);
        
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

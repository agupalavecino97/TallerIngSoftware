
package corralon.vistas.catalogo;

import corralon.DAO.DAOManager;
import corralon.DAO.catalogoDAO;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.DAO.productoCatalogoDAO;
import corralon.modelos.proveedor;
import corralon.modelos.catalogo;
import corralon.modelos.productoCatalogo;
import corralon.vistas.pedidoProveedor.catalogoUnProveedor;
import corralon.vistas.pedidoProveedor.materialesTableModel3;
import static corralon.vistas.catalogo.seleccionProveedor.idProveedorSelec;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

public class actualizarPrecios extends javax.swing.JFrame {

   private DAOManager manager;
   private materialesTableModel3 model;
   private Long cuitProveedorIngresado;
   private productoCatalogoDAO prodCatdao;
   private productoCatalogo produC;
   private catalogo catalogo;
   public static catalogo catSel;
   public  static List<catalogoUnProveedor> nueva=new ArrayList();
 //  public  static List<elementosDePedido> pedido=new ArrayList();
   
   
   
    public actualizarPrecios(DAOManager manager) {
      initComponents();
        this.manager = manager;
        List<catalogo> datos;  
        catalogoUnProveedor elem;
        //seleccionProveedor sel = new seleccionProveedor(manager);
        datos = manager.getcatalogoDao().obtenerTodosDeProv(idProveedorSelec);
        System.out.println(datos);
        int i=0;
        while (i<datos.size()){         
            Long mandar = datos.get(i).getCodProductoCatalogo();
            produC = manager.getproductocatalogoDao().obtener(mandar);
            String nombre = produC.getNombreProductoCatalogo();
            Long dato = datos.get(i).getCodProductoCatalogo();
            elem = new catalogoUnProveedor(dato, nombre , datos.get(i).getPrecioUnitario());
            nueva.add(i, elem);
            i++;
        }
        System.out.println("listaaaa");
        System.out.println(nueva);       
        this.model=new materialesTableModel3(nueva);
       //        this.model.updateModel();
        this.tabla.setModel(model);
        
    }

    public Long getCuitProveedorIngresado() {
        return cuitProveedorIngresado;
    }

    public void setCuitProveedorIngresado(Long cuitProveedorIngresado) {
        this.cuitProveedorIngresado = cuitProveedorIngresado;
    }

    public static List<catalogoUnProveedor> getNueva() {
        return nueva;
    }

    public static void setNueva(List<catalogoUnProveedor> nueva) {
        actualizarPrecios.nueva = nueva;
    }


       private catalogo getCatalogoSeleccionado(){
         Long cod=(Long) tabla.getValueAt(tabla.getSelectedRow(),0);
         return manager.getcatalogoDao().obtener(cod);
    } 

    public static catalogo getCatSel() {
        return catSel;
    }

    public static void setCatSel(catalogo catSel) {
        actualizarPrecios.catSel = catSel;
    }
       
       
       
            private void catSel(){
         Long cod=(Long) tabla.getValueAt(tabla.getSelectedRow(),0);
           setCatSel(manager.getcatalogoDao().obtener(cod));
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
        productoAModificar2 = new corralon.vistas.catalogo.productoAModificar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        modificar.setText("Modificar Precio");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(productoAModificar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(productoAModificar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
//          catalogo datos = manager.getcatalogoDao().obtener(a);
////          catalogo datos = manager.getcatalogoDao().obtener(actualizarPrecios.catSel.getCodProductoCatalogo());
//          System.out.println("OBTENER UNOOOOOOooooooooooooooooooooooooooOOOO");
//          System.out.println(datos);
          
                 productoAModificar2.setCat(getCatalogoSeleccionado());
                 //System.out.println(productoAModificar1.getCat());
                 productoAModificar2.loadData();    

    }//GEN-LAST:event_modificarActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws SQLException {
        DAOManager manager = new MySQLDAOManager("localhost", "taller", "root", "root");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(actualizarPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(actualizarPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(actualizarPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(actualizarPrecios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new actualizarPrecios(manager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private corralon.vistas.catalogo.productoAModificar productoAModificar2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

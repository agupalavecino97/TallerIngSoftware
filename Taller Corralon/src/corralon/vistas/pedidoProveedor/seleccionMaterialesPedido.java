
package corralon.vistas.pedidoProveedor;

import corralon.DAO.DAOManager;
import corralon.DAO.catalogoDAO;
import corralon.DAO.mysql.MySQLDAOManager;
import corralon.DAO.productoCatalogoDAO;
import corralon.modelos.proveedor;
import corralon.modelos.catalogo;
import corralon.modelos.productoCatalogo;
import static corralon.vistas.pedidoProveedor.seleccionProveedorPedido.idProveedorSelec;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.TableModel;

public class seleccionMaterialesPedido extends javax.swing.JFrame {
    
   private DAOManager manager;
   private materialesTableModel3 model;
   private Long cuitProveedorIngresado;
   private productoCatalogoDAO prodCatdao;
   private productoCatalogo produC;

   
//      ESTA FUNCIONA PERFECTAMENTE!!! RESPALDO
//   public seleccionMaterialesPedido(DAOManager manager) {
//        initComponents();
//        this.manager = manager;
//        List<catalogo> datos;  
//        seleccionProveedorPedido sel = new seleccionProveedorPedido(manager);
//        datos = manager.getcatalogoDao().obtenerTodosDeProv(sel.getIdProveedorSelec());
//        System.out.println(datos);
//        this.model=new materialesTableModel3(datos);
//       //        this.model.updateModel();
//        this.tabla.setModel(model);
//        
//    }


    public seleccionMaterialesPedido(DAOManager manager) {
        initComponents();
        this.manager = manager;
        List<catalogo> datos;  

        List<catalogoUnProveedor> nueva; 
        catalogoUnProveedor elem;
        seleccionProveedorPedido sel = new seleccionProveedorPedido(manager);
        datos = manager.getcatalogoDao().obtenerTodosDeProv(sel.getIdProveedorSelec());
        System.out.println(datos);
        int i=0;
        while (i<datos.size()){         
            Long mandar = Long.valueOf(datos.get(i).getCodProductoCatalogo());
            System.out.println("variableeeeee");
            System.out.println(mandar);
            produC = manager.getproductocatalogoDao().obtener(mandar);
            System.out.println("pruoducccccccccccc");
            System.out.println(produC);
            String nombre = produC.getNombreProductoCatalogo();
            Long dato = Long.valueOf(datos.get(i).getCodProductoCatalogo());
            elem = new catalogoUnProveedor(dato, nombre , datos.get(i).getPrecioUnitario());
            System.out.println("productooooooooooooooooooo");
            System.out.println(elem);
            i++;
        }
        
        System.out.println("finnnn");
        
        
        
        this.model=new materialesTableModel3(datos);
       //        this.model.updateModel();
        this.tabla.setModel(model);
        
    }

    private seleccionMaterialesPedido() {
        System.out.println(cuitProveedorIngresado);
    }

    public Long getCuitProveedorIngresado() {
        return cuitProveedorIngresado;
    }

    public void setCuitProveedorIngresado(Long cuitProveedorIngresado) {
        this.cuitProveedorIngresado = cuitProveedorIngresado;
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
        agregar = new javax.swing.JButton();
        continuar = new javax.swing.JButton();

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

        agregar.setText("Agregar");

        continuar.setText("Continuar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(continuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(continuar)
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(agregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(seleccionMaterialesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seleccionMaterialesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seleccionMaterialesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seleccionMaterialesPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new seleccionMaterialesPedido(manager).setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton continuar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables


}

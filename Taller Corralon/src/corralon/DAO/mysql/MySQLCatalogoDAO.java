
package corralon.DAO.mysql;

import corralon.DAO.DAOManager;
import corralon.DAO.catalogoDAO;
import corralon.modelos.catalogo;
import corralon.vistas.proveedores.ListaProveedores;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLCatalogoDAO implements catalogoDAO{
    final String INSERT = "INSERT INTO catalogo(codProducto, cuitProveedor, fechaDeActualizacion, precioUnitario ) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE catalogo SET cuitProveedor=?, codProducto=?, fechaDeActualizacion=?, precioUnitario=?  WHERE cuitProveedor=? AND codProducto=?" ;
    final String DELETE = "DELETE FROM catalogo WHERE cuitProveedor=?";
    final String GETALL = "SELECT cuitProveedor, codProducto, fechaDeActualizacion, precioUnitario  FROM catalogo";
    final String GETALLdeprov = "(SELECT cuitProveedor, codProducto, precioUnitario, fechaDeActualizacion  FROM catalogo WHERE cuitProveedor =?)";
//    final String GETALLdeprov = "SELECT  cat.codProducto as 'id', cat.precioUnitario as 'preP', prodcat.nombreProd as 'nombre' FROM catalogo as cat JOIN "
//            + "productocatalogo as prodCat ON prodCat.codProducto = cat.id WHERE cuitProveedor =?";
    final String GETONE = "SELECT cuitProveedor, codProducto, fechaDeActualizacion, precioUnitario FROM catalogo WHERE codProducto=?";
    final String UPDATECANT="UPDATE catalogo SET fechaDeActualizacion=?,precioUnitario=? WHERE cuitProveedor=? AND codProducto=?";
    final String GETONEPROV= "SELECT cuitProveedor, codProducto, fechaDeActualizacion, precioUnitario FROM catalogo WHERE cuitProveedor=? AND codProducto=?";  
    
    private final Connection conn;
    
    MySQLCatalogoDAO(Connection con) {
        this.conn = con;
    }
    
    private catalogo convertir(ResultSet rs)throws SQLException {
          Long cuit=rs.getLong("cuitProveedor");
          Long cod= rs.getLong("codProducto");
          float precio=rs.getFloat("precioUnitario");
          Date fecha = rs.getDate("fechaDeActualizacion");
          catalogo catalogo= new catalogo(cuit, cod, precio,fecha);
          return catalogo;
    }
    
//      public static void main(String args[]) throws SQLException {
//        DAOManager manager = new MySQLDAOManager("localhost", "taller", "root", "root");
//                
//        java.awt.EventQueue.invokeLater(() -> {
//            new ListaProveedores(manager).setVisible(true);
//            Long a = Long.valueOf(10);
//            List<catalogo> catalogos= new ArrayList<>();
//            obtenerTodosDeProv(a);
//        });
//    }
//    
    
    
    
    
    @Override
    public void insertar(catalogo a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodProductoCatalogo());
            stat.setLong(2, a.getCuitProveedor());
            //stat.setDate(4, a.getFechaVigencia());
            stat.setDate(3, a.getFechaVigencia());
            stat.setFloat(4, a.getPrecioUnitario());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(catalogo a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCuitProveedor());
            stat.setLong(2, a.getCodProductoCatalogo());
            stat.setDate(3, a.getFechaVigencia());
            stat.setFloat(4, a.getPrecioUnitario());
            stat.setLong(5, a.getCuitProveedor());
            stat.setLong(6, a.getCodProductoCatalogo());
            //final String UPDATE = "UPDATE catalogo SET cuitProveedor=?, codProducto=?, fechaDeActualizacion=?, precioUnitario=?  WHERE cuitProveedor=? AND codProducto=?" ;

            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

       @Override
        public void modificarCantidad(Long codM, Long cuitP, Date fecha, float precio) {
          PreparedStatement stat=null;
        try{
            stat=conn.prepareStatement(UPDATECANT);
            stat.setDate(1,fecha);
            stat.setFloat(2,precio);
            stat.setLong(3, cuitP);
            stat.setLong(4, codM);
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }    
    }
    
    
    @Override
    public void eliminar(catalogo a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCuitProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<catalogo> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<catalogo> catalogos= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while(rs.next()){
                 catalogos.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return catalogos;
    }
    
    
       

    @Override
    public catalogo obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        catalogo cat=null;
        try {
             stat=conn.prepareStatement(GETONE);
             stat.setLong(1, id);
             rs=stat.executeQuery();
             if (rs.next()) {
                cat=convertir(rs);
            } else {
                 System.out.println("No se ha encontrado el registro.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cat;
    }

    @Override
    public List<catalogo> obtenerTodosDeProv(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<catalogo> catalogos= new ArrayList<>();
        try {
//                         stat=conn.prepareStatement(GETONE);
//             stat.setLong(1, id);
//             rs=stat.executeQuery(); 
            stat=conn.prepareStatement(GETALLdeprov);
            stat.setLong(1, id);
             rs=stat.executeQuery();
             while(rs.next() ){
                 catalogos.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return catalogos;
    }

    @Override
    public catalogo ObtenerUnProductoDeUnProveedor(Long id, Long cod) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        catalogo cat=null;
        try {
             stat=conn.prepareStatement(GETONEPROV);
             stat.setLong(1, id);
             stat.setLong(2,cod);
             rs=stat.executeQuery();
             if (rs.next()) {
                cat=convertir(rs);
            } else {
                 System.out.println("No se ha encontrado el registro.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cat;
    }
    
    
}

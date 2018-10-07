
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLCatalogoDAO implements catalogoDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO catalogo(cuitProveedor, codProductoCatalogo, precioUnitario, fechaVigencia) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE catalogo SET cuitProveedor=?, codProductoCatalogo=?, precioUnitario=?, fechaVigencia=? WHERE cuitProveedor=?" ;
    final String DELETE = "DELETE FROM catalogo WHERE cuitProveedor=?";
    final String GETALL = "SELECT cuitProveedor, codProductoCatalogo, precioUnitario  FROM catalogo";
    final String GETALLdeprov = "SELECT codProductoCatalogo, precioUnitario  FROM catalogo WHERE cuitProveedor =?";
    final String GETONE = "SELECT cuitProveedor, codProductoCatalogo, precioUnitario FROM catalogo WHERE cuitProveedor=?";

    MySQLCatalogoDAO(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private catalogo convertir(ResultSet rs)throws SQLException {
          Long cuit=rs.getLong("cuitProveedor");
          int cod= rs.getInt("codProductoCatalogo");
          float precio=rs.getFloat("precioUnitario");
          Date fecha= rs.getDate("fechaVigencia");
          catalogo cat= new catalogo(cuit, cod, precio, fecha);
          return cat;
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
            stat.setLong(1, a.getCuitProveedor());
            stat.setInt(2, a.getCodProductoCatalogo());
            stat.setFloat(3, a.getPrecioUnitario());
            //stat.setDate(4, a.getFechaVigencia());
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
            stat.setInt(2, a.getCodProductoCatalogo());
            stat.setFloat(3, a.getPrecioUnitario());
            stat.setDate(4, a.getFechaVigencia());
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
             stat=conn.prepareStatement(GETALLdeprov);
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
    
    
}

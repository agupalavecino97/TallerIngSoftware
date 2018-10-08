
package corralon.DAO.mysql;

import corralon.DAO.productoCatalogoDAO;
import corralon.modelos.productoCatalogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLProductoCatalogoDAO implements productoCatalogoDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO productoCatalogo(codProductoCatalogo,nombreProcudcoCatalogo,descripcionPorductoCatalogo) VALUES(?,?,?)";
    final String UPDATE = "UPDATE productoCatalogo SET codProductoCatalogo=?, dniCliente=?, fechaPresupuesto=? WHERE codProductoCatalogo=?" ;
    final String DELETE = "DELETE FROM productoCatalogo WHERE codProductoCatalogo=?";
    final String GETALL = "SELECT codProducto,descripcionProd,nombreProd FROM productocatalogo";
    final String GETONE = "SELECT codProducto,descripcionProd,nombreProd FROM productocatalogo WHERE codProducto=?";

    MySQLProductoCatalogoDAO(Connection con) {
        this.conn = con;
    }
    
    private productoCatalogo convertir(ResultSet rs)throws SQLException {
          Long cod=rs.getLong("codProducto");
          String nombre=rs.getString("nombreProd");
          String descrip=rs.getString("descripcionProd");
          productoCatalogo prodCat = new productoCatalogo(cod, nombre, descrip);
          return prodCat;
    }

    @Override
    public void insertar(productoCatalogo a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodProductoCatalogo());
            stat.setString(2, a.getNombreProductoCatalogo());
            stat.setString(3, a.getDescripcionProductoCatalogo());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(productoCatalogo a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCodProductoCatalogo());
            stat.setString(2, a.getNombreProductoCatalogo());
            stat.setString(3, a.getDescripcionProductoCatalogo());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(productoCatalogo a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCodProductoCatalogo());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<productoCatalogo> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<productoCatalogo> productosCat= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while(rs.next()){
                 productosCat.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return productosCat;
    }

    @Override
    public productoCatalogo obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        productoCatalogo prodCat= null;
        try {
             stat=conn.prepareStatement(GETONE);
             stat.setLong(1, id);
             rs=stat.executeQuery();
             if(rs.next()){
                 prodCat=convertir(rs);
             }else{
                 System.out.println("No se ha encontrado el registro.");
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProductoCatalogoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return prodCat;
    }
    
}

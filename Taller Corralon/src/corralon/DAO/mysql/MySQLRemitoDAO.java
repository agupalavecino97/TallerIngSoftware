
package corralon.DAO.mysql;

import corralon.DAO.remitoDAO;
import corralon.modelos.remito;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLRemitoDAO implements remitoDAO{
    private Connection conn;
    			
    final String INSERT = "INSERT INTO remito(cuitProveedor, codPedidoProv, montoRemito, Fecha, estado) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE remito SET cuitProveedor=?, codPedidoProv=?, montoRemito=?, Fecha=? ,estado=? WHERE cuitProveedor=?" ;
    final String DELETE = "DELETE FROM remito WHERE cuitProveedor=?";
    final String GETALL = "SELECT cuitProveedor, codPedidoProv, montoRemito, Fecha,estado FROM remito";
    final String GETONE = "SELECT cuitProveedor, codPedidoProv, montoRemito, Fecha,estado FROM remito WHERE cuitProveedor=?";
    
    
    MySQLRemitoDAO(Connection con) {
        this.conn = con;
    }
    private remito convertir(ResultSet rs)throws SQLException {
          Long cuit=rs.getLong("cuitProveedor");
          Long cod= rs.getLong("codPedidoProv");
          float subT=rs.getFloat("montoRemito");
          Date total=rs.getDate("Fecha");
          String estado=rs.getString("estado");
          remito r=new remito(cuit, cod, subT, total,estado);
          return r;
    }

    @Override
    public void insertar(remito a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCuitProveedor());
            stat.setLong(2, a.getCodigoPedidoProveedor());
            stat.setFloat(3, a.getTotalRemito());
            stat.setDate(4, a.getFecha());
            stat.setString(5,a.getEstado());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(remito a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCuitProveedor());
            stat.setLong(2, a.getCodigoPedidoProveedor());
            stat.setFloat(3, a.getTotalRemito());
            stat.setDate(4, a.getFecha());
            stat.setString(5,a.getEstado());
            stat.setLong(6,a.getCuitProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(remito a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCuitProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<remito> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<remito> r= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while(rs.next()){
                 r.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return r;
    }

    @Override
    public remito obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        remito r= null;
        try {
             stat=conn.prepareStatement(GETONE);
             stat.setLong(1, id);
             rs=stat.executeQuery();
             if(rs.next()){
                 r=convertir(rs);
             }else{
                 System.out.println("No se ha encontrado el registro.");
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLRemitoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return r;
    }
    
}

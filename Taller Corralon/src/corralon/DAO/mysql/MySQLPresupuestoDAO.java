
package corralon.DAO.mysql;

import corralon.DAO.presupuestoDAO;
import corralon.modelos.presupuesto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLPresupuestoDAO implements presupuestoDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO presupuesto(codigoPedidoClie, dniCliente, fechaPresupuesto) VALUES(?,?,?)";
    final String UPDATE = "UPDATE presupuesto SET codigoPedidoClie=?, dniCliente=?, fechaPresupuesto=? WHERE codigoPedidoClie=?" ;
    final String DELETE = "DELETE FROM presupuesto WHERE codigoPedidoClie=?";
    final String GETALL = "SELECT codigoPedidoClie, dniCliente, fechaPresupuesto FROM presupuesto";
    final String GETONE = "SELECT codigoPedidoClie, dniCliente, fechaPresupuesto FROM presupuesto WHERE codigoPedidoClie=?";
    
    private presupuesto convertir(ResultSet rs)throws SQLException {
          Long cod=rs.getLong("codigoPedidoClie");
          int doc= rs.getInt("dniCliente");
          Date fecha= rs.getDate("fechaPresupuesto");
          presupuesto presupuesto= new presupuesto(cod, doc, fecha);
          return presupuesto;
    }

    @Override
    public void insertar(presupuesto a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodigoPedidoClie());
            stat.setInt(2, a.getDniCliente());
            stat.setDate(3, a.getFechaPresupuesto());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(presupuesto a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCodigoPedidoClie());
            stat.setInt(2, a.getDniCliente());
            stat.setDate(3, a.getFechaPresupuesto());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(presupuesto a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCodigoPedidoClie());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<presupuesto> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<presupuesto> presupuesto= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while(rs.next()){
                 presupuesto.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return presupuesto;
    }

    @Override
    public presupuesto obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        presupuesto presupuesto= null;
        try {
             stat=conn.prepareStatement(GETONE);
             stat.setLong(1, id);
             rs=stat.executeQuery();
             if(rs.next()){
                 presupuesto=convertir(rs);
             }else{
                 System.out.println("No se ha encontrado el registro.");
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPresupuestoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return presupuesto;
    }
    
}

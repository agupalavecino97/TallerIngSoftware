
package corralon.DAO.mysql;

import corralon.DAO.facturaDAO;
import corralon.modelos.factura;
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

public class MySQLFacturaDAO implements facturaDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO factura(fechaFactura, codPedidoClie, estadoFactura) VALUES(?,?,?)";
    final String UPDATE = "UPDATE factura SET codFactura=?, fechaFactura=?, codPedidoClie=?, estadoFactura=? WHERE codigoFactura=?" ;
    final String DELETE = "DELETE FROM factura WHERE codFactura=?";
    final String GETALL = "SELECT codFactura, fechaFactura, codPedidoClie, estadoFactura FROM factura";
    final String GETONE = "SELECT codFactura, fechaFactura, codPedidoClie, estadoFactura FROM factura WHERE codFactura=?";

    public MySQLFacturaDAO(Connection con) {
        this.conn = con;
     }
    
    private factura convertir(ResultSet rs)throws SQLException {
          Date fecha= rs.getDate("fechaFactura");
          Long codigo= rs.getLong("codPedidoClie");
          String estado= rs.getString("estadoFactura");
          factura fac= new factura(fecha, codigo, estado);
          return fac;
    }
    @Override
    public void insertar(factura a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setDate(1, a.getFechaFactura());
            stat.setLong(2, a.getCodigoPedidoClie());
            stat.setString(3, a.getEstadoFactura());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
            rs = stat.getGeneratedKeys();
                if(rs.next())
                { //esto es para guardar el atributo autoincremental en el objeto 
                    int last_inserted_id = rs.getInt(1);
                     System.out.println(last_inserted_id);
                     a.setCodigoFactura(Long.valueOf(last_inserted_id));
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(factura a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCodigoFactura());
            stat.setDate(2, a.getFechaFactura());
            stat.setLong(3, a.getCodigoPedidoClie());
            stat.setString(4, a.getEstadoFactura());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(factura a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCodigoFactura());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<factura> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<factura> facturas= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while (rs.next()) {
                facturas.add(convertir(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return facturas;
    }

    @Override
    public factura obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        factura factura = null;
        try {
             stat=conn.prepareStatement(GETONE);
             stat.setLong(1, id);
             rs=stat.executeQuery();
             if (rs.next()) {
                factura=convertir(rs);
            } else {
                 System.out.println("No se ha encontrado el registro.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLFacturaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return factura;
    }
    
}

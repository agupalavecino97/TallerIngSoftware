
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
    final String INSERT = "INSERT INTO factura(codigoFactura, fechaFactura, codigoPedidoClie, estadoFactura) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE factura SET codigoFactura=?, fechaFactura=?, codigoPedidoClie=?, estadoFactura=? WHERE codigoFactura=?" ;
    final String DELETE = "DELETE FROM factura WHERE codigoFactura=?";
    final String GETALL = "SELECT codigoFactura, fechaFactura, codigoPedidoClie, estadoFactura FROM factura";
    final String GETONE = "SELECT codigoFactura, fechaFactura, codigoPedidoClie, estadoFactura FROM factura WHERE codgioFactura=?";

    private factura convertir(ResultSet rs)throws SQLException {
          Long id=rs.getLong("codigoFactura");
          Date fecha= rs.getDate("fechaFactura");
          int codigo= rs.getInt("codigoPedidoClie");
          int estado= rs.getInt("estadoFactura");
          factura fac= new factura(id, fecha, codigo, estado);
          return fac;
    }
    @Override
    public void insertar(factura a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodigoFactura());
            stat.setDate(2, a.getFechaFactura());
            stat.setInt(3, a.getCodigoPedidoClie());
            stat.setInt(4, a.getEstadoFactura());
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
    public void modificar(factura a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCodigoFactura());
            stat.setDate(2, a.getFechaFactura());
            stat.setInt(3, a.getCodigoPedidoClie());
            stat.setInt(4, a.getEstadoFactura());
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

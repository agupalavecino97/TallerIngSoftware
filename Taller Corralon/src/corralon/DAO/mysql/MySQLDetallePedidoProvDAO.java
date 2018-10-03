
package corralon.DAO.mysql;

import corralon.DAO.detallePedidoProveedorDAO;
import corralon.modelos.detallePedidoProveedor;
import corralon.vistas.materiales.detalleMateriales;
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

public class MySQLDetallePedidoProvDAO implements detallePedidoProveedorDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO detallePedidoProveedor(codigoPedidoProveedor, codigoMaterial, cantidadSolicitada, precioActual, subtotalPedidoProveedor) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE detallePedidoProveedor SET codigoPedidoProveedor=?, codigoMaterial=?, cantidadSolicitada=?, precioActual=?, subtotalPedidoProveedor=? WHERE codigoPedidoProveedor=?" ;
    final String DELETE = "DELETE FROM detallePedidoProveedor WHERE codigoPedidoProveedor=?";
    final String GETALL = "SELECT codigoPedidoProveedor, codigoMaterial, cantidadSolicitada, precioActual, subtotalPedidoProveedor FROM detallePedidoProveedor";
    final String GETONE = "SELECT codigoPedidoProveedor, codigoMaterial, cantidadSolicitada, precioActual, subtotalPedidoProveedor FROM detallePedidoProveedor WHERE codigoPedidoProveedor=?";

    private detallePedidoProveedor convertir(ResultSet rs)throws SQLException {
          Long id= rs.getLong("codigoPedidoProveedor");
          int codigo=rs.getInt("codigoMaterial");
          int cant=rs.getInt("cantidadSolicitada");
          float precio=rs.getFloat("precioActual");
          float subtotal=rs.getFloat("subtotalPedidoProveedor");
          detallePedidoProveedor detalle = new detallePedidoProveedor(id, codigo, cant, precio, subtotal);
          return detalle;
    }
    
    @Override
    public void insertar(detallePedidoProveedor a) {
        PreparedStatement stat=null;
        try {
             stat=conn.prepareStatement(INSERT);
             stat.setLong(1, a.getCodigoPedidoProveedor());
             stat.setInt(2, a.getCodigoMaterial());
             stat.setInt(3, a.getCantidadSolicitada());
             stat.setFloat(4, a.getPrecioActual());
             stat.setFloat(5, a.getSubtotalPedidoProveedor());
             if (stat.executeUpdate()==0) {
                 System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(detallePedidoProveedor a) {
        PreparedStatement stat=null;
        try {
             stat=conn.prepareStatement(UPDATE);
             stat.setLong(1, a.getCodigoPedidoProveedor());
             stat.setInt(2, a.getCodigoMaterial());
             stat.setInt(3, a.getCantidadSolicitada());
             stat.setFloat(4, a.getPrecioActual());
             stat.setFloat(5, a.getSubtotalPedidoProveedor());
             if (stat.executeUpdate()==0) {
                 System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(detallePedidoProveedor a) {
        PreparedStatement stat=null;
        try {
             stat=conn.prepareStatement(DELETE);
             stat.setLong(1, a.getCodigoPedidoProveedor());
             if (stat.executeUpdate()==0) {
                 System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<detallePedidoProveedor> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<detallePedidoProveedor> detalle = new ArrayList<>();
        try {
            stat=conn.prepareStatement(GETALL);
            rs=stat.executeQuery();
            while (rs.next()) {
                detalle.add(convertir(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return detalle;
    }

    @Override
    public detallePedidoProveedor obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        detallePedidoProveedor detalle=null;
        try {
            stat=conn.prepareStatement(GETALL);
            stat.setLong(1, id);
            rs=stat.executeQuery();
            if (rs.next()) {
                detalle=convertir(rs);
            } else {
                System.out.println("El registro no se ha encontrado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLDetallePedidoProvDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return detalle;
    }
    
}


package corralon.DAO.mysql;

import corralon.DAO.pedidoProveedorDAO;
import corralon.modelos.pedidoProveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLPedidoProveedorDAO implements pedidoProveedorDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO pedidoProveedor(codigoPedidoProveedor, cuitProveedor, fechaPedidoProveedor, totalPedidoProveedor, estadoPedidoProveedor) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE pedidoProveedor SET codigoPedidoProveedor=?, cuitProveedor=?, fechaPedidoProveedor=?, totalPedidoProveedor=?, estadoPedidoProveedor=? WHERE codigoPedidoProveedor=?" ;
    final String DELETE = "DELETE FROM pedidoProveedor WHERE codigoPedidoProveedor=?";
    final String GETALL = "SELECT codigoPedidoProveedor, cuitProveedor, fechaPedidoProveedor, totalPedidoProveedor, estadoPedidoProveedor FROM pedidoProveedor";
    final String GETONE = "SELECT codigoPedidoProveedor, cuitProveedor, fechaPedidoProveedor, totalPedidoProveedor, estadoPedidoProveedor FROM pedidoProveedor WHERE codigoPedidoProveedor=?";
    
    private pedidoProveedor convertir(ResultSet rs)throws SQLException {
          Long cod=rs.getLong("codigoPedidoProveedor");
          int cuit= rs.getInt("cuitProveedor");
          Date fecha= rs.getDate("fechaPedidoProveedor");
          float total=rs.getFloat("totalPedidoProveedor");
          boolean estado=rs.getBoolean("estadoPedidoProveedor");
          pedidoProveedor pedido= new pedidoProveedor(cod, cuit, fecha, total, estado);
          return pedido;
    }

    @Override
    public void insertar(pedidoProveedor a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodigoPedidoProveedor());
            stat.setInt(2, a.getCuitProveedor());
            stat.setDate(3, a.getFechaPedidoProveedor());
            stat.setFloat(4, a.getTotalPedidoProveedor());
            stat.setBoolean(5, a.isEstadoPedidoProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(pedidoProveedor a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCodigoPedidoProveedor());
            stat.setInt(2, a.getCuitProveedor());
            stat.setDate(3, a.getFechaPedidoProveedor());
            stat.setFloat(4, a.getTotalPedidoProveedor());
            stat.setBoolean(5, a.isEstadoPedidoProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(pedidoProveedor a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCodigoPedidoProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<pedidoProveedor> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<pedidoProveedor> pedidos= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while(rs.next()){
                 pedidos.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pedidos;
    }

    @Override
    public pedidoProveedor obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        pedidoProveedor pedido = null;
        try {
             stat=conn.prepareStatement(GETONE);
             stat.setLong(1, id);
             rs=stat.executeQuery();
             if (rs.next()) {
                pedido=convertir(rs);
            } else {
                 System.out.println("No se ha encontrado el registro.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pedido;
    }
    
}

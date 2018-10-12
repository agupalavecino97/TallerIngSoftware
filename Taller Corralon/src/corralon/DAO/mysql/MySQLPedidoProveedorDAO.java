
package corralon.DAO.mysql;

import corralon.DAO.pedidoProveedorDAO;
import corralon.modelos.pedidoProveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLPedidoProveedorDAO implements pedidoProveedorDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO pedidosproveedor( cuitProveedor, fechaPedidoProv, totalPedidoProd, estadoPedidoProd) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE pedidosproveedor SET codPedidoProv=?, cuitProveedor=?, fechaPedidoProv=?, totalPedidoProd=?, estadoPedidoProd=? WHERE codPedidoProv=?" ;
    final String DELETE = "DELETE FROM pedidosproveedor WHERE codPedidoProv=?";
    final String GETALL = "SELECT codPedidoProv, cuitProveedor, fechaPedidoProv, totalPedidoProd, estadoPedidoProd FROM pedidosproveedor";
    final String GETONE = "SELECT codPedidoProv,cuitProveedor, fechaPedidoProv, totalPedidoProd, estadoPedidoProd FROM pedidosproveedor WHERE codPedidoProv=?";

    MySQLPedidoProveedorDAO(Connection con) {
        this.conn=con;
                }
    
    private pedidoProveedor convertir(ResultSet rs)throws SQLException {
          Long cod=rs.getLong("codPedidoProv");
          Long cuit= rs.getLong("cuitProveedor");
          Date fecha= rs.getDate("fechaPedidoProv");
          float total=rs.getFloat("totalPedidoProd");
          String estado=rs.getString("estadoPedidoProd");
          pedidoProveedor pedido= new pedidoProveedor(cod,cuit, fecha, total, estado);
          return pedido;
    }

    @Override
    public void insertar(pedidoProveedor a) {
        ResultSet rs=null;
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stat.setLong(1, a.getCuitProveedor());
            stat.setDate(2, a.getFechaPedidoProveedor());
            stat.setFloat(3, a.getTotalPedidoProveedor());
            stat.setString(4, a.getEstadoPedidoProveedor());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
             rs = stat.getGeneratedKeys();
                if(rs.next())
                {
                    int last_inserted_id = rs.getInt(1);
                     System.out.println(last_inserted_id);
                     a.setCodigoPedidoProveedor(Long.valueOf(last_inserted_id));
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
            stat.setLong(2, a.getCuitProveedor());
            stat.setDate(3, a.getFechaPedidoProveedor());
            stat.setFloat(4, a.getTotalPedidoProveedor());
            stat.setString(5, a.getEstadoPedidoProveedor());
            stat.setLong(6, a.getCodigoPedidoProveedor());
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

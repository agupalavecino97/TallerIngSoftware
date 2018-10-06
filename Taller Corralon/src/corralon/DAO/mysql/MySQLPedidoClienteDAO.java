package corralon.DAO.mysql;

import corralon.DAO.pedidoClienteDAO;
import corralon.modelos.pedidoCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLPedidoClienteDAO implements pedidoClienteDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO pedidoCliente(codigoPedidoClie, dniCliente, fechaPedidoClie, totalPedidoClie) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE pedidoCliente SET codigoPedidoClie=?, dniCliente=?, fechaPedidoClie=?, totalPedidoClie=? WHERE codigoPedidoClie=?" ;
    final String DELETE = "DELETE FROM pedidoCliente WHERE codigoPedidoClie=?";
    final String GETALL = "SELECT codigoPedidoClie, dniCliente, fechaPedidoClie, totalPedidoClie FROM pedidoCliente";
    final String GETONE = "SELECT codigoPedidoClie, dniCliente, fechaPedidoClie, totalPedidoClie FROM pedidoCliente WHERE codigoPedidoClie=?";
    
    private pedidoCliente convertir(ResultSet rs)throws SQLException {
          Long cod=rs.getLong("codigoPedidoClie");
          int doc= rs.getInt("dniCliente");
          Date fecha= rs.getDate("fechaPedidoClie");
          float total=rs.getFloat("totalPedidoClie");
          pedidoCliente pedido=new pedidoCliente(cod, doc, fecha, total);
          return pedido;
    }

    @Override
    public void insertar(pedidoCliente a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodigoPedidoClie());
            stat.setInt(2, a.getDniCliente());
            stat.setDate(3, a.getFechaPedidoClie());
            stat.setFloat(4, a.getTotalPedidoClie());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void modificar(pedidoCliente a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);
            stat.setLong(1, a.getCodigoPedidoClie());
            stat.setInt(2, a.getDniCliente());
            stat.setDate(3, a.getFechaPedidoClie());
            stat.setFloat(4, a.getTotalPedidoClie());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void eliminar(pedidoCliente a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCodigoPedidoClie());
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya eliminado correctamente.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<pedidoCliente> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<pedidoCliente> pedidos= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALL);
             rs=stat.executeQuery();
             while(rs.next()){
                 pedidos.add(convertir(rs));
             }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pedidos;
    }

    @Override
    public pedidoCliente obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        pedidoCliente pedido = null;
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
            Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (rs!=null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLPedidoClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return pedido;
    }
    
}
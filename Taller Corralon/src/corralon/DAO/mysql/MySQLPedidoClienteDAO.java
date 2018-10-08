package corralon.DAO.mysql;

import corralon.DAO.pedidoClienteDAO;
import corralon.modelos.pedidoCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLPedidoClienteDAO implements pedidoClienteDAO{
    private Connection conn;
    final String INSERT = "INSERT INTO pedidosCliente(cuitCliente, fechaPedidoClie, totalPedidoClie, estado) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE pedidosCliente SET  cuitCliente=?, fechaPedidoClie=?, totalPedidoClie=?,estado=? WHERE codPedidoClie=?" ;
    final String DELETE = "DELETE FROM pedidosCliente WHERE codigoPedidoClie=?";
    final String GETALL = "SELECT codPedidoClie, cuitCliente, fechaPedidoClie, totalPedidoClie,estado FROM pedidoscliente";
    final String GETONE = "SELECT cuitCliente, fechaPedidoClie, totalPedidoClie,estado FROM pedidosCliente WHERE codPedidoClie=?";
    final String UPDATEestado= "UPDATE pedidosCliente SET estado=? WHERE codPedidoClie=?";
    
  
    MySQLPedidoClienteDAO(Connection con) {
            this.conn=con;
    }
    
    private pedidoCliente convertir(ResultSet rs)throws SQLException {
//          Long cod=rs.getLong("codPedidoClie");
          Long doc= rs.getLong("cuitCliente");
          Date fecha= rs.getDate("fechaPedidoClie");
          Long total=rs.getLong("totalPedidoClie");
          String estado=rs.getString("estado");
          pedidoCliente pedido=new pedidoCliente(doc, fecha, total,estado);
          System.out.println("aqui llega");
          System.out.println(pedido);
          return pedido;
    }

    @Override
    public void insertar(pedidoCliente a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stat.setLong(1, a.getDniCliente());
            stat.setDate(2, a.getFechaPedidoClie());
            stat.setLong(3, a.getTotalPedidoClie());
            stat.setString(4, a.getEstado());
            
            if (stat.executeUpdate()==0) {
                System.out.println("Puede que no se haya guardado correctamente.");
            }
            rs = stat.getGeneratedKeys();
                if(rs.next())
                {
                    int last_inserted_id = rs.getInt(1);
                     System.out.println(last_inserted_id);
                     a.setCodigoPedidoClie(Long.valueOf(last_inserted_id));
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
            stat.setLong(1, a.getDniCliente());
            stat.setDate(2, a.getFechaPedidoClie());
            stat.setLong(3, a.getTotalPedidoClie());
            stat.setString(4, a.getEstado());
            stat.setLong(5, a.getCodigoPedidoClie());
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
        System.out.println(pedido);
        return pedido;
    }
  
    
    @Override
    public void modificarEstado(Long id, String estado) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATEestado);            
            stat.setString(1,estado);
            stat.setLong(2,id);
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
    //Esto es para probar 
// public static void main(String[]args) throws SQLException{
//    String driver = "com.mysql.jdbc.Driver";
//    String database = "taller";
//    String hostname = "localhost";
//    String port = "3306";
//    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
//    Connection con=null;
//    con=DriverManager.getConnection(url,"root","root");
//    MySQLPedidoClienteDAO dao=new MySQLPedidoClienteDAO(con);
//    
//     Long a=Long.valueOf("45");
//     Long b=Long.valueOf("45");
//     //java.util.Date fechaActual = new java.util.Date();
//     java.util.Date date=new java.util.Date();
//     java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//     pedidoCliente tr=new pedidoCliente(a,sqlDate,b,"pendiente");
//     dao.insertar(tr);
//     List<pedidoCliente> clientes=dao.obtenerTodos(); 
//     for(pedidoCliente c :clientes){
//         System.out.println(c.toString());
//     }     
// }    

 
}
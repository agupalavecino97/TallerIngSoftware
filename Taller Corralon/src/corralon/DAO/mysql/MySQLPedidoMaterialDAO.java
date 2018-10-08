
package corralon.DAO.mysql;

import corralon.DAO.pedidoMaterialDAO;
import corralon.modelos.pedidoCliente;
import corralon.modelos.pedidoMaterial;
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


public class MySQLPedidoMaterialDAO implements pedidoMaterialDAO {
private Connection conn;
    final String INSERT = "INSERT INTO pedidoMaterial(codPedidoClie, codMaterial, cantMat, subTotalMat) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE pedidoMaterial SET codMaterial=?, cantMat=?,subTotalMat=? WHERE codPedidoClie=?" ;
    final String DELETE = "DELETE FROM pedidoMaterial WHERE codigoPedidoClie=? AND codMaterial=?";
    final String GETALL = "SELECT codPedidoClie, codMaterial, cantMat,subTotalMat FROM pedidoMaterial";
    final String GETONE = "SELECT codPedidoClie, codMaterial, cantMat,subTotalMat FROM pedidoMaterial WHERE codPedidoClie=?";
    final String GETALLporProv="SELECT codPedidoClie, codMaterial, cantMat,subTotalMat FROM pedidoMaterial WHERE codPedidoClie=?";
    MySQLPedidoMaterialDAO(Connection con) {
            this.conn=con;
    }
    
    private pedidoMaterial convertir(ResultSet rs)throws SQLException {
          //Long cod=rs.getLong("codigoPedidoClie");
          Long doc= rs.getLong("codPedidoClie");
          Long cod= rs.getLong("codMaterial");
          Long total=rs.getLong("cantMat");
          Long estado=rs.getLong("subTotalMat");
          pedidoMaterial pedido=new pedidoMaterial(doc, cod, total,estado);
          return pedido;
    }

    @Override
    public void insertar(pedidoMaterial a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try {
            stat=conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stat.setLong(1, a.getCodigoPedidoClie());
            stat.setLong(2, a.getCodMaterial());
            stat.setLong(3, a.getCantidadMaterial());
            stat.setLong(4, a.getSubTotalMat());
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
    public void modificar(pedidoMaterial a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(UPDATE);            
            stat.setLong(4, a.getCodigoPedidoClie());
            stat.setLong(1, a.getCodMaterial());
            stat.setLong(2, a.getCantidadMaterial());
            stat.setLong(3, a.getSubTotalMat());
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
    public void eliminar(pedidoMaterial a) {
        PreparedStatement stat=null;
        try {
            stat=conn.prepareStatement(DELETE);
            stat.setLong(1, a.getCodigoPedidoClie());
            stat.setLong(2,a.getCodMaterial());
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
    public List<pedidoMaterial> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<pedidoMaterial> pedidos= new ArrayList<>();
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
    public pedidoMaterial obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        pedidoMaterial pedido = null;
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
  
    
    @Override
    public List<pedidoMaterial> obtenerTodosDeUnPedido(Long cod) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<pedidoMaterial> pedidos= new ArrayList<>();
        try {
             stat=conn.prepareStatement(GETALLporProv);
             stat.setLong(1, cod);
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

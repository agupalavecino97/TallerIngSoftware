package corralon.DAO.mysql;

import corralon.DAO.pedidoClienteDAO;
import corralon.modelos.pedidoCliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLPedidoClienteDAO implements pedidoClienteDAO{

    final String INSERT = "INSERT INTO (codPedidoClie, cuitCliente, fechaPedidoClie, totalPedidoClie) VALUES(?,?,?,?)";
    final String UPDATE = "UPDATE pedidoCliente SET codPedidoClie=?, cuitCliente=?, fechaPedidoClie=?, totalPedidoClie=? WHERE codPedidoClie=?" ;
    final String DELETE = "DELETE FROM pedidoCliente WHERE codPedidoClie=?";
    final String GETALL = "SELECT codPedidoClie, cuitCliente, fechaPedidoClie, totalPedidoClie FROM pedidoCliente";
    final String GETONE = "SELECT codPedidoClie, cuitCliente, fechaPedidoClie, totalPedidoClie FROM pedidoCliente WHERE codPedidoClie=?";
    
    private final Connection con;

    public MySQLPedidoClienteDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public void insertar(pedidoCliente a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try{
            stat=con.prepareStatement(INSERT);
            stat.setLong(1,a.getCodigoPedidoClie());
            stat.setInt(2, a.getDniCliente());
            stat.setDate(3, a.getFechaPedidoClie());
            stat.setFloat(4, a.getTotalPedidoClie());
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                        try {
                            rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }

    @Override
    public void modificar(pedidoCliente a) {
            PreparedStatement stat=null;
            try{
                stat=con.prepareStatement(UPDATE);      
                stat.setLong(1, a.getCodigoPedidoClie());
                stat.setInt(2, a.getDniCliente());
                stat.setDate(3, a.getFechaPedidoClie());
                stat.setFloat(4, a.getTotalPedidoClie());
                if(stat.executeUpdate()==0){
                    System.out.println("Quizas no se guardo correctamente gg");
                } 
            } catch (SQLException ex) {
                Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                } finally{
                    if (stat != null)
                        try {
                            stat.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
    }

    @Override
    public void eliminar(pedidoCliente a) {
        PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(DELETE);  
            stat.setLong(1,a.getCodigoPedidoClie());
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }
    
    private pedidoCliente convertir(ResultSet rs) throws SQLException{
        Long codigo=rs.getLong("codPedidoClie");
        int dniClie=rs.getInt("cuitCliente");
        Date fecha=rs.getDate("fechaPedidoClie");
        float total=rs.getFloat("totalPedidoClie");
        pedidoCliente pedido= new pedidoCliente(codigo, dniClie, fecha, total);
        return pedido;
    }

    @Override
    public List<pedidoCliente> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<pedidoCliente> pedido=new ArrayList<>();
        try{
            stat=con.prepareStatement(GETALL);  
            rs=stat.executeQuery();
            while(rs.next()){
                pedido.add(convertir(rs));
        }  
        } catch (SQLException ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
     return pedido;
    }

    @Override
    public pedidoCliente obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        pedidoCliente a=null;
        try{
            stat=con.prepareStatement(GETONE);  
            stat.setLong(1,id);
            rs=stat.executeQuery();
            if(rs.next()){
                a=convertir(rs);
        }else{
                System.out.println("NO se encontro ese registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
    return a;
    }
    
}
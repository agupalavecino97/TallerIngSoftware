
package corralon.DAO.mysql;
import corralon.DAO.clienteDAO;
import corralon.modelos.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLClienteDAO implements clienteDAO{

    
    final String INSERT = "INSERT INTO cliente(cuitCliente, razonSocial, direccionCliente, telefonoCliente, estadoClie) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE cliente SET razonSocial=?, direccionCliente=?, telefonoCliente=?, estadoClie=? WHERE cuitCliente=?" ;
    final String DELETE = "DELETE FROM cliente WHERE cuitCliente=?";
    final String GETALL = "SELECT cuitCliente, razonSocial, direccionCliente, telefonoCliente, estadoClie FROM cliente";
    final String GETONE = "SELECT cuitCliente, razonSocial, direccionCliente, telefonoCliente, estadoClie FROM cliente WHERE cuitCliente=?";
 
    private final Connection con;
    public MySQLClienteDAO(Connection con) {
        this.con = con;
     }
  //prueba   
    @Override
    public void insertar(cliente a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try{
            stat=con.prepareStatement(INSERT);
            stat.setLong(1,a.getCuitCliente());
            stat.setString(2,a.getRazonSocial());
            stat.setString(3,a.getDireccionCliente());
            stat.setInt(4,a.getTelefonoCliente());
            stat.setBoolean(5,true); 
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            }
            /* para generar un atributo autoinclemental
            rs=stat.getGeneratedKeys();
            if(rs.next()){
                a.setCuitCliente(rs.getLong(1));
            }else{
                throw new SQLException("NO se puede asignar el id");
            }*/
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
    }

    @Override
    public void modificar(cliente a) {
            PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(UPDATE);      
            stat.setString(1,a.getRazonSocial());
            stat.setString(2,a.getDireccionCliente());
            stat.setInt(3,a.getTelefonoCliente());
            stat.setBoolean(4,a.isEstadoClie());
            stat.setLong(5,a.getCuitCliente());
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
    public void eliminar(cliente a) {
               PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(DELETE);  
            stat.setLong(1,a.getCuitCliente());
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


    private cliente convertir(ResultSet rs)throws SQLException {
          Long cuit=rs.getLong("cuitCliente");
          String nombre=rs.getString("razonSocial");
          String direccion=rs.getString("direccionCliente");
          int telefono=rs.getInt("telefonoCliente");
          boolean estado=rs.getBoolean("estadoClie");
          cliente cliente = new cliente(cuit,nombre,direccion,telefono,estado);
          return cliente;        
    }
    
    
    @Override
    public List<cliente> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<cliente> cliente=new ArrayList<>();
        try{
            stat=con.prepareStatement(GETALL);  
            rs=stat.executeQuery();
            while(rs.next()){
                cliente.add(convertir(rs));
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
    return cliente;      
    }

    @Override
    public cliente obtener(Long id){
        PreparedStatement stat=null;
        ResultSet rs=null;
        cliente a=null;
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
 
 
/*
    Esto es para probar 
 public static void main(String[]args) throws SQLException{
    String driver = "com.mysql.jdbc.Driver";
    String database = "taller";
    String hostname = "localhost";
    String port = "3306";
    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    Connection con=null;
    con=DriverManager.getConnection(url,"root","root");
    MySQLClienteDAO dao=new MySQLClienteDAO(con);
    
   
     cliente a=new cliente(45,"pepo","dirpepo", 456,true);
     dao.eliminar(a);
     List<cliente> clientes=dao.obtenerTodos(); 
     for(cliente c :clientes){
         System.out.println(c.toString());
     }     
 }    
 */

     
   
 }   
  


   

package corralon.DAO.mysql;


import corralon.DAO.proveedorDAO;
import corralon.modelos.proveedor;
import corralon.modelos.stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLProveedorDAO implements proveedorDAO{
    
    
    final String INSERT = "INSERT INTO proveedor(cuitProveedor, nombreProv, direccionProv, telefonoProv, estadoProv) VALUES(?,?,?,?,?)";
    final String UPDATE = "UPDATE proveedor SET nombreProv=?, direccionProv=?, telefonoProv=?, estadoProv=? WHERE cuitProveedor=?" ;
    final String DELETE = "DELETE FROM proveedor WHERE cuitProveedor=?";
    final String GETALL = "SELECT cuitProveedor, nombreProv, direccionProv, telefonoProv, estadoProv FROM proveedor";
    final String GETONE = "SELECT cuitProveedor, nombreProv, direccionProv, telefonoProv, estadoProv FROM proveedor WHERE cuitProveedor=?";
    
    private final Connection con;
    public MySQLProveedorDAO(Connection con) {
        this.con = con;
     }
        

    @Override
    public void insertar(proveedor a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try{
            stat=con.prepareStatement(INSERT);
            stat.setLong(1,a.getCuitProveedor());
            stat.setString(2,a.getNombreProveedor());
            stat.setString(3,a.getDireccionProveedor());
            stat.setLong(4,a.getTelefonoProveedor());
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
            Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                        try {
                            rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    public void modificar(proveedor a) {
            PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(UPDATE);      
            stat.setString(1,a.getNombreProveedor());
            stat.setString(2,a.getDireccionProveedor());
            stat.setLong(3,a.getTelefonoProveedor());
            stat.setBoolean(4,a.isEstadoProveedor());
            stat.setLong(5,a.getCuitProveedor());
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }
    
    @Override
    public void eliminar(proveedor a) {
               PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(DELETE);  
            stat.setLong(1,a.getCuitProveedor());
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }
    
    
    private proveedor convertir(ResultSet rs)throws SQLException {
          Long cuit=rs.getLong("cuitProveedor");
          String nombre=rs.getString("nombreProv");
          String direccion=rs.getString("direccionProv");
          Long telefono=rs.getLong("telefonoProv");
          boolean estado=rs.getBoolean("estadoProv");
          proveedor proveedor = new proveedor(cuit,nombre,direccion,telefono,estado);
          return proveedor;        
    }
    
    @Override
    public List<proveedor> obtenerTodos() {
        PreparedStatement stat=null;
        ResultSet rs=null;
        List<proveedor> proveedor=new ArrayList<>();
        try{
            stat=con.prepareStatement(GETALL);  
            rs=stat.executeQuery();
            while(rs.next()){
                proveedor.add(convertir(rs));
        }  
        } catch (SQLException ex) {
            Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
    return proveedor;      
    }
    
    @Override
     public proveedor obtener(Long id){
        PreparedStatement stat=null;
        ResultSet rs=null;
        proveedor a=null;
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
            Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
    return a;  
    }
}

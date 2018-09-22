
package corralon.DAO.mysql;

import corralon.DAO.materialDAO;
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


public class MySQLMaterialDAO implements materialDAO{
    
    final String INSERT="INSERT INTO stock(nombreMat, descripcionMat, cantExistente, stockMinimo, stockMax, estadoMat) VALUES (?,?,?,?,?,?)";
    final String DELETE="DELETE FROM stock WHERE codMaterial=?";
    //final String DELETE="UPDATE stcok set estado=false WHERE codigoMaterial=?";
    final String UPDATE="UPDATE stock SET nombreMat=?, descripcionMat=?, cantExistente=?, stockMinimo=?, stockMax=?, estadoMat=?";
    final String GETALL="SELECT codMaterial, nombreMat, descripcionMat, cantExistente, stockMinimo, stockMax, estadoMat FROM stock";
    final String GETONE="SELECT codMaterial nombreMat, descripcionMat, cantdExistente, stockMinimo, stockMax, estadoMat FROM stock WHERE codMaterial=?";

    private final Connection con;
    
    public MySQLMaterialDAO(Connection con){
        this.con=con;
    }

    @Override
    public void insertar(stock a) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        try{
            stat=con.prepareStatement(INSERT);
            
            stat.setString(1,a.getNombreMaterial());
            stat.setString(2,a.getDescripcionMaterial());
            stat.setInt(3,a.getCantidadExistente());
            stat.setInt(4,a.getStockMaximo());
            stat.setInt(5 ,a.getStockMinimo());
            stat.setBoolean(6,true); 
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            }
            rs=stat.getGeneratedKeys();
            if(rs.next()){  
                a.setCodigoMaterial(rs.getLong(1));
            }else{
                throw new SQLException("NO se puede asignar el id");
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
    }

    
    
    
    @Override
    public void modificar(stock a) {
                PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(UPDATE);      
            stat.setString(1,a.getNombreMaterial());
            stat.setString(2,a.getDescripcionMaterial());
            stat.setInt(3,a.getCantidadExistente());
            stat.setInt(4,a.getStockMaximo());
            stat.setInt(5,a.getStockMinimo());
            stat.setBoolean(6,a.isEstadoMaterial());
            stat.setLong(7,a.getCodigoMaterial());
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
    public void eliminar(stock a) {
              PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(DELETE);  
            stat.setLong(1,a.getCodigoMaterial());
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

    private stock convertir(ResultSet rs)throws SQLException {
          //Long codigo=rs.getLong("codigoMaterial");
          String nombre=rs.getString("nombreMat");
          String descripcion=rs.getString("descripcionMat");
          int cantidad=rs.getInt("cantExistente");
          int stockmax=rs.getInt("StockMax");
          int stockmin=rs.getInt("stockMinimo");
          boolean estado=rs.getBoolean("estadoMat");
          stock material = new stock(nombre,descripcion,cantidad,stockmax,stockmin,estado);
          return material;       
    }
    

    @Override
    public List<stock> obtenerTodos() {
            PreparedStatement stat=null;
        ResultSet rs=null;
        List<stock> material=new ArrayList<>();
        try{
            stat=con.prepareStatement(GETALL);  
            rs=stat.executeQuery();
            while(rs.next()){
                material.add(convertir(rs));
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
    return material;
    }

    @Override
    public stock obtener(Long id) {
        PreparedStatement stat=null;
        ResultSet rs=null;
        stock a=null;
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
    



 public static void main(String[]args) throws SQLException{
    String driver = "com.mysql.jdbc.Driver";
    String database = "taller";
    String hostname = "localhost";
    String port = "3306";
    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    Connection con=null;
    con=DriverManager.getConnection(url,"root","root");
    MySQLMaterialDAO dao =new MySQLMaterialDAO(con);
    
   
     stock a=new stock("cal","descripcion de la cal",500,10,10000,true);
     dao.insertar(a);
     List<stock> materiales=dao.obtenerTodos(); 
     for(stock c :materiales){
         System.out.println(c.toString());
     }     
 }    
 
}
 
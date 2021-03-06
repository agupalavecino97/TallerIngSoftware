
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
    
    final String INSERT="INSERT INTO stock(codMaterial, nombreMat,precio, descripcionMat, cantExistente, stockMinimo, stockMax, estadoMat) VALUES (?,?,?,?,?,?,?,?)";
    final String DELETE="DELETE FROM stock WHERE codMaterial=?";
    //final String DELETE="UPDATE stcok set estado=false WHERE codigoMaterial=?";
    final String UPDATE="UPDATE stock SET nombreMat=?, precio=?, descripcionMat=?, cantExistente=?, stockMinimo=?, stockMax=?, estadoMat=? WHERE codMaterial=?";
    final String GETALL="SELECT codMaterial,nombreMat,precio,descripcionMat, cantExistente, stockMinimo, stockMax, estadoMat FROM stock";
    final String GETONE="SELECT codMaterial,nombreMat,precio, descripcionMat, cantExistente, stockMinimo, stockMax, estadoMat FROM stock WHERE codMaterial=?";
    final String UPDATECANT="UPDATE stock SET cantExistente=? WHERE codMaterial=?";
    final String GETONECANT="SELECT cantExistente FROM stock WHERE codMaterial=?";
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
            stat.setLong(1,a.getCodMaterial());
            stat.setString(2,a.getNombreMaterial());
            stat.setLong(3,a.getPrecio());
            stat.setString(4,a.getDescripcionMaterial());
            stat.setLong(5,a.getCantidadExistente());
            stat.setLong(6,a.getStockMaximo());
            stat.setLong(7 ,a.getStockMinimo());
            stat.setBoolean(8,true); 
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            }
//            rs=stat.getGeneratedKeys();
//            if(rs.next()){  
//                a.setCodigoMaterial(rs.getLong(1));
//            }else{
//                throw new SQLException("NO se puede asignar el id");
//            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                        try {
                            rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }   
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }

    
    @Override
    public void modificar(stock a) {
                PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(UPDATE);
            stat.setString(1,a.getNombreMaterial());
            stat.setLong(2,a.getPrecio());
            stat.setString(3,a.getDescripcionMaterial());
            stat.setLong(4,a.getCantidadExistente());
            stat.setLong(5,a.getStockMaximo());
            stat.setLong(6,a.getStockMinimo());
            stat.setBoolean(7,a.isEstadoMaterial());
            stat.setLong(8,a.getCodMaterial());
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }    
    }
    
     @Override
    public void modificarCantidad(Long id, Long cantidad) {
          PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(UPDATECANT);
            stat.setLong(1,cantidad);
            stat.setLong(2,id);
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }    
    }


    @Override
    public void eliminar(stock a) {
              PreparedStatement stat=null;
        try{
            stat=con.prepareStatement(DELETE);  
            stat.setLong(1,a.getCodMaterial());
            if(stat.executeUpdate()==0){
                System.out.println("Quizas no se guardo correctamente gg");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
    }

    private stock convertir(ResultSet rs)throws SQLException {
          Long codigo=rs.getLong("codMaterial");
          String nombre=rs.getString("nombreMat");
          Long precio=rs.getLong("precio");
          String descripcion=rs.getString("descripcionMat");
          Long cantidad=rs.getLong("cantExistente");
          Long stockmax=rs.getLong("StockMax");
          Long stockmin=rs.getLong("stockMinimo");
          boolean estado=rs.getBoolean("estadoMat");
          stock material = new stock(codigo,nombre,precio,descripcion,cantidad,stockmax,stockmin,estado);
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
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
           System.out.println(a);
    return a;    
    }
    
     @Override
    public Long obtenerCantidad(Long id) {
       PreparedStatement stat=null;
        ResultSet rs=null;
        Long cantidad=null;
        try{
            stat=con.prepareStatement(GETONECANT);  
            stat.setLong(1,id);
            rs=stat.executeQuery();
            if(rs.next()){
               cantidad=rs.getLong("cantExistente");
        }else{
                System.out.println("NO se encontro ese registro");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if (rs != null)
                    try {
                        rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
                if (stat != null)
                    try {
                        stat.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MySQLMaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
                } 
             }
         return cantidad;    
    }


// public static void main(String[]args) throws SQLException{
//    String driver = "com.mysql.jdbc.Driver";
//    String database = "taller";
//    String hostname = "localhost";
//    String port = "3306";
//    String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
//    Connection con=null;
//    con=DriverManager.getConnection(url,"root","root");
//    MySQLMaterialDAO dao =new MySQLMaterialDAO(con);
//    //Long l = Long.parseLong(String.valueOf(1));
//     Long a=Long.parseLong(String.valueOf(2));
//     Long b=Long.parseLong(String.valueOf(2));
//     Long c=Long.parseLong(String.valueOf(2));
//     Long d=Long.parseLong(String.valueOf(2));
//     Long e=Long.parseLong(String.valueOf(2));
//     stock g=new stock(a,"nombremodificado",b,"deascr",c,d,e,true);
//     //dao.insertar(g); 
//     dao.modificar(g);
////      
////     List<stock> materiales=dao.obtenerTodos();        
////    for(stock c :materiales){
////        System.out.println(c.toString());
////    }     
////        materiales.forEach((c) -> {
////            System.out.println(c.toString());
////        });     
// } 

   
   
   
}
 
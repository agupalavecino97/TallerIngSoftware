
package corralon.DAO.mysql;

import corralon.DAO.empleadoDAO;
import corralon.modelos.cliente;
import corralon.modelos.empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySQLempleadoDAO implements empleadoDAO {
    
    private final Connection conn;

    public MySQLempleadoDAO(Connection con) {
        this.conn=con;
    }
    
 
    @Override
    public void insertar(empleado a) {
    }

    @Override
    public void modificar(empleado a) {
    }

    @Override
    public void eliminar(empleado a) {
    }

    @Override
    public List<empleado> obtenerTodos() {
        return null;
    }

    
final String GETONE = "SELECT id, usuario,contraseña, nombre, apellido, telefono, prioridad FROM empleado WHERE usuario=?";



    private empleado convertir(ResultSet rs)throws SQLException {
          //((Long id=rs.getLong("id");
          String usuario=rs.getString("usuario");
          String contraseña=rs.getString("contraseña");
          String nombre=rs.getString("nombre");
          String apellido=rs.getString("apellido");
          Long telefono=rs.getLong("telefono");
          int prioridad=rs.getInt("prioridad");
          empleado empleado= new empleado(usuario,contraseña,nombre,apellido,telefono,prioridad);
          return empleado;      
    }
    
 

    @Override
    public empleado obtener2(String c) {
                PreparedStatement stat=null;
        ResultSet rs=null;
        empleado a=null;
        try{
            stat=conn.prepareStatement(GETONE);  
            stat.setString(1,c);
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

    @Override
    public empleado obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

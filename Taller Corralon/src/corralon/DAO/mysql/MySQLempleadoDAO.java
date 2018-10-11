
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

    
final String GETONE = "SELECT id,contraseña, nombre, apellido, telefono, prioridad FROM empleado WHERE id=?";



    private empleado convertir(ResultSet rs)throws SQLException {
          //((Long id=rs.getLong("id");
          Long id=rs.getLong("id");
          String contraseña=rs.getString("contraseña");
          String nombre=rs.getString("nombre");
          String apellido=rs.getString("apellido");
          Long telefono=rs.getLong("telefono");
          int prioridad=rs.getInt("prioridad");
          empleado empleado= new empleado(id,contraseña,nombre,apellido,telefono,prioridad);
          return empleado;      
    }
    
 

    @Override
    public empleado obtener(Long id) {
         PreparedStatement stat=null;
        ResultSet rs=null;
        empleado a=null;
        try{
            stat=conn.prepareStatement(GETONE);  
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

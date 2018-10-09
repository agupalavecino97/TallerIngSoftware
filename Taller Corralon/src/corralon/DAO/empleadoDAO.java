package corralon.DAO;


import corralon.DAO.DAO;
import corralon.modelos.empleado;


public interface empleadoDAO extends DAO<empleado,Long>{
    empleado obtener2(String c);
}

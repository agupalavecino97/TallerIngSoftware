
package corralon.DAO;
import corralon.modelos.stock;

public interface materialDAO extends DAO<stock,Long>{
    void modificarCantidad(Long id,Long cantidad);
    Long obtenerCantidad(Long id);
}

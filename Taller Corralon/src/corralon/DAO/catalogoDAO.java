
package corralon.DAO;

import corralon.modelos.catalogo;
import java.sql.Date;
import java.util.List;

public interface catalogoDAO extends DAO<catalogo, Long>{
    
    List<catalogo> obtenerTodosDeProv(Long id);
    void modificarCantidad(Long id,Long id2, Date fecha, float precio);
    catalogo ObtenerUnProductoDeUnProveedor(Long id,Long cod);
    
}


package corralon.DAO;

import corralon.modelos.catalogo;
import java.util.List;

public interface catalogoDAO extends DAO<catalogo, Long>{
    
    List<catalogo> obtenerTodosDeProv(Long id);
    
    
}

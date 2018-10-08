
package corralon.DAO;

import corralon.modelos.pedidoMaterial;
import java.util.List;


public interface pedidoMaterialDAO extends DAO<pedidoMaterial, Long>{
    List<pedidoMaterial> obtenerTodosDeUnPedido(Long cod);
}

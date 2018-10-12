
package corralon.DAO;

import corralon.modelos.detallePedidoProveedor;
import java.util.List;

public interface detallePedidoProveedorDAO extends DAO<detallePedidoProveedor, Long>{
     List<detallePedidoProveedor> obtenerTodosDeUnPedido(Long cod);
    
}

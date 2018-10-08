
package corralon.DAO;

import corralon.modelos.pedidoCliente;

public interface pedidoClienteDAO extends DAO<pedidoCliente, Long>{
    void modificarEstado(Long id,String estado);
}

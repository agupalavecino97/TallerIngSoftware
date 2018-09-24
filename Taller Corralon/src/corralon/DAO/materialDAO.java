
package corralon.DAO;
import corralon.modelos.stock;

public interface materialDAO extends DAO<stock,Long>{

    public stock obtenerconcodigo(int id);
    
}

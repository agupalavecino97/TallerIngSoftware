
package corralon.modelos;
import java.sql.Date;
/**
 *
 * @author Agustin
 */
public class presupuesto {
    
    private int codigoPedidoClie;
    private int dniCliente;
    private Date fechaPresupuesto;

    public presupuesto(int codigoPedidoClie, int dniCliente, Date fechaPresupuesto) {
        this.codigoPedidoClie = codigoPedidoClie;
        this.dniCliente = dniCliente;
        this.fechaPresupuesto = fechaPresupuesto;
    }

    public int getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public void setCodigoPedidoClie(int codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Date getFechaPresupuesto() {
        return fechaPresupuesto;
    }

    public void setFechaPresupuesto(Date fechaPresupuesto) {
        this.fechaPresupuesto = fechaPresupuesto;
    }
    
    
}

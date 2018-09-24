
package corralon.modelos;

import java.sql.Date;

public class presupuesto {
    
    private Long codigoPedidoClie;
    private int dniCliente;
    private Date fechaPresupuesto;

    public presupuesto(Long codigoPedidoClie, int dniCliente, Date fechaPresupuesto) {
        this.codigoPedidoClie = codigoPedidoClie;
        this.dniCliente = dniCliente;
        this.fechaPresupuesto = fechaPresupuesto;
    }

    public Long getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public void setCodigoPedidoClie(Long codigoPedidoClie) {
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

    @Override
    public String toString() {
        return "presupuesto{" + "codigoPedidoClie=" + codigoPedidoClie + ", dniCliente=" + dniCliente + ", fechaPresupuesto=" + fechaPresupuesto + '}';
    }
   
}

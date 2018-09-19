
package corralon.modelos;

import java.sql.Date;

public class pedidoCliente {
    
    private int codigoPedidoClie;
    private int dniCliente;
    private Date fechaPedidoClie;
    private float totalPedidoClie;

    public pedidoCliente(int codigoPedidoClie, int dniCliente, Date fechaPedidoClie, float totalPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
        this.dniCliente = dniCliente;
        this.fechaPedidoClie = fechaPedidoClie;
        this.totalPedidoClie = totalPedidoClie;
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

    public Date getFechaPedidoClie() {
        return fechaPedidoClie;
    }

    public void setFechaPedidoClie(Date fechaPedidoClie) {
        this.fechaPedidoClie = fechaPedidoClie;
    }

    public float getTotalPedidoClie() {
        return totalPedidoClie;
    }

    public void setTotalPedidoClie(float totalPedidoClie) {
        this.totalPedidoClie = totalPedidoClie;
    }

    @Override
    public String toString() {
        return "pedidoCliente{" + "codigoPedidoClie=" + codigoPedidoClie + ", dniCliente=" + dniCliente + ", fechaPedidoClie=" + fechaPedidoClie + ", totalPedidoClie=" + totalPedidoClie + '}';
    }
       
}

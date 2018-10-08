
package corralon.modelos;

import java.sql.Date;

public class pedidoCliente {
    
    private Long codigoPedidoClie;
    private Long dniCliente;
    private Date fechaPedidoClie;
    private Long totalPedidoClie;
    private String estado;

    public pedidoCliente(Long dniCliente, Date fechaPedidoClie, Long totalPedidoClie, String estado) {
        this.dniCliente = dniCliente;
        this.fechaPedidoClie = fechaPedidoClie;
        this.totalPedidoClie = totalPedidoClie;
        this.estado = estado;
    }

    

    public Long getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public Long getDniCliente() {
        return dniCliente;
    }

    public Date getFechaPedidoClie() {
        return fechaPedidoClie;
    }

    public Long getTotalPedidoClie() {
        return totalPedidoClie;
    }

    public String getEstado() {
        return estado;
    }

  

    public void setCodigoPedidoClie(Long codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
    }

    public void setDniCliente(Long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setFechaPedidoClie(Date fechaPedidoClie) {
        this.fechaPedidoClie = fechaPedidoClie;
    }

    public void setTotalPedidoClie(Long totalPedidoClie) {
        this.totalPedidoClie = totalPedidoClie;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "pedidoCliente{" + "codigoPedidoClie=" + codigoPedidoClie + ", dniCliente=" + dniCliente + ", fechaPedidoClie=" + fechaPedidoClie + ", totalPedidoClie=" + totalPedidoClie + ", estado=" + estado + '}';
    }
    

}


package corralon.modelos;

import java.sql.Date;


public class pedidoProveedor {
    private Long codigoPedidoProveedor;
    private Long cuitProveedor;
    private Date fechaPedidoProveedor;
    private float totalPedidoProveedor;
    private boolean estadoPedidoProveedor;

    public pedidoProveedor(Long cuitProveedor, Date fechaPedidoProveedor, float totalPedidoProveedor, boolean estadoPedidoProveedor) {
        this.cuitProveedor = cuitProveedor;
        this.fechaPedidoProveedor = fechaPedidoProveedor;
        this.totalPedidoProveedor = totalPedidoProveedor;
        this.estadoPedidoProveedor = estadoPedidoProveedor;
    }

    public Long getCodigoPedidoProveedor() {
        return codigoPedidoProveedor;
    }

    public Long getCuitProveedor() {
        return cuitProveedor;
    }

    public Date getFechaPedidoProveedor() {
        return fechaPedidoProveedor;
    }

    public float getTotalPedidoProveedor() {
        return totalPedidoProveedor;
    }

    public boolean isEstadoPedidoProveedor() {
        return estadoPedidoProveedor;
    }

    public void setCodigoPedidoProveedor(Long codigoPedidoProveedor) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
    }

    public void setCuitProveedor(Long cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void setFechaPedidoProveedor(Date fechaPedidoProveedor) {
        this.fechaPedidoProveedor = fechaPedidoProveedor;
    }

    public void setTotalPedidoProveedor(float totalPedidoProveedor) {
        this.totalPedidoProveedor = totalPedidoProveedor;
    }

    public void setEstadoPedidoProveedor(boolean estadoPedidoProveedor) {
        this.estadoPedidoProveedor = estadoPedidoProveedor;
    }

    @Override
    public String toString() {
        return "pedidoProveedor{" + "codigoPedidoProveedor=" + codigoPedidoProveedor + ", cuitProveedor=" + cuitProveedor + ", fechaPedidoProveedor=" + fechaPedidoProveedor + ", totalPedidoProveedor=" + totalPedidoProveedor + ", estadoPedidoProveedor=" + estadoPedidoProveedor + '}';
    }
    
    
        
}

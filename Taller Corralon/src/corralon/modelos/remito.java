
package corralon.modelos;

import java.sql.Date;

public class remito {
    private Long cuitProveedor;
    private Long codigoPedidoProveedor;
    private float totalRemito;
    private Date fecha;
    private String estado;

    public remito(Long cuitProveedor, Long codigoPedidoProveedor, float totalRemito, Date fecha, String estado) {
        this.cuitProveedor = cuitProveedor;
        this.codigoPedidoProveedor = codigoPedidoProveedor;
        this.totalRemito = totalRemito;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Long getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(Long cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public Long getCodigoPedidoProveedor() {
        return codigoPedidoProveedor;
    }

    public void setCodigoPedidoProveedor(Long codigoPedidoProveedor) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
    }

    public float getTotalRemito() {
        return totalRemito;
    }

    public void setTotalRemito(float totalRemito) {
        this.totalRemito = totalRemito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "remito{" + "cuitProveedor=" + cuitProveedor + ", codigoPedidoProveedor=" + codigoPedidoProveedor + ", totalRemito=" + totalRemito + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

    
}

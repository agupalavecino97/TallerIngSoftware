
package corralon.modelos;

public class remito {
    private Long cuitProveedor;
    private int codigoPedidoProveedor;
    private float subtotalRemito;
    private float totalRemito;

    public remito(Long cuitProveedor, int codigoPedidoProveedor, float subtotalRemito, float totalRemito) {
        this.cuitProveedor = cuitProveedor;
        this.codigoPedidoProveedor = codigoPedidoProveedor;
        this.subtotalRemito = subtotalRemito;
        this.totalRemito = totalRemito;
    }

    public Long getCuitProveedor() {
        return cuitProveedor;
    }

    public int getCodigoPedidoProveedor() {
        return codigoPedidoProveedor;
    }

    public float getSubtotalRemito() {
        return subtotalRemito;
    }

    public float getTotalRemito() {
        return totalRemito;
    }

    public void setCuitProveedor(Long cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void setCodigoPedidoProveedor(int codigoPedidoProveedor) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
    }

    public void setSubtotalRemito(float subtotalRemito) {
        this.subtotalRemito = subtotalRemito;
    }

    public void setTotalRemito(float totalRemito) {
        this.totalRemito = totalRemito;
    }

    @Override
    public String toString() {
        return "remito{" + "cuitProveedor=" + cuitProveedor + ", codigoPedidoProveedor=" + codigoPedidoProveedor + ", subtotalRemito=" + subtotalRemito + ", totalRemito=" + totalRemito + '}';
    }
    
    
}

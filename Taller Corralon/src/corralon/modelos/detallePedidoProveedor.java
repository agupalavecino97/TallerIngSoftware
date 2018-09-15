
package corralon.modelos;

public class detallePedidoProveedor {
    private int codigoPedidoProveedor;
    private int codigoMaterial;    
    private int cantidadSolicitada;
    private float precioActual;
    private float subtotalPedidoProveedor;


    public detallePedidoProveedor(int codigoPedidoProveedor, int codigoMaterial, int cantidadSolicitada, float precioActual, float subtotalPedidoProveedor) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
        this.codigoMaterial = codigoMaterial;
        this.cantidadSolicitada = cantidadSolicitada;
        this.precioActual = precioActual;
        this.subtotalPedidoProveedor = subtotalPedidoProveedor;
    }

    public int getCodigoPedidoProveedor() {
        return codigoPedidoProveedor;
    }

    public int getCodigoMaterial() {
        return codigoMaterial;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public float getPrecioActual() {
        return precioActual;
    }

    public float getSubtotalPedidoProveedor() {
        return subtotalPedidoProveedor;
    }

    public void setCodigoPedidoProveedor(int codigoPedidoProveedor) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
    }

    public void setCodigoMaterial(int codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public void setPrecioActual(float precioActual) {
        this.precioActual = precioActual;
    }

    public void setSubtotalPedidoProveedor(float subtotalPedidoProveedor) {
        this.subtotalPedidoProveedor = subtotalPedidoProveedor;
    }

    @Override
    public String toString() {
        return "detallePedidoProveedor{" + "codigoPedidoProveedor=" + codigoPedidoProveedor + ", codigoMaterial=" + codigoMaterial + ", cantidadSolicitada=" + cantidadSolicitada + ", precioActual=" + precioActual + ", subtotalPedidoProveedor=" + subtotalPedidoProveedor + '}';
    }

    
}

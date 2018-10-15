package corralon.modelos;

public class detallePedidoProveedor {
    private Long codigoPedidoProveedor;
    private Long codigoMaterial;    
    private Long cantidadSolicitada;
    private float precioActual;
   // private float subtotalPedidoProveedor;

    public detallePedidoProveedor(Long codigoPedidoProveedor, Long codigoMaterial, Long cantidadSolicitada, float precioActual) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
        this.codigoMaterial = codigoMaterial;
        this.cantidadSolicitada = cantidadSolicitada;
        this.precioActual = precioActual;
    }

    public Long getCodigoPedidoProveedor() {
        return codigoPedidoProveedor;
    }

    public void setCodigoPedidoProveedor(Long codigoPedidoProveedor) {
        this.codigoPedidoProveedor = codigoPedidoProveedor;
    }

    public Long getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(Long codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public Long getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(Long cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public float getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(float precioActual) {
        this.precioActual = precioActual;
    }

    @Override
    public String toString() {
        return "detallePedidoProveedor{" + "codigoPedidoProveedor=" + codigoPedidoProveedor + ", codigoMaterial=" + codigoMaterial + ", cantidadSolicitada=" + cantidadSolicitada + ", precioActual=" + precioActual + '}';
    }

   

    
}

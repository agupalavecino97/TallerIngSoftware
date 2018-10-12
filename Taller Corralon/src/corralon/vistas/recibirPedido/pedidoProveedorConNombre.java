
package corralon.vistas.recibirPedido;


class pedidoProveedorConNombre {
    private int codigoMaterial;
    private String nombre;
    private int cantidadSolicitada;
    private float precioActual;
    private float subtotalPedidoProveedor;

    public pedidoProveedorConNombre(int codigoMaterial, String nombre, int cantidadSolicitada, float precioActual, float subtotalPedidoProveedor) {
        this.codigoMaterial = codigoMaterial;
        this.nombre = nombre;
        this.cantidadSolicitada = cantidadSolicitada;
        this.precioActual = precioActual;
        this.subtotalPedidoProveedor = subtotalPedidoProveedor;
    }

    public int getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(int codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public float getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(float precioActual) {
        this.precioActual = precioActual;
    }

    public float getSubtotalPedidoProveedor() {
        return subtotalPedidoProveedor;
    }

    public void setSubtotalPedidoProveedor(float subtotalPedidoProveedor) {
        this.subtotalPedidoProveedor = subtotalPedidoProveedor;
    }

    @Override
    public String toString() {
        return "pedidoProveedorConNombre{" + "codigoMaterial=" + codigoMaterial + ", nombre=" + nombre + ", cantidadSolicitada=" + cantidadSolicitada + ", precioActual=" + precioActual + ", subtotalPedidoProveedor=" + subtotalPedidoProveedor + '}';
    }
    
    
}

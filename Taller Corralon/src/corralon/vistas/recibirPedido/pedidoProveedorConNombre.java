
package corralon.vistas.recibirPedido;


class pedidoProveedorConNombre {
    private Long codigoMaterial;
    private String nombre;
    private Long cantidadSolicitada;
    private float precioActual;
    //private float subtotalPedidoProveedor;

    public pedidoProveedorConNombre(Long codigoMaterial, String nombre, Long cantidadSolicitada, float precioActual) {
        this.codigoMaterial = codigoMaterial;
        this.nombre = nombre;
        this.cantidadSolicitada = cantidadSolicitada;
        this.precioActual = precioActual;
    }

    public Long getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(Long codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "pedidoProveedorConNombre{" + "codigoMaterial=" + codigoMaterial + ", nombre=" + nombre + ", cantidadSolicitada=" + cantidadSolicitada + ", precioActual=" + precioActual + '}';
    }

    
}

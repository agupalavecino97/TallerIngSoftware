
package corralon.vistas.pedidoProveedor;

public class elementosDePedido {
    
    private Long codProducto;
    private String nombrePr;
    private float precio;
    private Object cantidad;

    public elementosDePedido(Long codProducto, String nombrePr, float precio, Object cantidad) {
        this.codProducto = codProducto;
        this.nombrePr = nombrePr;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Object getCantidad() {
        return cantidad;
    }

    public void setCantidad(Object cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "elementosDePedido{" + "codProducto=" + codProducto + ", nombrePr=" + nombrePr + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
}

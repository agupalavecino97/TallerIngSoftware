
package corralon.vistas.pedidoProveedor;

public class elementosDePedido {
    
    private Long codProducto;
    private String nombrePr;
    private float precio;
    private Long cantidad;

    public elementosDePedido(Long codProducto, String nombrePr, float precio, Long cantidad) {
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

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "elementosDePedido{" + "codProducto=" + codProducto + ", nombrePr=" + nombrePr + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
}

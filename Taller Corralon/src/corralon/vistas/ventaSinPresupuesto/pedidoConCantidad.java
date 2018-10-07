
package corralon.vistas.ventaSinPresupuesto;


public class pedidoConCantidad {
    
    private Long codMaterial;    
    private String nombreMaterial;
    private Object cantidad;
    private Long precio;

    public pedidoConCantidad(Long codMaterial, String nombreMaterial, Object cantidad, Long precio) {
        this.codMaterial = codMaterial;
        this.nombreMaterial = nombreMaterial;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public Object getCantidad() {
        return cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public void setCantidad(Object cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "pedidoConCantidad{" + "codMaterial=" + codMaterial + ", nombreMaterial=" + nombreMaterial + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

    
    
    }


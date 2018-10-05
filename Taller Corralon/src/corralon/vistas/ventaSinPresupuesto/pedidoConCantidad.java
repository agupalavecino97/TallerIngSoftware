
package corralon.vistas.ventaSinPresupuesto;


public class pedidoConCantidad {
    
    private Long codMaterial;    
    private String nombreMaterial;
    private Object cantidad;

    public pedidoConCantidad(Long codMaterial, String nombreMaterial, Object cantidad) {
        this.codMaterial = codMaterial;
        this.nombreMaterial = nombreMaterial;
        this.cantidad = cantidad;
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

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public void setCantidad(Object cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "pedidoConCantidad{" + "codMaterial=" + codMaterial + ", nombreMaterial=" + nombreMaterial + ", cantidad=" + cantidad + '}';
    }

    
    
    }


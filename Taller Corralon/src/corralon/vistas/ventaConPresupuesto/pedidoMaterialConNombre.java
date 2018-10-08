
package corralon.vistas.ventaConPresupuesto;

public class pedidoMaterialConNombre {
    private Long codMaterial;
    private Long cantidadMaterial;
    private Long subTotalMat;
    private String Nombre;
    private float Precio;

    public pedidoMaterialConNombre(Long codMaterial, Long cantidadMaterial, Long subTotalMat, String Nombre, float Precio) {
        this.codMaterial = codMaterial;
        this.cantidadMaterial = cantidadMaterial;
        this.subTotalMat = subTotalMat;
        this.Nombre = Nombre;
        this.Precio = Precio;
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public Long getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(Long cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public Long getSubTotalMat() {
        return subTotalMat;
    }

    public void setSubTotalMat(Long subTotalMat) {
        this.subTotalMat = subTotalMat;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        return "pedidoMaterialConNombre{" + "codMaterial=" + codMaterial + ", cantidadMaterial=" + cantidadMaterial + ", subTotalMat=" + subTotalMat + ", Nombre=" + Nombre + ", Precio=" + Precio + '}';
    }


}

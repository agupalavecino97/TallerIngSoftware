
package corralon.vistas.ventaConPresupuesto;

public class pedidoMaterialConNombre {
    private Long codMaterial;
    private Long cantidadMaterial;
    private Long subTotalMat;
    private String Nombre;
    private Long Precio;

    public pedidoMaterialConNombre(Long codMaterial, Long cantidadMaterial, Long subTotalMat, Long Precio, String Nombre) {
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

    public Long getPrecio() {
        return Precio;
    }

    public void setPrecio(Long Precio) {
        this.Precio = Precio;
    }

    @Override
    public String toString() {
        return "pedidoMaterialConNombre{" + "codMaterial=" + codMaterial + ", cantidadMaterial=" + cantidadMaterial + ", subTotalMat=" + subTotalMat + ", Nombre=" + Nombre + ", Precio=" + Precio + '}';
    }


}

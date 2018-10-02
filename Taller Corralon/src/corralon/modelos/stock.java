
package corralon.modelos;


public class stock {
    private Long codMaterial;    
    private String nombreMaterial;
    private Long precio;
    private String descripcionMaterial;
    private Long cantidadExistente;
    private Long stockMinimo;
    private Long stockMaximo;
    private boolean estadoMaterial;
    
    

    public stock(Long codMaterial, String nombreMaterial, Long precio, String descripcionMaterial, Long cantidadExistente, Long stockMinimo, Long stockMaximo, boolean estadoMaterial) {     
        this.codMaterial = codMaterial;
        this.nombreMaterial = nombreMaterial;
        this.precio = precio;
        this.descripcionMaterial = descripcionMaterial;
        this.cantidadExistente = cantidadExistente;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.estadoMaterial = estadoMaterial;
    }
    
    public stock() {
        this.codMaterial=null;
        this.nombreMaterial = "";
        this.precio = null;
        this.descripcionMaterial = "";
        this.cantidadExistente = null;
        this.stockMinimo = null;
        this.stockMaximo = null;    
    }

    public Long getCodMaterial() {
        return codMaterial;
    }
  
    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public Long getPrecio() {
        return precio;
    }

    public String getDescripcionMaterial() {
        return descripcionMaterial;
    }

    public Long getCantidadExistente() {
        return cantidadExistente;
    }

    public Long getStockMinimo() {
        return stockMinimo;
    }

    public Long getStockMaximo() {
        return stockMaximo;
    }

    public boolean isEstadoMaterial() {
        return estadoMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public void setDescripcionMaterial(String descripcionMaterial) {
        this.descripcionMaterial = descripcionMaterial;
    }

    public void setCantidadExistente(Long cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public void setStockMinimo(Long stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setStockMaximo(Long stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public void setEstadoMaterial(boolean estadoMaterial) {
        this.estadoMaterial = estadoMaterial;
    }

    @Override
    public String toString() {
        return "stock{" + "codMaterial=" + codMaterial + ", nombreMaterial=" + nombreMaterial + ", precio=" + precio + ", descripcionMaterial=" + descripcionMaterial + ", cantidadExistente=" + cantidadExistente + ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + '}';
    }

    
}

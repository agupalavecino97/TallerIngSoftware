
package corralon.modelos;


public class stock {
    private Long codMaterial;    
    private String nombreMaterial;
    private float precio;
    private String descripcionMaterial;
    private int cantidadExistente;
    private int stockMinimo;
    private int stockMaximo;
    private boolean estadoMaterial;

    public stock(Long codMaterial, String nombreMaterial, float precio, String descripcionMaterial, int cantidadExistente, int stockMinimo, int stockMaximo, boolean estadoMaterial) {     
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
        this.precio = 0;
        this.descripcionMaterial = "";
        this.cantidadExistente = 0;
        this.stockMinimo = 0;
        this.stockMaximo = 0;    
    }

    public Long getCodMaterial() {
        return codMaterial;
    }
  
    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public float getPrecio() {
        return precio;
    }

    public String getDescripcionMaterial() {
        return descripcionMaterial;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public int getStockMaximo() {
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

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setDescripcionMaterial(String descripcionMaterial) {
        this.descripcionMaterial = descripcionMaterial;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public void setStockMaximo(int stockMaximo) {
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

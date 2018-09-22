
package corralon.modelos;


public class stock {
    private Long codigoMaterial=null;    
    private String nombreMaterial;
    private String descripcionMaterial;
    private int cantidadExistente;
    private int stockMinimo;
    private int stockMaximo;
    private boolean estadoMaterial;

  
     public stock() {
        
        this.nombreMaterial = null;
        this.descripcionMaterial = null;
        this.cantidadExistente = 0;
        this.stockMinimo = 0;
        this.stockMaximo = 0;
        this.estadoMaterial = false;
    }

    public stock( String nombreMaterial, String descripcionMaterial, int cantidadExistente, int stockMinimo, int stockMaximo, boolean estadoMaterial) {
        
        this.nombreMaterial = nombreMaterial;
        this.descripcionMaterial = descripcionMaterial;
        this.cantidadExistente = cantidadExistente;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.estadoMaterial = estadoMaterial;
    }

    public Long getCodigoMaterial() {
        return codigoMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
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

    public void setCodigoMaterial(Long codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
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
        return "stock{" + "codigoMaterial=" + codigoMaterial + ", nombreMaterial=" + nombreMaterial + ", descripcionMaterial=" + descripcionMaterial + ", cantidadExistente=" + cantidadExistente + ", stockMinimo=" + stockMinimo + ", stockMaximo=" + stockMaximo + ", estadoMaterial=" + estadoMaterial + '}';
    }
    
    
}

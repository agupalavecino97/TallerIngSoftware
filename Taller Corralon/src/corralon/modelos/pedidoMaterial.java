
package corralon.modelos;

public class pedidoMaterial {
    
    private Long codigoPedidoClie;
    private Long  codMaterial;
    private Long cantidadMaterial;
    private Long subTotalMat;

    public pedidoMaterial(Long codigoPedidoClie, Long codMaterial, Long cantidadMaterial, Long subTotalMat) {
        this.codigoPedidoClie = codigoPedidoClie;
        this.codMaterial = codMaterial;
        this.cantidadMaterial = cantidadMaterial;
        this.subTotalMat = subTotalMat;
    }

    public Long getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public void setCodigoPedidoClie(Long codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
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

    @Override
    public String toString() {
        return "pedidoMaterial{" + "codigoPedidoClie=" + codigoPedidoClie + ", codMaterial=" + codMaterial + ", cantidadMaterial=" + cantidadMaterial + ", subTotalMat=" + subTotalMat + '}';
    }

    
}

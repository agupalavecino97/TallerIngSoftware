
package corralon.modelos;

public class pedidoMaterial {
    
    private Long codigoPedidoClie;
    private int codigoPedidoMaterial;
    private int cantidadMaterial;
    private float subTotalMat;

    public pedidoMaterial(Long codigoPedidoClie, int codigoPedidoMaterial, int cantidadMaterial, float subTotalMat) {
        this.codigoPedidoClie = codigoPedidoClie;
        this.codigoPedidoMaterial = codigoPedidoMaterial;
        this.cantidadMaterial = cantidadMaterial;
        this.subTotalMat = subTotalMat;
    }

    public Long getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public void setCodigoPedidoClie(Long codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
    }

    public int getCodigoPedidoMaterial() {
        return codigoPedidoMaterial;
    }

    public void setCodigoPedidoMaterial(int codigoPedidoMaterial) {
        this.codigoPedidoMaterial = codigoPedidoMaterial;
    }

    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public float getSubTotalMat() {
        return subTotalMat;
    }

    public void setSubTotalMat(float subTotalMat) {
        this.subTotalMat = subTotalMat;
    }

    @Override
    public String toString() {
        return "pedidoMaterial{" + "codigoPedidoClie=" + codigoPedidoClie + ", codigoPedidoMaterial=" + codigoPedidoMaterial + ", cantidadMaterial=" + cantidadMaterial + ", subTotalMat=" + subTotalMat + '}';
    }
    
}

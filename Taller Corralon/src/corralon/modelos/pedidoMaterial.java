
package corralon.modelos;

public class pedidoMaterial {
    
    private Long codigoPedidoClie;
    //private int codigoPedidoMaterial;   //AQUI este atributo no tendria que existir. LO SACO.
    private int cantidadMaterial;
    private float subTotalMat;

    public pedidoMaterial(Long codigoPedidoClie, int cantidadMaterial, float subTotalMat) {
        this.codigoPedidoClie = codigoPedidoClie;
        this.cantidadMaterial = cantidadMaterial;
        this.subTotalMat = subTotalMat;
    }

    public Long getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public int getCantidadMaterial() {
        return cantidadMaterial;
    }

    public float getSubTotalMat() {
        return subTotalMat;
    }

    public void setCodigoPedidoClie(Long codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
    }

    public void setCantidadMaterial(int cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }

    public void setSubTotalMat(float subTotalMat) {
        this.subTotalMat = subTotalMat;
    }

    
}

package corralon.modelos;

import java.sql.Date;


public class catalogo{
    private Long cuitProveedor;
    private int codProductoCatalogo;
    private float precioUnitario;
    private String fechaVigencia;   

    public catalogo(Long cuitProveedor, int codProductoCatalogo, float precioUnitario, String fechaVigencia) {
        this.cuitProveedor = cuitProveedor;
        this.codProductoCatalogo = codProductoCatalogo;
        this.precioUnitario = precioUnitario;
        this.fechaVigencia = fechaVigencia;
    }

    public Long getCuitProveedor() {
        return cuitProveedor;
    }

    public int getCodProductoCatalogo() {
        return codProductoCatalogo;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setCuitProveedor(Long cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void setCodProductoCatalogo(int codProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    @Override
    public String toString() {
        return "catalogo{" + "cuitProveedor=" + cuitProveedor + ", codProductoCatalogo=" + codProductoCatalogo + ", descripcionProdCat=" + ", precioUnitario=" + precioUnitario + '}';
    }
    
    
    
    
}

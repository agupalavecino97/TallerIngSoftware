package corralon.modelos;

import java.sql.Date;


public class catalogo{
    private Long cuitProveedor;
    private Long codProductoCatalogo;
    private float precioUnitario;
    private Date fechaVigencia;   

    public catalogo(Long cuitProveedor, Long codProductoCatalogo, float precioUnitario, Date fechaVigencia) {
        this.cuitProveedor = cuitProveedor;
        this.codProductoCatalogo = codProductoCatalogo;
        this.precioUnitario = precioUnitario;
        this.fechaVigencia = fechaVigencia;
    }
    
        public catalogo() {
        this.cuitProveedor = null;
        this.codProductoCatalogo = null;
        this.precioUnitario = 0;
        this.fechaVigencia = null;
    }

    public Long getCuitProveedor() {
        return cuitProveedor;
    }

    public Long getCodProductoCatalogo() {
        return codProductoCatalogo;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setCuitProveedor(Long cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void setCodProductoCatalogo(Long codProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    @Override
    public String toString() {
        return "catalogo{" + "cuitProveedor=" + cuitProveedor + ", codProductoCatalogo=" + codProductoCatalogo + "Fecha vigencia=" + fechaVigencia +  "precioUnitario=" + precioUnitario + '}';
    }
    
    
    
    
}

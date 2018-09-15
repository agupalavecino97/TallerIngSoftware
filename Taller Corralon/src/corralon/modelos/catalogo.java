package corralon.modelos;

import java.sql.Date;


public class catalogo{
    private int cuitProveedor;
    private int codProductoCatalogo;
    private float precioUnitario;
    private Date fechaVigencia;   

    public catalogo(int cuitProveedor, int codProductoCatalogo, float precioUnitario, Date fechaVigencia) {
        this.cuitProveedor = cuitProveedor;
        this.codProductoCatalogo = codProductoCatalogo;
        this.precioUnitario = precioUnitario;
        this.fechaVigencia = fechaVigencia;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public int getCodProductoCatalogo() {
        return codProductoCatalogo;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void setCodProductoCatalogo(int codProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }
    
}

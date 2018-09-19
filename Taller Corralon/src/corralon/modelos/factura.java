package corralon.modelos;

import java.sql.Date;

public class factura {
 
    private int codigoFactura;
    private Date fechaFactura;
    private int codigoPedidoClie;
    private int estadoFactura;

    public factura(int codigoFactura, Date fechaFactura, int codigoPedidoClie, int estadoFactura) {
        this.codigoFactura = codigoFactura;
        this.fechaFactura = fechaFactura;
        this.codigoPedidoClie = codigoPedidoClie;
        this.estadoFactura = estadoFactura;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public void setCodigoPedidoClie(int codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
    }

    public int getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(int estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    @Override
    public String toString() {
        return "factura{" + "codigoFactura=" + codigoFactura + ", fechaFactura=" + fechaFactura + ", codigoPedidoClie=" + codigoPedidoClie + ", estadoFactura=" + estadoFactura + '}';
    }
    
}

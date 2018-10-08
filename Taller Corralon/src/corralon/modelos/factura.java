package corralon.modelos;

import java.sql.Date;

public class factura {
 
    private Long codigoFactura;
    private Date fechaFactura;
    private Long codigoPedidoClie;
    private String estadoFactura;

    public factura(Date fechaFactura, Long codigoPedidoClie, String estadoFactura) {
        this.fechaFactura = fechaFactura;
        this.codigoPedidoClie = codigoPedidoClie;
        this.estadoFactura = estadoFactura;
    }

   

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Long getCodigoPedidoClie() {
        return codigoPedidoClie;
    }

    public void setCodigoPedidoClie(Long codigoPedidoClie) {
        this.codigoPedidoClie = codigoPedidoClie;
    }

    public String getEstadoFactura() {
        return estadoFactura;
    }

    public void setEstadoFactura(String estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    @Override
    public String toString() {
        return "factura{" + "codigoFactura=" + codigoFactura + ", fechaFactura=" + fechaFactura + ", codigoPedidoClie=" + codigoPedidoClie + ", estadoFactura=" + estadoFactura + '}';
    }

    
}

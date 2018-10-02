
package corralon.modelos;

public class proveedor {
    private Long cuitProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private int telefonoProveedor;
    private boolean estadoProveedor;

    public proveedor(Long cuitProveedor, String nombreProveedor, String direccionProveedor, int telefonoProveedor, boolean estadoProveedor) {
        this.cuitProveedor = cuitProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.estadoProveedor = estadoProveedor;
    }

    public proveedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Long getCuitProveedor() {
        return cuitProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public int getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public boolean isEstadoProveedor() {
        return estadoProveedor;
    }

    public void setCuitProveedor(Long cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public void setTelefonoProveedor(int telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public void setEstadoProveedor(boolean estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    @Override
    public String toString() {
        return "proveedor{" + "cuitProveedor=" + cuitProveedor + ", nombreProveedor=" + nombreProveedor + ", direccionProveedor=" + direccionProveedor + ", telefonoProveedor=" + telefonoProveedor + ", estadoProveedor=" + estadoProveedor + '}';
    }   
}


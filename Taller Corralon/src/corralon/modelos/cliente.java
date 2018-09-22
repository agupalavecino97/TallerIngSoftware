package corralon.modelos;


public class cliente {
    
    private Long cuitCliente;
    private String razonSocial;
    private String direccionCliente;
    private int telefonoCliente;
    private boolean estadoClie;
    
    public cliente(){
        this.direccionCliente="";
        this.direccionCliente="";
        this.telefonoCliente=0;  
    }

    public cliente(Long cuitCliente,String razonSocial, String direccionCliente, int telefonoCliente, boolean estadoClie) {
        this.cuitCliente=cuitCliente;
        this.razonSocial = razonSocial;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.estadoClie = estadoClie;
    }

    public Long getCuitCliente() {
        return cuitCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public boolean isEstadoClie() {
        return estadoClie;
    }

    public void setCuitCliente(Long cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setEstadoClie(boolean estadoClie) {
        this.estadoClie = estadoClie;
    }

    @Override
    public String toString() {
        return "cliente{" + "cuitCliente=" + cuitCliente + ", razonSocial=" + razonSocial + ", direccionCliente=" + direccionCliente + ", telefonoCliente=" + telefonoCliente + ", estadoClie=" + estadoClie + '}';
    }

    
    
    
}

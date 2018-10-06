
package corralon.modelos;

public class productoCatalogo{
      private Long codProductoCatalogo;
      private String nombreProductoCatalogo;
      private String descripcionProductoCatalogo;
      private String tipoProductoCatalogo;

    public productoCatalogo(Long codProductoCatalogo, String nombreProcudcoCatalogo, String descripcionPorductoCatalogo, String tipoProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
        this.nombreProductoCatalogo = nombreProcudcoCatalogo;
        this.descripcionProductoCatalogo = descripcionPorductoCatalogo;
        this.tipoProductoCatalogo = tipoProductoCatalogo;
    }

    public Long getCodProductoCatalogo() {
        return codProductoCatalogo;
    }

    public String getNombreProductoCatalogo() {
        return nombreProductoCatalogo;
    }

    public String getDescripcionProductoCatalogo() {
        return descripcionProductoCatalogo;
    }

    public String getTipoProductoCatalogo() {
        return tipoProductoCatalogo;
    }

    public void setCodProductoCatalogo(Long codProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
    }

    public void setNombreProductoCatalogo(String nombreProductoCatalogo) {
        this.nombreProductoCatalogo = nombreProductoCatalogo;
    }

    public void setDescripcionProductoCatalogo(String descripcionProductoCatalogo) {
        this.descripcionProductoCatalogo = descripcionProductoCatalogo;
    }

    public void setTipoProductoCatalogo(String tipoProductoCatalogo) {
        this.tipoProductoCatalogo = tipoProductoCatalogo;
    }

    @Override
    public String toString() {
        return "productoCatalogo{" + "codProductoCatalogo=" + codProductoCatalogo + ", nombreProcudcoCatalogo=" + nombreProductoCatalogo + ", descripcionPorductoCatalogo=" + descripcionProductoCatalogo + ", tipoProductoCatalogo=" + tipoProductoCatalogo + '}';
    }
    
    
    
}


package corralon.modelos;

class productoCatalogo{
      private int codProductoCatalogo;
      private String nombreProcudcoCatalogo;
      private String descripcionPorductoCatalogo;
      private String tipoProductoCatalogo;

    public productoCatalogo(int codProductoCatalogo, String nombreProcudcoCatalogo, String descripcionPorductoCatalogo, String tipoProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
        this.nombreProcudcoCatalogo = nombreProcudcoCatalogo;
        this.descripcionPorductoCatalogo = descripcionPorductoCatalogo;
        this.tipoProductoCatalogo = tipoProductoCatalogo;
    }

    public int getCodProductoCatalogo() {
        return codProductoCatalogo;
    }

    public String getNombreProcudcoCatalogo() {
        return nombreProcudcoCatalogo;
    }

    public String getDescripcionPorductoCatalogo() {
        return descripcionPorductoCatalogo;
    }

    public String getTipoProductoCatalogo() {
        return tipoProductoCatalogo;
    }

    public void setCodProductoCatalogo(int codProductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
    }

    public void setNombreProcudcoCatalogo(String nombreProcudcoCatalogo) {
        this.nombreProcudcoCatalogo = nombreProcudcoCatalogo;
    }

    public void setDescripcionPorductoCatalogo(String descripcionPorductoCatalogo) {
        this.descripcionPorductoCatalogo = descripcionPorductoCatalogo;
    }

    public void setTipoProductoCatalogo(String tipoProductoCatalogo) {
        this.tipoProductoCatalogo = tipoProductoCatalogo;
    }

    @Override
    public String toString() {
        return "productoCatalogo{" + "codProductoCatalogo=" + codProductoCatalogo + ", nombreProcudcoCatalogo=" + nombreProcudcoCatalogo + ", descripcionPorductoCatalogo=" + descripcionPorductoCatalogo + ", tipoProductoCatalogo=" + tipoProductoCatalogo + '}';
    }
    
    
    
}


package corralon.modelos;

public class productoCatalogo{
      private Long codProductoCatalogo;
      private String nombreProductoCatalogo;
      private String descripcionProductoCatalogo;


    public productoCatalogo(Long codProductoCatalogo, String nombreProcudcoCatalogo, String descripcionPorductoCatalogo) {
        this.codProductoCatalogo = codProductoCatalogo;
        this.nombreProductoCatalogo = nombreProcudcoCatalogo;
        this.descripcionProductoCatalogo = descripcionPorductoCatalogo;

    }
//    
//    
//     public productoCatalogo(){
//        this.codProductoCatalogo = null;
//        this.nombreProductoCatalogo = "";
//        this.descripcionProductoCatalogo = "";
//     }

    public Long getCodProductoCatalogo() {
        return codProductoCatalogo;
    }

    public String getNombreProductoCatalogo() {
        return nombreProductoCatalogo;
    }

    public String getDescripcionProductoCatalogo() {
        return descripcionProductoCatalogo;
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



    @Override
    public String toString() {
        return "productoCatalogo{" + "codProductoCatalogo=" + codProductoCatalogo + ", nombreProcudcoCatalogo=" + nombreProductoCatalogo + ", descripcionPorductoCatalogo=" + descripcionProductoCatalogo +  '}';
    }
    
    
    
}

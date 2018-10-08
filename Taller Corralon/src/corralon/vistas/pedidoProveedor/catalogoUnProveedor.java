/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corralon.vistas.pedidoProveedor;

public class catalogoUnProveedor {
    private Long codProducto;
    private String nombrePr;
    private float precio;
    

    public catalogoUnProveedor(Long codProducto, String nombrePr, float precio) {
        this.codProducto = codProducto;
        this.nombrePr = nombrePr;
        this.precio = precio;
    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombrePr() {
        return nombrePr;
    }

    public void setNombrePr(String nombrePr) {
        this.nombrePr = nombrePr;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "catalogoUnProveedor{" + "codProducto=" + codProducto + ", nombrePr=" + nombrePr + ", precio=" + precio + '}';
    }

    
    
    
    
    
}


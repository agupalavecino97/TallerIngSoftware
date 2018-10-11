
package corralon.modelos;

import java.util.Objects;

public class empleado {
    private Long id;
    private String contraseña;
    private String nombre;
    private String apellido;
    private Long telefono;
    private int Prioridad;

    public empleado(Long id, String contraseña, String nombre, String apellido, Long telefono, int Prioridad) {
        this.id = id;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.Prioridad = Prioridad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(int Prioridad) {
        this.Prioridad = Prioridad;
    }

    @Override
    public String toString() {
        return "empleado{" + "id=" + id + ", contrase\u00f1a=" + contraseña + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", Prioridad=" + Prioridad + '}';
    }

    
    
}

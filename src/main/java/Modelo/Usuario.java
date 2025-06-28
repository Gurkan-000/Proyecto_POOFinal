
package Modelo;
/**
 *
 * @author RODRIGO
 */
public class Usuario {
    private String usuario;
    private String contraseña;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros (opcional, útil)
    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}

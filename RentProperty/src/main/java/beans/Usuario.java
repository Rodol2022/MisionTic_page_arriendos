
package beans;


public class Usuario {
    
    private int idUsuario;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private String ciudad;

    public Usuario(int idUsuario, String usuario, String contrasena, String nombre, String apellido, int telefono, String email, String ciudad) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuario=" + usuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", ciudad=" + ciudad + '}';
    }

    
}

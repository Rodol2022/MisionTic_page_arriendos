
package controller;

import java.util.Map;

public interface IUsuarioController {
    
    public String login(String usuario, String contrasena);
    
    public String register(int idUsuario, String usuario, String contrasena, String nombre, String apellido, int telefono, String email,  String ciudad);
    
    public String pedir(String usuario);
    
  
    
    
    
}

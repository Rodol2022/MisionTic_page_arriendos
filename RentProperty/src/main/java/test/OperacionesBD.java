
package test;

import beans.Usuario;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {
    
    public static void main(String[] args) {
        listarUsuario();
    }
    
    
    
    public static void actualizarUsuario(int idUsuario, String username){
        
        DBConnection con = new DBConnection();
        String sql = "UPDATE usuario SET username = '" + username + "' WHERE idUsuario = " + idUsuario;
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
    public static void listarUsuario(){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM usuario";
        
        try {
            Statement st = con.getConnection().createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               int idUsuario = rs.getInt("id_usuario");
               String usuario = rs.getString("usuario");
               String contrasena = rs.getString("contrasena");
               String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellido");
               int telefono = rs.getInt("telefono");
               String email = rs.getString("email");
               String ciudad = rs.getString("ciudad");
               Usuario user = new Usuario(idUsuario, usuario, contrasena, nombre, apellido, telefono, email, ciudad);
               System.out.println(user.toString());   
           }
           st.executeQuery(sql);
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
}

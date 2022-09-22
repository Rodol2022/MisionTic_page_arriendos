
package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import beans.Usuario;
import connection.DBConnection;

public class UsuarioController implements IUsuarioController{
    
    @Override
    public String login(String usuario, String contrasena){
        
        Gson gson = new Gson();
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM Usuario WHERE usuario ='"+ usuario
                + "' and contrasena = '" + contrasena + "'";
        
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int telefono = rs.getInt("telefono");
                String email = rs.getString("email");
                String ciudad = rs.getString("ciudad");
               
                Usuario user = new Usuario(idUsuario, usuario, contrasena, nombre, apellido, telefono, email, ciudad);
                return gson.toJson(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
        
        return "false";
    }
    
    @Override
    public String register(int idUsuario, String usuario, String contrasena, String nombre, String apellido, int telefono, String email,  String ciudad){
        
        Gson gson = new Gson();
        
        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values(" + idUsuario + ", '" + usuario + "', '" + contrasena + "', '" + nombre
                + "', '" + apellido + "'," + telefono + ", '" + email + "',  '" + ciudad + "')";
        
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
            
            Usuario user = new Usuario(idUsuario, usuario, contrasena, nombre, apellido, telefono, email, ciudad);
            
            st.close();
            
            return gson.toJson(user);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
            con.desconectar();
        }
        
        return "false";
    }
    
    @Override
    public String pedir(String usuario) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where usuario = '" + usuario + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int telefono = rs.getInt("telefono");
                String email = rs.getString("email");
                String ciudad = rs.getString("ciudad");

                Usuario user = new Usuario(idUsuario, usuario, contrasena, nombre, apellido, telefono, email, ciudad);

                return gson.toJson(user);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    
}

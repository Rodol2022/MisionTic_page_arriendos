
package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;


@WebServlet("/ServletUsuarioRegister")
public class ServletUsuarioRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ServletUsuarioRegister(){
        super();
    }  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        UsuarioController user = new UsuarioController();
        
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String email = request.getParameter("email");
        String ciudad = request.getParameter("ciudad");
        
        String result = user.register(idUsuario, usuario, contrasena, nombre, apellido, telefono, email, ciudad);
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    

}

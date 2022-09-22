
package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

@WebServlet("/ServletUsuarioLogin")


public class ServletUsuarioLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public ServletUsuarioLogin(){
        super();
    }

   
       
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioController user = new UsuarioController();
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String result = user.login(usuario, contrasena);
        
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

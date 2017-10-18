package Controlador;

import DAO.DaoUsuario;
import Modelo.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class changePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                ArrayList<String> a = new ArrayList<>();
                String usuario = (String) session.getAttribute("user");
                String oldClave = (String) session.getAttribute("pass");
                String newClave = request.getParameter("valor3");
                String Clave = request.getParameter("valor1");
                boolean change = false;
                DaoUsuario daoU = new DaoUsuario();
                if (oldClave.equals(Clave)) {
                    change = daoU.modificarClave(usuario, newClave);
                    System.out.println(change);
                    a.add(usuario);
                    a.add(newClave);                    
                    String json = new Gson().toJson(a);
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                } else {
                    response.setContentType("application/json");
                    response.getWriter().write("fail");
                }

            } else {
                response.getWriter().write("false");
            }

        } catch (SQLException | URISyntaxException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

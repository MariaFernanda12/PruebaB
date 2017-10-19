package Controlador;

import DAO.DaoUsuario;
import Modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

public class Sesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String usuario = (String) session.getAttribute("user");
                String password = (String) session.getAttribute("pass");
                Usuario user;
                DaoUsuario daoU = new DaoUsuario();
                user = daoU.validarUsuario(usuario, password);
                String json = new Gson().toJson(user);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } else {
                response.getWriter().write("false");
            }

        } catch (SQLException | URISyntaxException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

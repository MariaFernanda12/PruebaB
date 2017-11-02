package Controlador;

import DAO.DaoUsuario;
import Modelo.Usuario;
import Util.conexion;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@MultipartConfig(maxFileSize = 169999999)
public class uploadServlet extends HttpServlet {

    private Connection Conexion;

    public uploadServlet() throws URISyntaxException {

        this.Conexion = conexion.getConnection();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String newRuta1 = request.getParameter("valor1");
        String ruta = newRuta1.substring(1, newRuta1.length() - 3);
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String usuario = (String) session.getAttribute("user");
                boolean res = true;
                DaoUsuario daoU = new DaoUsuario();
                res = daoU.modificarImagen(usuario, ruta);
                String json = new Gson().toJson(res);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } else {
                response.getWriter().write("false");
            }

        } catch (URISyntaxException ex) {
            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(uploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

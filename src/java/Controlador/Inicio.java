package Controlador;

import DAO.DaoUsuario;
import Modelo.usuarios;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

public class Inicio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identificador = request.getParameter("valor1");
        String clave = request.getParameter("valor2");
        try {
            usuarios user;
            DaoUsuario daoU = new DaoUsuario();
            user = daoU.validarUsuario(identificador, clave).get(0);
            if (identificador.equals(user.getIdentificador())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", identificador);
                session.setAttribute("pass", clave);
            }
            String json = new Gson().toJson(user);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

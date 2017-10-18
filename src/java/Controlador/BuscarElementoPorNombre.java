package Controlador;

import DAO.DaoElementos;
import Modelo.Elemento;
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
import com.google.gson.Gson;


public class BuscarElementoPorNombre extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("Busqueda");

        DaoElementos dao;
        try {

            dao = new DaoElementos();
            ArrayList<Elemento> c = new ArrayList<Elemento>();
            c = dao.listarTodo();
            String json = new Gson().toJson(c);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(json);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package Controlador;

import DAO.DaoElementos;
import Modelo.inventario;
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
        DaoElementos dao;
        try {

            dao = new DaoElementos();
            ArrayList<inventario> c = new ArrayList<inventario>();
            c = dao.listarTodo();
            for (int i = 0; i < c.size(); i++) {
                System.out.println(c.get(i)+"¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
            }
            String json = new Gson().toJson(c);
            response.setContentType("application/json;");
            response.getWriter().write(json);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarElementoPorNombre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package Controlador;

import Modelo.inventario;
import TX.SQLgen;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;

public class ElementosPorArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<inventario> lista = null;
            SQLgen sql = new SQLgen();
            lista = sql.cantidadElementosPorArea();
            String a = "";
//            for (inventario model : lista) {
                a = "{\n"
                        + " label: 'Español',\n"
                        + " backgroundColor: \"rgba(151,187,205,0.5)\",\n"
                        + " data: [50]\n"
                        + " }\n"
                        + " \n";
//            }            
            String json = new Gson().toJson(a);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

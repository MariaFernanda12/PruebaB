package Controlador;


import DAO.DaoReservas;
import Modelo.reserva;
import TX.SQLreserva;
import java.io.IOException;
import java.util.ArrayList;
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

public class ListarReservas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            try {
                String usuario = (String) session.getAttribute("user");
                ArrayList<reserva> lista = null;
                DaoReservas daoR = new DaoReservas();
                lista = daoR.listarTodo();
                String json = new Gson().toJson(lista);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } catch (URISyntaxException ex) {
                Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ListarReservas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

package Controlador;

import DAO.DaoReservas;
import Modelo.Elemento;
import Modelo.ReservasM;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Reservas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession(false);
            String usuario = (String) session.getAttribute("user");
            java.util.Date utilDate = new java.util.Date();
            long lnMilisegundos = utilDate.getTime();

            String idElm = request.getParameter("idElm");
            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            String fechaRes = request.getParameter("fechaRes");
            String cantidad = request.getParameter("cantidad");
            String estado = "Pendiente";

            DaoReservas daoR = new DaoReservas();
            ReservasM reserva = new ReservasM();
            reserva.setEtiquetaInv(Integer.parseInt(idElm));
            reserva.setCantidadRes(Integer.parseInt(cantidad));
            reserva.setFechaRes(fechaRes);
            reserva.setFechaActual(sqlDate.toString());
            reserva.setEstado(estado);
            reserva.setIdentificadorsol(usuario);
            boolean respuesta = false;
            respuesta = daoR.insertar(reserva);
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String valor = request.getParameter("identificador");
            Elemento elm = new Elemento();
            DaoReservas daoR = new DaoReservas();
            elm = daoR.buscar(Integer.valueOf(valor));
            String json = new Gson().toJson(elm);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package Controlador;

import DAO.DaoPrestamos;
import Modelo.prestamo;
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

public class NewPrestamo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            java.util.Date utilDate = new java.util.Date();
            long lnMilisegundos = utilDate.getTime();
          

            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            String idsol = request.getParameter("idSol");
            String idlibro = request.getParameter("idElm");
            String cantidad = request.getParameter("cantidad");
            String fechadev = request.getParameter("fechaRes");

            DaoPrestamos pretamos = new DaoPrestamos();
            prestamo prestamo = new prestamo();
            prestamo.setEtiquetaInv(idlibro);
            prestamo.setCantidadPrestamo(cantidad);
            prestamo.setFechaDev(fechadev);
            prestamo.setFechaActual(sqlDate.toString());
            prestamo.setEstado("prestado");
            prestamo.setIdentificadorSol(idsol);
            boolean respuesta = false;
            respuesta = pretamos.insertar(prestamo);
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

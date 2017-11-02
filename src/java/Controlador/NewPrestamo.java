package Controlador;

import DAO.DaoPrestamos;
import DAO.DaoReservas;
import Modelo.Elemento;
import Modelo.PrestamoM;
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

public class NewPrestamo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            
            java.util.Date utilDate = new java.util.Date();
            long lnMilisegundos = utilDate.getTime();

            
            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            int idsol = Integer.valueOf(request.getParameter("campoSol"));
            int idlibro = Integer.valueOf(request.getParameter("element"));
            int  cantidad = Integer.valueOf(request.getParameter("campo1"));
            String fechadev=request.getParameter("campo2");
            
            
            DaoPrestamos pretamos=new DaoPrestamos();           
            PrestamoM reserva = new PrestamoM();
            reserva.setEtiquetaInv(idlibro);
            reserva.setCantidadPrestamo(cantidad);
            reserva.setFechaDev(fechadev);
            reserva.setFechaActual(sqlDate.toString());
            reserva.setEstado("prestado");
            reserva.setIdentificadorsol(idsol);
            boolean respuesta = false;
            respuesta = pretamos.insertar(reserva);
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
       
    }

}

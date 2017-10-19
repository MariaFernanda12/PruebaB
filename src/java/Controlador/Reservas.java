package Controlador;

import DAO.DaoReservas;
import Modelo.Elemento;
import Modelo.ReservasM;
import com.google.gson.Gson;
import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
public class Reservas extends HttpServlet {
    
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        try {
             Date fecha = new Date(System.currentTimeMillis());
//             System.out.println(fecha.getDate()+"/"+fecha.getMonth()+"/"+2017);
            int IndentificadorInv = Integer.valueOf(request.getParameter("identificador"));
            int idenDelSolici = Integer.valueOf(request.getParameter("ident2"));
            int cantidad =Integer.valueOf(request.getParameter("campo1"));
            String fechaSolicitada = request.getParameter("campo2");
            String FechaActual=fecha.getDate()+"/"+fecha.getMonth()+"/"+2017;
            
            DaoReservas daoR = new DaoReservas();
           ReservasM res=new ReservasM( IndentificadorInv,idenDelSolici, fechaSolicitada, FechaActual,cantidad,"Reservado");
           daoR.insertar(res);
           
            
            

        } catch (URISyntaxException | SQLException ex) {
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

        } catch (URISyntaxException | SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

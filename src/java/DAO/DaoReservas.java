package DAO;

import Modelo.reserva;
import TX.SQLgen;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoReservas {
    

     SQLgen<reserva> a;

    public DaoReservas() throws URISyntaxException, SQLException {
        a = new SQLgen<reserva>();
    }   
    
 
    public ArrayList<reserva> listarTodo() {
        ArrayList<reserva> respuesta = new ArrayList();
        reserva res = new reserva();
        respuesta = a.listarTodo(res);
        return respuesta;
    }
    
  
    
}

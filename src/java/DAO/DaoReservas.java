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
    
    public boolean insertar(reserva p) throws IllegalArgumentException, IllegalAccessException {
        boolean respuesta = false;
        respuesta = a.insertar(p);
        return respuesta;
    }
 
    public ArrayList<reserva> listarTodo() {
        ArrayList<reserva> respuesta = new ArrayList();
        reserva res = new reserva();
        respuesta = a.Select4(res);
        return respuesta;
    }
    
  
    
}

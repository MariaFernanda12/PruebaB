package DAO;

import Modelo.inventario;
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
    
   
    
  
    
}

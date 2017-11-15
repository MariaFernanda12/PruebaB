package DAO;

import Modelo.prestamo;
import TX.SQLgen;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;



public class DaoPrestamos {  
    
    SQLgen<prestamo> a;

    public DaoPrestamos() throws URISyntaxException, SQLException {
        a = new SQLgen<prestamo>();
    }   
    
 
    public ArrayList<prestamo> listarTodo() {
        ArrayList<prestamo> respuesta = new ArrayList();
        prestamo inv = new prestamo();
        respuesta = a.listarTodo(inv);
        return respuesta;
    }
    
}

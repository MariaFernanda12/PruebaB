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
    
    public boolean insertar(prestamo p) throws IllegalArgumentException, IllegalAccessException {
        boolean respuesta = false;
        respuesta = a.insertar(p);
        return respuesta;
    }
 
    public ArrayList<prestamo> listarTodo() {
        ArrayList<prestamo> respuesta = new ArrayList();
        prestamo inv = new prestamo();
        respuesta = a.listarTodo(inv);
        return respuesta;
    }
    
    
    
}

package DAO;

import Modelo.inventario;
import TX.SQLgen;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;



public class DaoElementos {
    
    SQLgen<inventario> a;

    public DaoElementos() throws URISyntaxException, SQLException {
        a = new SQLgen<inventario>();
    }   
    
    
    public ArrayList<inventario> listarPorArea(String area) throws InvocationTargetException, NoSuchMethodException, InstantiationException {
        ArrayList<inventario> respuesta = new ArrayList();
        inventario inv = new inventario(null, null, null, null, null, null, area, null);
        respuesta = a.Select(inv);
        return respuesta;
    }
    
    public ArrayList<inventario> listarTodo() {
        ArrayList<inventario> respuesta = new ArrayList();
        inventario inv = new inventario();
        respuesta = a.Select4(inv);
        return respuesta;
    }
     
    public ArrayList<inventario> buscar(String et) throws InvocationTargetException, InstantiationException, NoSuchMethodException {
        ArrayList<inventario> respuesta = new ArrayList();
        inventario inv1 = new inventario(et, null, null, null, null, null, null, null);
        respuesta = a.Select(inv1);
        return respuesta;
    }
    
    public boolean borrar(String et){
        boolean respuesta = false;
        inventario inv1 = new inventario(et, null, null, null, null, null, null, null);
        respuesta = a.borrar(inv1);
        return respuesta;
    }
    
    
}

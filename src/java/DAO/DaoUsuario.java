package DAO;

import Modelo.usuarios;
import TX.SQLgen;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoUsuario {

    SQLgen<usuarios> a;

    public DaoUsuario() throws URISyntaxException, SQLException {
        a = new SQLgen<usuarios>();
    }

    public ArrayList<usuarios> validarUsuario(String id, String clave) throws InstantiationException, NoSuchMethodException, InvocationTargetException {
        ArrayList<usuarios> respuesta = new ArrayList();
        usuarios user = new usuarios(id, null, null, null, null, clave, null, null, null);
        respuesta = a.Select2(user);
        if (respuesta.isEmpty()) {
            user = new usuarios();
            respuesta.add(user);
        }
        return respuesta;
    }

    public boolean validarRegistro(String id, String clave, String colegio, String correo) {
        boolean respuesta = false;
        usuarios user = new usuarios(id, null, null, null, colegio, null, null, null, "null");
        respuesta = a.Select3(user);
        if (respuesta == true) {
            modificarClave(id, clave, correo);
        }
        return respuesta;
    }

    public boolean modificarClave(String id, String clave, String correo) {
        boolean respuesta = false;
        usuarios user = new usuarios(id, null, null, null, null, clave, null, correo, null);
        respuesta = a.update(user);
        return respuesta;
    }
    public boolean modificarClave2(String id, String clave) {
        boolean respuesta = false;
        usuarios user = new usuarios(id, null, null, null, null, clave, null, null, null);
        respuesta = a.update(user);
        return respuesta;
    }
    public boolean modificarEstado(String id) {
        boolean respuesta = false;
        usuarios user = new usuarios(id, null, null, null, null, null, null, null, "true");
        respuesta = a.update(user);
        return respuesta;
    }
    public boolean modificarImagen(String id, String ruta) {
        boolean respuesta = false;
        usuarios user = new usuarios(id, null, null, null, null, null, ruta, null, null);
        respuesta = a.update(user);
        return respuesta;
    }

}

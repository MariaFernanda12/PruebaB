package DAO;

import Modelo.usuarios;
import TX.SQLgen;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoUsuario {

    SQLgen<usuarios> a;

    public DaoUsuario() throws URISyntaxException, SQLException {
        a = new SQLgen<usuarios>();
    }

    public ArrayList<usuarios> validarUsuario(String id, String clave) {
        ArrayList<usuarios> respuesta = new ArrayList();
        usuarios user = new usuarios(id, null, null, null, null, clave, null, null, null);
        respuesta = a.Select2(user);
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

}

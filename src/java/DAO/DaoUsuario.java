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
    public ArrayList<Boolean> validarRegistro(String id, String clave, String colegio) {
        ArrayList<Boolean> respuesta = new ArrayList();
        usuarios user = new usuarios(id, null, null, null, colegio, clave, null, null, "null");
        respuesta = a.Select3(user);
        return respuesta;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TX;

import DAO.DaoElementos;
import Modelo.usuarios;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labin
 */
public class SQLusuarios {
    private Connection conexion;

    public SQLusuarios() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public ArrayList validarRegistro(String usuario, String clave, String colegio, String correo) {
        ArrayList<Boolean> arr1 = new ArrayList<Boolean>();
        boolean res = false;
        boolean res2 = false;
        try {
            String consulta = "select * from usuarios where identificador=? and colegio=? and clave='null'";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            statement.setString(1, usuario);
            statement.setString(2, colegio);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                res = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (res == true) {
            res2 = modificarClave(usuario, clave, correo);
        }
        arr1.add(res);
        return arr1;

    }

    public boolean modificarClave(String usuario, String clave, String correo) {
        boolean resultado = false;

        try {
            String consulta = "update usuarios set clave=?, correo=? where identificador=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setString(1, clave);
            statement.setString(2, correo);
            statement.setString(3, usuario);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }
    public boolean modificarClave2(String usuario, String clave) {
        boolean resultado = false;

        try {
            String consulta = "update usuarios set clave=? where identificador=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setString(1, clave);
            statement.setString(2, usuario);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public boolean modificarImagen(String usuario, String rutaImagen) {
        boolean resultado = false;

        try {
            String consulta = "update usuarios set imagen=? where identificador=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setString(1, rutaImagen);
            statement.setString(2, usuario);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public usuarios validarUsuario(String usuario, String clave) {
        usuarios respuesta = new usuarios();
        String consulta = "select * from usuarios where identificador= '" + usuario + "' and clave='" + clave + "'";
        try {
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                usuarios user = new usuarios();
                user.setIdentificador(resultado.getString("identificador"));
                user.setNombreSol(resultado.getString("nombreSol"));
                user.setTipo(resultado.getString("tipo"));
                user.setCursoArea(resultado.getString("cursoArea"));
                user.setColegio(resultado.getString("colegio"));
                user.setClave(resultado.getString("clave"));
                user.setImagen(resultado.getString("imagen"));
                user.setCorreo(resultado.getString("correo"));
                user.setEstado(resultado.getString("estado"));
                respuesta = user;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public boolean modificarEstado(String usuario) {
        boolean resultado = false;

        try {
            String consulta = "update usuarios set estado=? where identificador =?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setString(1, "true");
            statement.setString(2, usuario);
            resultado = statement.execute();
        } catch (Exception e) {
        }
        return resultado;
    }
    
}

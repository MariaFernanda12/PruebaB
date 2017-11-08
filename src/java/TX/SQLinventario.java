package TX;

import DAO.DaoElementos;
import Modelo.inventario;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLinventario {

    private Connection conexion;

    public SQLinventario() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public boolean insertar(inventario elm) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into inventario values(?,?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------

            statement.setInt(1, elm.getEtiqueta());
            statement.setString(2, elm.getNombre());
            statement.setInt(3, elm.getCantidadDisponible());
            statement.setString(4, elm.getUbicacion());
            statement.setString(5, elm.getPropiedad());
            statement.setString(6, elm.getResponsable());
            statement.setString(7, elm.getArea());

            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<inventario> listarTodo() {
        //1.Consulta

        ArrayList<inventario> respuesta = new ArrayList();
        String consulta = "select * from inventario";
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
                inventario elm = new inventario();
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
                elm.setColegio(resultado.getString("colegio"));

                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<inventario> listarPorArea(String area) {
        ArrayList<inventario> respuesta = new ArrayList();
        String consulta = "select * from inventario where area = '" + area + "'";
        System.out.println(consulta);
        try {

            Statement statement
                    = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);

            while (resultado.next()) {
                inventario elm = new inventario();
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
                elm.setColegio(resultado.getString("colegio"));
                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<inventario> buscarPorNombre(String nombre) {
        ArrayList<inventario> respuesta = new ArrayList();
        try {
            String consulta = "select * from inventario where nombre like '%" + nombre + "%'";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                inventario elm = new inventario();
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;
    }

    public inventario buscar(int etiqueta) {
        inventario elm = null;

        try {
            String consulta = "select * from inventario where etiqueta = ?";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            statement.setInt(1, etiqueta);

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                elm = new inventario();
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

    public boolean modificarElemento(int etiqueta, int newCantidad, String newUbicacion) {
        boolean resultado = false;

        try {
            String consulta = "update inventario set cantidadDisponible=?, ubicacion=? where etiqueta=?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, newCantidad);
            statement.setString(2, newUbicacion);
            statement.setInt(3, etiqueta);
            resultado = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    public boolean borrarElemento(int etiqueta) {
        boolean retorno = false;
        try {

            String consulta = "delete from inventario where etiqueta = ?";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, etiqueta);
            retorno = statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;

    }

    public ArrayList<inventario> cantidadElementosPorArea() {
        ArrayList<inventario> arr = new ArrayList<inventario>();

        try {
            String consulta = "select area,  sum(cantidaddisponible) as Total from inventario group by area";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                inventario elm = new inventario();
                elm = new inventario();
                elm.setArea(resultado.getString("area"));
                elm.setCantidadDisponible(resultado.getInt("total"));
                arr.add(elm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

}

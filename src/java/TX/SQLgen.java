package TX;

import DAO.DaoElementos;
import Modelo.inventario;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLgen<T> {

    private Connection conexion;

    public SQLgen() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

//    public boolean insertar(inventario elm) throws IllegalArgumentException, IllegalAccessException {
//        boolean resultado = false;
//        try {
//            Field[] f = elm.getClass().getDeclaredFields();
//            String consulta = "insert into " + elm.getClass().getSimpleName() + " values(" + "'";
//            for (int i = 0; i < f.length; i++) {
//                if (i == f.length - 1) {
//                    consulta = consulta + f[i].get(elm) + "'";
//                } else {
//                    consulta = consulta + f[i].get(elm) + "'" + "," + "'";
//                }
//
//            }
//            consulta = consulta + ")";
//            System.out.println(consulta);
//            PreparedStatement statement = this.conexion.prepareStatement(consulta);
//            statement.execute();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return resultado;
//    }
//
    public ArrayList<T> listarTodo(T p) {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName();
        try {            
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                T f2 = p;
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String r = rs.getString("" + f3[i].getName());
                    f3[i].set(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

//    public ArrayList<inventario> buscarPorNombre(String nombre) {
//        ArrayList<inventario> respuesta = new ArrayList();
//        try {
//            String consulta = "select * from inventario where nombre like '%" + nombre + "%'";
//            PreparedStatement statement
//                    = this.conexion.prepareStatement(consulta);
//            ResultSet resultado = statement.executeQuery();
//            while (resultado.next()) {
//                inventario elm = new inventario();
//                elm.setEtiqueta(resultado.getInt("etiqueta"));
//                elm.setNombre(resultado.getString("nombre"));
//                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
//                elm.setUbicacion(resultado.getString("ubicacion"));
//                elm.setPropiedad(resultado.getString("propiedad"));
//                elm.setResponsable(resultado.getString("responsable"));
//                elm.setArea(resultado.getString("area"));
//                respuesta.add(elm);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return respuesta;
//    }
//
//    public inventario buscar(int etiqueta) {
//        inventario elm = null;
//
//        try {
//            String consulta = "select * from inventario where etiqueta = ?";
//            PreparedStatement statement
//                    = this.conexion.prepareStatement(consulta);
//
//            statement.setInt(1, etiqueta);
//
//            ResultSet resultado = statement.executeQuery();
//            if (resultado.next()) {
//                elm = new inventario();
//                elm.setEtiqueta(resultado.getInt("etiqueta"));
//                elm.setNombre(resultado.getString("nombre"));
//                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
//                elm.setUbicacion(resultado.getString("ubicacion"));
//                elm.setPropiedad(resultado.getString("propiedad"));
//                elm.setResponsable(resultado.getString("responsable"));
//                elm.setArea(resultado.getString("area"));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return elm;
//    }
//
//    public boolean modificarElemento(int etiqueta, int newCantidad, String newUbicacion) {
//        boolean resultado = false;
//
//        try {
//            String consulta = "update inventario set cantidadDisponible=?, ubicacion=? where etiqueta=?";
//            PreparedStatement statement = this.conexion.prepareStatement(consulta);
//            statement.setInt(1, newCantidad);
//            statement.setString(2, newUbicacion);
//            statement.setInt(3, etiqueta);
//            resultado = statement.execute();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return resultado;
//
//    }
//
//    public boolean borrarElemento(int etiqueta) {
//        boolean retorno = false;
//        try {
//
//            String consulta = "delete from inventario where etiqueta = ?";
//            PreparedStatement statement = this.conexion.prepareStatement(consulta);
//            statement.setInt(1, etiqueta);
//            retorno = statement.execute();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return retorno;
//
//    }
//
//    public ArrayList<inventario> cantidadElementosPorArea() {
//        ArrayList<inventario> arr = new ArrayList<inventario>();
//
//        try {
//            String consulta = "select area,  sum(cantidaddisponible) as total from inventario group by area";
//            PreparedStatement statement
//                    = this.conexion.prepareStatement(consulta);
//
//            ResultSet resultado = statement.executeQuery();
//            while (resultado.next()) {
//                inventario elm = new inventario();
//                elm = new inventario();
//                elm.setArea(resultado.getString("area"));
//                elm.setCantidadDisponible(resultado.getInt("total"));
//                arr.add(elm);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return arr;
//    }

    public ArrayList<T> Select(T p) {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (f[i].get(p) != null) {
                    query += f[i].getName() + " = '" + f[i].get(p) + "'";
                    break;
                }
            }
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                T f2 = p;
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String r = rs.getString("" + f3[i].getName());
                    f3[i].set(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}

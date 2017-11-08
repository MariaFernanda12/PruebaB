package TX;

import Modelo.inventario;
import Modelo.reserva;
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

public class SQLreserva {

    private Connection conexion;

    public SQLreserva() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public boolean insertar(reserva res) throws IllegalArgumentException, IllegalAccessException {
        boolean resultado = false;
        try {

            Field[] f = res.getClass().getDeclaredFields();
            String consulta = "insert into " + res.getClass().getSimpleName() + " values(" + "'";
            for (int i = 0; i < f.length; i++) {
                if (i == f.length - 1) {
                    consulta = consulta + f[i].get(res) + "'";
                } else {
                    consulta = consulta + f[i].get(res) + "'" + "," + "'";
                }

            }
            consulta = consulta + ")";
            System.out.println(consulta);
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public inventario buscar(int etiqueta) {
        inventario elm = new inventario();
        try {
            String consulta = "select * from " + elm.getClass().getSimpleName() + " where etiqueta = " + etiqueta + "";
            System.out.println(consulta);
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                elm.setEtiqueta(resultado.getInt("etiqueta"));
                elm.setNombre(resultado.getString("nombre"));
                elm.setCantidadDisponible(resultado.getInt("cantidadDisponible"));
                elm.setUbicacion(resultado.getString("ubicacion"));
                elm.setPropiedad(resultado.getString("propiedad"));
                elm.setResponsable(resultado.getString("responsable"));
                elm.setArea(resultado.getString("area"));
                elm.setColegio(resultado.getString("colegio"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLreserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

    public ArrayList<reserva> listarTodo(String usuario) {

        ArrayList<reserva> respuesta = new ArrayList();
        reserva res = new reserva();
        Field[] f = res.getClass().getDeclaredFields();

        String consulta = "select * from " + res.getClass().getSimpleName() + " where "+f[3].getName()+" = '" + usuario + "'";
        System.out.println(consulta);
        try {
            Statement statement
                    = this.conexion.createStatement();
            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                reserva elm = new reserva();
                elm.setIdElemento(resultado.getInt("idElemento"));
                elm.setFechaActual(resultado.getString("fechaActual"));
                elm.setFechaReserva(resultado.getString("fechaReserva"));
                elm.setIdSol(resultado.getString("idSol"));
                elm.setCantidad(resultado.getInt("cantidad"));
                elm.setEstado(resultado.getString("estado"));
                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

}

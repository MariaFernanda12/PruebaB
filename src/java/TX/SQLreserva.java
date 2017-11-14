package TX;

import DAO.DaoReservas;
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

    public DaoReservas() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
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
            Logger.getLogger(DaoReservas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

    public boolean insertar(reserva res) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into reserva values(?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------

            statement.setInt(1, res.getIdElemento());
            statement.setString(2, res.getFechaActual());
            statement.setString(3, res.getFechaReserva());
            statement.setString(4, res.getIdSol());
            statement.setInt(5, res.getCantidad());
            statement.setString(6, res.getEstado());

            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
     public ArrayList<reserva> listarTodo(String usuario) {
        //1.Consulta

        ArrayList<reserva> respuesta = new ArrayList();
        String consulta = "select * from reserva where idsol=  '" + usuario + "'";
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

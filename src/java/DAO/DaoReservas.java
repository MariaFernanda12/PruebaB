package DAO;

import Modelo.Elemento;
import Modelo.ReservasM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modelo.ReservasM;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReservas {

    private Connection conexion;

    public DaoReservas() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public Elemento buscar(int etiqueta) {
        Elemento elm = null;

        try {
            String consulta = "select * from inventario where etiqueta = ?";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            statement.setInt(1, etiqueta);

            ResultSet resultado = statement.executeQuery();
            if (resultado.next()) {
                elm = new Elemento();
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

    public boolean insertar(ReservasM res) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into reserva values(?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------

            statement.setInt(1, res.getEtiquetaInv());
            statement.setString(2, res.getFechaActual());
            statement.setString(3, res.getFechaRes());
            statement.setString(4, res.getIdentificadorsol());
            statement.setInt(5, res.getCantidadRes());
            statement.setString(6, res.getEstado());

            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
     public ArrayList<ReservasM> listarTodo() {
        //1.Consulta

        ArrayList<ReservasM> respuesta = new ArrayList();
        String consulta = "select * from reserva";
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
                ReservasM elm = new ReservasM();
                elm.setEtiquetaInv(resultado.getInt("idElemento"));
                elm.setFechaActual(resultado.getString("fechaActual"));
                elm.setFechaRes(resultado.getString("fechaReserva"));
                elm.setIdentificadorsol(resultado.getString("idSol"));
                elm.setCantidadRes(resultado.getInt("cantidad"));
                elm.setEstado(resultado.getString("estado"));
                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

}

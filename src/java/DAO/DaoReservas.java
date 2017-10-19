package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Elemento;
import Modelo.ReservasM;
import java.net.URISyntaxException;
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
            Logger.getLogger(DaoElementos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elm;
    }

    public boolean insertar(ReservasM res) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into prestamo values(?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------

            statement.setInt(1, res.getEtiquetaInv());
            statement.setInt(2, res.getIdentificadorsol());
            statement.setString(3, res.getFechaDev());
            statement.setString(4, res.getFechaActual());
            statement.setInt(5, res.getCantidadPrestamo());
            statement.setString(6, res.getEstado());
            

            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    } 

}

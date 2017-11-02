package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Elemento;
import Modelo.PrestamoM;
import Modelo.ReservasM;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPrestamos {

    private Connection conexion;

    public DaoPrestamos() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    
    
    
    public boolean insertar(PrestamoM elm) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into prestamo values(?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------

            statement.setInt(1, elm.getEtiquetaInv());
            statement.setInt(2, elm.getIdentificadorsol());
            statement.setString(3, elm.getFechaDev());
            statement.setString(4, elm.getFechaActual());
            statement.setInt(5, elm.getCantidadPrestamo());
            statement.setString(6, elm.getEstado());
            

            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    

  
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TX;

import Modelo.prestamo;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Labin
 */
public class SQLprestamo {
    
     private Connection conexion;

    public DaoPrestamos() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    
    
    
    public boolean insertar(prestamo elm) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "insert into prestamo values(?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            //-----------------------------------

            statement.setInt(1, elm.getEtiquetaInv());
            statement.setString(2, elm.getIdentificadorSol());
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
    
    public ArrayList<prestamo> listarTodo() {
        //1.Consulta

        ArrayList<prestamo> respuesta = new ArrayList();
        String consulta = "select * from prestamo";
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
                prestamo elm = new prestamo();
                elm.setEtiquetaInv(resultado.getInt("etiquetaInv"));
                elm.setFechaActual(resultado.getString("fechaActual"));
                elm.setFechaDev(resultado.getString("fechaDev"));
                elm.setIdentificadorSol(resultado.getString("identificadorSol"));
                elm.setCantidadPrestamo(resultado.getInt("cantidadPrestamo"));
                elm.setEstado(resultado.getString("estado"));
                respuesta.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    
    
}

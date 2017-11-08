package TX;

import Modelo.reserva;
import Modelo.usuarios;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQL {

    private Connection conexion;

    public SQL() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    public boolean insertar(reserva res) throws IllegalArgumentException, IllegalAccessException {
        boolean resultado = false;
        try {

            Field[] f = res.getClass().getDeclaredFields();
            String consulta = "insert into " + res.getClass().getSimpleName() + " values(" + "'";
            for (int i = 0; i < f.length; i++) {
                if (i == f.length-1) {
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

}

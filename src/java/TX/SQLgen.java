package TX;


import Modelo.inventario;
import Modelo.prestamo;
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

public class SQLgen<T> {

    private Connection conexion;

    public SQLgen() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    //insert into ... values 
    public boolean insertar(T p) throws IllegalArgumentException, IllegalAccessException {
        boolean rs = false;
        try {
            Field[] f = p.getClass().getDeclaredFields();
            String consulta = "insert into " + p.getClass().getSimpleName() + " values(" + "'";
            for (int i = 0; i < f.length; i++) {
                if (i == f.length - 1) {
                    consulta = consulta + f[i].get(p) + "'";
                } else {
                    consulta = consulta + f[i].get(p) + "'" + "," + "'";
                }

            }
            consulta = consulta + ")";
            System.out.println(consulta);
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    //Select * from 
    public ArrayList<inventario> listarTodoInventario(inventario p) {

        ArrayList<inventario> res2 = new ArrayList<>();

        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName();
        try {
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                inventario elm = new inventario();
                elm.setEtiqueta(rs.getString("etiqueta"));
                elm.setNombre(rs.getString("nombre"));
                elm.setCantidadDisponible(rs.getString("cantidadDisponible"));
                elm.setUbicacion(rs.getString("ubicacion"));
                elm.setPropiedad(rs.getString("propiedad"));
                elm.setResponsable(rs.getString("responsable"));
                elm.setArea(rs.getString("area"));
                elm.setColegio(rs.getString("colegio"));

                res2.add(elm);
            }

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
    }
    
    public ArrayList<prestamo> listarTodoPrestamo(prestamo p) {

        ArrayList<prestamo> res2 = new ArrayList<>();

        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName();
        try {
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet resultado = st.executeQuery(query);
    

            while (resultado.next()) {
                prestamo elm = new prestamo();
                elm.setEtiquetaInv(resultado.getString("etiquetaInv"));
                elm.setFechaActual(resultado.getString("fechaActual"));
                elm.setFechaDev(resultado.getString("fechaDev"));
                elm.setIdentificadorSol(resultado.getString("identificadorSol"));
                elm.setCantidadPrestamo(resultado.getString("cantidadPrestamo"));
                elm.setEstado(resultado.getString("estado"));
                res2.add(elm);              
            }

            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res2;
    }
    
     public ArrayList<reserva> listarTodoReserva(reserva p) {
        //1.Consulta

        ArrayList<reserva> res2 = new ArrayList<>();

        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName();
        try {
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(query);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                reserva elm = new reserva();
                elm.setIdElemento(resultado.getString("idElemento"));
                elm.setFechaActual(resultado.getString("fechaActual"));
                elm.setFechaReserva(resultado.getString("fechaReserva"));
                elm.setIdSol(resultado.getString("idSol"));
                elm.setCantidad(resultado.getString("cantidad"));
                elm.setEstado(resultado.getString("estado"));
                res2.add(elm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return res2;
    }

    //delete from where
    public boolean borrar(T p) {
        boolean retorno = false;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "delelte from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (f[i].get(p) != null) {
                    query += f[i].getName() + " = '" + f[i].get(p) + "'";
                    break;
                }
            }
            System.out.println(query);
            PreparedStatement statement = this.conexion.prepareStatement(query);
            retorno = statement.execute();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    //select * from where
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
        System.out.println(res);
        return res;
        
    }

    //select * from .... where .... = .... and ..... = .......
    public ArrayList<T> Select2(T p) {
        ArrayList<T> res = new ArrayList<T>();
        int contador = 0;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (contador == 0) {
                    if (f[i].get(p) != null) {
                        query += f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                } else {
                    if (f[i].get(p) != null) {
                        query += " and " + f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                }

                contador++;
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

    //select * from .... where .... = .... and ..... = .......
    public boolean Select3(T p) {
        boolean res = false;
        int contador = 0;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (contador == 0) {
                    if (f[i].get(p) != null) {
                        query += f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                } else {
                    if (f[i].get(p) != null) {
                        query += " and " + f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                }

                contador++;
            }
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                res = true;
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

    public boolean update(T p) {
        boolean res = false;
        int contador = 0;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "update " + p.getClass().getSimpleName() + " set ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (contador == 0) {
                    if (f[i].get(p) != null) {
                        query += f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                } else {
                    if (f[i].get(p) != null) {
                        query += ", " + f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                }

                contador++;
            }
            query += " where " + f[0].getName() + " = '" + f[0].get(p) + "'";
            System.out.println(query);
            PreparedStatement statement = this.conexion.prepareStatement(query);
            res = statement.execute();
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

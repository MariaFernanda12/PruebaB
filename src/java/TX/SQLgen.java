package TX;

import Modelo.inventario;
import Modelo.prestamo;
import Modelo.reserva;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    public ArrayList<T> Select(T p) throws InvocationTargetException, NoSuchMethodException, InstantiationException {
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
                T f2 = (T) p.getClass().newInstance();
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String methodName = "set" + f3[i].getName();
                    Method setNameMethod = f2.getClass().getMethod(methodName, String.class);
                    String r = rs.getString("" + f3[i].getName());
                    setNameMethod.invoke(f2, r);
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

    public ArrayList<T> Select4(T p) {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName();
        try {
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                T f2 = (T) p.getClass().newInstance();
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String methodName = "set" + f3[i].getName();
                    Method setNameMethod = f2.getClass().getMethod(methodName, String.class);
                    String r = rs.getString("" + f3[i].getName());
                    setNameMethod.invoke(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}

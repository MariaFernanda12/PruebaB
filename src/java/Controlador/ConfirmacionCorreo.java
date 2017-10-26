package Controlador;

import DAO.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletActivacionCuenta
 */
public class ConfirmacionCorreo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmacionCorreo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String usu = request.getParameter("usuario");
            String ale = request.getParameter("aleatorio");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String id = (String) request.getAttribute("id");
            String cad = (String) request.getAttribute("cadena");
            
            System.out.println(id+"---------"+cad);

            try {
                String cliente = request.getRemoteAddr();
                out.println("");
                out.println("");
                out.println("");
                out.println("");

                if (usu.equals(id)) {
                    if (ale.equals(cad)) {
                        out.println("<h3>Bienvenido Usuario:" + usu + "</h3>");
                        out.println("<b>Gracias por verificar su Usuario</b>");
                        out.println("");
                        out.println("");
                        System.out.println("El Usuario a confirmado su Alta Nueva!");
                        DaoUsuario usuario = new DaoUsuario();
                        usuario.modificarEstado(usu);
                    } else {
                        out.println("<h3>ERROR!</h3>");
                        out.println("<b>Lo sentimos no es el numero de registro</b>");
                        out.println("");
                        out.println("");
                        System.out.println("Lo sentimos no es el numero de registro");
                    }
                } else {
                    out.println("<h3>ERROR!</h3>");
                    out.println("<b>No existe usuario</b>");
                    out.println("");
                    out.println("");
                    System.out.println("No existe usuario!");
                }

            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error de escritura:" + e);
            } finally {
                out.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error" + e);
        }

    }
}

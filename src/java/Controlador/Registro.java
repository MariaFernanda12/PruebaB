package Controlador;

import DAO.DaoUsuario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.*;
import java.util.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public String getCadenaAlfanumAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            if ((c >= '0' && c <= 9) || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identificador = request.getParameter("identificador");
        String clave = request.getParameter("pwd2");
        String colegio = request.getParameter("colegio");
        String correo = request.getParameter("pwd3");
        String cadena = getCadenaAlfanumAleatoria(8);
        HttpSession session1 = request.getSession();
        session1.setAttribute("identificador", identificador);
        session1.setAttribute("cadena", cadena);

        try {
            DaoUsuario daoU = new DaoUsuario();
            ArrayList<Boolean> arr1 = null;
            arr1 = daoU.validarRegistro(identificador, clave, colegio, correo);
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "librarysoftcolombia@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            // la persona k tiene k verificar
            message.setFrom(new InternetAddress("librarisoftcolombia@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            message.addHeader("Disposition-Notification-To", "librarisoftcolombia@gmail.com");
            message.setSubject("Correo de verificacion, porfavor no responder");
            message.setText(
                    " <img src='https://kingmathew.000webhostapp.com/images/titulo1.png' alt='Not-Found'> \n"
                    + "<br> \n"
                    + " Este es un correo de verificacion \n"
                    + "Gracias por registrarse en LibrarySoft \n"
                    + "Porfavor haga click en el siguiente enlace\n"
                    + "para verificar su cuenta \n"
                    + "<br> \n"
                    + "  <a href='http://librarysoft.herokuapp.com/myApp/ConfirmacionCorreo?usuario=" + identificador + "&aleatorio=" + cadena
                    + "'>Enlace de verificación</a>  ", "ISO-8859-1", "html");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("librarysoftcolombia@gmail.com", "thebestteam");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            String json = new Gson().toJson(arr1);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

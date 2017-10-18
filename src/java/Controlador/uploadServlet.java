package Controlador;

import Util.conexion;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 169999999)
public class uploadServlet extends HttpServlet {
    
    private Connection Conexion;
    
    public uploadServlet() throws URISyntaxException {
        
        this.Conexion = conexion.getConnection();
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            HttpSession session = request.getSession(false);
            String usuario = (String) session.getAttribute("user");
            Part filePart = request.getPart("photo");
            InputStream inputStream = null;
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }
            
            Connection con = this.Conexion;
            PreparedStatement st = con.prepareStatement("update usuarios set imagen=? where identificador=?");
            st.setBlob(1, inputStream);
            st.setString(2, usuario);
            int returnCode = st.executeUpdate();
            if (returnCode == 0) {
                response.sendRedirect("Usuario/perfil.jsp");

            } else {
                response.sendRedirect("Usuario/perfil.jsp");

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

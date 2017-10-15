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
            Part filePart = request.getPart("photo");
            InputStream inputStream = null;
            if (filePart != null) {
                inputStream = filePart.getInputStream();
            }

            
            Connection con = this.Conexion;
            PreparedStatement st = con.prepareStatement("update usuarios set imagen=? where identificador=12345");
            st.setBlob(1, inputStream);
            int returnCode = st.executeUpdate();
            if (returnCode == 0) {
                System.out.println("Fail");
            } else {
                
                System.out.println("Congrats Done");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
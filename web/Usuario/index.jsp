
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="Util.conexion"%>

<%  
    
    conexion a = new conexion();
    
    Blob image = null;
    
    Connection con = a.getConnection();

    byte[] imgData = null;

    Statement stmt = null;

    ResultSet rs = null;

    try {
        
        String usuario = (String) session.getAttribute("user");

        stmt = con.createStatement();

        rs = stmt.executeQuery("select imagen from usuarios where identificador='"+usuario+"'");

        if (rs.next()) {

            image = rs.getBlob(1);

            imgData = image.getBytes(1, (int) image.length());

        } else {

            out.println("Display Blob Example");

            out.println("image not found for given id>");

            return;

        }

        response.setContentType("image/png");

        OutputStream o = response.getOutputStream();

        o.write(imgData);

        o.flush();

        o.close();

    } catch (Exception e) {

        out.println("Unable To Display image");

        out.println("Image Display Error=" + e.getMessage());

        return;

    } finally {

        try {

            rs.close();

            stmt.close();

            con.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

%>
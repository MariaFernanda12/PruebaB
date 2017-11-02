package Controlador;

import DAO.DaoElementos;
import Modelo.Elemento;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;

public class ListarPorArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<Elemento> lista = null;
            DaoElementos daoE = new DaoElementos();
            String area = request.getParameter("valor1");
            if (area.equals("EspaÃ±ol")) {
                lista = daoE.listarPorArea("Español");
            } else {
                if (area.equals("MatemÃ¡ticas")) {
                    lista = daoE.listarPorArea("Matemáticas");
                } else {
                    if (area.equals("FÃ­sica")) {
                        lista = daoE.listarPorArea("Física");
                    } else {
                        if (area.equals("QuÃ­mica")) {
                            lista = daoE.listarPorArea("Química");
                        } else {
                            if (area.equals("Ciencias Naturales")) {
                                lista = daoE.listarPorArea("Ciencias  Naturales");
                            } else {
                                if (area.equals("FilosofÃ­a")) {
                                    lista = daoE.listarPorArea("Filosofía");
                                } else {
                                    if (area.equals("ReligiÃ³n")) {
                                        lista = daoE.listarPorArea("Religión");
                                    } else {
                                        if (area.equals("Ã?tica")) {
                                            lista = daoE.listarPorArea("Ética y Valores");
                                        } else {
                                            if (area.equals("InformÃ¡tica")) {
                                                lista = daoE.listarPorArea("Informática");
                                            } else {
                                                if (area.equals("Salud y EducaciÃ³n Sexual")) {
                                                    lista = daoE.listarPorArea("Salud y Educación Sexual");
                                                } else {
                                                    if (area.equals("Dibujo TÃ©cnico")) {
                                                        lista = daoE.listarPorArea("Dibujo Técnico y Artística");
                                                    } else {
                                                        if (area.equals("Material DidÃ¡ctico")) {
                                                            lista = daoE.listarPorArea("Material Didáctico");
                                                        } else {
                                                            if (area.equals("Multimedia")) {
                                                                lista = daoE.listarPorArea("Videos - DVD- CD-ROOM");
                                                            } else {
                                                                lista = daoE.listarPorArea(area);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            String json = new Gson().toJson(lista);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

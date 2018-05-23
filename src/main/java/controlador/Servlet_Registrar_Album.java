/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.admin.Admin_Album;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import vo.Album;
import vo.Interprete;

/**
 *
 * @author USUARIO
 */
public class Servlet_Registrar_Album extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_Registrar_Album</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Registrar_Album at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //processRequest(request, response);
        response.setContentType("application/json");

        Admin_Album adminAlbum = new Admin_Album();
        Album album = new Album();
        ArrayList<Interprete> arregloInterprete = new ArrayList<>();
        Interprete interpreteVO = new Interprete();

        String ID = request.getParameter("ID");
        String titulo = request.getParameter("titulo");
        String interprete = request.getParameter("interprete");
        String interprete2 = request.getParameter("interprete2");
        String interprete3 = request.getParameter("interprete3");

        interpreteVO.setNombre(interprete);
        arregloInterprete.add(interpreteVO);
        
        //NO SIRVE POR EL MOMENTO

//        if (!interprete2.equals("Vacio")) {
//            interpreteVO = new Interprete();
//            interpreteVO.setNombre(interprete2);
//            arregloInterprete.add(interpreteVO);
//
//            if (!interprete3.equals("Vacio")) {
//                interpreteVO = new Interprete();
//                interpreteVO.setNombre(interprete3);
//                arregloInterprete.add(interpreteVO);
//            }
//        }

        album.setTitulo(titulo);
        album.setId(ID);
        album.setInterprete(arregloInterprete);
        album.setPuestoAnterior(0);
        album.setNumeroDeListas(0);

        if (adminAlbum.crearAlbum(album)) {

            String Full = "Se ha registrado el album " + titulo + " con el ID " + ID + ", Interpretada por " + interprete;

            JSONObject json = new JSONObject();
            System.out.println("JSON Enviado");
            try {
                json.put("confirmacion", Full);
            } catch (JSONException ex) {
                Logger.getLogger(Servlet_Registrar_Album.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.print(json);
        }else{
            String Full = "Error creando Album";

            JSONObject json = new JSONObject();
            System.out.println("JSON Enviado");
            try {
                json.put("confirmacion", Full);
            } catch (JSONException ex) {
                Logger.getLogger(Servlet_Registrar_Album.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.print(json);
        
        
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

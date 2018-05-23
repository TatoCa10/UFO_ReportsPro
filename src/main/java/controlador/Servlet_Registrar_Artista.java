/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.admin.Admin_Interprete;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import vo.Interprete;

/**
 *
 * @author USUARIO
 */
public class Servlet_Registrar_Artista extends HttpServlet {

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
            out.println("<title>Servlet Servlet_Registrar_Artista</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Registrar_Artista at " + request.getContextPath() + "</h1>");
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

        Admin_Interprete adminInterprete = new Admin_Interprete();
        Interprete interprete = new Interprete();

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String genero = request.getParameter("genero");
        String idioma = request.getParameter("idioma");

        interprete.setNombre(nombre);
        interprete.setEdad(Integer.parseInt(edad));
        interprete.setGenero(genero);
        interprete.setIdioma(idioma);

        if (adminInterprete.crearInterprete(interprete)) {

            String Full = "Se ha registrado el artista " + nombre + " con la edad de " + edad + " años, del sexo " + genero + " y la lengua nativa " + idioma;

            JSONObject json = new JSONObject();
            System.out.println("JSON Enviado");
            try {
                json.put("confirmacion", Full);
            } catch (JSONException ex) {
                Logger.getLogger(Servlet_Registrar_Artista.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.print(json);
        } else {
            
            String Full = "Error creando Interprete";
            JSONObject json = new JSONObject();
            System.out.println("JSON Enviado");
            try {
                json.put("confirmacion", Full);
            } catch (JSONException ex) {
                Logger.getLogger(Servlet_Registrar_Artista.class.getName()).log(Level.SEVERE, null, ex);
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
        PrintWriter out = response.getWriter();
        //processRequest(request, response);
        response.setContentType("application/json");

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String genero = request.getParameter("genero");
        String idioma = request.getParameter("idiona");
        String Full = "Se ha registrado el artista " + nombre + "el cual tiene la edad de " + edad + "del sexo " + genero + "con la lengua nativa " + idioma;

        JSONObject json = new JSONObject();
        System.out.println("JSON Enviado");
        try {
            json.put("confirmacion", Full);
        } catch (JSONException ex) {
            Logger.getLogger(Servlet_Registrar_Artista.class.getName()).log(Level.SEVERE, null, ex);
        }

        out.print(json);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.admin.Admin_Reporte_Por_Ventas;
import dao.admin.Admin_Reporte_Ventas_Album;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import vo.Album;
import vo.Cancion;
import vo.Reporte_Por_Ventas;
import vo.Reporte_Ventas_Album;

/**
 *
 * @author USUARIO
 */
public class Servlet_Registrar_Ventas extends HttpServlet {

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
            out.println("<title>Servlet Servlet_Registrar_Ventas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Registrar_Ventas at " + request.getContextPath() + "</h1>");
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

        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String name = request.getParameter("name");
        String ID = request.getParameter("ID");
        String tipo = request.getParameter("tipo");
        String ventas = request.getParameter("ventas");

        Admin_Reporte_Por_Ventas adminReporte = new Admin_Reporte_Por_Ventas();
        Admin_Reporte_Ventas_Album adminReporteVentasAlbum = new Admin_Reporte_Ventas_Album();
        Reporte_Por_Ventas reportePorVentas = new Reporte_Por_Ventas();
        Reporte_Ventas_Album reporteporVentasAlbum = new Reporte_Ventas_Album();
        Cancion cancion = new Cancion();
        Album album = new Album();
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        
        opcion = 1;
        switch (opcion) {
            case 1:
                cancion= new Cancion();

                cancion.setNombre(name);
                cancion.setId(ID);

                reportePorVentas.setCancion(cancion);
                reportePorVentas.setVentas(Integer.parseInt(ventas));
                reportePorVentas.setFecha(now);

                if (tipo.equals("1")) {

                    if (adminReporte.crearReportePorVentasCancion(reportePorVentas)) {

                        String Full = "Se ha registrado una venta para la cancion " + name + " con el ID " + ID + "TIPO-> " + tipo;

                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);
                    } else {

                        String Full = "Error registrando venta de cancion";
                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);
                    }

                }

                if (tipo.equals("2")) {

                    if (adminReporte.crearReportePorVentasCancion(reportePorVentas)) {
                        String Full = "Se registraron " + ventas + " ventas para la cancion " + name + " con el ID " + ID + "TIPO-> " + tipo;

                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);

                    } else {

                        String Full = "Error registrando ventas de cancion";
                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);
                    }

                }

                break;

            case 2:

                
                reporteporVentasAlbum = new Reporte_Ventas_Album();
                album = new Album();
                

                album.setTitulo(name);
                album.setId(ID);

                reporteporVentasAlbum.setAlbum(album);
                reportePorVentas.setVentas(Integer.parseInt(ventas));
                reportePorVentas.setFecha(now);

                
                if (tipo.equals("1")) {

                    if (adminReporteVentasAlbum.crearReportePorVentasAlbum(reporteporVentasAlbum)) {

                        String Full = "Se ha registrado una venta para la cancion " + name + " con el ID " + ID + "TIPO-> " + tipo;

                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);
                    } else {

                        String Full = "Error registrando venta de cancion";
                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);
                    }

                }

                if (tipo.equals("2")) {

                    if (adminReporteVentasAlbum.crearReportePorVentasAlbum(reporteporVentasAlbum)) {
                        String Full = "Se registraron " + ventas + " ventas para la cancion " + name + " con el ID " + ID + "TIPO-> " + tipo;

                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);

                    } else {

                        String Full = "Error registrando ventas de cancion";
                        JSONObject json = new JSONObject();
                        System.out.println("JSON Enviado");
                        try {
                            json.put("confirmacion", Full);
                        } catch (JSONException ex) {
                            Logger.getLogger(Servlet_Registrar_Ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        out.print(json);
                    }

                }
                
                break;

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

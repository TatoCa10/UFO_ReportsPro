/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.admin.Admin_Reporte;
import dao.servicio.Servicio_Reporte;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vo.Reporte;

/**
 *
 * @author USUARIO
 */
public class Servlet_Reportes extends HttpServlet {

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
            out.println("<title>Servlet Servlet_Reportes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_Reportes at " + request.getContextPath() + "</h1>");
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

        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String year = request.getParameter("year");
        String ComboIgual = request.getParameter("ComboIgual");

        ArrayList<String> fechas = new ArrayList<>();
        
        System.out.println(ComboIgual);

        if(ComboIgual.equals("Reporte_Canciones")){

           

                Servicio_Reporte reporte = new Servicio_Reporte();
                Admin_Reporte adminReporte = new Admin_Reporte();
                ArrayList<Reporte> arregloReporte = new ArrayList<>();

                String fechaCorte = year + "-" + mes + "-" + dia;
                String fechaCorteAnterior = adminReporte.obtenerFechaCorteAnteriorCanciones();
                System.out.println("Fecha anterior: "+ fechaCorte);

                fechas.add(fechaCorte);
                fechas.add(fechaCorteAnterior);

                arregloReporte = reporte.obtenerReporteCanciones(fechas);
                JSONArray array = new JSONArray();
                
                for (int i = 0; i < arregloReporte.size(); i++) {
                
                    System.out.println(arregloReporte.get(i).getCancion().getNombre());
                    
            }

                for (int i = 0; i < arregloReporte.size(); i++) {
                    System.out.println("JSON Enviado");

                    try {
                        for (int j = 0; j < arregloReporte.get(i).getCancion().getInterprete().size(); j++) {

                            JSONObject json = new JSONObject();
                            json.put("puesto", i+1);
                            json.put("nombre", arregloReporte.get(i).getCancion().getNombre());
                            json.put("interprete", arregloReporte.get(i).getCancion().getInterprete().get(j).getNombre());
                            json.put("ventas", arregloReporte.get(i).getVentas());
                            json.put("anterior", arregloReporte.get(i).getCancion().getPuestoAnterior());
                            json.put("v_anterior", arregloReporte.get(i).getCancion().getNumeroDeListas());

                            array.put(json);
                        }

                    } catch (JSONException ex) {
                        Logger.getLogger(Servlet_Reportes.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                String Full = "Se genero el reporte " + ComboIgual + " en el periodo " + dia + "/" + mes + "/" + year;

                JSONObject mainJson = new JSONObject();
                 {
                    try {
                        mainJson.put("Reportes", array);
                    } catch (JSONException ex) {
                        Logger.getLogger(Servlet_Reportes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                
                out.print(mainJson);
                

        }

//        int puesto = 1000;
//        String nombre = "Mi Cancion De Prueba";
//        String interprete = "Yotas";
//        int ventas = 9999;
//        int anterior = 222;
//        int v_anterior = 000;
//
//        JSONObject json = new JSONObject();
//        System.out.println("JSON Enviado");
//        try {
//            json.put("puesto", puesto);
//            json.put("nombre", nombre);
//            json.put("interprete", interprete);
//            json.put("ventas", ventas);
//            json.put("anterior", anterior);
//            json.put("v_anterior", v_anterior);
//            json.put("confirmacion", Full);
//        } catch (JSONException ex) {
//            Logger.getLogger(Servlet_Reportes.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        out.print(json);

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

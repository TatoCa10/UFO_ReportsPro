/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicio;

import dao.admin.Admin_Cancion;
import dao.admin.Admin_Reporte;
import java.util.ArrayList;
import vo.Album;
import vo.Reporte;

/**
 *
 * @author Carlos Alberto
 */
public class Servicio_Reporte {

    private Admin_Reporte adminReporte;

    public void generarReportes(ArrayList<Reporte> reporte) {
        adminReporte = new Admin_Reporte();

        for (int i = 0; i < reporte.size(); i++) {
            adminReporte.crearReporte(reporte.get(i));
        }

    }

    public ArrayList<Reporte> obtenerReporteCanciones(ArrayList<String> fechas) {

        Servicio_Reporte_Ventas SReporteVentas = new Servicio_Reporte_Ventas();
        ArrayList<Reporte> sumaDeVentas = new ArrayList<>();
        ArrayList<Reporte> reportesOrdenados = new ArrayList<>();
        adminReporte = new Admin_Reporte();
        Admin_Cancion adminCancion = new Admin_Cancion();

        sumaDeVentas = SReporteVentas.ObtenerSumaDeVentasPorReporte(fechas);
        generarReportes(sumaDeVentas);

        reportesOrdenados = adminReporte.leerReportes(sumaDeVentas.get(0).getFecha().toString());

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            adminCancion.modificarCancion(reportesOrdenados.get(i).getCancion(), i);
        }

        return reportesOrdenados;
    }
    
    public ArrayList<Reporte> obtenerReporteCancionesDeAlbum(ArrayList<String> fechas, Album album) {

        Servicio_Reporte_Ventas SReporteVentas = new Servicio_Reporte_Ventas();
        ArrayList<Reporte> sumaDeVentas = new ArrayList<>();
        ArrayList<Reporte> reportesOrdenados = new ArrayList<>();
        adminReporte = new Admin_Reporte();
        Admin_Cancion adminCancion = new Admin_Cancion();

        sumaDeVentas = SReporteVentas.ObtenerSumaDeVentasCancionesDeAlbum(fechas, album);
        generarReportes(sumaDeVentas);

        reportesOrdenados = adminReporte.leerReportes(sumaDeVentas.get(0).getFecha().toString());

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            adminCancion.modificarCancion(reportesOrdenados.get(i).getCancion(), i);
        }

        return reportesOrdenados;
    }

}

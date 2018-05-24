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

    public boolean generarReportes(ArrayList<Reporte> reporte) {
        adminReporte = new Admin_Reporte();

        for (int i = 0; i < reporte.size(); i++) {
            System.out.println("Creando Reportes...");
            adminReporte.crearReporte(reporte.get(i));
            if (i == reporte.size() - 1) {

                return true;

            }
        }
        return false;

    }

    public ArrayList<Reporte> obtenerReporteCanciones(ArrayList<String> fechas) {

        Servicio_Reporte_Ventas SReporteVentas = new Servicio_Reporte_Ventas();
        ArrayList<Reporte> sumaDeVentas = new ArrayList<>();
        ArrayList<Reporte> reportesOrdenados = new ArrayList<>();
        adminReporte = new Admin_Reporte();
        Admin_Cancion adminCancion = new Admin_Cancion();

        for (int i = 0; i < fechas.size(); i++) {
            System.out.println(fechas.get(i));
        }

        sumaDeVentas = SReporteVentas.ObtenerSumaDeVentasPorReporte(fechas);

        if (generarReportes(sumaDeVentas)) {
            Servicio_Reporte_Ventas Servicio = new Servicio_Reporte_Ventas();
            reportesOrdenados = adminReporte.leerReportes(fechas.get(0));
            System.out.println(reportesOrdenados.size());
        }

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            System.out.println(reportesOrdenados.get(i).getCancion().getNombre());
        }

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            System.out.println("Modificando cancion: "+reportesOrdenados.get(i).getCancion().getNombre());
            if (adminCancion.modificarCancion(reportesOrdenados.get(i).getCancion(), i+1)) {
                System.out.println("Se Modifico cancion: "+reportesOrdenados.get(i).getCancion().getNombre());
            }else{
                System.out.println("No se modificó ni mierda");
            }

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

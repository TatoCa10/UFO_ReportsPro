/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicio;

import dao.admin.Admin_Album;
import dao.admin.Admin_Reporte_Album;
import java.util.ArrayList;
import vo.Reporte_Album;

/**
 *
 * @author Carlos Alberto
 */
public class Servicio_Reporte_Album {

    private Admin_Reporte_Album adminReporte;

    public boolean generarReportes(ArrayList<Reporte_Album> reporte) {
        adminReporte = new Admin_Reporte_Album();

        for (int i = 0; i < reporte.size(); i++) {
            System.out.println("Creando Reportes...");
            adminReporte.crearReporte(reporte.get(i));
            if (i == reporte.size() - 1) {

                return true;

            }
        }
        return false;

    }

    public ArrayList<Reporte_Album> obtenerReporteAlbumes(ArrayList<String> fechas) {

        Servicio_Reporte_Ventas_Album SReporteVentas = new Servicio_Reporte_Ventas_Album();
        ArrayList<Reporte_Album> sumaDeVentas = new ArrayList<>();
        ArrayList<Reporte_Album> reportesOrdenados = new ArrayList<>();
        adminReporte = new Admin_Reporte_Album();
        Admin_Album adminAlbum = new Admin_Album();
        
        System.out.println("Metodo obtenerReporteAlbumes");

        sumaDeVentas = SReporteVentas.ObtenerSumaDeVentasPorReporte(fechas);

        if (generarReportes(sumaDeVentas)) {
            Servicio_Reporte_Ventas_Album Servicio = new Servicio_Reporte_Ventas_Album();
            reportesOrdenados = adminReporte.leerReportes(fechas.get(0));
            System.out.println(reportesOrdenados.size());

        }

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            System.out.println(reportesOrdenados.get(i).getAlbum().getTitulo());
        }

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            System.out.println("Modificando cancion: "+reportesOrdenados.get(i).getAlbum().getTitulo());
            if (adminAlbum.modificarAlbum(reportesOrdenados.get(i).getAlbum(), i+1)) {
                System.out.println("Se Modifico cancion: "+reportesOrdenados.get(i).getAlbum().getTitulo());
            }else{
                System.out.println("No se modificó ni mierda");
            }
        }

        return reportesOrdenados;
    }

}

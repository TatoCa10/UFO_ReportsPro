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

    public void generarReportes(ArrayList<Reporte_Album> reporte) {
        adminReporte = new Admin_Reporte_Album();

        for (int i = 0; i < reporte.size(); i++) {
            adminReporte.crearReporte(reporte.get(i));
        }

    }

    public ArrayList<Reporte_Album> obtenerReporte(ArrayList<String> fechas) {

        Servicio_Reporte_Ventas_Album SReporteVentas = new Servicio_Reporte_Ventas_Album();
        ArrayList<Reporte_Album> sumaDeVentas = new ArrayList<>();
        ArrayList<Reporte_Album> reportesOrdenados = new ArrayList<>();
        adminReporte = new Admin_Reporte_Album();
        Admin_Album adminAlbum = new Admin_Album();

        sumaDeVentas = SReporteVentas.ObtenerSumaDeVentasPorReporte(fechas);
        generarReportes(sumaDeVentas);

        reportesOrdenados = adminReporte.leerReportes(sumaDeVentas.get(0).getFecha().toString());

        for (int i = 0; i < reportesOrdenados.size(); i++) {
            adminAlbum.modificarAlbum(reportesOrdenados.get(i).getAlbum(), i);
        }

        return reportesOrdenados;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicio;

import dao.admin.Admin_Reporte_Ventas_Album;
import java.util.ArrayList;
import vo.Reporte_Album;

/**
 *
 * @author Carlos Alberto
 */
public class Servicio_Reporte_Ventas_Album {
    
    private Admin_Reporte_Ventas_Album adminReporteVentasAlbum;

    public ArrayList<Reporte_Album> ObtenerSumaDeVentasPorReporte(ArrayList<String> fechas) {

        adminReporteVentasAlbum = new Admin_Reporte_Ventas_Album();
        Servicio_Reporte_Ventas servicio = new Servicio_Reporte_Ventas();
        ArrayList<String> fechasConfirmadas = new ArrayList<>();
        ArrayList<Reporte_Album> reporteFull = new ArrayList<>();

        String fechaDeCorte = servicio.modificarFecha(fechas.get(1));

        fechasConfirmadas.add(fechas.get(0));
        fechasConfirmadas.add(fechaDeCorte);

        reporteFull = adminReporteVentasAlbum.sumaReporteVentasAlbum(fechasConfirmadas);

        return reporteFull;
    }

}

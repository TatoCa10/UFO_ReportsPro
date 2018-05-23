/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.servicio;

import dao.admin.Admin_Reporte;
import dao.admin.Admin_Reporte_Por_Ventas;
import java.util.ArrayList;
import java.util.Date;
import vo.Album;
import vo.Cancion;
import vo.Reporte;
import vo.Reporte_Por_Ventas;

/**
 *
 * @author Carlos Alberto
 */
public class Servicio_Reporte_Ventas {

    private Admin_Reporte_Por_Ventas adminReporteVentas;

    public ArrayList<Reporte> ObtenerSumaDeVentasPorReporte(ArrayList<String> fechas) {

        adminReporteVentas = new Admin_Reporte_Por_Ventas();
        ArrayList<String> fechasConfirmadas = new ArrayList<>();
        ArrayList<Reporte> reporteFull = new ArrayList<>();

        String fechaDeCorte = modificarFecha(fechas.get(1));

        fechasConfirmadas.add(fechas.get(0));
        fechasConfirmadas.add(fechaDeCorte);

        reporteFull = adminReporteVentas.sumaReporteVentasCancion(fechasConfirmadas);

        return reporteFull;
    }

    public ArrayList<Reporte> ObtenerSumaDeVentasCancionesDeAlbum(ArrayList<String> fechas, Album album) {

        adminReporteVentas = new Admin_Reporte_Por_Ventas();
        ArrayList<String> fechasConfirmadas = new ArrayList<>();
        ArrayList<Reporte> reporteFull = new ArrayList<>();

        String fechaDeCorte = modificarFecha(fechas.get(1));

        fechasConfirmadas.add(fechas.get(0));
        fechasConfirmadas.add(fechaDeCorte);

        reporteFull = adminReporteVentas.sumaReporteVentasCancionesDeAlbum(fechasConfirmadas, album);

        return reporteFull;
    }
    
    public String modificarFecha(String fecha) {

        String[] arrayFechaCorte = fecha.split("-");

        int restaDia = Integer.parseInt(arrayFechaCorte[2]) - 1;

        if (restaDia == 0) {
            String Mes = restaMes(arrayFechaCorte[1]);
            String Dia = ultimoDiaDelMes(Mes);
            String fechaConfirmada = arrayFechaCorte[0] + "-" + Mes + "-" + Dia;
            return fechaConfirmada;
        } else {
            String fechaConfirmada = arrayFechaCorte[0] + "-" + arrayFechaCorte[1] + "-" + Integer.toString(restaDia);
            return fechaConfirmada;

        }

    }

    public String restaMes(String mes) {

        String mesConfirmado = "";
        int restaMes = Integer.parseInt(mes) - 1;

        if (restaMes == 0) {
            restaMes = 12;
            mesConfirmado = Integer.toString(restaMes);
        } else {
            mesConfirmado = Integer.toString(restaMes);
        }

        return mesConfirmado;
    }

    public String ultimoDiaDelMes(String Mes) {

        int numeroMes = Integer.parseInt(Mes);
        String diaConfirmado = "";

        if (numeroMes % 2 == 0) {

            if (numeroMes == 8) {
                diaConfirmado = "31";
                return diaConfirmado;
            } else {
                diaConfirmado = "30";
                return diaConfirmado;
            }
        } else {

            diaConfirmado = "31";
            return diaConfirmado;

        }
    }

}

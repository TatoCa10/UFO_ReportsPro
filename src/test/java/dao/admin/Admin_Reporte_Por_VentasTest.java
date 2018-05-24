/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vo.Album;
import vo.Cancion;
import vo.Interprete;
import vo.Reporte;
import vo.Reporte_Por_Ventas;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_Por_VentasTest {
    
    public Admin_Reporte_Por_VentasTest() {
    }
    
    

    /**
     * Test of crearReportePorVentasCancion method, of class Admin_Reporte_Por_Ventas.
     */
    @Test
    public void testCrearReportePorVentasCancion() {
        System.out.println("crearReportePorVentasCancion");
        Reporte_Por_Ventas reportePorVentas = new Reporte_Por_Ventas();
        Admin_Reporte_Por_Ventas instance = new Admin_Reporte_Por_Ventas();
        Cancion cancion = new Cancion();
        cancion.setNombre("Cancion_Test");
        cancion.setId("111");
        
        Album album = new Album();
        album.setTitulo("Album_Test");
        album.setId("11");
        album.setNumeroDeListas(11);
        album.setPuestoAnterior(22);
        
        Interprete interprete = new Interprete();
        interprete.setNombre("Artista_Test");
        interprete.setEdad(26);
        interprete.setGenero("Masculino");
        interprete.setIdioma("Español");
        
        ArrayList<Interprete> arreglo = new ArrayList<>();
        arreglo.add(interprete);
        
        album.setInterprete(arreglo);
        
        String fecha = "2018-05-24";
        
        cancion.setAlbum(album);
        cancion.setInterprete(arreglo);
        cancion.setNumeroDeListas(22);
        cancion.setPuestoAnterior(12);
    
        reportePorVentas.setCancion(cancion);
        reportePorVentas.setVentas(1000);
        reportePorVentas.setFecha(Date.valueOf(fecha));
        
        
        boolean expResult = true;
        boolean result = instance.crearReportePorVentasCancion(reportePorVentas);
        
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of sumaReporteVentasCancion method, of class Admin_Reporte_Por_Ventas.
     */
//    @Test
//    public void testSumaReporteVentasCancion() {
//        System.out.println("sumaReporteVentasCancion");
//        ArrayList<String> fechasConfirmadas = null;
//        Admin_Reporte_Por_Ventas instance = new Admin_Reporte_Por_Ventas();
//        ArrayList<Reporte> expResult = null;
//        ArrayList<Reporte> result = instance.sumaReporteVentasCancion(fechasConfirmadas);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of sumaReporteVentasCancionesDeAlbum method, of class Admin_Reporte_Por_Ventas.
     */
//    @Test
//    public void testSumaReporteVentasCancionesDeAlbum() {
//        System.out.println("sumaReporteVentasCancionesDeAlbum");
//        ArrayList<String> fechasConfirmadas = null;
//        Album album = null;
//        Admin_Reporte_Por_Ventas instance = new Admin_Reporte_Por_Ventas();
//        ArrayList<Reporte> expResult = null;
//        ArrayList<Reporte> result = instance.sumaReporteVentasCancionesDeAlbum(fechasConfirmadas, album);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

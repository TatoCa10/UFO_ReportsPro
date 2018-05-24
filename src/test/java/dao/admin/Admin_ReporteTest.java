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

/**
 *
 * @author Carlos Alberto
 */
public class Admin_ReporteTest {

    public Admin_ReporteTest() {
    }

    /**
     * Test of crearReporte method, of class Admin_Reporte.
     */
    @Test
    public void testCrearReporte() {
        System.out.println("crearReporte");
        Reporte reporte = new Reporte();
        Admin_Reporte instance = new Admin_Reporte();
        Cancion cancion = new Cancion();
        Album album = new Album();
        Interprete interprete = new Interprete();
        ArrayList<Interprete> arreglo = new ArrayList<>();

        String fecha = "2018-05-24";
        album.setTitulo("ALBUM_TEST");

        interprete.setNombre("INTER_TEST");
        arreglo.add(interprete);

        cancion.setNombre("SONG_TEST");
        cancion.setId("200");
        cancion.setAlbum(album);
        cancion.setInterprete(arreglo);
        cancion.setPuestoAnterior(0);
        cancion.setNumeroDeListas(0);


        reporte.setCancion(cancion);
        reporte.setVentas(10);
        reporte.setFecha(Date.valueOf(fecha));

        boolean expResult = true;
        boolean result = instance.crearReporte(reporte);

        assertEquals(expResult, result);

    }

    /**
     * Test of crearReporteCancionesAlbum method, of class Admin_Reporte.
     */
    @Test
    public void testCrearReporteCancionesAlbum() {
        System.out.println("crearReporteCancionesAlbum");
        Reporte reporte = new Reporte();
        Admin_Reporte instance = new Admin_Reporte();
        Cancion cancion = new Cancion();
        Album album = new Album();
        Interprete interprete = new Interprete();
        ArrayList<Interprete> arreglo = new ArrayList<>();

        String fecha = "2018-05-24";
        
        album.setTitulo("ALBUM_TEST");

        interprete.setNombre("INTER_TEST");
        arreglo.add(interprete);

        cancion.setNombre("SONG_TEST");
        cancion.setId("200");
        cancion.setAlbum(album);
        cancion.setInterprete(arreglo);
        cancion.setPuestoAnterior(0);
        cancion.setNumeroDeListas(0);


        reporte.setCancion(cancion);

        reporte.setVentas(10);
        reporte.setFecha(Date.valueOf(fecha));
        
        
        boolean expResult = true;
        boolean result = instance.crearReporteCancionesAlbum(reporte);

        assertEquals(expResult, result);

    }

    /**
     * Test of leerReportes method, of class Admin_Reporte.
     */
//    @Test
//    public void testLeerReportes() {
//        System.out.println("leerReportes");
//        String fecha = "";
//        Admin_Reporte instance = new Admin_Reporte();
//        ArrayList<Reporte> expResult = null;
//        ArrayList<Reporte> result = instance.leerReportes(fecha);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of leerReportesCancionesAlbum method, of class Admin_Reporte.
     */
//    @Test
//    public void testLeerReportesCancionesAlbum() {
//        System.out.println("leerReportesCancionesAlbum");
//        String fecha = "";
//        Admin_Reporte instance = new Admin_Reporte();
//        ArrayList<Reporte> expResult = null;
//        ArrayList<Reporte> result = instance.leerReportesCancionesAlbum(fecha);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of obtenerFechaCorteAnteriorCanciones method, of class
     * Admin_Reporte.
     */
    @Test
    public void testObtenerFechaCorteAnteriorCanciones() {
        System.out.println("obtenerFechaCorteAnteriorCanciones");
        Admin_Reporte instance = new Admin_Reporte();
        
        
        String expResult = "2018-05-30";
        String result = instance.obtenerFechaCorteAnteriorCanciones();
        
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of obtenerFechaCorteAnteriorCancionesAlbum method, of class
     * Admin_Reporte.
     */
    @Test
    public void testObtenerFechaCorteAnteriorCancionesAlbum() {
        System.out.println("obtenerFechaCorteAnteriorCancionesAlbum");
        Admin_Reporte instance = new Admin_Reporte();
        
        
        String expResult = "2018-05-24";
        String result = instance.obtenerFechaCorteAnteriorCancionesAlbum();
        
        
        assertEquals(expResult, result);
        
    }

}

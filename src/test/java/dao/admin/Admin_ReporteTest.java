/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vo.Reporte;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_ReporteTest {
    
    public Admin_ReporteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearReporte method, of class Admin_Reporte.
     */
    @Test
    public void testCrearReporte() {
        System.out.println("crearReporte");
        Reporte reporte = null;
        Admin_Reporte instance = new Admin_Reporte();
        boolean expResult = false;
        boolean result = instance.crearReporte(reporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearReporteCancionesAlbum method, of class Admin_Reporte.
     */
    @Test
    public void testCrearReporteCancionesAlbum() {
        System.out.println("crearReporteCancionesAlbum");
        Reporte reporte = null;
        Admin_Reporte instance = new Admin_Reporte();
        boolean expResult = false;
        boolean result = instance.crearReporteCancionesAlbum(reporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerReportes method, of class Admin_Reporte.
     */
    @Test
    public void testLeerReportes() {
        System.out.println("leerReportes");
        String fecha = "";
        Admin_Reporte instance = new Admin_Reporte();
        ArrayList<Reporte> expResult = null;
        ArrayList<Reporte> result = instance.leerReportes(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerReportesCancionesAlbum method, of class Admin_Reporte.
     */
    @Test
    public void testLeerReportesCancionesAlbum() {
        System.out.println("leerReportesCancionesAlbum");
        String fecha = "";
        Admin_Reporte instance = new Admin_Reporte();
        ArrayList<Reporte> expResult = null;
        ArrayList<Reporte> result = instance.leerReportesCancionesAlbum(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerFechaCorteAnteriorCanciones method, of class Admin_Reporte.
     */
    @Test
    public void testObtenerFechaCorteAnteriorCanciones() {
        System.out.println("obtenerFechaCorteAnteriorCanciones");
        Admin_Reporte instance = new Admin_Reporte();
        String expResult = "";
        String result = instance.obtenerFechaCorteAnteriorCanciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerFechaCorteAnteriorCancionesAlbum method, of class Admin_Reporte.
     */
    @Test
    public void testObtenerFechaCorteAnteriorCancionesAlbum() {
        System.out.println("obtenerFechaCorteAnteriorCancionesAlbum");
        Admin_Reporte instance = new Admin_Reporte();
        String expResult = "";
        String result = instance.obtenerFechaCorteAnteriorCancionesAlbum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

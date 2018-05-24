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
import vo.Reporte_Album;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_AlbumTest {
    
    public Admin_Reporte_AlbumTest() {
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
     * Test of crearReporte method, of class Admin_Reporte_Album.
     */
    @Test
    public void testCrearReporte() {
        System.out.println("crearReporte");
        Reporte_Album reporte = null;
        Admin_Reporte_Album instance = new Admin_Reporte_Album();
        boolean expResult = false;
        boolean result = instance.crearReporte(reporte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerReportes method, of class Admin_Reporte_Album.
     */
    @Test
    public void testLeerReportes() {
        System.out.println("leerReportes");
        String fecha = "";
        Admin_Reporte_Album instance = new Admin_Reporte_Album();
        ArrayList<Reporte_Album> expResult = null;
        ArrayList<Reporte_Album> result = instance.leerReportes(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerFechaCorteAnteriorAlbumes method, of class Admin_Reporte_Album.
     */
    @Test
    public void testObtenerFechaCorteAnteriorAlbumes() {
        System.out.println("obtenerFechaCorteAnteriorAlbumes");
        Admin_Reporte_Album instance = new Admin_Reporte_Album();
        String expResult = "";
        String result = instance.obtenerFechaCorteAnteriorAlbumes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

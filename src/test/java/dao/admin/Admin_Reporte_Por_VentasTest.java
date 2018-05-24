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
import vo.Album;
import vo.Reporte;
import vo.Reporte_Por_Ventas;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_Por_VentasTest {
    
    public Admin_Reporte_Por_VentasTest() {
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
     * Test of crearReportePorVentasCancion method, of class Admin_Reporte_Por_Ventas.
     */
    @Test
    public void testCrearReportePorVentasCancion() {
        System.out.println("crearReportePorVentasCancion");
        Reporte_Por_Ventas reportePorVentas = null;
        Admin_Reporte_Por_Ventas instance = new Admin_Reporte_Por_Ventas();
        boolean expResult = false;
        boolean result = instance.crearReportePorVentasCancion(reportePorVentas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaReporteVentasCancion method, of class Admin_Reporte_Por_Ventas.
     */
    @Test
    public void testSumaReporteVentasCancion() {
        System.out.println("sumaReporteVentasCancion");
        ArrayList<String> fechasConfirmadas = null;
        Admin_Reporte_Por_Ventas instance = new Admin_Reporte_Por_Ventas();
        ArrayList<Reporte> expResult = null;
        ArrayList<Reporte> result = instance.sumaReporteVentasCancion(fechasConfirmadas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaReporteVentasCancionesDeAlbum method, of class Admin_Reporte_Por_Ventas.
     */
    @Test
    public void testSumaReporteVentasCancionesDeAlbum() {
        System.out.println("sumaReporteVentasCancionesDeAlbum");
        ArrayList<String> fechasConfirmadas = null;
        Album album = null;
        Admin_Reporte_Por_Ventas instance = new Admin_Reporte_Por_Ventas();
        ArrayList<Reporte> expResult = null;
        ArrayList<Reporte> result = instance.sumaReporteVentasCancionesDeAlbum(fechasConfirmadas, album);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

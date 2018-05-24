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
import vo.Reporte_Ventas_Album;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_Ventas_AlbumTest {
    
    public Admin_Reporte_Ventas_AlbumTest() {
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
     * Test of crearReportePorVentasAlbum method, of class Admin_Reporte_Ventas_Album.
     */
    @Test
    public void testCrearReportePorVentasAlbum() {
        System.out.println("crearReportePorVentasAlbum");
        
        //1. Preparacion
        Reporte_Ventas_Album reportePorVentas = null;
        Admin_Reporte_Ventas_Album instance = new Admin_Reporte_Ventas_Album();
        
        //2. Ejercicio
        boolean expResult = false;
        boolean result = instance.crearReportePorVentasAlbum(reportePorVentas);
        
        //3. Verificacion
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaReporteVentasAlbum method, of class Admin_Reporte_Ventas_Album.
     */
    @Test
    public void testSumaReporteVentasAlbum() {
        System.out.println("sumaReporteVentasAlbum");
        ArrayList<String> fechasConfirmadas = null;
        Admin_Reporte_Ventas_Album instance = new Admin_Reporte_Ventas_Album();
        ArrayList<Reporte_Album> expResult = null;
        ArrayList<Reporte_Album> result = instance.sumaReporteVentasAlbum(fechasConfirmadas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

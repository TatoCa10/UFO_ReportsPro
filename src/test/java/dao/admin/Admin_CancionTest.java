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
import vo.Cancion;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_CancionTest {
    
    public Admin_CancionTest() {
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
     * Test of crearCancion method, of class Admin_Cancion.
     */
    @Test
    public void testCrearCancion() {
        System.out.println("crearCancion");
        Cancion cancion = null;
        Admin_Cancion instance = new Admin_Cancion();
        boolean expResult = false;
        boolean result = instance.crearCancion(cancion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerCancion method, of class Admin_Cancion.
     */
    @Test
    public void testLeerCancion() {
        System.out.println("leerCancion");
        Admin_Cancion instance = new Admin_Cancion();
        ArrayList<Cancion> expResult = null;
        ArrayList<Cancion> result = instance.leerCancion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerCancionesDeAlbum method, of class Admin_Cancion.
     */
    @Test
    public void testLeerCancionesDeAlbum() {
        System.out.println("leerCancionesDeAlbum");
        Album albumPro = null;
        Admin_Cancion instance = new Admin_Cancion();
        ArrayList<Cancion> expResult = null;
        ArrayList<Cancion> result = instance.leerCancionesDeAlbum(albumPro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerAlbumDeCancion method, of class Admin_Cancion.
     */
    @Test
    public void testObtenerAlbumDeCancion() {
        System.out.println("obtenerAlbumDeCancion");
        String cancionsinAlbum = "";
        Admin_Cancion instance = new Admin_Cancion();
        ArrayList<Cancion> expResult = null;
        ArrayList<Cancion> result = instance.obtenerAlbumDeCancion(cancionsinAlbum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarCancion method, of class Admin_Cancion.
     */
    @Test
    public void testModificarCancion() {
        System.out.println("modificarCancion");
        Cancion cancion = null;
        int numeroNuevo = 0;
        Admin_Cancion instance = new Admin_Cancion();
        boolean expResult = false;
        boolean result = instance.modificarCancion(cancion, numeroNuevo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarCancion method, of class Admin_Cancion.
     */
    @Test
    public void testBorrarCancion() {
        System.out.println("borrarCancion");
        Cancion cancion = null;
        Admin_Cancion instance = new Admin_Cancion();
        boolean expResult = false;
        boolean result = instance.borrarCancion(cancion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

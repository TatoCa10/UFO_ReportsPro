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
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_AlbumTest {
    
    public Admin_AlbumTest() {
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
     * Test of crearAlbum method, of class Admin_Album.
     */
    @Test
    public void testCrearAlbum() {
        System.out.println("crearAlbum");
        
        ArrayList<Interprete> arreglo = new ArrayList<>();
        Interprete interprete = new Interprete();
        
        interprete.setNombre("MalumaTest");
        arreglo.add(interprete);
        
        Album album = new Album();
        
        Admin_Album instance = new Admin_Album();
        
        album.setTitulo("FAME_test");
        album.setId("23");
        album.setInterprete(arreglo);
        album.setPuestoAnterior(1);
        album.setNumeroDeListas(1);
        
        
        boolean expResult = true;
        boolean result = instance.crearAlbum(album);
        
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of leerAlbum method, of class Admin_Album.
     */
//    @Test
//    public void testLeerAlbum() {
//        System.out.println("leerAlbum");
//        Admin_Album instance = new Admin_Album();
//        
//        
//        ArrayList<Album> expResult = null;
//        ArrayList<Album> result = instance.leerAlbum();
//        
//        
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of modificarAlbum method, of class Admin_Album.
     */
    @Test
    public void testModificarAlbum() {
        System.out.println("modificarAlbum");
        
        ;
        
        Album album = new Album();
        
        album.setId("24");
        album.setNumeroDeListas(1);
        
        int numeroNuevo = 2;
        Admin_Album instance = new Admin_Album();
        
        
        boolean expResult = true;
        boolean result = instance.modificarAlbum(album, numeroNuevo);
        
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of borrarAlbum method, of class Admin_Album.
     */
    
    @Test
    public void testBorrarAlbum() {
        System.out.println("borrarAlbum");
        
        Album album = new Album();
        album.setTitulo("FAME_test");
        album.setId("23");
        album.setInterprete(null);
        album.setPuestoAnterior(1);
        album.setNumeroDeListas(1);
        Admin_Album instance = new Admin_Album();
        
        
        boolean expResult = false;
        boolean result = instance.borrarAlbum(album);
        
        
        assertEquals(expResult, result);
        
    }
    
}

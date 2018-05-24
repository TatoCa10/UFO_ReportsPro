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
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_CancionTest {
    
    public Admin_CancionTest() {
    }
    
    

    /**
     * Test of crearCancion method, of class Admin_Cancion.
     */
    @Test
    public void testCrearCancion() {
        System.out.println("crearCancion");
        Cancion cancion = new Cancion();
        Admin_Cancion instance = new Admin_Cancion();
        Album album = new Album();
        Interprete interprete = new Interprete();
        ArrayList<Interprete> arreglo = new ArrayList<>();
        
        
        cancion.setNombre("SONG_TEST");
        cancion.setId("100");
        cancion.setAlbum(album);
        album.setTitulo("ALBUM_TEST");
        album.setId("100");
        interprete.setNombre("INTER_TEST");
        arreglo.add(interprete);
        cancion.setInterprete(arreglo);
        cancion.setPuestoAnterior(0);
        cancion.setNumeroDeListas(0);
        
        
        
        boolean expResult = true;
        boolean result = instance.crearCancion(cancion);
        
        
        assertEquals(expResult, result);
       
    }

    /**
     * Test of leerCancion method, of class Admin_Cancion.
     */
//    @Test
//    public void testLeerCancion() {
//        System.out.println("leerCancion");
//        Admin_Cancion instance = new Admin_Cancion();
//        ArrayList<Cancion> expResult = null;
//        ArrayList<Cancion> result = instance.leerCancion();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }

    /**
     * Test of leerCancionesDeAlbum method, of class Admin_Cancion.
     */
//    @Test
//    public void testLeerCancionesDeAlbum() {
//        System.out.println("leerCancionesDeAlbum");
//        Album albumPro = null;
//        Admin_Cancion instance = new Admin_Cancion();
//        ArrayList<Cancion> expResult = null;
//        ArrayList<Cancion> result = instance.leerCancionesDeAlbum(albumPro);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of obtenerAlbumDeCancion method, of class Admin_Cancion.
     */
//    @Test
//    public void testObtenerAlbumDeCancion() {
//        System.out.println("obtenerAlbumDeCancion");
//        String cancionsinAlbum = "";
//        Admin_Cancion instance = new Admin_Cancion();
//        ArrayList<Cancion> expResult = null;
//        ArrayList<Cancion> result = instance.obtenerAlbumDeCancion(cancionsinAlbum);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of modificarCancion method, of class Admin_Cancion.
     */
    @Test
    public void testModificarCancion() {
        System.out.println("modificarCancion");
        Cancion cancion = new Cancion();
        int numeroNuevo = 0;
        Admin_Cancion instance = new Admin_Cancion();
        
        cancion.setNombre("SONG_TEST");
        cancion.setId("200");
        
        
        boolean expResult = true;
        boolean result = instance.modificarCancion(cancion, numeroNuevo);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of borrarCancion method, of class Admin_Cancion.
     */
    @Test
    public void testBorrarCancion() {
        System.out.println("borrarCancion");
        Cancion cancion = new Cancion();
        Admin_Cancion instance = new Admin_Cancion();
        Album album = new Album();
        Interprete interprete = new Interprete();
        ArrayList<Interprete> arreglo = new ArrayList<>();
        
        
        cancion.setNombre("SONG_TEST");
        cancion.setId("100");
        cancion.setAlbum(album);
        album.setTitulo("ALBUM_TEST");
        album.setId("100");
        interprete.setNombre("INTER_TEST");
        arreglo.add(interprete);
        cancion.setInterprete(arreglo);
        cancion.setPuestoAnterior(0);
        cancion.setNumeroDeListas(0);
        
        
        boolean expResult = false;
        boolean result = instance.borrarCancion(cancion);
        assertEquals(expResult, result);
        
    }
    
}

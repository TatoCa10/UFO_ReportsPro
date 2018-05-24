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
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_InterpreteTest {
    
    public Admin_InterpreteTest() {
    }
    
    

    /**
     * Test of crearInterprete method, of class Admin_Interprete.
     */
    @Test
    public void testCrearInterprete() {
        System.out.println("crearInterprete");
        
        //1. Prep
        Interprete interprete = new Interprete();
        interprete.setNombre("MalumaTest");
        interprete.setEdad(24);
        interprete.setGenero("Masculino");
        interprete.setIdioma("Spanish");
        Admin_Interprete instance = new Admin_Interprete();
        
        //2. Exe
        boolean expResult = true;
        boolean result = instance.crearInterprete(interprete);
        
        //3. Verif
        assertEquals(expResult, result);
    }

    /**
     * Test of leerInterprete method, of class Admin_Interprete.
     */
//    @Test
//    public void testLeerInterprete() {
//        System.out.println("leerInterprete");
//        Admin_Interprete instance = new Admin_Interprete();
//        ArrayList<Interprete> arreglo = new ArrayList<>();
//        arreglo = instance.leerInterprete();
//        
//        
//        ArrayList<Interprete> expResult = arreglo;
//        ArrayList<Interprete> result = instance.leerInterprete();
//        
//        
//        assertEquals(expResult, result);
//    }

    /**
     * Test of borrarInterprete method, of class Admin_Interprete.
     */
    @Test
    public void testBorrarInterprete() {
        System.out.println("borrarInterprete");
        Interprete interprete = new Interprete();
        interprete.setNombre("MalumaTest");
        interprete.setEdad(24);
        interprete.setGenero("Masculino");
        interprete.setIdioma("Spanish");
        Admin_Interprete instance = new Admin_Interprete();
        
        
        boolean expResult = false;
        boolean result = instance.borrarInterprete(interprete);
        
        
        assertEquals(expResult, result);
        
    }
    
}

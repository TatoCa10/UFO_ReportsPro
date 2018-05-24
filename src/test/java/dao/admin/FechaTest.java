/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlos Alberto
 */
public class FechaTest {
    
    public FechaTest() {
    }
    
    

    /**
     * Test of obtenerFecha method, of class Fecha.
     */
    @Test
    public void testObtenerFecha() {
        System.out.println("obtenerFecha");
        Fecha instance = new Fecha();
        String fecha="2018-05-24";
        
        
        Date expResult = java.sql.Date.valueOf(fecha);
        Date result = instance.obtenerFecha();
        
        
        assertEquals(expResult, result);
        
    }
    
}

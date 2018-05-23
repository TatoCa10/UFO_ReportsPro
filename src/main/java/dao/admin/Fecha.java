/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import util.Conexion;

/**
 *
 * @author Carlos Alberto
 */
public class Fecha {
    
    private Connection conexion;

    public Fecha() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }
    
    public java.sql.Date obtenerFecha(){
        //1.Consulta
        java.sql.Date fecha = new java.sql.Date(0);
        String consulta = "SELECT CURDATE()";
        try {
            //----------------------------
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                fecha =resultado.getDate(1);
            }

            return fecha;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    
        
        return fecha;
    }
    
}

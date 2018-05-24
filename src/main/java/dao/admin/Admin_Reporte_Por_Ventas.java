/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conexion;
import vo.Album;
import vo.Cancion;
import vo.Interprete;
import vo.Reporte;
import vo.Reporte_Por_Ventas;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_Por_Ventas {

    private Connection conexion;

    public Admin_Reporte_Por_Ventas() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearReportePorVentasCancion(Reporte_Por_Ventas reportePorVentas) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Reporte_ventas VALUES(?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, reportePorVentas.getCancion().getNombre());
            statement.setString(2, reportePorVentas.getCancion().getId());
            statement.setString(3, reportePorVentas.getCancion().getAlbum().getTitulo());
            statement.setString(4, reportePorVentas.getCancion().getAlbum().getId());
            statement.setInt(5, reportePorVentas.getVentas());
            statement.setDate(6, (Date) reportePorVentas.getFecha());

            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Reporte> sumaReporteVentasCancion(ArrayList<String> fechasConfirmadas) {

        Admin_Cancion adminCancion = new Admin_Cancion();
        Admin_Reporte adminReporte = new Admin_Reporte();
        ArrayList<Cancion> canciones = new ArrayList<>();
        ArrayList<Reporte> reporteListo = new ArrayList<>();

        canciones = adminCancion.leerCancion();

        for (int i = 0; i < canciones.size(); i++) {
            int suma = 0;
            Reporte reporteVentas = new Reporte();

            String consulta
                    = "SELECT SUM(ventas) from Reporte_Ventas where id = '" + canciones.get(i).getId() + "' and fecha_log between '" + fechasConfirmadas.get(0) + "' and '" + fechasConfirmadas.get(1) + "'";
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
                    suma = resultado.getInt(1);
                }

                if (suma != 0) {
                    reporteVentas.setCancion(canciones.get(i));
                    reporteVentas.setFecha(Date.valueOf(fechasConfirmadas.get(2)));
                    reporteVentas.setVentas(suma);
                    reporteListo.add(reporteVentas);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return reporteListo;
    }
    
    
    public ArrayList<Reporte> sumaReporteVentasCancionesDeAlbum(ArrayList<String> fechasConfirmadas, Album album) {

        Admin_Cancion adminCancion = new Admin_Cancion();
        Admin_Reporte adminReporte = new Admin_Reporte();
        ArrayList<Cancion> canciones = new ArrayList<>();
        ArrayList<Reporte> reporteListo = new ArrayList<>();

        canciones = adminCancion.leerCancionesDeAlbum(album);

        for (int i = 0; i < canciones.size(); i++) {
            int suma = 0;
            Reporte reporteVentas = new Reporte();

            String consulta
                    = "SELECT SUM(ventas) from Reporte_Ventas where id = '" + canciones.get(i).getId() + "' and fecha between '" + fechasConfirmadas.get(0) + "' and '" + fechasConfirmadas.get(1) + "'";
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
                    suma = resultado.getInt(1);
                }

                if (suma != 0) {
                    reporteVentas.setCancion(canciones.get(i));
                    reporteVentas.setFecha(Date.valueOf(fechasConfirmadas.get(1)));
                    reporteVentas.setVentas(suma);
                    reporteListo.add(reporteVentas);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return reporteListo;
    }
    

}

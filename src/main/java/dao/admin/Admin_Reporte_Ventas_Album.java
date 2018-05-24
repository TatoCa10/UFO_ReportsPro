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
import vo.Reporte;
import vo.Reporte_Album;
import vo.Reporte_Ventas_Album;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_Ventas_Album {
    
    
    private Connection conexion;

    public Admin_Reporte_Ventas_Album() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearReportePorVentasAlbum(Reporte_Ventas_Album reportePorVentas) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Reporte_ventas_album VALUES(?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setString(1, reportePorVentas.getAlbum().getTitulo());
            statement.setString(2, reportePorVentas.getAlbum().getId());
            statement.setInt(3, reportePorVentas.getVentas());
            statement.setDate(4, (Date) reportePorVentas.getFecha());

            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Reporte_Album> sumaReporteVentasAlbum(ArrayList<String> fechasConfirmadas) {

        Admin_Album adminAlbum = new Admin_Album();
        Admin_Reporte adminReporte = new Admin_Reporte();
        ArrayList<Album> albumes = new ArrayList<>();
        ArrayList<Reporte_Album> reporteListo = new ArrayList<>();

        albumes = adminAlbum.leerAlbum();

        for (int i = 0; i < albumes.size(); i++) {
            int suma = 0;
            Reporte_Album reporteVentas = new Reporte_Album();

            String consulta
                    = "SELECT SUM(ventas) from Reporte_Ventas_Album where id = '" + albumes.get(i).getId() + "' and fecha_log between '" + fechasConfirmadas.get(0) + "' and '" + fechasConfirmadas.get(1) + "'";
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
                    reporteVentas.setAlbum(albumes.get(i));
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
}

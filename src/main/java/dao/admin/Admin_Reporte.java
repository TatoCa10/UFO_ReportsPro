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
import vo.Reporte;
import vo.Cancion;
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte {

    private Connection conexion;

    public Admin_Reporte() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearReporte(Reporte reporte) {
        boolean resultado = false;

        Admin_Cancion admin_cancion = new Admin_Cancion();
        ArrayList<Cancion> cancion = new ArrayList<>();
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Reporte VALUES(?,?,?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            for (int i = 0; i < reporte.getCancion().getInterprete().size(); i++) {

                statement.setString(1, reporte.getCancion().getNombre());
                statement.setString(2, reporte.getCancion().getId());
                statement.setString(3, reporte.getCancion().getAlbum().getTitulo());
                statement.setString(4, reporte.getCancion().getInterprete().get(i).getNombre());
                statement.setInt(5, reporte.getVentas());
                statement.setInt(6, reporte.getCancion().getPuestoAnterior());
                statement.setInt(7, reporte.getCancion().getNumeroDeListas());
                statement.setDate(8, (Date) reporte.getFecha());

                //--------------------------------------
                //3. Hacer la ejecucion
                resultado = statement.execute();
            }

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Reporte> leerReportes(String fecha) {
        //1.Consulta
        ArrayList<Reporte> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM reporte_global WHERE fecha_log='" + fecha + "' order by ventas desc";
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
            String idViejo = "";
            int i = 0;
            while (resultado.next()) {

                if (resultado.getString(2).equals(idViejo)) {
                    Interprete interpretes = new Interprete();
                    interpretes.setNombre(resultado.getString(4));
                    respuesta.get(i - 1).getInterprete().add(interpretes);
                } else {

                    Reporte reporte = new Reporte();

                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Cancion cancion = new Cancion();
                    Interprete interprete = new Interprete();
                    Album album = new Album();
                    idViejo = resultado.getString(3);

                    cancion.setNombre(resultado.getString(1));
                    cancion.setId(resultado.getString(2));
                    album.setTitulo(resultado.getString(3));
                    cancion.setAlbum(album);
                    interprete.setNombre(resultado.getString(4));
                    arregloInterprete.add(interprete);
                    cancion.setInterprete(arregloInterprete);
                    reporte.setVentas(resultado.getInt(5));
                    cancion.setPuestoAnterior(resultado.getInt(6));
                    cancion.setNumeroDeListas(resultado.getInt(7));
                    reporte.setCancion(cancion);
                    reporte.setFecha(resultado.getDate(8));

                    respuesta.add(reporte);
                    i++;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    
    
    public String obtenerFechaCorteAnteriorCanciones() {
    String fecha="";
    String consulta = "SELECT fecha_log FROM reporte_global order by Fecha_log desc";
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
            int i=0;
            while (i!=1) {
                fecha = resultado.getDate(1).toString();
                i++;
                }
            
            if (fecha==null) {
                fecha="2015-05-11";
            }
            
            return fecha;

            }

         catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return null;
    }

}

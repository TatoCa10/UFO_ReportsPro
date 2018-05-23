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
import vo.Reporte_Album;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Reporte_Album {
    
    private Connection conexion;

    public Admin_Reporte_Album() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearReporte(Reporte_Album reporte) {
        boolean resultado = false;

        Admin_Cancion admin_cancion = new Admin_Cancion();
        ArrayList<Album> album = new ArrayList<>();
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Reporte_Album VALUES(?,?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            for (int i = 0; i < reporte.getAlbum().getInterprete().size(); i++) {

                statement.setString(1, reporte.getAlbum().getTitulo());
                statement.setString(2, reporte.getAlbum().getId());
                statement.setString(3, reporte.getAlbum().getInterprete().get(i).getNombre());
                statement.setInt(4, reporte.getVentas());
                statement.setInt(5, reporte.getAlbum().getPuestoAnterior());
                statement.setInt(6, reporte.getAlbum().getNumeroDeListas());
                statement.setDate(7, (Date) reporte.getFecha());

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

    public ArrayList<Reporte_Album> leerReportes(String fecha) {
        //1.Consulta
        ArrayList<Reporte_Album> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM reporte_album WHERE fecha='" + fecha + "' order by ventas desc";
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
                    interpretes.setNombre(resultado.getString(3));
                    respuesta.get(i - 1).getInterprete().add(interpretes);
                } else {

                    Reporte_Album reporte = new Reporte_Album();

                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Album album = new Album();
                    Interprete interprete = new Interprete();
                    idViejo = resultado.getString(2);

                    album.setTitulo(resultado.getString(1));
                    album.setId(resultado.getString(2));
                    interprete.setNombre(resultado.getString(3));
                    arregloInterprete.add(interprete);
                    album.setInterprete(arregloInterprete);
                    reporte.setVentas(resultado.getInt(4));
                    album.setPuestoAnterior(resultado.getInt(5));
                    album.setNumeroDeListas(resultado.getInt(6));
                    reporte.setAlbum(album);
                    reporte.setFecha(resultado.getDate(7));

                    respuesta.add(reporte);
                    i++;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    
    public String obtenerFechaCorteAnteriorAlbumes(){
    String fecha="";
    String consulta = "SELECT fecha FROM reporte_album order by Fecha desc";
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
            while (i!= 1) {
                
                fecha = resultado.getDate(1).toString();
                i++;
                }
            
            return fecha;

            }

         catch (SQLException ex) {
            ex.printStackTrace();
        }
    
        return null;
    }
    
}

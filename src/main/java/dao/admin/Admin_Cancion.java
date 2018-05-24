/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.Conexion;
import vo.Album;
import vo.Cancion;
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Cancion {

    private Connection conexion;

    public Admin_Cancion() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearCancion(Cancion cancion) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Cancion VALUES(?,?,?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            for (int i = 0; i < cancion.getInterprete().size(); i++) {

                statement.setString(1, cancion.getNombre());
                statement.setString(2, cancion.getId());
                statement.setString(3, cancion.getAlbum().getTitulo());
                statement.setString(4, cancion.getAlbum().getId());
                statement.setString(5, cancion.getInterprete().get(i).getNombre());
                statement.setInt(6, cancion.getPuestoAnterior());
                statement.setInt(7, cancion.getNumeroDeListas());

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

    public ArrayList<Cancion> leerCancion() {
        //1.Consulta
        ArrayList<Cancion> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Cancion";
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

                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Cancion cancion = new Cancion();
                    Interprete interprete = new Interprete();
                    Album album = new Album();
                    idViejo = resultado.getString(2);

                    cancion.setNombre(resultado.getString(1));
                    cancion.setId(resultado.getString(2));
                    album.setTitulo(resultado.getString(3));
                    album.setId(resultado.getString(4));
                    cancion.setAlbum(album);
                    interprete.setNombre(resultado.getString(5));
                    arregloInterprete.add(interprete);
                    cancion.setInterprete(arregloInterprete);
                    cancion.setPuestoAnterior(resultado.getInt(6));
                    cancion.setNumeroDeListas(resultado.getInt(7));

                    respuesta.add(cancion);
                    i++;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<Cancion> leerCancionesDeAlbum(Album albumPro) {
        //1.Consulta
        ArrayList<Cancion> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Cancion where idAlbum ='"+albumPro.getId()+"'";
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

                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Cancion cancion = new Cancion();
                    Interprete interprete = new Interprete();
                    Album album = new Album();
                    idViejo = resultado.getString(2);

                    cancion.setNombre(resultado.getString(1));
                    cancion.setId(resultado.getString(2));
                    album.setTitulo(resultado.getString(3));
                    album.setId(resultado.getString(4));
                    cancion.setAlbum(album);
                    interprete.setNombre(resultado.getString(5));
                    arregloInterprete.add(interprete);
                    cancion.setInterprete(arregloInterprete);
                    cancion.setPuestoAnterior(resultado.getInt(6));
                    cancion.setNumeroDeListas(resultado.getInt(7));

                    respuesta.add(cancion);
                    i++;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    public ArrayList<Cancion> obtenerAlbumDeCancion(String cancionsinAlbum) {
        //1.Consulta
        ArrayList<Cancion> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Cancion where id= '"+cancionsinAlbum+"'";
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

                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Cancion cancion = new Cancion();
                    Interprete interprete = new Interprete();
                    Album album = new Album();
                    idViejo = resultado.getString(2);

                    cancion.setNombre(resultado.getString(1));
                    cancion.setId(resultado.getString(2));
                    album.setTitulo(resultado.getString(3));
                    album.setId(resultado.getString(4));
                    cancion.setAlbum(album);
                    interprete.setNombre(resultado.getString(5));
                    arregloInterprete.add(interprete);
                    cancion.setInterprete(arregloInterprete);
                    cancion.setPuestoAnterior(resultado.getInt(6));
                    cancion.setNumeroDeListas(resultado.getInt(7));

                    respuesta.add(cancion);
                    i++;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    
    public boolean modificarCancion(Cancion cancion, int numeroNuevo) {
        
        System.out.println("nombre: "+cancion.getNombre());
        System.out.println("id: "+ cancion.getId());
        System.out.println("numero nuevo"+numeroNuevo);
        System.out.println("numero de listas: "+ cancion.getNumeroDeListas());
        boolean result = false;
        String query = "update Cancion set id = ?, puestoListaAnterior = ?, numeroDeListas = ?  where id= ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, cancion.getId());
            preparedStmt.setInt(2, numeroNuevo);
            preparedStmt.setInt(3, cancion.getNumeroDeListas() + 1);
            preparedStmt.setString(4, cancion.getId());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean borrarCancion(Cancion cancion) {
        boolean result = false;
        String query = "delete from Cancion where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, cancion.getId());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

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
import vo.Interprete;

/**
 *
 * @author Carlos Alberto
 */
public class Admin_Album {
    
    private Connection conexion;

    public Admin_Album() {
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }

    public boolean crearAlbum(Album album) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Album VALUES(?,?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            for (int i = 0; i < album.getInterprete().size(); i++) {

                statement.setString(1, album.getTitulo());
                statement.setString(2, album.getId());
                statement.setString(3, album.getInterprete().get(i).getNombre());
                statement.setInt(4, album.getPuestoAnterior());
                statement.setInt(5, album.getNumeroDeListas());

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

    public ArrayList<Album> leerAlbum() {
        //1.Consulta
        ArrayList<Album> respuesta = new ArrayList<>();
        String consulta = "SELECT * FROM Album";
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

                if (resultado.getString(4).equals(idViejo)) {
                    Interprete interpretes = new Interprete();
                    interpretes.setNombre(resultado.getString(2));
                    respuesta.get(i - 1).getInterprete().add(interpretes);
                } else {

                    ArrayList<Interprete> arregloInterprete = new ArrayList<>();
                    Album album = new Album();
                    Interprete interprete = new Interprete();
                    idViejo = resultado.getString(3);

                    album.setTitulo(resultado.getString(1));
                    album.setId(resultado.getString(2));
                    interprete.setNombre(resultado.getString(3));
                    arregloInterprete.add(interprete);
                    album.setInterprete(arregloInterprete);
                    album.setPuestoAnterior(resultado.getInt(4));
                    album.setNumeroDeListas(resultado.getInt(5));

                    respuesta.add(album);
                    i++;
                }

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public boolean modificarAlbum(Album album, int numeroNuevo) {
        boolean result = false;
        String query = "update Album set puesto_Anterior = ?, numero_De_Listas = ?  where id= ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setInt(1, numeroNuevo);
            preparedStmt.setInt(2, album.getNumeroDeListas() + 1);
            preparedStmt.setString(3, album.getId());

            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean borrarAlbum(Album album) {
        boolean result = false;
        String query = "delete from Album where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, album.getId());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}

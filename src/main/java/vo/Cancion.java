/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.ArrayList;

/**
 *
 * @author Carlos Alberto
 */
public class Cancion {

    private String id;
    private String nombre;
    private ArrayList<Interprete> interprete;
    private Album album;
    private int puestoAnterior;
    private int numeroDeListas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Interprete> getInterprete() {
        return interprete;
    }

    public void setInterprete(ArrayList<Interprete> interprete) {
        this.interprete = interprete;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getPuestoAnterior() {
        return puestoAnterior;
    }

    public void setPuestoAnterior(int puestoAnterior) {
        this.puestoAnterior = puestoAnterior;
    }

    public int getNumeroDeListas() {
        return numeroDeListas;
    }

    public void setNumeroDeListas(int numeroDeListas) {
        this.numeroDeListas = numeroDeListas;
    }

}

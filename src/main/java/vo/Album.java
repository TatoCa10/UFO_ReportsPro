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
public class Album {

    private String id;
    private String titulo;
    private ArrayList<Interprete> interprete;
    private int puestoAnterior;
    private int numeroDeListas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Interprete> getInterprete() {
        return interprete;
    }

    public void setInterprete(ArrayList<Interprete> interprete) {
        this.interprete = interprete;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author antonio
 */
public class Partido {
    private String denominacion;
    private String siglas;
    private int votos;

    public Partido() {
    }

    public Partido(String siglas) {
        this.siglas = siglas;
    }

    public Partido(String denominacion, String siglas, int votos) {
        this.denominacion = denominacion;
        this.siglas = siglas;
        this.votos = votos;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    
    
    
    
    
}

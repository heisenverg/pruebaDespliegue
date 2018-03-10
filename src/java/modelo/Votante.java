/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author antonio
 */
public class Votante {
    
    private String nif;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNac;
    private String password;
    private String votado;

    public Votante() {
    }

    public Votante(String nif, String password) {
        this.nif = nif;
        this.password = password;
    }

    
    public Votante(String nif, String nombre, String apellidos, LocalDate fechaNac, String votado) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.votado = votado;
    }

    
    public Votante(String nif, String nombre, String apellidos, LocalDate fechaNac, String password, String votado) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.password = password;
        this.votado = votado;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVotado() {
        return votado;
    }

    public void setVotado(String votado) {
        this.votado = votado;
    }
    
}

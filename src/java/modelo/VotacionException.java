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
public class VotacionException extends Exception {
    
    private String mensaje;
    private int codigo;
    private String alerta;

    public VotacionException() {
    }

    public VotacionException(String mensaje, int codigo, String alerta) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.alerta = alerta;
    }

    @Override
    public String toString() {
        return "VotacionException{" + "mensaje=" + mensaje + ", codigo=" + codigo + ", alerta=" + alerta + '}';
    }
    
    
    
}

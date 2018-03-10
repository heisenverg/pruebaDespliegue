/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Partido;
import modelo.VotacionException;
import modelo.Votante;

/**
 *
 * @author antonio
 */
public class Operaciones {

    public Operaciones() {
    }
    
    public void añadirVotante(Connection con, Votante objV) throws VotacionException{
       
        String sentenciaSQL = "insert into votante values(null,?,?,?,?,?,?)";
        try (
            PreparedStatement consulta = con.prepareStatement(sentenciaSQL)) {
            consulta.setString(1,objV.getNif());
            consulta.setString(2,objV.getNombre());
            consulta.setString(3, objV.getApellidos());
            consulta.setDate(4, java.sql.Date.valueOf(objV.getFechaNac()));
            consulta.setString(5, objV.getPassword());
            consulta.setString(6,objV.getVotado());
            consulta.executeUpdate();
  
        }catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
            String alerta = "La consulta ha fallado";
            throw new VotacionException(mensaje,codigo,alerta);
        }
    }
    
     public int borrarVotante(Connection con, Votante objV) throws VotacionException{
        int total;
        String sentenciaSQL = "delete from votante where nif = ?";
        try {
            PreparedStatement consulta = con.prepareStatement(sentenciaSQL);
            consulta.setString(1,objV.getNif());
            total = consulta.executeUpdate();
        
        } catch (SQLException ex) {
            throw new VotacionException();
        }
        return total;
    }
    
    
    public Votante sacarVotante(Connection con, Votante objV) throws VotacionException{
        Votante votanteOk = new Votante();
        
        try {
            String sentenciaSQL = "select * from votante where nif = ? and password = ?";
            PreparedStatement consulta = con.prepareStatement(sentenciaSQL);
            consulta.setString(1, objV.getNif());
            consulta.setString(2, objV.getPassword());
            ResultSet rs = consulta.executeQuery();
            
            if(rs.next()){
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                LocalDate fecha_nac = rs.getDate("fecha_nac").toLocalDate();
                String password = rs.getString("password");
                String votado = rs.getString("votado");
 
                votanteOk = new Votante(nif, nombre, apellidos, fecha_nac, password, votado);
                
            }
            
        } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
            String alerta = "La consulta ha fallado";
            throw new VotacionException(mensaje,codigo,alerta);
        }
        return votanteOk;
    }
    
    public ArrayList<Partido> sacarPartidos(Connection con) throws VotacionException{
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        String sentenciaSQL = "select * from partido";
      
        try {
            PreparedStatement consulta = con.prepareStatement(sentenciaSQL);
            ResultSet rs = consulta.executeQuery();
            
            while(rs.next()){
                String denominacion = rs.getString("denominacion");
                String siglas = rs.getString("siglas");
                int votos = rs.getInt("votos");
                
                Partido partido = new Partido(denominacion, siglas, votos);
                listaPartidos.add(partido);
            }
            
        } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
            String alerta = "No se han listado los partidos";
            throw new VotacionException(mensaje,codigo,alerta);
        }
        
        return listaPartidos;
            
    }
    
    public void votar(Connection con, Partido objP, Votante objV) throws SQLException{
        con.setAutoCommit(false);
            try {
                String sentenciaSQL = "UPDATE votante SET votado='S' WHERE nif=? and password=?";
                PreparedStatement consulta = con.prepareStatement(sentenciaSQL);
                consulta.setString(1, objV.getNif());
                consulta.setString(2, objV.getPassword());
                int resultado = consulta.executeUpdate();
            
                 String otraSentenciaSQL = "UPDATE partido SET votos=votos+1 where siglas=?";
                PreparedStatement otraConsulta = con.prepareStatement(otraSentenciaSQL);
                otraConsulta.setString(1, objP.getSiglas());
                int otroResultado = otraConsulta.executeUpdate();
                
                con.commit();
            }catch (SQLException ex) {
                con.rollback();
                throw ex;
            }finally{
                con.setAutoCommit(true);
            }
    }
    
    public ArrayList<Votante> sacarVotantes(Connection con) throws VotacionException{
        
        ArrayList<Votante> listaVotantes = new ArrayList<>();
        String sentenciaSQL = "select * from votante";
        
        try {
            PreparedStatement consulta = con.prepareStatement(sentenciaSQL);
            ResultSet rs = consulta.executeQuery();
            
            while(rs.next()){
               String nif = rs.getString("nif");
               String nombre = rs.getString("nombre");
               String apellidos = rs.getString("apellidos");
               LocalDate fechaNac = rs.getDate("fecha_nac").toLocalDate();
               String votado = rs.getString("votado");
               
               Votante votante = new Votante(nif,nombre,apellidos,fechaNac,votado);
               listaVotantes.add(votante);
            }       
            
        } catch (SQLException ex) {
            String mensaje = ex.getMessage();
            int codigo = ex.getErrorCode();
            String alerta = "No se han listado votantes";
            throw new VotacionException(mensaje,codigo,alerta);
        }
        return listaVotantes;
    }  
    

}
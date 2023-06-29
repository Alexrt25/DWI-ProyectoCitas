/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Modelo.Paciente;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author lisbetmoron
 */
public class PacienteDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int agregar(Paciente pac){
        Integer idPaciente =0;
        String sql="insert into paciente (correo,documento,estado,nombre,telefono)values (?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pac.getCorreo());
            ps.setString(2, pac.getDocumento());
            ps.setString(3, pac.getEstado());
            ps.setString(4, pac.getNombre());
            ps.setString(5, pac.getTelefono());
           // ps.executeUpdate();
           if (ps.executeUpdate() > 0) {
                   
              java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if ( generatedKeys.next() ) {
                     idPaciente = generatedKeys.getInt(1);
                 }
              }
        } catch (Exception e) {
        }
        return idPaciente;
    }
       public boolean editar(Paciente pac){
        boolean resultado  = false;
        String sql="update paciente set correo=?, telefono=?, nombre=? where PacienteID=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);

            ps.setString(1, pac.getCorreo());
            ps.setString(2, pac.getTelefono());
            ps.setString(3, pac.getNombre());
            ps.setInt(4, pac.getPacienteID());
              
            ps.executeUpdate();
            
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
       public boolean eliminar(int id){
        boolean resultado  = false;
        String sql="update usuario inner join paciente on usuario.pacienteID = cliente.pacienteID \n" +
        "set estado = 0\n" +
        "where pacienteID="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
    
}

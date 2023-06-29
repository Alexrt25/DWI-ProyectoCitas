/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Asesor;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Grupo 5
 */
public class AsesorDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int agregar(Asesor cli){
        Integer idAsesor =0;
        String sql="insert into asesor (DocumentoIdentidad,Telefono, IdUsuario)values (?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cli.getDocumentoIdentidad());
            ps.setString(2, cli.getTelefono());
            ps.setInt(3, cli.getIdUsuario());
           if (ps.executeUpdate() > 0) {
                   
              java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if ( generatedKeys.next() ) {
                     idAsesor = generatedKeys.getInt(1);
                 }
              }
        } catch (Exception e) {
        }
        return idAsesor;
    }
    public boolean editar(Asesor ase){
        boolean resultado  = false;
        String sql="update asesor set Telefono=? where IdAsesor=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);

            ps.setString(1, ase.getTelefono());
            ps.setInt(2, ase.getIdAsesor());
             
            ps.executeUpdate();
            resultado = true;
            
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
    public boolean eliminar(int id){
        boolean resultado  = false;
        String sql="update usuario inner join asesor on usuario.IdUsuario = asesor.IdUsuario \n" +
        "set EstadoUsuario = 0\n" +
        "where IdAsesor="+id;
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

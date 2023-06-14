/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lisbetmoron
 */
public class ClienteDAO {
   
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int agregar(Cliente cli){
        Integer idCliente =0;
        String sql="insert into cliente (DocumentoIdentidad,Telefono, RazonSocial, RUC, IdUsuario)values (?,?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cli.getDocumentoIdentidad());
            ps.setString(2, cli.getTelefono());
            ps.setString(3, cli.getRazonSocial());
            ps.setString(4, cli.getRUC());
            ps.setInt(5, cli.getIdUsuario());
           // ps.executeUpdate();
           if (ps.executeUpdate() > 0) {
                   
              java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if ( generatedKeys.next() ) {
                     idCliente = generatedKeys.getInt(1);
                 }
              }
        } catch (Exception e) {
        }
        return idCliente;
    }
       public boolean editar(Cliente cli){
        boolean resultado  = false;
        String sql="update cliente set Telefono=?, RazonSocial=?, RUC=? where IdCliente=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);

            ps.setString(1, cli.getTelefono());
            ps.setString(2, cli.getRazonSocial());
            ps.setString(3, cli.getRUC());
            ps.setInt(4, cli.getIdCliente());
              
            ps.executeUpdate();
            
            resultado = true;
        } catch (Exception e) {
        }
        return resultado;
    }
       public boolean eliminar(int id){
        boolean resultado  = false;
        String sql="update usuario inner join cliente on usuario.IdUsuario = cliente.IdUsuario \n" +
        "set EstadoUsuario = 0\n" +
        "where IdCliente="+id;
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

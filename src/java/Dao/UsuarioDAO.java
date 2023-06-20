/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Usuario;
import Modelo.UsuarioAsesor;
import Modelo.UsuarioCliente;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo 5
 */
public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario validar(String correo, String contrasenia){
        Usuario us=new Usuario();
        String sql="select t1.IdUsuario,t1.Nombre,t1.Correo,t1.Contrasenia, t1.EstadoUsuario , t1.IdPerfil from usuario t1 inner join perfil_usuario t2 on t1.IdPerfil = t2.IdPerfil where Correo=? and Contrasenia=MD5(?) and EstadoUsuario=1";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasenia);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setIdUsuario(rs.getInt("IdUsuario"));
                us.setNombre(rs.getString("Nombre"));
                us.setCorreo(rs.getString("Correo"));
                us.setContrasenia(rs.getString("Contrasenia"));
                us.setEstadoUsuario(rs.getInt("EstadoUsuario"));
                us.setIdPerfil(rs.getInt("IdPerfil"));
            }
        } catch (Exception e) {
        }
        return us;
    }
        public Usuario validarCorreo(String correo){
        Usuario us=new Usuario();
        String sql="select * from usuario where Correo=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, correo);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setIdUsuario(rs.getInt("IdUsuario"));
                us.setNombre(rs.getString("Nombre"));
                us.setCorreo(rs.getString("Correo"));
                us.setContrasenia(rs.getString("Contrasenia"));
                us.setEstadoUsuario(rs.getInt("EstadoUsuario"));
                us.setIdPerfil(rs.getInt("IdPerfil"));
                
            }
        } catch (Exception e) {
        }
        return us;
    }
    //Operaciones CRUD
    
    public List listar(){
        String sql="select t2.IdCliente,t1.Nombre,t2.DocumentoIdentidad,t1.Correo,t2.Telefono,t1.EstadoUsuario,CASE t1.EstadoUsuario when 1 THEN 'ACTIVO' ELSE 'INACTIVO' END EstadoUsuarioNombre ,t2.RazonSocial,t2.RUC from usuario t1 inner join cliente t2 on t1.IdUsuario = t2.IdUsuario where t1.IdPerfil = 3";
        List<UsuarioCliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                UsuarioCliente us=new UsuarioCliente();
                us.setIdCliente(rs.getInt("IdCliente"));
                us.setNombre(rs.getString("Nombre"));
                us.setDocumentoIdentidad(rs.getString("DocumentoIdentidad"));
                us.setCorreo(rs.getString("Correo"));
                us.setTelefono(rs.getString("Telefono"));
                us.setEstadoUsuario(rs.getInt("EstadoUsuario"));
                us.setEstadoUsuarioNombre(rs.getString("EstadoUsuarioNombre"));
                us.setRazonSocial(rs.getString("RazonSocial"));
                us.setRUC(rs.getString("RUC"));
                //us.setIdPerfil(rs.getInt("IdPerfil"));
                lista.add(us);
            }
            System.out.println(lista);
        } catch (Exception e) {
        }
        return lista;
    }
    
     public List listarAsesor(){
        String sql="select t2.IdAsesor,t1.Nombre,t2.DocumentoIdentidad,t1.Correo,t1.EstadoUsuario,CASE t1.EstadoUsuario when 1 THEN 'ACTIVO' ELSE 'INACTIVO' END EstadoUsuarioNombre ,t2.Telefono from usuario t1 inner join asesor t2 on t1.IdUsuario = t2.IdUsuario where t1.IdPerfil = 2";
        List<UsuarioAsesor>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                UsuarioAsesor us=new UsuarioAsesor();
                us.setIdAsesor(rs.getInt("IdAsesor"));
                us.setNombre(rs.getString("Nombre"));
                us.setDocumentoIdentidad(rs.getString("DocumentoIdentidad"));
                us.setCorreo(rs.getString("Correo"));
                us.setEstadoUsuario(rs.getInt("EstadoUsuario"));
                us.setEstadoUsuarioNombre(rs.getString("EstadoUsuarioNombre"));
                us.setTelefono(rs.getString("Telefono"));
                //us.setIdPerfil(rs.getInt("IdPerfil"));
                lista.add(us);
            }
            System.out.println(lista);
        } catch (Exception e) {
        }
        return lista;
    }
     
     public int buscarCliente(int id){
        String sql="select u.IdUsuario, cl.IdCliente from usuario u inner join cliente cl on u.IdUsuario = cl.IdUsuario where cl.IdUsuario =" + id;
        int valor =0;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                valor = rs.getInt("IdCliente");
            }
        } catch (Exception e) {
        }
        return valor;
    }
    
    public int agregar(Usuario us){
        int idUsuario =0;
        String sql="insert into usuario(Nombre,Correo,Contrasenia,EstadoUsuario,IdPerfil)values(?,?,MD5(?),?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getCorreo());
            ps.setString(3, us.getContrasenia());
            ps.setInt(4, 1);
            ps.setInt(5, us.getIdPerfil());
            //ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                   
              java.sql.ResultSet generatedKeys = ps.getGeneratedKeys();
                if ( generatedKeys.next() ) {
                     idUsuario = generatedKeys.getInt(1);
                 }
              }
        } catch (Exception e) {
        }
        return idUsuario;
    }
    
    public Usuario listarId(int id){
        Usuario us=new Usuario();
        String sql="select * from usuario where IdUsuario="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setNombre(rs.getString(2));
                us.setCorreo(rs.getString(3));
                us.setContrasenia(rs.getString(4));
                us.setEstadoUsuario(rs.getInt(5));
                us.setIdPerfil(rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return us;
    }
    
      
    public int editar(Usuario us){
        String sql="update usuario set Nombre=?, Correo=?, Contrasenia=?, EstadoUsuario=?, IdPerfil=? where IdUsuario=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getCorreo());
            ps.setString(3, us.getContrasenia());
            ps.setInt(4, us.getEstadoUsuario());
            ps.setInt(5, us.getIdPerfil());
            ps.setInt(6, us.getIdUsuario());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
        public boolean editarNombre(String nom, Integer id){
        String sql="update usuario set Nombre=? where IdUsuario=?";
        boolean resul = false;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setInt(2, id);

            ps.executeUpdate();
            resul = true;
        } catch (Exception e) {
        }
        return resul;
    }
    
        public void eliminar(int id){
            String sql="delete from usuario where IdUsuario="+id;
            try {
                con=cn.Conexion();
                ps=con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        }
}

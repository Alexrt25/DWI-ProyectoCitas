/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Usuario;

//import Modelo.UsuarioAsesor;
//import Modelo.UsuarioCliente;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lisbetmoron
 */
public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuario validar(String correo, String contrasenia){
        Usuario us=new Usuario();
        String sql="select t1.UsuarioID,t1.Nombre,t1.fecha_mod,t1.Contraseña, t1.Estado , t1.PerfilID from usuario t1 inner join perfil t2 on t1.perfilID = t2.perfilID where usuario=? and Contraseña=MD5(?) and t1.Estado=1";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasenia);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setUsuarioID(rs.getInt("UsuarioID"));
                us.setNombre(rs.getString("Nombre"));
                us.setFecha_mod(rs.getDate("fecha_mod"));
                us.setContraseña(rs.getString("Contrasenia"));
                us.setEstado(rs.getString("Estado"));
                us.setPerfilID(rs.getInt("PerfilID"));
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
                us.setUsuarioID(rs.getInt("IdUsuario"));
                us.setNombre(rs.getString("Nombre"));
                us.setContraseña(rs.getString("Contraseña"));

                
            }
        } catch (Exception e) {
        }
        return us;
    }
    //Operaciones CRUD
    
//    public List listar(){
//        String sql="select t2.pacienteID,t1.Nombre,t2.Documento,t1.Usuario,t2.Telefono,t1.Estado,CASE t1.Estado when 1 THEN 'ACTIVO' ELSE 'INACTIVO' END EstadoUsuarioNombre  from usuario t1 inner join paciente t2 on t1.pacienteID = t2.pacienteID where t1.PerfilID = 3";
//        List<UsuarioCliente>lista=new ArrayList<>();
//        try {
//            con=cn.Conexion();
//            ps=con.prepareStatement(sql);
//            rs=ps.executeQuery();
//            while (rs.next()) {
//                UsuarioCliente us=new UsuarioCliente();
//                us.setIdCliente(rs.getInt("pacienteID"));
//                us.setNombre(rs.getString("Nombre"));
//                us.setDocumentoIdentidad(rs.getString("Documento"));
//                us.setCorreo(rs.getString("Correo"));
//                us.setTelefono(rs.getString("Telefono"));
//                us.setEstadoUsuario(rs.getInt("Estado"));
//                us.setEstadoUsuarioNombre(rs.getString("EstadoUsuarioNombre"));             
//                us.setIdPerfil(rs.getInt("IdPerfil"));
//                lista.add(us);
//            }
//            System.out.println(lista);
//        } catch (Exception e) {
//        }
//        return lista;
//    }
//    
    
     public int buscarCliente(int id){
        String sql="select u.UsuarioID, cl.pacienteID from usuario u inner join paciente cl on u.pacienteID = cl.pacienteID where cl.UsuarioID =" + id;
        int valor =0;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                valor = rs.getInt("pacienteID");
            }
        } catch (Exception e) {
        }
        return valor;
    }
    
    public int agregar(Usuario us){
        int idUsuario =0;
        String sql="insert into usuario(Nombre,Usuario,Contraseña,Estado,PerfilID)values(?,?,MD5(?),?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getUsuario());
            ps.setString(3, us.getContraseña());
            ps.setString(4, "1");
            ps.setInt(5, us.getPerfilID());
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
        String sql="select * from usuario where UsuarioID="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                us.setNombre(rs.getString(2));
                us.setUsuario(rs.getString(3));
                us.setContraseña(rs.getString(4));
                us.setEstado(rs.getString(5));
                us.setPerfilID(rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return us;
    }
    
      
    public int editar(Usuario us){
        String sql="update usuario set Nombre=?,  Contraseña=?, Estado=?, PerfilId=? where UsuarioID=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, us.getNombre());
            ps.setString(2, us.getContraseña());
            ps.setString(3, us.getEstado());
            ps.setInt(4, us.getPerfilID());
            ps.setInt(5, us.getUsuarioID());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
        public boolean editarNombre(String nom, Integer id){
        String sql="update usuario set Nombre=? where UsuarioID=?";
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
            String sql="update usuario set estado = '0'  where UsuarioID="+id;
            try {
                con=cn.Conexion();
                ps=con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        }
}

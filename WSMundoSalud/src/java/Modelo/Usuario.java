/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Grupo 5
 */
public class Usuario {
     int usuarioID;
     String nombre;
     String usuario;
     String contraseña;
     String estado;
     Date fecha_creacion;
     Date fecha_mod;
     int pacienteID;
     int perfilID;
      String nombrePerfil;

    public Usuario(int usuarioID, String nombre, String usuario, String contraseña, String estado, Date fecha_creacion, Date fecha_mod, int pacienteID, int perfilID) {
        this.usuarioID = usuarioID;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.fecha_mod = fecha_mod;
        this.pacienteID = pacienteID;
        this.perfilID = perfilID;
    }
     
    public Usuario(){
        
    }
    public String getNombrePerfil() {
        int perfil = this.getPerfilID();
        if (perfil == 1) {
            this.nombrePerfil = "Administrador";
        } else if (perfil == 2) {
            this.nombrePerfil = "Cliente";
        } 
        return nombrePerfil;
    }
    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    public int getUsuarioID() {
        return usuarioID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public Date getFecha_mod() {
        return fecha_mod;
    }

    public int getPacienteID() {
        return pacienteID;
    }

    public int getPerfilID() {
        return perfilID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_mod(Date fecha_mod) {
        this.fecha_mod = fecha_mod;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public void setPerfilID(int perfilID) {
        this.perfilID = perfilID;
    }
    
    
     
}

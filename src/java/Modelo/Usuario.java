/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Rody Fernandez
 */
public class Usuario {
    int idUsuario;
    String nombre;
    String correo;
    String contrasenia;
    int estadoUsuario;
    int idPerfil;
    String nombrePerfil;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String correo, String contrasenia, int estadoUsuario, int idPerfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.estadoUsuario = estadoUsuario;
        this.idPerfil = idPerfil;
    }

      public String getNombrePerfil() {
        int perfil = this.getIdPerfil();
        if (perfil == 1) {
            this.nombrePerfil = "Administrador";
        } else if (perfil == 2) {
            this.nombrePerfil = "Asesor";
        } else {
            this.nombrePerfil = "Cliente";
        }
        return nombrePerfil;
    }

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    
}


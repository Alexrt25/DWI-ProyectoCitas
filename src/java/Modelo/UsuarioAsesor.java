/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lisbetmoron
 */
public class UsuarioAsesor {
    
        Integer IdAsesor;
        String DocumentoIdentidad;
        String Telefono;
        String nombre;
        String correo;
        Integer estadoUsuario;
        String estadoUsuarioNombre;
        
public UsuarioAsesor() {
    
    }

    public UsuarioAsesor(Integer IdAsesor,String DocumentoIdentidad, String Telefono, String nombre, String correo,Integer estadoUsuario,String estadoUsuarioNombre) {
        this.IdAsesor = IdAsesor;
        this.DocumentoIdentidad = DocumentoIdentidad;
        this.Telefono = Telefono;
        this.nombre = nombre;
        this.correo = correo;
        this.estadoUsuario = estadoUsuario;
        this.estadoUsuarioNombre = estadoUsuarioNombre;
    }

    public Integer getIdAsesor() {
        return IdAsesor;
    }

    public void setIdAsesor(Integer IdAsesor) {
        this.IdAsesor = IdAsesor;
    }

    public String getDocumentoIdentidad() {
        return DocumentoIdentidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setDocumentoIdentidad(String DocumentoIdentidad) {
        this.DocumentoIdentidad = DocumentoIdentidad;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Integer estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getEstadoUsuarioNombre() {
        return estadoUsuarioNombre;
    }

    public void setEstadoUsuarioNombre(String estadoUsuarioNombre) {
        this.estadoUsuarioNombre = estadoUsuarioNombre;
    }
        
        
        
}

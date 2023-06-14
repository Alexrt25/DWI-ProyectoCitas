/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lisbetmoron
 */
public class UsuarioCliente {
    
    Integer IdUsuario;
    Integer IdCliente;
    String nombre;
    String correo;
    String DocumentoIdentidad;
    String Telefono;
    String RazonSocial;
    String RUC;
    Integer estadoUsuario;
    String estadoUsuarioNombre;
 
    public UsuarioCliente(){
        
    }
    
    public UsuarioCliente(Integer IdCliente,String nombre, String correo, String DocumentoIdentidad, String Telefono, String RazonSocial, String RUC,Integer estadoUsuario, String estadoUsuarioNombre) {
        this.nombre = nombre;
        this.correo = correo;
        this.DocumentoIdentidad = DocumentoIdentidad;
        this.Telefono = Telefono;
        this.RazonSocial = RazonSocial;
        this.RUC = RUC;
        this.IdCliente = IdCliente;
        this.estadoUsuario = estadoUsuario;
        this.estadoUsuarioNombre = estadoUsuarioNombre;
    }

    public UsuarioCliente(Integer IdUsuario, Integer IdCliente) {
        this.IdUsuario = IdUsuario;
        this.IdCliente = IdCliente;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDocumentoIdentidad() {
        return DocumentoIdentidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public String getRUC() {
        return RUC;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDocumentoIdentidad(String DocumentoIdentidad) {
        this.DocumentoIdentidad = DocumentoIdentidad;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
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

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    
}

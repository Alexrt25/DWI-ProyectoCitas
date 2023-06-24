/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author lisbetmoron
 */
public class Paciente {
    
       int pacienteID;
       String correo;
       String documento;
       String estado;
       String nombre;
       String telefono;

   public Paciente() {
    }
    
    public Paciente(int pacienteID, String correo, String documento, String estado, String nombre, String telefono) {
        this.pacienteID = pacienteID;
        this.correo = correo;
        this.documento = documento;
        this.estado = estado;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public int getPacienteID() {
        return pacienteID;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setPacienteID(int pacienteID) {
        this.pacienteID = pacienteID;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
       
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lisbetmoron
 */
public class Asesor {
    
    int IdAsesor;
    String DocumentoIdentidad;
    String Telefono;
    int IdUsuario;

    public Asesor() {
    }
    
    public Asesor(int IdAsesor, String DocumentoIdentidad, String Telefono, int IdUsuario) {
        this.IdAsesor = IdAsesor;
        this.DocumentoIdentidad = DocumentoIdentidad;
        this.Telefono = Telefono;
        this.IdUsuario = IdUsuario;
    }

    public int getIdAsesor() {
        return IdAsesor;
    }

    public String getDocumentoIdentidad() {
        return DocumentoIdentidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdAsesor(int IdAsesor) {
        this.IdAsesor = IdAsesor;
    }

    public void setDocumentoIdentidad(String DocumentoIdentidad) {
        this.DocumentoIdentidad = DocumentoIdentidad;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    
}

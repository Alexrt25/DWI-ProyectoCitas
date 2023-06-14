/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author lisbetmoron
 */
public class Cliente {
    int idCliente;
    String DocumentoIdentidad;
    String Telefono;
    String RazonSocial;
    String RUC;
    int IdUsuario;

    public Cliente() {
    }
    
    public Cliente(int idCliente, String DocumentoIdentidad, String Telefono, String RazonSocial, String RUC, int IdUsuario) {
        this.idCliente = idCliente;
        this.DocumentoIdentidad = DocumentoIdentidad;
        this.Telefono = Telefono;
        this.RazonSocial = RazonSocial;
        this.RUC = RUC;
        this.IdUsuario = IdUsuario;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdCliente() {
        return idCliente;
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

    public int getIdUsuario() {
        return IdUsuario;
    }
}
